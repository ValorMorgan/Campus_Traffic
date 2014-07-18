package com.campustraffic.util;

import java.math.BigDecimal;

public class ParkingLot {

	String lotName;
	BigDecimal xCoord;
	BigDecimal yCoord;
	Integer curCars;
	Integer capacity;
	Boolean lotOpen;
	
	
	public ParkingLot(){
		lotName = "New Lot";
		xCoord = new BigDecimal(0.0);
		yCoord = new BigDecimal(0.0);
		curCars = 0;
		capacity = 20;
		lotOpen = false;
	}
	
	public ParkingLot(String lotname, BigDecimal xCoord, BigDecimal yCoord, int capacity, int curCars, boolean lotOpen){
		this.lotName = lotname;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.curCars = curCars;
		this.capacity = capacity;
		this.lotOpen = lotOpen;
	}

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
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

	public int getCurCars() {
		return curCars;
	}

	public void setCurCars(Integer curCars) {
		this.curCars = curCars;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public boolean getLotOpen() {
		return lotOpen;
	}

	public void setLotOpen(Boolean lotOpen) {
		this.lotOpen = lotOpen;
	}
	
	@Override
	public String toString(){
		return "Parking Lot: lot " + lotName + ", coords(" + xCoord + ", " + yCoord + "), capacity: " + curCars + "/" + capacity + ", lot status: " + lotOpen;
	}

}
