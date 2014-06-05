package com.campusfeatures;

import java.sql.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class DatabaseAccess {
	private Connection conn;
	
	
	public DatabaseAccess() {
		conn = null;
	}
	
	public boolean openDatabase(DataSource ds) {
		try {
			conn = ds.getConnection();
			System.out.println("Connected!");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean closeDatabase() {
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
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<ParkingLot> rsArray = new ArrayList<ParkingLot>();
			while(rs.next()) {
				rsArray.add(new ParkingLot(rs.getString("Lot_Name"), rs.getDouble("X_Coord"), rs.getDouble("Y_Coord"),
										rs.getShort("Capacity"), rs.getShort("Vehicles"), rs.getBoolean("Lot_Open")));
			}
			return rsArray;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return null;
		}
	}
	
	public ArrayList<Obstruction> getObstructionData() {
		String sql = "SELECT * FROM Obstructions";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<Obstruction> rsArray = new ArrayList<Obstruction>();
			while(rs.next()) {
				rsArray.add(new Obstruction(rs.getString("Street_Name"), rs.getDouble("X_Coord"),
						             rs.getDouble("Y_Coord"), rs.getString("description")));
			}
			return rsArray;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return null;
		}
	}
	
	//Search function finds Parking Lot in database and returns Parking Lot object
	public ParkingLot getParkingLot(String lotName){
		String sql = "SELECT * FROM ParkingLots WHERE Lot_Name = ?";
		ParkingLot yourLot;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				yourLot = new ParkingLot();
				yourLot.setLotName(rs.getString("Lot_Name"));
				yourLot.setXCoord(rs.getDouble("X_Coord"));
				yourLot.setYCoord(rs.getDouble("Y_Coord"));
				yourLot.setTotalCapacity(rs.getShort("Capacity"));
				yourLot.setNumberVehicles(rs.getShort("Vehicles"));
				yourLot.setLotOpen(rs.getBoolean("Lot_Open"));
				return yourLot;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//Functions for inserting Parking lot row and Obstruction row
	public int insertParkingLotRow(String lotName, double xCoord, double yCoord, short capacity, short vehicles, boolean isOpen) {
		try {
			String sql = "INSERT INTO ParkingLots VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			pstmt.setDouble(2, xCoord);
			pstmt.setDouble(3, yCoord);
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
		}
	}
	public int insertObstructionRow(String streetName, double xCoord, double yCoord) {
		try {
			String sql = "INSERT INTO Obstructions VALUES (?,?,?,NULL)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, streetName);
			pstmt.setDouble(2, xCoord);
			pstmt.setDouble(3, yCoord);
			int i = pstmt.executeUpdate();
			String logUpdateString = streetName + " " + xCoord + " " + yCoord;
			logObstructionInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		}
	}
	public int insertObstructionRow(String streetName, double xCoord, double yCoord, String description) {
		try {
			String sql = "INSERT INTO Obstructions VALUES (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, streetName);
			pstmt.setDouble(2, xCoord);
			pstmt.setDouble(3, yCoord);
			pstmt.setString(4, description);
			int i = pstmt.executeUpdate();
			String logUpdateString = streetName + " " + xCoord + " " + yCoord + " " + description;
			logObstructionInsert(logUpdateString);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		}
	}
	
	//Functions for removing Parking lot row and Obstruction row
	public int removeParkingLotRow(String lotName) {
		try{
			String sql = "DELETE FROM ParkingLots WHERE Lot_Name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lotName);
			int i = pstmt.executeUpdate();
			logParkingLotRemove(lotName);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
		}
	}
	public int removeObstructionRow(double xCoord, double yCoord) {
		try{
			String sql = "DELETE FROM Obstructions WHERE X_Coord = ? AND Y_Coord = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, xCoord);
			pstmt.setDouble(2, yCoord);
			int i = pstmt.executeUpdate();
			String logUpdate = xCoord + " " + yCoord;
			logObstructionRemove(logUpdate);
			return i;
		} catch (SQLException sqle) {
			System.out.println(sqle);
			return 0;
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
