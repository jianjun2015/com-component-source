package component.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class MongoDBJDBC {

    public MongoClient getMongoClient(){

        try {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017);
            return mongoClient;
        }catch (Exception e){
            System.out.println(e.getClass().getName()+":"+e.getMessage());
        }

        return null;
    }

    public MongoDatabase baseJdbc(String dbName) {
        try {
            //连接mongodb服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
            System.out.println("Connect to database successfully:"+mongoDatabase);

            return mongoDatabase;
        }catch (Exception e){
            System.out.println("Connect to database failure");
        }

        return null;
    }

    //带参数的mongoJdbc
    public void goodJdbc(){

        try{
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost",27017);
            List<ServerAddress> addrs = new ArrayList<>();
            addrs.add(serverAddress);

            MongoCredential credential = MongoCredential.createCredential(
                    "username", "databaseName", "password".toCharArray()
            );
            List<MongoCredential> mongoCredentials = new ArrayList<>();
            mongoCredentials.add(credential);

            MongoClient mongoClient = new MongoClient(addrs,mongoCredentials);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
        }catch (Exception e){
            System.out.println(e.getClass().getName()+":"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        MongoDBJDBC mongoDBJDBC = new MongoDBJDBC();
        mongoDBJDBC.baseJdbc("test");
    }
}
