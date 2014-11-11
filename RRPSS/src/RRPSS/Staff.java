/**
 * Represent a Staff that works and access the RRPSS in the restaurant.
 * They will have a unique ID, name, gender and jobTitle.
 * @author How Jiahe
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;

import java.io.Serializable;

public class Staff implements Serializable{

	/**
	 * Categories of gender the staff belong to.
	 */
	public enum Gender {
		MALE,
		FEMALE,
		UNKNOWN
	}
	
	/**
	 * The gender of the staff.
	 */
	public Gender GENDER;
	
	/**
	 * Creates a new staff database along with all possible attributes.
	 * @param GENDER      The gender of the staff.
	 * @param name        The name of the staff.
	 * @param id          The identification number of the staff.
	 * @param jobTitle    The job position of the staff.
	 */
	public Staff(Gender GENDER, String name, String id, String jobTitle) {
		this.GENDER = GENDER;
		this.name = name;
		this.id = id;
		this.jobTitle = jobTitle;
	}
	
	/**
	 * The name of the staff.
	 */
	private String name;
	
	/**
	 * The identification number of the staff.
	 */
	private String id;
	
	/**
	 * The job position of the staff.
	 */
	private String jobTitle;

	/**
	 * Get the name of the current staff.
	 * @return The name of the staff.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of the current staff.
	 * @param name The new name of the staff.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the identification number of the current staff.
	 * @return The identification number of the staff.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Changes the identification number of the current staff.
	 * @param id The new identification number of the staff.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the job position of the current staff.
	 * @return The job position of the staff.
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Changes the job position of the current staff.
	 * @param jobTitle The new job position of the staff.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**
	 * Get the Gender of the Staff.
	 * @return The Gender of the Staff.
	 */
	public Gender getGender() {
		return GENDER;
	}

	/**
	 * Changes the Gender of the Staff.
	 * @param GENDER The Gender of the Staff.
	 */
	public void setGender(Gender GENDER) {
		this.GENDER = GENDER;
	}
}