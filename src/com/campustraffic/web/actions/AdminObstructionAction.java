package com.campustraffic.web.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.campustraffic.web.dao.DatabaseAccess;
import com.campustraffic.web.forms.AdminObstructionForm;

public class AdminObstructionAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    							 HttpServletRequest request, HttpServletResponse response)
    									 throws Exception {
    	
    	AdminObstructionForm obstructionForm = (AdminObstructionForm) form;
    	int ID = obstructionForm.getID();
    	String streetName = obstructionForm.getStreetName();
    	BigDecimal xCoord = new BigDecimal(obstructionForm.getxCoord());
    	BigDecimal yCoord = new BigDecimal(obstructionForm.getyCoord());
    	String description = obstructionForm.getDescription();
    	
    	DatabaseAccess DBAccess = new DatabaseAccess();
    	if(request.getParameter("Edit") != null) { // Edit row
    		DBAccess.editObstructionRow(ID, streetName, xCoord, yCoord, description);
    	} else if(request.getParameter("Remove") != null) { // Remove row
    		DBAccess.removeObstructionRow(ID);
    	} else { // Add row
    		DBAccess.insertObstructionRow(streetName, xCoord, yCoord, description);
    	}
    	
    	request.setAttribute("old_streetName", "");
        request.setAttribute("old_xCoord", "");
        request.setAttribute("old_yCoord", "");
        request.setAttribute("old_description", "");
    	
    	ActionForward forward = new ActionForward(); // return value
    	forward = mapping.findForward("success");
    	return (forward);
    }
}