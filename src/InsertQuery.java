import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.lang.String;import java.lang.System;import static com.mongodb.client.model.Filters.*;


public class InsertQuery {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        try{
            MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
            MongoCollection<Document> collection = mongoDatabase.getCollection("flights");

            //insert a document
            Document airlineDoc = new Document("airlineID", "98765");
            airlineDoc.append("name", "Java Airways");
            airlineDoc.append("country", "England");
            airlineDoc.append("active", true);

            Document originDoc = new Document("country", "Netherlands Antilles");
            originDoc.append("code", "SAB");
            originDoc.append("name", "Juancho E. Yrausquin");
            originDoc.append("city", "Saba");

            Document flightDoc = new Document("_id",62466);
            flightDoc.append("airline", airlineDoc);
            flightDoc.append("origin", originDoc);

            collection.insertOne(flightDoc);

        } finally {
            mongoClient.close();
        }


    }
}
