package uz.universes.mongodb.repository;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import lombok.NonNull;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import uz.universes.mongodb.Post;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

public class PostRepositoryImpl implements PostRepository{
    private static final MongoClient CLIENT= MongoClients.create("mongodb://test_user:root@localhost:27017/test_database");
    private static final MongoDatabase DB=CLIENT.getDatabase("test_database");
    private static final MongoCollection<Document> COLLECTION=DB.getCollection("posts");
    @Override
    public Post get(String id) {
        Bson filter= Filters.eq("id",new ObjectId());
        Document document=COLLECTION.find(filter).first();
        if (document==null){
            return null;
        }
        return new Post(document);
    }

    @Override
    public List<Post> getList() {
        List<Post> postList=new ArrayList<>();
        FindIterable<Document> documents = COLLECTION.find();
        for (Document document:documents){
            postList.add(new Post(document));
        }
        return postList;
    }

    @Override
    public List<Post> getAll(int page, int size) {
        List<Post> postList=new ArrayList<>();
        FindIterable<Document> limit = COLLECTION.find().skip(page * size).limit(size);
        for (Document document:limit)
            postList.add(new Post(document));
        return postList;
    }

    @Override
    public Post save(@NonNull Post post) {
        Document document=new Document(Map.of(
         "id",post.getId(),
                "userId",post.getUserId(),
                "title",post.getTitle(),
                "body",post.getBody()
        ));
        InsertOneResult insertOneResult = COLLECTION.insertOne(document);
        if (insertOneResult.wasAcknowledged()){
            ObjectId objectId=insertOneResult.getInsertedId().asObjectId().getValue();
            post.setObjectId(objectId);
            return post;
        }

        return null;
    }

    @Override
    public List<Post> saveAll(@NonNull List<Post> posts) {
        for (Post post:posts){
            save(post);
        }
        return posts;
    }

    @Override
    public boolean delete(String id) {
        Bson filter= Filters.eq("id",new ObjectId());
        return COLLECTION.deleteOne(filter).wasAcknowledged();
    }

    @Override
    public boolean update(Post post) {
        Bson filter= Filters.eq("id",post.getObjectId());
        Bson update = Updates.combine(
                Updates.set("title", post.getTitle()),
                Updates.set("body", post.getBody())
        );
        return COLLECTION.updateOne(filter,update).wasAcknowledged();
    }
}
