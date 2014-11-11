/**
 * Represent a Table in the restaurant.
 * It will contain a unique TableNo, seat capacity, current status and also a list of reservation for this Table.
 * @author Leon Lee
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Calendar;

public class Table implements Serializable{
	/**
	 * The unique table number of this Table.
	 */
	private int tableNo;
	
	/**
	 * The seat capacity of this Table.
	 */
	private int noOfSeats;
	
	/**
	 * The status of this Table.
	 */
	private boolean currentlyOccupied;
	
	/**
	 * A collection of reservation for this table.
	 */
	private  Collection<Reservation> reservationList;
	
	/**
	 * Creates a new Table with the given tableNo, noOfSeats and currentlyOccupied.
	 * @param tableNo This is Table's tableNo.
	 * @param noOfSeats This is Table's capacity.
	 * @param currentlyOccupied This is the status of the Table.
	 */
	public Table(int tableNo, int noOfSeats, boolean currentlyOccupied) {
		this.tableNo = tableNo;
		this.noOfSeats = noOfSeats;
		this.currentlyOccupied = currentlyOccupied;
		reservationList = new ArrayList<Reservation>();
	}
	
	/**
	 * Gets the table number of this Table.
	 * @return This Table's tableNo.
	 */
	public int getTableNo() {
		return tableNo;
	}
	
	/**
	 * Gets the seat capacity of this Table.
	 * @return This Table's noOfSeats.
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	/**
	 * Gets the status of this Table.
	 * @return This Table's currentlyOccupied.
	 */
	public boolean getCurrentlyOccupied() {
		return currentlyOccupied;
	}
	
	/**
	 * Gets all the reservation booking for this Table.
	 * @return This Table's reservation bookings
	 */
	public Collection<Reservation> getReservationList() {
		return this.reservationList;
	}
	
	/**
	 * Changes the table number of this Table.
	 * @param tableNo This Table's new tableNo.
	 */
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	
	/**
	 * Changes the seating capacity of this Table.
	 * @param tableNo This Table's new noOfSeats.
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	/**
	 * Changes the status of this Table.
	 * @param tableNo This Table's new currentlyOccupied.
	 */
	public void setCurrentlyOccupied(boolean currentlyOccupied) {
		this.currentlyOccupied = currentlyOccupied;
	}
	
	/**
	 * Change the reservations of this Table.
	 * @param reservationList This Table's new reservation list.
	 */
	public void setReservationList(Reservation reservation) {
		if(!reservationList.contains(reservation)) {
			reservationList.add(reservation);
			reservation.setTable(this);
		}
	}
	
	/**
	 * To check whether the Table is unoccupied during a given time.
	 * @param dateTime The given time to check for availability.
	 * @return This return whether the Table is free for a given time.
	 */
	public boolean getAvailability(Calendar dateTime) {
		for(Reservation r : reservationList) {
			Calendar time2HrBefore = (Calendar) r.getDateTime();
			time2HrBefore.add(Calendar.HOUR_OF_DAY, -2);
			Calendar time2HrAfter = (Calendar) r.getDateTime();
			time2HrAfter.add(Calendar.HOUR_OF_DAY, 2);
			
			if (!dateTime.before(time2HrBefore) || !dateTime.after(time2HrAfter))
				return false;
		}
		return true;
	}
	
	public void addReservation(Reservation reservation) {
		reservationList.add(reservation);
		reservation.setTable(this);
	}
	
	/**
	 * Remove all reservation from the Table's reservation list.
	 * @return true When removal is complete.
	 */
	public boolean removeReservation() {
		
		for(Reservation r : reservationList) {
			r.setTable(null);
		}
		reservationList.clear();
		return true;
	}
	
	/**
	 * Remove a given reservation from the Table's reservation list.
	 * @param reservation This the reservation to be remove from the reservationList.
	 * @return This is indicate whether the removal operation is successful or not.
	 */
	public boolean removeReservation(Reservation reservation) {
		
		if (reservationList.contains(reservation)) {
			reservation.setTable(null);
			reservationList.remove(reservation);
			return true;
		}
		return false;
	}
}

