import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;import java.lang.String;import java.lang.System;

public class UpdateQuery {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        try{
            MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
            MongoCollection<Document> collection = mongoDatabase.getCollection("flights");

            //three type of update methods available
            // replaceOne, updateOne, updateMany

            Document queryDoc = new Document("_id", 62466);
            Document updateDoc = new Document("$set" , new Document("airline.name", "Mongo Airways"));

            UpdateResult result = collection.updateOne(queryDoc, updateDoc);

            System.out.println("Matched: "+result.getMatchedCount() + " Modified: "+ result.getModifiedCount());

        } finally {
            mongoClient.close();
        }


    }
}
