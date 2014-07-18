package com.campustraffic.web.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.campustraffic.web.dao.DatabaseAccess;
import com.campustraffic.web.forms.AdminParkingLotForm;

public class AdminParkingLotAction extends Action {
	    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    							 HttpServletRequest request, HttpServletResponse response)
	    									 throws Exception {
	    	
	    	AdminParkingLotForm parkingLotForm = (AdminParkingLotForm) form;
	    	String lotName = parkingLotForm.getLotName();
	    	BigDecimal xCoord = new BigDecimal(parkingLotForm.getxCoord());
	    	BigDecimal yCoord = new BigDecimal(parkingLotForm.getyCoord());
	    	short capacity = java.lang.Short.parseShort(parkingLotForm.getCapacity());
	    	short vehicles = java.lang.Short.parseShort(parkingLotForm.getVehicles());
	    	boolean lotOpen = parkingLotForm.isLotOpen();
	    	
	    	DatabaseAccess DBAccess = new DatabaseAccess();
	    	DBAccess.editParkingLotRow(lotName, xCoord, yCoord, capacity, vehicles, lotOpen);
	    	
	    	ActionForward forward = new ActionForward(); // return value
	    	forward = mapping.findForward("success");
	    	return (forward);
	    }
	}
