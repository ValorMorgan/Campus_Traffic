package com.campustraffic.web.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.campustraffic.util.Obstruction;
import com.campustraffic.util.ParkingLot;
import com.campustraffic.web.dao.DatabaseAccess;

public class MapDataAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DatabaseAccess dao = new DatabaseAccess();
		
		ArrayList<ParkingLot> lots = dao.getParkingLotData();
		ArrayList<Obstruction> obstructions = dao.getObstructionData();
		
		request.setAttribute("parkingLots", lots);
		request.setAttribute("obstructions", obstructions);
		
		return(mapping.findForward("map"));
	}
}
