import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.lang.String;import java.lang.System;import static com.mongodb.client.model.Filters.*;


/**
 * Created by akmalmuqeeth on 9/13/15.
 */
public class ComplexGetQuery {
    public static void main(String args[]){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        try{
            MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
            MongoCollection<Document> collection = mongoDatabase.getCollection("flights");

            Bson airline = gt("airline.airlineID", 4000);
            Bson destination = eq("destination.code", "JFK");

            Bson origin = or(
                        eq("origin.code", "LAS"),
                        eq("origin.code", "LAS")
                    );


            Bson query = and(destination, airline, origin);

            FindIterable<Document> results = collection.find(query);

            for(Document doc: results){
                System.out.println(doc.toJson());
            }


        } finally {
            mongoClient.close();
        }

    }
}
