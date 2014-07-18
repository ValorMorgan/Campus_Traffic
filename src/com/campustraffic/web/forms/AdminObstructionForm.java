package com.campustraffic.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AdminObstructionForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private int ID = -1;
    private String streetName = null;
    private String xCoord = null;
    private String yCoord = null;
    private String description = null;
    
    public int getID() {
    	return ID;
    }
    public void setID(int ID) {
    	this.ID = ID;
    }
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName.trim();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description.trim();
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		ID = -1;
		streetName = null;
	    xCoord = null;
	    yCoord = null;
	    description = null;
    }
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        request.setAttribute("old_streetName", this.streetName);
        request.setAttribute("old_xCoord", this.xCoord);
        request.setAttribute("old_yCoord", this.yCoord);
        request.setAttribute("old_description", this.description);

        if(this.streetName.isEmpty()) {
        	errors.add("error.obstructionForm.streetName", new ActionMessage("error.obstructionForm.streetName", this.streetName));
        }
        if(this.xCoord.isEmpty() || !this.xCoord.matches("^(-)?[0-9]{1,3}(.[0-9]{0,6})?")) {
        	errors.add("error.obstructionForm.xCoord", new ActionMessage("error.obstructionForm.xCoord", this.xCoord));
        }
        if(this.yCoord.isEmpty() || !this.xCoord.matches("^(-)?[0-9]{1,3}(.[0-9]{0,6})?")) {
        	errors.add("error.obstructionForm.yCoord", new ActionMessage("error.obstructionForm.yCoord", this.yCoord));
        }
        
        return errors;
    }
}