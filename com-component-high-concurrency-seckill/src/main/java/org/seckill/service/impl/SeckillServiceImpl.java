package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.TSeckillMapper;
import org.seckill.dao.TSuccessKilledMapper;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entitiy.Seckill;
import org.seckill.entitiy.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.module.TSeckill;
import org.seckill.module.TSuccessKilled;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * Created by wangjianjun on 2017/9/15.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TSeckillMapper seckillMapper;

    @Autowired
    private TSuccessKilledMapper successKilledMapper;

    @Autowired
    private RedisDao redisDao;

    private final String slat = "skdfjksjdf7787%^%^%^FSKJFK*(&&%^%&^8DF8^%^^*7hFJDHFJ";

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public List<Seckill> getSeckillList() {
        List<TSeckill> list = seckillMapper.queryAll(0,4);
        List<Seckill> seckills = new ArrayList<>();
        for (TSeckill t:list){
            seckills.add(writeSeckill(t));
        }
        return seckills;
    }

    @Override
    public Seckill getById(long seckillId) {
        return writeSeckill(seckillMapper.selectByPrimaryKey(seckillId));
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill == null){
            seckill = writeSeckill(seckillMapper.selectByPrimaryKey(seckillId));
            if (seckill == null)
                return new Exposer(false,seckillId);
            else
                redisDao.putSeckill(seckill);
        }

        if (seckill == null)
            return new Exposer(false,seckillId);

        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        // 转化特定字符串的过程，不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        // 执行秒杀逻辑：减库存 + 记录购买行为
        Date now = new Date();
        try {
            // 记录购买行为
            int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
            // 唯一：seckillId,userPhone
            if (insertCount <= 0) {
                // 重复秒杀
                throw new RepeatKillException("seckill repeated");
            } else {
                // 减库存，热点商品竞争
                int updateCount = seckillMapper.reduceNumber(seckillId, now);
                if (updateCount <= 0) {
                    // 没有更新到记录 rollback
                    throw new SeckillCloseException("seckill is closed");
                } else {
                    // 秒杀成功 commit
                    SuccessKilled successKilled = writeSuccessKilled(successKilledMapper.selectByPrimaryKeyWithSeckill(seckillId, userPhone));
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }

    @Override
    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            return new SeckillExecution(seckillId, SeckillStateEnum.DATA_REWRITE);
        }
        Date killTime = new Date();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("seckillId", seckillId);
        map.put("phone", userPhone);
        map.put("killTime", killTime);
        map.put("result", null);
        // 执行存储过程，result被赋值
        try {
            seckillMapper.killByProcedure(map);
            // 获取result
            int result = MapUtils.getInteger(map, "result", -2);
            if (result == 1) {
                SuccessKilled sk = writeSuccessKilled(successKilledMapper.selectByPrimaryKeyWithSeckill(seckillId, userPhone));
                return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, sk);
            } else {
                return new SeckillExecution(seckillId, SeckillStateEnum.stateOf(result));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
        }
    }

    private TSeckill writeTSeckill(Seckill seckill){
        TSeckill tSeckill = new TSeckill();
        tSeckill.setSeckillId(seckill.getSeckillId());
        tSeckill.setName(seckill.getName());
        tSeckill.setNumber(seckill.getNumber());
        tSeckill.setCreateTime(seckill.getCreateTime());
        tSeckill.setEndTime(seckill.getEndTime());
        tSeckill.setStartTime(seckill.getStartTime());
        return tSeckill;
    }

    private Seckill writeSeckill(TSeckill tSeckill){
        Seckill seckill = new Seckill();
        seckill.setSeckillId(tSeckill.getSeckillId());
        seckill.setName(tSeckill.getName());
        seckill.setNumber(tSeckill.getNumber());
        seckill.setCreateTime(tSeckill.getCreateTime());
        seckill.setEndTime(tSeckill.getEndTime());
        seckill.setStartTime(tSeckill.getStartTime());
        return seckill;
    }

    private TSuccessKilled writeTSuccessKilled(SuccessKilled successKilled){
        TSuccessKilled tSuccessKilled = new TSuccessKilled();
        tSuccessKilled.setSeckillId(successKilled.getSeckillId());
        tSuccessKilled.setUserPhone(successKilled.getUserPhone());
        tSuccessKilled.setState(successKilled.getState());
        tSuccessKilled.setCreateTime(successKilled.getCreateTime());

        return tSuccessKilled;
    }

    private SuccessKilled writeSuccessKilled(TSuccessKilled tSuccessKilled){
        SuccessKilled successKilled = new SuccessKilled();
        successKilled.setSeckillId(tSuccessKilled.getSeckillId());
        successKilled.setUserPhone(tSuccessKilled.getUserPhone());
        successKilled.setState(tSuccessKilled.getState());
        successKilled.setCreateTime(tSuccessKilled.getCreateTime());
        successKilled.setSeckill(tSuccessKilled.getSeckill());

        return successKilled;
    }
}
