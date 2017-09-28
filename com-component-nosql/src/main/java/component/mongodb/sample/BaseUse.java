package component.mongodb.sample;

import com.mongodb.BasicDBObject;
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

    public MongoCollection createCollection(String dbName,String colName){

        MongoCollection<Document> collection = null;
        try{

            MongoDatabase testDB = mongoDBJDBC.createMongoDatabase(dbName);

            collection = testDB.getCollection(colName);
            if (collection == null)
                testDB.createCollection(colName);

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

    public MongoCursor<Document> findDoucuments_(MongoCollection<Document> mongoCollection){

        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            Document document = mongoCursor.next();
            System.out.println(document.get("_id"));
            System.out.println(document.get("id"));
            System.out.println(document.get("name"));
            System.out.println(document.get("age"));
        }

//        FindIterable findIterable_ = mongoCollection.find(Filters.eq("id",1)).sort(new BasicDBObject("id",1));
        FindIterable findIterable_ = mongoCollection.find().limit(10).sort(new BasicDBObject("age",1));//1升序 -1降序
        MongoCursor<Document> mongoCursor_ = findIterable_.iterator();
        while (mongoCursor_.hasNext()){
            System.out.println(mongoCursor_.next());
        }

        return mongoCursor;
    }

    public void find_function(MongoCollection<Document> collection){
        BasicDBObject exclude = new BasicDBObject(); //projection :除了_id字段例外，不能把包含和不包含混用,1用于显示字段，而0用于隐藏字段
        exclude.append("_id",1);
        exclude.append("zhangsan", 1);//有则显示，没有就不显示，不会报错
        exclude.append("description", 1);
//         exclude.append("title", 0); //会出错

        FindIterable datas = collection.find()
                .projection(exclude)
                .limit(5);

//        BasicDBList options = new BasicDBList();
//        options.add(new BasicDBObject("likes", 101));
//        options.add(new BasicDBObject("likes", 103));
//        BasicDBObject queryObj = new BasicDBObject("$or", options);
//        BasicDBObject queryObj = new BasicDBObject("by", "fly");
//        BasicDBObject queryObj = new BasicDBObject("likes", new BasicDBObject("$gt", 100));
//        FindIterable<User> datas = collection.find(queryObj).limit(5);
//        FindIterable<User> datas = collection.find(Filters.type("zhangsan", BsonType.STRING)).limit(5); //查询含有zhangsan为key的
//        FindIterable datas = collection.find(Filters.eq("by","fly")).limit(5);
//        FindIterable datas_ = collection.find(Filters.eq("likes",100)).limit(5);
//        FindIterable datas__ = collection.find(Filters.eq("by","fly")).limit(5);
        MongoCursor cursor = datas.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
//            Document doc = (Document) cursor.next();
//            if (doc.containsKey("_id")){
//                System.out.println("_id:"+doc.get("_id"));
//            }
        }
    }

    public static void main(String[] args) {
        BaseUse baseUse = new BaseUse();
        MongoCollection mongoCollection = baseUse.createCollection("test","myColl");

        baseUse.insertDocument(mongoCollection);
        baseUse.findDoucuments(mongoCollection);
        baseUse.findDoucuments_(mongoCollection);
//        baseUse.updatedDoucuments(mongoCollection);
//        baseUse.deleteDoucuments(mongoCollection);
    }
}
