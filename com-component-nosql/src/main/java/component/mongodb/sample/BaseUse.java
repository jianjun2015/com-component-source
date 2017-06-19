package component.mongodb.sample;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import component.mongodb.MongoDBJDBC;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class BaseUse {

    MongoDBJDBC mongoDBJDBC = new MongoDBJDBC();

    public MongoDatabase getMongoDatabase(String dbNames){
        MongoClient client = mongoDBJDBC.getMongoClient();
        MongoDatabase mongoDatabase = client.getDatabase(dbNames);

        return mongoDatabase;
    }

    public MongoCollection createCollection(String colName){

        MongoCollection<Document> collection = null;
        try{
            //连接到数据库
            MongoDatabase testDB = mongoDBJDBC.baseJdbc("test");
            testDB.createCollection(colName);

            collection = testDB.getCollection(colName);
            System.out.println("集合 "+colName+" 连接成功");
        }catch (Exception e){
            System.out.println(e.getClass().getName()+":"+e.getMessage());
        }

        return collection;
    }

    public void insertDocument(MongoCollection<Document> mongoCollection){
        Document document = new Document("title","mongoDB")
                .append("description","databases")
                .append("likes",100)
                .append("by","fly");

        List<Document> list = new ArrayList<>();
        list.add(document);

        mongoCollection.insertMany(list);
        System.out.println("文档插入成功");
    }

    public MongoCursor<Document> findDoucuments(MongoCollection<Document> mongoCollection){

        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

        return mongoCursor;
    }

    public MongoCursor<Document> updatedDoucuments(MongoCollection<Document> mongoCollection){

        //更新文档   将文档中likes=100的文档修改为likes=200
        mongoCollection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));

        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

        return mongoCursor;
    }

    public MongoCursor<Document> deleteDoucuments(MongoCollection<Document> mongoCollection){

        //删除符合条件的第一个文档
        mongoCollection.deleteOne(Filters.eq("likes", 200));
        //删除所有符合条件的文档
        mongoCollection.deleteMany (Filters.eq("likes", 200));

        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

        return mongoCursor;
    }

    public static void main(String[] args) {
        BaseUse baseUse = new BaseUse();
        MongoCollection mongoCollection = baseUse.createCollection("myColl");
        baseUse.insertDocument(mongoCollection);
        baseUse.findDoucuments(mongoCollection);
        baseUse.updatedDoucuments(mongoCollection);
        baseUse.deleteDoucuments(mongoCollection);
    }
}
