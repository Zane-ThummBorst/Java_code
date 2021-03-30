package se2;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeNode {
	// Data fields
	// TODO
	private String lastName;
	private List<Person> family;
	public FamilyTreeNode left;
	public FamilyTreeNode right;
	/**
     	* Constructor: instantializes a new FamilyTreeNode
     	* given a lastName
     	*/
	public FamilyTreeNode(String lastName) {
        	this.lastName = lastName;
        	family = new ArrayList<Person>();
        	left = null;
        	right = null;
	}

	/**
     	* Returns the last name of the FamilyTreeNode
     	*/
	public String getLastName() {
		//TODO
		return lastName;
	}

	/**
     	* Returns the arraylist of members in the FamilyTreeNode
     	*/
	public List<Person> getMembers() {
		//TODO
		return family;
	}

	/*
	 * Returns true if there is an instance of Person in the FamilyTreeNode that has
	 * the same first and last name provided Return false otherwise
	 */
	public boolean doesFamilyMemberExist(String lastName, String firstName) {
        	if(lastName != this.lastName) {
        		return false;
        	}
        	else {
        		for(int i = 0; i < family.size(); i++) {
        			if(family.get(i).getFirstName() == firstName) {
        				return true;
        			}
        		}
        	}
        	return false;
	}

	/**
	 * Returns true if there is an instance of Person in the FamilyTreeNode whose
	 * phone number matches the one provided Returns false otherwise
	 */
	public boolean doesNumberExist(String phoneNumber) {
		for(int i = 0; i < family.size(); i++) {
			if(family.get(i).getPhoneNumber() == phoneNumber) {
				return true;
			}
		}
    	return false;
	}

	/*
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(String lastName, String firstName, String phoneNumber) {
		if(lastName != this.lastName) {
			throw new IllegalArgumentException("Not of this family!");
		}
		Person p = new Person(lastName,firstName,phoneNumber);
		family.add(p);
	}

	/**
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(Person person) {
		//TODO
		if(lastName != person.getLastName()) {
			throw new IllegalArgumentException("Not of this family!");
		}
		family.add(person);
	}

	/*
	 * Returns the phone number of the person in the family with the given phone
	 * number Returns "Does not exist." if not found
	 */
	public String getPhoneNumberOfFamilyMember(String lastName, String firstName) {
		if(doesFamilyMemberExist(lastName,firstName)){
    		for(int i = 0; i < family.size(); i++) {
    			if(family.get(i).getFirstName() == firstName) {
    				return family.get(i).getPhoneNumber();
    			}
    		}
		}
		return "Does Not Exist";
	}

	/*
	 * toString method Ex: [] [John Smith (5551234567), May Smith (5551234568),
	 * April Smith (5551234569), August Smith (5551234570)]
	 */
	public String toString() {
		String s = "[";
		for(int i = 0; i < family.size()-1;i++) {
			s = s + family.get(i) + ',';
		}
		if(family.size() == 0) {
			s = s + ']';
		} else {
		s = s+ family.get(family.size()-1) + ']';
		}
		return s;
	}
}

