/**
 * Represent a StaffManager that could create, update and delete a Staff information.
 * This class will also read and write into the text file containing Staffs.
 * @author How Jiahe
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import RRPSS.Staff.Gender;


public class StaffManager {
	/**
	 * The collection that will store list of Staffs from the flat file.
	 */
	private Collection<Staff> staffList;

	private static StaffManager staffManager;
	
	private static String staffFileName = "Staff.dat";
	
	/**
	 * Creates a new StaffManager and populate staffList with Staffs from the flat file.
	 */
	public StaffManager() {
		staffList = new ArrayList<Staff>();
	}
	
	/**
	 * Returns the collection of Staffs.
	 * @return Return the collection of Staffs.
	 */
	public Collection<Staff> getStaffList() {
		return this.staffList;
	}

	/**
	 * Changes the list of Staffs.
	 * @param staffList The list of Staff.
	 */
	public void setStaffList(Collection<Staff> staffList) {
		this.staffList = staffList;
	}
	
	/**
	 * Creates a new Staff.
	 * @param GENDER      The gender of the staff.
	 * @param name        The name of the staff.
	 * @param id          The identification number of the staff.
	 * @param jobTitle    The job position of the staff.
	 */
	public void createStaff(Gender GENDER, String name, String id, String jobTitle) {
		Staff s = new Staff(GENDER, name, id,jobTitle);
		staffList.add(s);
	}
	
	/**
	 * Updates a particular staff in the staffList.
	 * @param staffID The ID of the Staff to be updated.
	 */
	public void updateStaff(String staffID) {
		Staff s = getStaff(staffID);
		
		int choice, genderChoice;
		String updateName, updateJobTitle;
		Scanner sc = new Scanner(System.in);
		
		if (s == null) {
			System.out.println("Please enter an existing Staff ID");
			return;
		}
		
		do {
			System.out.println("1. Update Gender");
			System.out.println("2. Update Name");
			System.out.println("3. Update Job Title");
			System.out.println("4. Exit");
			System.out.print("Please enter the number of your choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println("1. Male");
					System.out.println("2. Female");
					System.out.println("3. Unknown");
					System.out.print("Please select the choice of gender: ");
					genderChoice = sc.nextInt();
					if (genderChoice == 1) {
						s.setGender(Gender.MALE);
					}
					else if (genderChoice ==2) {
						s.setGender(Gender.FEMALE);
					}
					else s.setGender(Gender.UNKNOWN);
					break;
					
				case 2:
					System.out.print("Please enter the new name: ");
					updateName = sc.next();
					sc.nextLine();
					s.setName(updateName);
					break;
					
				case 3:
					System.out.print("Please enter the new Job Title: ");
					updateJobTitle = sc.next();
					sc.nextLine();
					s.setJobTitle(updateJobTitle);
					break;
					
				case 4:
					System.exit(0);
			}
		} while (choice < 7);
		
		System.out.println("+++ New updated staff +++\n");
		System.out.println("Gender:      " + s.getGender());
		System.out.println("Name:        " + s.getName());
		System.out.println("Job Title:   " + s.getJobTitle());
	}

	/**
	 * Deletes a specific Staff.
	 * @param id Given Staff ID used for searching specific Staff to delete.
	 */
	public void deleteStaff(String id) {
		for (Staff s : staffList) {
			if (s.getId() == id) {
				staffList.remove(s);
				break;
			}
		}
	}

	/**
	 * Return a specific Staff.
	 * @param staffID Given staff ID used for searching specific Staff.
	 * @return Return Staff s if found or else return null if no such Staff exists.
	 */
	public Staff getStaff(String staffID) {
		for (Staff s : staffList) {
			if (s.getId() == staffID)
				return s;
		}
		return null;
	}
}