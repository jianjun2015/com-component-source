package shell;

import util.exception.BusiException;

/**
 * Created by wangjianjun on 2017/8/24.
 */
public class MainTest {

    public static void main(String[] args) {
        ExecShellCommandPwdUtil shellCommandUtil = new ExecShellCommandPwdUtil("192.168.66.129","root","352810579");
        try {
//            String shellCMD = "pwd";
            String shellCMD ="sh " + "/root/cmdPath/test.sh";
            String result = shellCommandUtil.execute(shellCMD);
            System.out.println(result);
        } catch (BusiException e) {
            System.out.println("执行出错了："+e.getMessage());
        }
    }
}
