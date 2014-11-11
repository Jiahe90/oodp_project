/**
 * Represents a TableManager to could create, edit and delete Table.
 * This class will also read and write into the file text containing Tables.
 * @author Leon
 * @version 1.0
 * @since 2014-10-19
 */
package RRPSS;

import java.util.ArrayList;
import java.util.Collection;

public class TableManager {
	/**
	 * The Collection that will store list of tables from the flat file.
	 */
	private Collection<Table> tableList;
	
	private static String tableFileName = "Tables.dat";
	
	private static TableManager tableManager;
	
	/**
	 * Creates a new TableManager and populate tableList with tables from the flat file.
	 */
	private TableManager() {
		tableList = new ArrayList<Table>();
		try {
			tableList = SerializeDB.readSerializedObject(tableFileName);
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}		
	}
	
	public static TableManager getInstance() {
		if (tableManager == null)
			tableManager = new TableManager();
		return tableManager;
	}
	
	/**
	 * Creates a new Table.
	 * @param seats Indicates the seat capacity.
	 */
	public void createTable(int seats) {
		ArrayList temp = new ArrayList();
		Table newTable = new Table(tableList.size(), seats, true);
		temp.add(newTable);
		//Store Table in file
		SerializeDB.writeSerializedObject("Tables.dat", temp);
		tableList.add(newTable);
	}
	
	/**
	 * Locates the table with given table number and performs update on it.
	 * @param tableNo Given table number to locate specific Table.
	 * @param status Updates the Table to according to the status.
	 * @param noOfSeats	Updates the seating capacity of the Table.
	 */
	public void updateTable(int tableNo, boolean status, int noOfSeats) {
		Table table = getTable(tableNo);
		if (table != null) {
			table.setCurrentlyOccupied(status);
			table.setNoOfSeats(noOfSeats);
			//Need to update file. Clear all before re-populating
			updateTableFile(tableFileName, tableList);
		} else
			System.out.println("No such table");
	}
	
	/**
	 * Deletes a specific Table.
	 * @param tableNo Given table number to locate Table to delete.
	 */
	public void deleteTable(int tableNo) {
		Table table = getTable(tableNo);
		if (table != null) {
			table.removeReservation();
			tableList.remove(table);
			//Need to update file. Clear all before re-populating
			updateTableFile(tableFileName, tableList);
		} else
			System.out.println("No such table");
	}
	
	/**
	 * Returns the collection of Tables.
	 * @return Return the collection of Tables.
	 */
	public Collection<Table> getTables() {
		return tableList;
	}
	
	/**
	 * Change the status of all Table in the Lists.
	 */
	public void setTables() {
		for (Table table : tableList) {
			if (table != null)
				table.setCurrentlyOccupied(false);
		}
		//Need to update file. Clear all before re-populating
		updateTableFile(tableFileName, tableList);
	}
	
	/**
	 * Returns a Table that have the exact amount of seat capacity.
	 * @param seats Given seat capacity amount to satisfied.
	 * @return Table that fits the given seat capacity.
	 */
	public Table getAvailableTable(int seats) {
		for (Table table : tableList) {
			if (table != null && table.getNoOfSeats() == seats && table.getCurrentlyOccupied() == false)
				return table;
		}
		return null;
	}
	
	/**
	 * Returns a specific Table.
	 * @param tableNo Given Table Number used for searching specific Table.
	 * @return Returns Table t if found. Return null if no such Table exists.
	 */
	public Table getTable(int tableNo) {
		for (Table table : tableList) {
			if (table != null && table.getTableNo() == tableNo)
				return table;
		}
		return null;
	}
	
	private void updateTableFile(String filename, Collection list) {
		SerializeDB.updateFile("Tables.dat", list);
	}
}
