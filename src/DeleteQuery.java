import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.lang.String;import java.lang.System;import static com.mongodb.client.model.Filters.*;


public class DeleteQuery {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        try{
            MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
            MongoCollection<Document> collection = mongoDatabase.getCollection("flights");

            Bson origin = eq("origin.code", "SAB");
            Bson destination = eq("destination.code", "SAB");

            Bson query = or(origin,destination);

            //there is also a deleteOne method
            DeleteResult result = collection.deleteMany(query);

            System.out.println("Number of docs deleted: "+result.getDeletedCount());

        } finally {
            mongoClient.close();
        }


    }
}
