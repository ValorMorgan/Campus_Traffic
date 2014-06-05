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
public class lotGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/CampusTrafficDataSource")
	DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lotGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseAccess DBAccess = new DatabaseAccess();
		DBAccess.openDatabase(ds);
		
		String lotName = (String)request.getParameter("lotList");
		System.out.println(lotName);
		ParkingLot yourLot = DBAccess.getParkingLot(lotName);

		request.setAttribute("yourLot", yourLot);
		request.setAttribute("xCoord", yourLot.getXCoord());
		request.setAttribute("yCoord", yourLot.getYCoord());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/searchResults.jsp");
		rd.forward(request, response);
		
		DBAccess.closeDatabase();
	}
}