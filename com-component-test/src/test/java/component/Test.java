package component;

/**
 * Created by wangjianjun on 2017/10/9.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("begin:"+System.currentTimeMillis()/1000);

//        for (int i=0;i<16;i++){
//            final String log = ""+(i+1);
//            Test.parseLog(log);
//        }

        for (int k=0;k<4;k++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 16; i++) {
                        final String log = "" + (i + 1);
                        Test.parseLog(log);
                        if (i==3)
                            break;
                    }
                }
            }.start();
        }
    }

    private static void parseLog(String log){
        System.out.println(log+":"+System.currentTimeMillis()/1000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
