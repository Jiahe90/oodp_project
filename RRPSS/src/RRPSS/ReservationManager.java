package RRPSS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class ReservationManager {
	private Collection<Reservation> reservationList;
	
	private static ReservationManager reservationManager;
	
	private static String reservationFileName = "reservationFileName";
	
	public ReservationManager() {
		reservationList = new ArrayList<Reservation>();
		try {
			reservationList = SerializeDB.readSerializedObject("Reservation.dat");
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}		
	}
	
	public void createReservation(String name, Calendar dateTime, int persons, int contactNo, Table table) {
		ArrayList temp = new ArrayList();
		Reservation newReservation = new Reservation(name, dateTime, persons, contactNo, table);
		temp.add(newReservation);
		//Store Reservation in file
		SerializeDB.writeSerializedObject("Reservation.dat", temp);
		reservationList.add(newReservation);
	}
	
	public void updateReservation(String name, Calendar dateTime, int person, int contactNo, Table table) {
		Reservation reservation = getReservation(name, contactNo);
		if (reservation != null) {
				reservation.setName(name);
				reservation.setDateTime(dateTime);
				reservation.setNoOfPersons(person);
				reservation.setContactNumber(contactNo);
				reservation.setTable(table);
				updateReservationFile();
		} else
			System.out.println("No such reservation");
	}
	
	public void deleteReservation(String name, int contactNo) {
		Reservation reservation = getReservation(name, contactNo);
		if(reservation != null) {
			reservation.setTable(null);
			reservationList.remove(reservation);
			updateReservationFile();
		} else
			System.out.println("No such reservation");	
	}
	
	public Collection<Reservation> getReservationList() {
		return reservationList;
	}
	
	public void setReservationList(Collection<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	public void viewReservation(String name, int contactNo) {
		Reservation reservation = getReservation(name, contactNo);
		if(reservation != null) {
				System.out.println("Name: " + reservation.getName());
				System.out.println("Contact No: " + reservation.getContactNumber());
				System.out.println("No. Of Persons: " + reservation.getNoOfPersons());
				System.out.println("Date and Time: " + reservation.getDateTime().getTime());
		}
	}
	
	public Reservation getReservation(String name, int contactNo) {
		for (Reservation reservation : reservationList) {
			if(reservation != null && reservation.getName().equals(name) && reservation.getContactNumber() == contactNo)
				return reservation;
		}
		return null;
	}
	
	private void updateReservationFile() {
		
		SerializeDB.writeSerializedObject("Reservation.dat", null);
		SerializeDB.writeSerializedObject("Reservation.dat", (ArrayList) reservationList);
	}
}
