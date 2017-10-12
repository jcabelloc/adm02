package org.tamu.client;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.tamu.adm.domain.AbandonedVehicle;

public class AppDraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient();
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoDatabase database = mongoClient.getDatabase("team6").withCodecRegistry(pojoCodecRegistry);
		MongoCollection<AbandonedVehicle> collection = database.getCollection("abandonedVehicle", AbandonedVehicle.class);
		//collection.drop();
		System.out.println("total # of AV " + collection.count());
		AbandonedVehicle av = new AbandonedVehicle("3GMHC28URTS46886", "LELEWALO ST", "chevrolet", "10/11/2017");
	    collection.insertOne(av);
	    System.out.println("total # of AV " + collection.count());
	}

}
