import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class mongoDB {

//WORK IN PROGRESS
    public static String uri = "";
    public static MongoClientURI clientURI = new MongoClientURI(uri);
    public static MongoClient mongoClient = new MongoClient(clientURI);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("RouletteBot");
    MongoCollection collection = mongoDatabase.getCollection("HashMap Data");





}
