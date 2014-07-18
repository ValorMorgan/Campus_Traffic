package com.campustraffic.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AdminParkingLotForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String lotName = null;
    private String xCoord = null;
    private String yCoord = null;
    private String capacity = null;
    private String vehicles = null;
    private boolean lotOpen = true;
    
	public String getLotName() {
		return lotName;
	}
	public void setLotName(String lotName) {
		this.lotName = lotName.trim();
	}
	public String getxCoord() {
		return xCoord;
	}
	public void setxCoord(String xCoord) {
		this.xCoord = xCoord.trim();
	}
	public String getyCoord() {
		return yCoord;
	}
	public void setyCoord(String yCoord) {
		this.yCoord = yCoord.trim();
	}
	public String getCapacity() {
		return this.capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity.trim();
	}
	public String getVehicles() {
		return this.vehicles;
	}
	public void setVehicles(String vehicles) {
		this.vehicles = vehicles.trim();
	}
	public boolean isLotOpen() {
		return lotOpen;
	}
	public void setLotOpen(boolean lotOpen) {
		this.lotOpen = lotOpen;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		lotName = null;
	    xCoord = null;
	    yCoord = null;
	    capacity = null;
	    vehicles = null;
	    lotOpen = true;
    }
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        if (this.capacity.isEmpty() || !this.capacity.matches("[0-9]{1,4}")) {
        	errors.add("error.parkingLotForm.capacity", new ActionMessage("error.parkingLotForm.capacity", this.capacity));
        }
        
        if (this.vehicles.isEmpty() || !this.vehicles.matches("[0-9]{1,4}")) {
        	errors.add("error.parkingLotForm.vehicles", new ActionMessage("error.parkingLotForm.vehicles", this.vehicles));
        }
        
        return errors;
    }

}