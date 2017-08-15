package rabbit.publish_order_routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由的方式
 * Created by wangjianjun on 2017/8/14.
 */
public class RoutingSendDirect {

    private static final String EXCHANGE_NAME="direct_logs";
    private static final String[] routingKeys = new String[]{"info" ,"warning", "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");//注意direct

        for (String routingKey:routingKeys){
            String msg = "RoutingSendDirect send the message level:"+routingKey;
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
            System.out.println("RoutingSendDirect send :"+msg);
        }

        channel.close();
        connection.close();
    }
}
