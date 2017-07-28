package com.shiro.redis;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by wangjianjun on 2017/7/28.
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private RedisClient sessionCacheClient=new RedisClient();

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        System.out.println("创建seesion,id="+session.getId().toString());
        try {
            sessionCacheClient.set(sessionId.toString(),  session);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("获取seesion,id="+sessionId.toString());
        Session session = null;
        try {
            session = (Session) sessionCacheClient.get(sessionId.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("更新seesion,id="+session.getId().toString());
        try {
            sessionCacheClient.replace(session.getId().toString(), session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Session session) {
        System.out.println("删除seesion,id="+session.getId().toString());
        try {
            sessionCacheClient.delete(session.getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        System.out.println("获取存活的session");
        return Collections.emptySet();
    }
}
