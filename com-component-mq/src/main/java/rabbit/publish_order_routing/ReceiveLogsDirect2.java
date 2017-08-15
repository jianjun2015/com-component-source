package rabbit.publish_order_routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class ReceiveLogsDirect2 {

    private static final String EXCHANGE_NAME="direct_logs";
    private static final String[] routingKeys = new String[]{ "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");//注意direct
        String queueName = channel.queueDeclare().getQueue();

        for (String routingKey:routingKeys){
            channel.queueBind(queueName,EXCHANGE_NAME,routingKey);
            System.out.println("ReceiveLogsDirect2 exchange:"+EXCHANGE_NAME+","+" queue:"+queueName+", BindRoutingKey:"+routingKey);
        }

        System.out.println("ReceiveLogsDirect2 waiting for msg");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"UTF-8");
                System.out.println("ReceiveLogsDirect2 received '"+envelope.getRoutingKey()+"':'"+msg+"'");
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }
}
