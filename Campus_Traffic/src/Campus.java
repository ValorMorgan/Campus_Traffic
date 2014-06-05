import com.campusfeatures.*;
import java.util.ArrayList;

public class Campus {
	public static void main(String[] args){
		DatabaseAccess DBAccess = new DatabaseAccess();
		DBAccess.openDatabase(); // Open access to database
		

		ArrayList<ParkingLot> parkingLotArray = DBAccess.getParkingLotData();
		ArrayList<Obstruction> obstructionArray = DBAccess.getObstructionData();
		
		System.out.println("Lot Name\tX Coordinate\t\tY Coordinate\t\tCapacity\tVehicles\tOpen\tUpdate");
		for(ParkingLot cur : parkingLotArray) {
			System.out.println(cur);
		}
		System.out.println("\nObstructions:");
		for(Obstruction cur : obstructionArray) {
			System.out.println(cur);
		}
		
		//		-- Show off adding a row of new info to database --
		//		Adds row to database
		if(DBAccess.insertParkingLotRow("pl11", 42.726636, -84.484728, (short)68, (short)12, false) >= 1) {
			System.out.println("Row Inserted");
		}
		if(DBAccess.removeParkingLotRow("pl11") >= 1) {
			System.out.println("Row Removed");
		}
		if(DBAccess.insertObstructionRow("Shaw", 42.726636, -84.484728, "Closed for construction") >= 1) {
			System.out.println("Row Inserted");
		}
		if(DBAccess.removeObstructionRow(42.726636, -84.484728) >= 1) {
			System.out.println("Row Removed");
		}
		
		DBAccess.closeDatabase(); // Close access to database
	}
}