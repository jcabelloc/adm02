package org.tamu.adm.domain;

public class AbandonedVehicle {
	// Attributes
	private String vin;
	private String streetName;
	private String vehicleMake;
	private String reportedDate;
	
	// Constructor
	
	public AbandonedVehicle () {
	}
	
	public AbandonedVehicle (String vin, String streetName, String vehicleMake, String reportedDate) {
		this.vin = vin;
		this.streetName = streetName;
		this.vehicleMake = vehicleMake;
		this.reportedDate = reportedDate;
	}


	// Getters and Setters
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	@Override
    public String toString() {
        return "Abandoned Vehicle{"
                + "vin='" + vin + "'"
                + ", streetName='" + streetName + "'"
                + ", vehicleMake=" + vehicleMake
                + ", reportedDate=" + reportedDate
                + "}";
	
	}
	
	
}
