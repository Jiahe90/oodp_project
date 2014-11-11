/**
 * 
 * @author Allan
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;
import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable {
	/**
	 * The name of patron making reservation.
	 */
	private String name;
	
	/**
	 * The date and time of reservation.
	 */
	private Calendar dateTime;
	
	/**
	 * The number of seats needed to be reserved.
	 */
	private int noOfPersons;
	
	/**
	 * The contact number of the patron making the reservation.
	 */
	private int contactNumber;
	
	/**
	 * The table that the reservation is assigned to.
	 */
	private Table table = null;
	
	/**
	 * Creates a reservation along with all the possible attributes.
	 * @param name Name of the customer.
	 * @param date	
	 * @param time
	 * @param noOfPersons
	 * @param contactNumber
	 * @param table
	 */
	public Reservation (String name, Calendar dateTime, int noOfPersons, int contactNumber, Table table){
		this.name = name;
		this.dateTime = dateTime;
		this.noOfPersons = noOfPersons;
		this.contactNumber = contactNumber;
		setTable(table);
	}
	
	/**
	 * Gets the name of customer that place the reservation.
	 * @return Name of customer.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of customer that place the reservation.
	 * @param name New customer name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns Calendar that contains the date and time of reservation.
	 * @return Date and Time of reservation.
	 */
	public Calendar getDateTime() {
		return this.dateTime;
	}
	
	/**
	 * Change the existing Calendar to an updated one.
	 * @param dateTime New date and time to be replace the older one.
	 */
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the number of customers the reservation is for.
	 * @return Number of customers.
	 */
	public int getNoOfPersons() {
		return this.noOfPersons;
	}

	/**
	 * Changes the number of customers the reservation is for.
	 * @param persons New number of customers.
	 */
	public void setNoOfPersons(int persons) {
		this.noOfPersons = persons;
	}

	/**
	 * Gets the contact number of customer that place the reservation.
	 * @return Contact number of customer.
	 */
	public int getContactNumber() {
		return this.contactNumber;
	}

	/**
	 * Changes the contact number of customer that place the reservation.
	 * @param contactNumber New contact number of customer.
	 */
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * Gets the table that this reservation is based on.
	 * @return The Table object that hold this reservation.
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * Changes the table that was assigned to this reservation.
	 * @param table The new table to be assigned to.
	 */
	public void setTable(Table table) {
		if(this.table != table) {
			//If there is already a table, unassigned reservation from it
			if(this.table != null)
				this.table.removeReservation(this);
			//If the new table is not null, assign the reservation to it
			if(table != null)
				table.addReservation(this);
			
			this.table = table;
		}
	}

}