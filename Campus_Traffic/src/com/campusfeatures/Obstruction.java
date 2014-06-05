package com.campusfeatures;

import java.math.BigDecimal;

public class Obstruction {
	
	public static final double DEFAULT_XCOORD = 42.725594;
	public static final double DEFAULT_YCOORD = -84.477861;
	public static final String NO_NAME = "";

	private String streetName;
	private double xCoord;
	private double yCoord;
	private String description;
	
	public Obstruction(){
		this(NO_NAME, DEFAULT_XCOORD, DEFAULT_YCOORD, NO_NAME);
	}
	
	public Obstruction(String streetName){
		this(streetName, DEFAULT_XCOORD, DEFAULT_YCOORD, NO_NAME);
	}
	
	public Obstruction(double xCoord, double yCoord){
		this(NO_NAME, xCoord, yCoord, NO_NAME);
	}
	
	public Obstruction(String streetName, double xCoord, double yCoord){
		this(streetName, xCoord, yCoord, NO_NAME);
	}
	
	public Obstruction(String streetName, String description){
		this(streetName, DEFAULT_XCOORD, DEFAULT_YCOORD, description);
	}
	
	public Obstruction(String streetName, double xCoord, double yCoord, String description) {
		this.setStreetName(streetName);
		this.setXCoord(xCoord);
		this.setYCoord(yCoord);
		this.setDescription(description);
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description == null) {
			this.description = NO_NAME;
			return;
		}
		this.description = description;
	}

	public String toString(){
		return "Obstruction on " + streetName + " at (" + xCoord + "," + yCoord + ")." + (description.equals("") ? "" : " Due to " + description);
	}
}
