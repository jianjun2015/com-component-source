package rabbit.topics;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class TopicReceive2 {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"topic");//topic
        String queueName = channel.queueDeclare().getQueue();
        String[] routingKeys = new String[]{"*.*.rabbit", "lazy.#"};

        for (String routingKey:routingKeys){
            channel.queueBind(queueName,EXCHANGE_NAME,routingKey);
            System.out.println("ReceiveLogsTopic2 exchange:" + EXCHANGE_NAME + ", queue:" + queueName + ", BindRoutingKey:" + routingKey);
        }
        System.out.println("ReceiveLogsTopic2 Waiting for messages");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogsTopic2 Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }
}
