package org.tamu.edu.util;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.tamu.adm.domain.AbandonedVehicle;
import org.tamu.adm.domain.AbandonedVehicleService;

public class DataLoader {

	public static void main(String[] args) throws IOException {
		// Object and Service provider for loading data
		List<AbandonedVehicle> abandonedVehicles = new ArrayList<AbandonedVehicle>();
		AbandonedVehicleService abandonedVehicleService = new AbandonedVehicleService();

		// Location of Data File to load to the Database
		Scanner in = new Scanner(Paths.get(System.getProperty("user.dir")+"\\data\\in\\DataSet01.txt"), "UTF-8");
		String line = in.nextLine();
		
		while (in.hasNextLine()) {
			line = in.nextLine();
			String[] tokens = line.split("\\|");
			AbandonedVehicle abandonedVehicle = new AbandonedVehicle(tokens[0],tokens[1], tokens[2], tokens[3]);
			abandonedVehicles.add(abandonedVehicle);
		}
		// Drop previous Data
		abandonedVehicleService.dropAbandonedVehiclesCollection();
		
		// Save Only One
		//abandonedVehicleService.saveAbandonedVehicle(abandonedVehicles.get(10));
		// Massive Load
		abandonedVehicleService.saveManyAbandonedVehicles(abandonedVehicles);
		
		in.close();
	}
}
