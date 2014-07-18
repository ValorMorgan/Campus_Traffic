package com.campustraffic.web.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.math.BigDecimal;

import com.campustraffic.util.*;

public class DatabaseAccess {
	private Connection conn;
	
	public DatabaseAccess() {
		conn = null;
	}
	
	private boolean openDatabase() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CAMPUS", "guest", "password");
			System.out.println("Connected!");
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean closeDatabase() {
		try {
			if (conn != null) {
				conn.close();
			}
			System.out.println("Connection closed...");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<ParkingLot> getParkingLotData() {
		String sql = "SELECT * FROM ParkingLots ORDER BY Lot_Name";
		ArrayList<ParkingLot> rsArray = new ArrayList<ParkingLot>();
		
		try {
			openDatabase();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				rsArray.add(new ParkingLot(rs.getString("Lot_Name"), rs.getBigDecimal("X_Coord"), rs.getBigDecimal("Y_Coord"),
										rs.getShort("Capacity"), rs.getShort("Vehicles"), rs.getBoolean("Lot_Open")));
			}
			
			return rsArray;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return null;
		} finally {
			closeDatabase();
		}
	}
	
	public ArrayList<Obstruction> getObstructionData() {
		String sql = "SELECT * FROM Obstructions ORDER BY ID";
		ArrayList<Obstruction> rsArray = new ArrayList<Obstruction>();
		
		try {
			openDatabase();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				rsArray.add(new Obstruction(rs.getInt("ID"), rs.getString("Street_Name"), rs.getBigDecimal("X_Coord"),
						             rs.getBigDecimal("Y_Coord"), rs.getString("description")));
			}
			
			return rsArray;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return null;
		} finally {
			closeDatabase();
		}
	}
	
	//Search function finds Parking Lot in database and returns Parking Lot object
	public ParkingLot getParkingLot(String lotName){
		String sql = "SELECT * FROM ParkingLots WHERE Lot_Name = ?";
		ParkingLot yourLot;
		try {
			openDatabase();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				yourLot = new ParkingLot();
				yourLot.setLotName(rs.getString("Lot_Name"));
				yourLot.setxCoord(rs.getBigDecimal("X_Coord"));
				yourLot.setyCoord(rs.getBigDecimal("Y_Coord"));
				yourLot.setCapacity((int) rs.getShort("Capacity"));
				yourLot.setCurCars((int) rs.getShort("Vehicles"));
				yourLot.setLotOpen(rs.getBoolean("Lot_Open"));
				return yourLot;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeDatabase();
		}
	}
	
	//Functions for inserting Parking lot row and Obstruction row
	public int insertParkingLotRow(String lotName, BigDecimal xCoord, BigDecimal yCoord, short capacity, short vehicles, boolean isOpen) {
		try {
			openDatabase();
			
			String sql = "INSERT INTO ParkingLots VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			pstmt.setBigDecimal(2, xCoord);
			pstmt.setBigDecimal(3, yCoord);
			pstmt.setShort(4, capacity);
			pstmt.setShort(5, vehicles);
			pstmt.setBoolean(6, isOpen);
			int i = pstmt.executeUpdate();
			String logUpdateString = lotName + " " + xCoord + " " + yCoord + " " + capacity + " " + vehicles + " " + isOpen;
			logParkingLotInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	public int insertObstructionRow(String streetName, BigDecimal xCoord, BigDecimal yCoord, String description) {
		try {
			openDatabase();
			
			String sql;
			if(description.isEmpty()) {
				sql = "INSERT INTO Obstructions VALUES (DEFAULT,?,?,?,DEFAULT)";
			} else {
				sql = "INSERT INTO Obstructions VALUES (DEFAULT,?,?,?,?)";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, streetName);
			pstmt.setBigDecimal(2, xCoord);
			pstmt.setBigDecimal(3, yCoord);
			if(!description.isEmpty()) {
				pstmt.setString(4, description);
			}
			int i = pstmt.executeUpdate();
			String logUpdateString = streetName + " " + xCoord + " " + yCoord + " " + description;
			logObstructionInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	
	public int editParkingLotRow(String lotName, BigDecimal xCoord, BigDecimal yCoord, short capacity, short vehicles, boolean isOpen) {
		try {
			openDatabase();
			
			String sql = "UPDATE ParkingLots "
					   + "SET Lot_Name=?, X_Coord=?, Y_Coord=?, Capacity=?, Vehicles=?, Lot_Open=? "
					   + "WHERE Lot_Name = '" + lotName + "'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			pstmt.setBigDecimal(2, xCoord);
			pstmt.setBigDecimal(3, yCoord);
			pstmt.setShort(4, capacity);
			pstmt.setShort(5, vehicles);
			pstmt.setBoolean(6, isOpen);
			int i = pstmt.executeUpdate();
			String logUpdateString = lotName + ": " + capacity + " , " + vehicles + " , " + isOpen;
			logParkingLotInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	public int editObstructionRow(int ID, String streetName, BigDecimal xCoord, BigDecimal yCoord, String description) {
		try {
			openDatabase();
			
			String sql = "UPDATE Obstructions "
					   + "SET Street_Name=?, X_Coord=?, Y_Coord=?, Description=? "
					   + "WHERE ID = " + ID;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, streetName);
			pstmt.setBigDecimal(2, xCoord);
			pstmt.setBigDecimal(3, yCoord);
			if(description.equals(null)) {
				pstmt.setString(4,  "");
			} else {
				pstmt.setString(4, description);
			}
			int i = pstmt.executeUpdate();
			String logUpdateString = streetName + " " + xCoord + " " + yCoord + " " + description;
			logObstructionInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	
	//Functions for removing Parking lot row and Obstruction row
	public int removeParkingLotRow(String lotName) {
		try{
			openDatabase();
			
			String sql = "DELETE FROM ParkingLots WHERE Lot_Name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			int i = pstmt.executeUpdate();
			logParkingLotRemove(lotName);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	public int removeObstructionRow(int ID) {
		try{
			openDatabase();
			
			String sql = "DELETE FROM Obstructions WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			int i = pstmt.executeUpdate();
			String logUpdate = "" + ID; // JANKY WARNING!!!!
			logObstructionRemove(logUpdate);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		} finally {
			closeDatabase();
		}
	}
	
	// Log functions for inserting parking lot and obstruction rows
	private void logParkingLotInsert(String logUpdateString) {
		try {
			FileWriter fw = new FileWriter("parkingLotLog.txt", true);
			
			Date logUpdate = new Date(System.currentTimeMillis());
			fw.write(logUpdate.toString() + ": " + logUpdateString + "\n");
			
			// Close reader/writer
			fw.close();
	    } catch (FileNotFoundException fnf) {
	    	fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void logObstructionInsert(String logUpdateString) {
		try {
			FileWriter fw = new FileWriter("obstructionLog.txt", true);
			
			Date logUpdate = new Date(System.currentTimeMillis());
			fw.write(logUpdate.toString() + ": " + logUpdateString + "\n");
			
			// Close reader/writer
			fw.close();
	    } catch (FileNotFoundException fnf) {
	    	fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Log functions for removing parking lot and obstruction rows
	private void logParkingLotRemove(String logUpdateString) {
		try {
			FileWriter fw = new FileWriter("parkingLotLog.txt", true);
			
			Date logUpdate = new Date(System.currentTimeMillis());
			fw.write(logUpdate.toString() + ": " + logUpdateString + "(Removed)\n");
			
			// Close reader/writer
			fw.close();
	    } catch (FileNotFoundException fnf) {
	    	fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void logObstructionRemove(String logUpdateString) {
		try {
			FileWriter fw = new FileWriter("obstructionLog.txt", true);
			
			Date logUpdate = new Date(System.currentTimeMillis());
			fw.write(logUpdate.toString() + ": " + logUpdateString + "(Removed)\n");
			
			// Close reader/writer
			fw.close();
	    } catch (FileNotFoundException fnf) {
	    	fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
