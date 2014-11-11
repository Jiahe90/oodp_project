/**
 * Represents a member in the restaurant.
 * It contains member's name and contact number.
 * @author Leon
 * @version 1.0
 * @since 2014-10-19 
 */
package RRPSS;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * Member's name.
	 */
	private String name;
	
	/**
	 * Member's contact number.
	 */
	private int contactNo;
	
	/**
	 * Creates a new member with the given parameters.
	 * @param name Member's name.
	 * @param contactNo	Member's contact number.
	 */
	public Member(String name, int contactNo) {
		this.name = name;
		this.contactNo = contactNo;
	}
	
	/**
	 * Gets the member's name.
	 * @return Returns the member's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Changes the member's name.
	 * @param name Member's new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the member's contact number.
	 * @return Returns the member's contact number.
	 */
	public int getContactNo() {
		return contactNo;
	}
	
	/**
	 * Changes the member's contact number.
	 * @param contactNo Member's new contact number.
	 */
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
}
