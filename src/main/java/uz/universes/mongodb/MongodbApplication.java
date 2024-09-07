package uz.universes.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MongodbApplication {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/?directConnection=true");
        MongoDatabase db = mongoClient.getDatabase("test_database");
        MongoCollection<Document> posts = db.getCollection("posts");
        //insertOne(posts);
        // insertMany(posts);
        //getFind(posts);
       // updateOne(posts);
        //deleteOne(posts);

    }

    private static void getFind(MongoCollection<Document> posts) {
        FindIterable<Document> documents= posts.find();
        for (Document document:documents){
            System.out.println("document = "+document);
        }
    }

    private static void insertMany(MongoCollection<Document> posts) {
        String postJson= """
                {
                "title" : "Json example",
                "body" : "bady Json"
                }
                """;
        Map<String, Object> map=Map.of(
                "titeli","mongodb 1",
                "body","mobgodb body"

        );
        List<Document> post=List.of(
                Document.parse(postJson),
                new Document(map)
        );
        InsertManyResult insertManyResult = posts.insertMany(post);
        if (insertManyResult.wasAcknowledged()){
            System.out.println(insertManyResult.getInsertedIds());
        }
    }


    public static void insertOne(MongoCollection<Document> posts){
        Document post = new Document("titel","Test Uchun MongoDb")
                .append("body","mongodb-driver-sync organmoqdamiz")
                .append("createDate",new Date());
        InsertOneResult insertOneResult = posts.insertOne(post);
        if (insertOneResult.wasAcknowledged()){
            System.out.println(insertOneResult.getInsertedId());
        }
    }
    private static void updateOne(MongoCollection<Document> posts) {
        UpdateResult updateResult = posts.updateOne(
                Filters.eq("title", "mongodb 1"),
                Updates.set("body", "Updated MongoDB Body")
        );
        if (updateResult.wasAcknowledged()) {
            System.out.println("Matched Count: " + updateResult.getMatchedCount());
            System.out.println("Modified Count: " + updateResult.getModifiedCount());
        }
    }
    private static void deleteOne(MongoCollection<Document> posts) {
        DeleteResult deleteResult = posts.deleteOne(Filters.eq("title", "mongodb 1"));
        if (deleteResult.wasAcknowledged()) {
            System.out.println("Deleted Count: " + deleteResult.getDeletedCount());
        }
    }

}
