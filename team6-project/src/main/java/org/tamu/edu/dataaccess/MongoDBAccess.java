package org.tamu.edu.dataaccess;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.tamu.adm.domain.AbandonedVehicle;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;



/**
 * Provides Methods to get access to MongoDB 
 * 
*/

public class MongoDBAccess {
	

	public static <T> List<T> getDocuments(Class<T> type, String dbname, String collectionName, String key, String value) {
		MongoDatabase database = getConnectionDB(dbname);
		MongoCollection<T> collection = database.getCollection(collectionName, type);
		MongoCursor<T> cursor = collection.find(eq(key, value)).iterator();
		System.out.println(collection.count());
		List<T> result = new ArrayList<T>();
		try {
		    while (cursor.hasNext()) {
		    	result.add(cursor.next());
		    }
		} finally {
			cursor.close();
		}
		return result;
	}
	
	private static MongoDatabase getConnectionDB(String dbname) {

		MongoClient mongoClient = new MongoClient();
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoDatabase database = mongoClient.getDatabase(dbname).withCodecRegistry(pojoCodecRegistry);
		return database;
	}

	public static <TDocument> void saveDocument(Class<TDocument> documentClass, String dbname, String collectionName,TDocument TDocument) {
		MongoDatabase database = getConnectionDB(dbname);
		MongoCollection<TDocument> collection = database.getCollection(collectionName, documentClass);
		collection.insertOne(TDocument);
	}
	
	public static <TDocument> void saveManyDocuments(List<TDocument> TDocuments, String dbname,  String collectionName, Class<TDocument> documentClass) {
		MongoDatabase database = getConnectionDB(dbname);
		MongoCollection<TDocument> collection = database.getCollection(collectionName, documentClass);
		collection.insertMany(TDocuments);
	}
	public static <T> void dropCollection(Class<T> type, String dbname, String collectionName) {
		MongoDatabase database = getConnectionDB(dbname);
		MongoCollection<T> collection = database.getCollection(collectionName, type);
		collection.drop();
	}

	
}
