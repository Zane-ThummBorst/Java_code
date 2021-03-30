package se2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
	// Data fields
	// TODO
	public Map<Character, BSFamilyTree> directory;
	/**
     	* Creates a new phone book with an empty directory.
     	*/
	public PhoneBook() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		directory = new HashMap<Character, BSFamilyTree>();
		for(int i = 0; i < alphabet.length(); i++) {
			directory.put(alphabet.charAt(i), new BSFamilyTree());
		}	
	}

	/*
	 * Returns the instance of BSFamilyTree at the indicated letter
	 * Must accept lowercase letters as well as uppercase letters
	 */
	public BSFamilyTree getFamilyTree(char letter) {

		if(!Character.isAlphabetic(letter)) {
			throw new IllegalArgumentException("Not a letter");
		}
		char l = Character.toUpperCase(letter);
		return directory.get(l);
	}

	/*
	 * Adds a FamilyTreeNode to the PhoneBook
	 */
	public void addFamily(String lastName) {
		//TODO
		BSFamilyTree t = getFamilyTree(lastName.charAt(0));
		t.addFamilyTreeNode(lastName);
	}

	/*
	 * Adds a Person to the PhoneBook
	 * If a FamilyTreeNode with the given last name doesn't currently exist, create the FamilyTreeNode
	 */
	public void addPerson(String lastName, String firstName, String phoneNumber) {
		//TODO
		BSFamilyTree t = getFamilyTree(lastName.charAt(0));
		if(!(t.doesFamilyExist(lastName))) {
			addFamily(lastName);
		}
		if(t.getFamilyTreeNode(lastName).doesFamilyMemberExist(lastName, firstName)) {
			throw new IllegalArgumentException("Person already Exists!");
		}
		for(Map.Entry<Character,BSFamilyTree> entry: directory.entrySet()) {
			if(entry.getValue().doesNumberExist(phoneNumber)) {
				throw new IllegalArgumentException("Number already Exists!");
			}
		}
		t.getFamilyTreeNode(lastName).addFamilyMember(lastName, firstName, phoneNumber);
		
	}

	/*
	 * Finds the phone number of a person
	 * Returns 'Does not exist.' if not found.
	 */
	public String getPhoneNumber(String lastName, String firstName) {
		//TODO
		BSFamilyTree t = getFamilyTree(lastName.charAt(0));
		if(t.doesFamilyExist(lastName)){
			if(t.getFamilyTreeNode(lastName).doesFamilyMemberExist(lastName, firstName)) {
				return t.getFamilyTreeNode(lastName).getPhoneNumberOfFamilyMember(lastName, firstName);
			}
		}
		return "Does not exist.";
	}

    	/**
     	* String representation of PhoneBook
     	*/
	private StringBuilder toString(int i) {
		StringBuilder r = new StringBuilder();
		for(Map.Entry<Character,BSFamilyTree> entry: directory.entrySet()) {
			r.append(entry.getKey() + "\n");
			r.append(entry.getValue().toString());
		}
		return r;
	}
	public String toString() {
		return toString(0).toString();
	}
	public static void main(String args[]) {
		PhoneBook f = new PhoneBook();
		System.out.println(f.getFamilyTree('A'));
	}
}

