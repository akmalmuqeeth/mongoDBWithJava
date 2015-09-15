import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;import java.lang.String;import java.lang.System;

public class SimpleGetQuery {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        try{
            MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
            MongoCollection<Document> collection = mongoDatabase.getCollection("flights");

            Document query = new Document("origin.code", "LAS");
            query.append("destination.code", "JFK");

            FindIterable<Document> results = collection.find(query);

            for(Document doc: results){
                System.out.println(doc.toJson());
            }




        } finally {
            mongoClient.close();
        }


    }
}
