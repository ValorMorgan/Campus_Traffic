package com.campusfeatures;
import java.util.*;

public class ParkingLot {
	
	public static final int MIN_CAPACITY = 0;
	public static final String DEFAULT_LOT_NAME = "";
	public static final short DEFAULT_CAPACITY_VEHICLES = 0;
	public static final boolean DEFAULT_OPEN = false;
	
	private String lotName;
	private double xCoord;
	private double yCoord;
	private short totalCapacity;
	private short numberVehicles;
	private boolean lotOpen;
	private java.sql.Date lastUpdate;
	//
	// Constructors
	//
	// No arguments
	public ParkingLot() { /* Empty */ }
	
	// Name
	public ParkingLot(String lotName) {
		this(lotName, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, DEFAULT_CAPACITY_VEHICLES, DEFAULT_CAPACITY_VEHICLES, DEFAULT_OPEN);
	}
	// XCoord + YCoord
	public ParkingLot(double xCoord, double yCoord) {
		this(DEFAULT_LOT_NAME, xCoord, yCoord, DEFAULT_CAPACITY_VEHICLES, DEFAULT_CAPACITY_VEHICLES, DEFAULT_OPEN);
	}
	// Capacity + NumberVehicles
	public ParkingLot(short totalCapacity, short numberVehicles) {
		this(DEFAULT_LOT_NAME, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, totalCapacity, numberVehicles, DEFAULT_OPEN);
	}
	// Open
	public ParkingLot(boolean lotOpen) {
		this(DEFAULT_LOT_NAME, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, DEFAULT_CAPACITY_VEHICLES, DEFAULT_CAPACITY_VEHICLES, lotOpen);
	}
	// Name + XCoord + YCoord
	public ParkingLot(String lotName, double xCoord, double yCoord) {
		this(DEFAULT_LOT_NAME, xCoord, yCoord, DEFAULT_CAPACITY_VEHICLES, DEFAULT_CAPACITY_VEHICLES, DEFAULT_OPEN);
	}
	// Name + Capacity + NumberVehicles
	public ParkingLot(String lotName, short totalCapacity, short numberVehicles) {
		this(lotName, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, totalCapacity, numberVehicles, DEFAULT_OPEN);
	}
	// Name + Open
	public ParkingLot(String lotName, boolean lotOpen) {
		this(lotName, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, DEFAULT_CAPACITY_VEHICLES, DEFAULT_CAPACITY_VEHICLES, lotOpen);
	}
	// Name + Capacity + NumberVehicles + Open [All variables]
	public ParkingLot(String lotName, double xCoord, double yCoord, short totalCapacity, short numberVehicles, boolean lotOpen) {
		lastUpdate = new java.sql.Date(System.currentTimeMillis());
		this.setLotName(lotName);
		this.setXCoord(xCoord);
		this.setYCoord(yCoord);
		this.setTotalCapacity(totalCapacity);
		this.setNumberVehicles(numberVehicles);
		this.setLotOpen(lotOpen);
	}
	// Capacity + NumberVehicles + Open
	public ParkingLot(short totalCapacity, short numberVehicles, boolean lotOpen) {
		this(DEFAULT_LOT_NAME, Obstruction.DEFAULT_XCOORD, Obstruction.DEFAULT_YCOORD, totalCapacity, numberVehicles, lotOpen);
	}
	
	// Access methods
	public String getLotName() {
		return lotName;
	}
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}
	public double getXCoord() {
		return xCoord;
	}
	public void setXCoord(double coord) {
		xCoord = coord;
	}
	public double getYCoord() {
		return yCoord;
	}
	public void setYCoord(double coord) {
		yCoord = coord;
	}
	public short getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(short totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public short getNumberVehicles() {
		return numberVehicles;
	}
	public void setNumberVehicles(short numberVehicles) {
		if(numberVehicles >= MIN_CAPACITY && numberVehicles <= totalCapacity) {
			this.numberVehicles = numberVehicles;
		}
		
		//this.setLastUpdate(System.currentTimeMillis());
	}
	public boolean isLotOpen() {
		return lotOpen;
	}
	public void setLotOpen(boolean lotOpen) {
		this.lotOpen = lotOpen;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	private void setLastUpdate(long lastUpdate) {
		// Called from within class only
		this.lastUpdate.setTime(lastUpdate);
	}
	
	public String toString(){
		return lotName + "\t\t" + xCoord + "\t\t" + yCoord + "\t\t" + totalCapacity + "\t\t" + numberVehicles + "\t\t" + lotOpen + "\t" + lastUpdate; 
	}
}