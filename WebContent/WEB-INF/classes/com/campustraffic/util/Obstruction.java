package com.campustraffic.util;

import java.math.BigDecimal;

public class Obstruction {
	
	private Integer id;
	private String streetName;
	private BigDecimal xCoord;
	private BigDecimal yCoord;
	private String description;
	
	
	public Obstruction(){
		streetName = "Unknown Street";
		xCoord = new BigDecimal(0.0);
		yCoord = new BigDecimal(0.0);
		description = "Unknown description";
	}
	
	public Obstruction(int id, String streetName, BigDecimal xCoord, BigDecimal yCoord, String description){
		this.id = id;
		this.streetName = streetName;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		if(description != null){
			this.description = description;
		}
		else{
			this.description = "";
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public BigDecimal getxCoord() {
		return xCoord;
	}

	public void setxCoord(BigDecimal xCoord) {
		this.xCoord = xCoord;
	}

	public BigDecimal getyCoord() {
		return yCoord;
	}

	public void setyCoord(BigDecimal yCoord) {
		this.yCoord = yCoord;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString(){
		return "Obstruction on street: " + streetName + ", coords(" + xCoord + ", " + yCoord + "), description: " + description;
	}

}
