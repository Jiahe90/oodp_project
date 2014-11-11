/**
 * This is a MemberManager that manage Member.
 * Able to create, remove and check for member.
 * @author Leon
 * @version 1.0
 * @since 2014-10-19 
 */
package RRPSS;

import java.util.ArrayList;
import java.util.Collection;

public class MemberManager {
	/**
	 * A collection of Member
	 */
	private Collection<Member> memberList;
	
	private static MemberManager memberManager;
	
	private static String memberFileName = "Member.dat";
	
	private MemberManager() {
		memberList = new ArrayList<Member>();
		try {
			memberList = SerializeDB.readSerializedObject("Member.dat");
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}	
	}
	
	public static MemberManager getInstance() {
		if (memberManager == null)
			memberManager = new MemberManager();
		return memberManager;
	}
	
	/**
	 * Gets the collection of member.
	 * @return Returns the collection of member.
	 */
	public Collection<Member> getMemberList() {
		return memberList;
	}
	
	/**
	 * Changes the collection of member.
	 * @param memberList The new collection of member.
	 */
	public void setMemberList(Collection<Member> memberList) {
		this.memberList = memberList;
	}
	
	/**
	 * Creates a new Member using the parameters.
	 * @param name	New member's name.
	 * @param contactNo	New member's contact number.
	 */
	public void createMember(String name, int contactNo) {
		Member newMember = new Member(name, contactNo);
		memberList.add(newMember);
		updateMemberFile(memberFileName, memberList);
	}
	
	/**
	 * Removes a particular Member using the parameters.
	 * @param name	Name of member to be remove.
	 * @param contactNo	Contact number of member to be remove.
	 */
	public void removeMember(String name, int contactNo) {
		Member member = this.getMember(name, contactNo);
		if (member != null) {
			memberList.remove(member);
			updateMemberFile(memberFileName, memberList);
		}	
	}
	
	/**
	 * Checks whether a person is a member.
	 * @param name	Name of person to be check.
	 * @param contactNo Contact number of person to be check.
	 * @return Return a boolean result that indicate whether the person is a member.
	 */
	public boolean checkMember(String name, int contactNo) {
		Member member = this.getMember(name, contactNo);
		if (member != null)
			return true;
		return false;
	}
	
	public Member getMember(String name, int contactNo) {
		for (Member member : memberList) {
			if (member != null && member.getName().equals(name) && member.getContactNo() == contactNo) {
				return member;
			}
		}
		return null;
	}
	
	private void updateMemberFile(String filename, Collection list) {
		SerializeDB.updateFile(filename, list);
	}
}
