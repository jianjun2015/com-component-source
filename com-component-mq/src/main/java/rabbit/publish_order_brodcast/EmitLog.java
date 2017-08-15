package rabbit.publish_order_brodcast;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 广播模式分发
 * Created by wangjianjun on 2017/8/14.
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");//分发 所有的消费者都可以得到

        for (int i=0;i<5;i++){
            String  msg = "hello world "+i;
            channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
            System.out.println("EmitLog Sent '"+msg+"'");
        }

        channel.close();
        connection.close();
    }
}
