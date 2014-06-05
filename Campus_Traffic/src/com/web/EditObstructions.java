package com.web;

import java.io.IOException;
import java.util.ArrayList;

import com.campusfeatures.DatabaseAccess;
import com.campusfeatures.Obstruction;
import com.campusfeatures.ParkingLot;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class lotGet
 */
public class EditObstructions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/CampusTrafficDataSource")
	DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditObstructions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseAccess DBAccess = new DatabaseAccess();
		DBAccess.openDatabase(ds);
		System.out.println(request.getParameter("edit"));
		String streetName = (String)request.getParameter("streetName");
		String sXCoord = (String)request.getParameter("xCoord");
		double xCoord = Double.parseDouble(sXCoord);
		String sYCoord = (String)request.getParameter("yCoord");
		double yCoord = Double.parseDouble(sYCoord);
		String obstructionDescription = (String)request.getParameter("obstructionDescription");
		
		int i = DBAccess.insertObstructionRow(streetName, xCoord, yCoord, obstructionDescription);
		request.setAttribute("rowsIns", i);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/admin.jsp");
		rd.forward(request, response);
		
		DBAccess.closeDatabase();
	}
}