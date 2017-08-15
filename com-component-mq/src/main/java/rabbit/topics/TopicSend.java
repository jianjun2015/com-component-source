package rabbit.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class TopicSend {

    private static final String EXCHANGE_NAME="topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = null;
        Channel channel = null;

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");//注意topic

            //待发送消息
            String[] routingKeys = new String[]{
                    "quick.orange.rabbit",
                    "lazy.orange.elephant",
                    "quick.orange.fox",
                    "lazy.brown.fox",
                    "quick.brown.fox",
                    "orange.male.rabbit",
                    "lazy.orange.male.rabbit"
            };

            for (String severity:routingKeys){
                String msg = "From "+severity+" routingKey's msg";
                channel.basicPublish(EXCHANGE_NAME,severity,null,msg.getBytes());
                System.out.println("Topic send '"+severity+"':'"+msg+"'");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                channel.close();
                connection.close();
            }
        } finally {
            if (connection != null) {
                channel.close();
                connection.close();
            }
        }
    }
}
