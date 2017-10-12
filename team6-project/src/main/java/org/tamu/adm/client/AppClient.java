package org.tamu.adm.client;
import org.tamu.adm.domain.AbandonedVehicleService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;


import org.tamu.adm.domain.AbandonedVehicle;


public class AppClient {

	public static void main(String[] args) throws FileNotFoundException {
		
		AbandonedVehicleService abandonedVehicleService = new AbandonedVehicleService();
		List <AbandonedVehicle> abandonedVehicles = abandonedVehicleService.getAllAbandonedVehicleByMake("subaru");
		String file = Paths.get(System.getProperty("user.dir")+"\\data\\out\\output.txt").toString();
		PrintWriter out = new PrintWriter(new FileOutputStream(file));
		for (int i = 0; i<abandonedVehicles.size(); i++) {
			out.println(abandonedVehicles.get(i).toString());
		}
		out.close();
	}

}
