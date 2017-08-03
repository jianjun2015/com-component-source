package com.base.util.other;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.base.util.exception.InspectionServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wangjianjun on 2017/3/30.
 */
public class ExecShellCommandUtil {

    private static Logger logger = LoggerFactory.getLogger(ExecShellCommandUtil.class);
    private static String DEFAULTCHART  = "UTF-8";
    private Connection conn;
    private String ip;//远程机器ip
    private String userName;//登录用户名
    private String userPwd;//登录密码

    public ExecShellCommandUtil(){}

    public ExecShellCommandUtil(String ip, String userName, String userPwd) {
        this.ip = ip;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    /**
     * 远程登录
     * @return
     * @throws IOException
     */
    private boolean login() throws IOException{

        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(userName,userPwd);
    }

    /**
     * 远程执行shell命令
     * @param shellCMD
     * @return
     * @throws InspectionServiceException
     */
    public String execute(String shellCMD) throws InspectionServiceException {

        String result;

        boolean loginFlg;
        try {
            loginFlg = login();
            if (!loginFlg){
                logger.info("登录失败:"+ip);
                return "登录失败";
            }
        } catch (IOException e) {
            throw new InspectionServiceException(e.getMessage());
        }

        try {
            Session session = conn.openSession();
            session.execCommand(shellCMD);
            result = processStdout(session.getStdout(),DEFAULTCHART);
            if (StringUtils.isBlank(result)){
                result = processStdout(session.getStderr(),DEFAULTCHART);
            }
            session.close();
        }catch (IOException e){
            logger.error("shell执行失败:"+e.getMessage());
            throw new InspectionServiceException("shell执行失败:"+e.getMessage());
        }finally {
            conn.close();
        }

        return result;
    }

    /**
     * 标准输出格式化
     * @param is
     * @param charset
     * @return
     * @throws IOException
     */
    private String processStdout(InputStream is,String charset) throws IOException{

        //标准输出包装成InputStream
        InputStream stdout = new StreamGobbler(is);
        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));
        String line;
        while ((line = br.readLine())!=null){
            sb.append(line+"\n");
        }

        return sb.toString();
    }
}
