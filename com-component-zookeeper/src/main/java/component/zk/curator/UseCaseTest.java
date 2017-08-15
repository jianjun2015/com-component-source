package component.zk.curator;

import component.zk.curator.create.CreateClient;
import component.zk.curator.usecase.ExampleClientThatLocks;
import component.zk.curator.usecase.FakeLimitedResource;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.CloseableUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjianjun on 2017/7/12.
 */
public class UseCaseTest {

    private static final String ZK_ADDR= "192.168.66.128:2181,192.168.66.129:2181,192.168.66.130:2181";
    private static final String ZK_PATH="/examples/locks";
    private static final int QTY = 5;
    private static final int REPETITION = QTY * 5;

    public static void main(String[] args) {

        final FakeLimitedResource resource = new FakeLimitedResource();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (int i=0;i<QTY;i++){
                final int index = 1;
                Callable<Void> task = new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        CuratorFramework client = CreateClient.createSimple(ZK_ADDR);
                        client.start();
                        try {
                            final ExampleClientThatLocks example = new ExampleClientThatLocks(client,ZK_PATH,resource,"Client "+ index);
                            for (int j=0;j<REPETITION;j++){
                                example.doWork(10, TimeUnit.SECONDS);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            CloseableUtils.closeQuietly(client);
                        }
                        return null;
                    }
                };
                executor.submit(task);
                executor.awaitTermination(10,TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
