package org.tamu.adm.domain;

import java.util.List;
import org.tamu.edu.dataaccess.MongoDBAccess;;

/**
 * Provides Methods to manage the Abandoned Vehicles data 
 * 
*/
public class AbandonedVehicleService {
	private static final String DBNAME = "team6";
	private static final String COLLECTIONNAME = "abandonedVehicle";
	
	public List<AbandonedVehicle> getAllAbandonedVehicleByMake(String vehicleMakeValue) {
		return MongoDBAccess.getDocuments(AbandonedVehicle.class, DBNAME, COLLECTIONNAME, "vehicleMake", vehicleMakeValue);
	}
	
	public void saveAbandonedVehicle (AbandonedVehicle abandonedVehicle ) {
		MongoDBAccess.saveDocument(AbandonedVehicle.class, DBNAME, COLLECTIONNAME, abandonedVehicle);
	}
	public void saveManyAbandonedVehicles (List<AbandonedVehicle> abandonedVehicles) {
		MongoDBAccess.saveManyDocuments(abandonedVehicles, DBNAME, COLLECTIONNAME,  AbandonedVehicle.class);
	}
	public void dropAbandonedVehiclesCollection () {
		MongoDBAccess.dropCollection(AbandonedVehicle.class, DBNAME, COLLECTIONNAME );
	}
	
}
