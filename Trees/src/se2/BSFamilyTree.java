package se2;

import java.util.ArrayList;


/**
 * BSFamilyTree creates a tree for specific families. 
 */
public class BSFamilyTree {
    //Data Fields
    //TODO
	private FamilyTreeNode root;

    /**
     * Constructor: constructs an empty BSFamilyTree
     */
    public BSFamilyTree() {
        //TODO
    	root = null;
    }

    /**
     * takes in the last name and returns true if there
     * is a FamilyTreeNode with the given last name.
     */
    private boolean doesFamilyExist_helper(String l, FamilyTreeNode r) {
    	if(r == null) {
    		return false;
    	}
    	else if(l == r.getLastName()) {
    		return true;
    	}
    	else {
    		return(doesFamilyExist_helper(l,r.left) || doesFamilyExist_helper(l,r.right));
    	}
    }
    public boolean doesFamilyExist(String lastName) {

        return doesFamilyExist_helper(lastName, root);
    }

    /**
     * Takes in a last name and creates a new instance of
     * FamilyTreeNode and adds it to the BSFamilyTree.
     */
    private FamilyTreeNode addFamilyTreeNode(String l,FamilyTreeNode r) {
    	if (r==null) {
    			return new FamilyTreeNode(l);
    		} else {
    	int n = r.getLastName().compareTo(l);
    	if (n==0) {
    			throw new IllegalStateException("Family already in tree");
    		}
    		if (n>0) {
    			r.left = addFamilyTreeNode(l,r.left);
    			return r;
    		}
    		r.right = addFamilyTreeNode(l,r.right);
    		return r;
    	}
    }
    public void addFamilyTreeNode(String lastName) {
    	if(root == null) {
    		root = new FamilyTreeNode(lastName);
    	}
    	else {
    		addFamilyTreeNode(lastName,root);	
    	}
    }

    /**
     * Takes a last name and then finds that specific
     * family tree and then returns that FamilyTreeNode
     * If last name is not in tree, throws an exception.
     */
    private FamilyTreeNode getFamilyTreeNode(String l,FamilyTreeNode r) {
    	if (r==null) {
    		throw new IllegalStateException("Item not in tree");
    		} else {
    	int n = r.getLastName().compareTo(l);
    	if (n==0) {
    			return r;
    		}
    		if (n>0) {
//    			r.left = getFamilyTreeNode(l,r.left);
    			return getFamilyTreeNode(l,r.left);
    		}
//    		r.right = getFamilyTreeNode(l,r.right);
    		return getFamilyTreeNode(l,r.right);
    	}
    }
    public FamilyTreeNode getFamilyTreeNode(String lastName) {
        //TODO
    	return getFamilyTreeNode(lastName, root);
    }

    /**
     * Returns true if the input phone number exists in the BSFamilyTree
     * false otherwise.
     */
    private boolean doesNumberExist_helper(String p, FamilyTreeNode r) {
    	if(r == null) {
    		return false;
    	}
    	else if(r.doesNumberExist(p)) {
    		return true;
    	}
    	else {
    		return(doesNumberExist_helper(p,r.left) || doesNumberExist_helper(p,r.right));
    	}
    }
    public boolean doesNumberExist(String phoneNumber) {
        //TODO
        return doesNumberExist_helper(phoneNumber, root);
    }

    /**
     * Returns the string representation of the BSFamilyTree
     */
	private StringBuilder toString(FamilyTreeNode current, int i) {
		StringBuilder r = new StringBuilder() ;
		for (int j=0; j<i; j++) {
			r.append("  ");
		}
		
		if (current==null) {
			r.append("null\n");
		} else {
			r.append(current.toString()+"\n");
			r.append(toString(current.left,i+1));
			r.append(toString(current.right,i+1));
			
		}
		return r;
		
	}
	
	public String toString() {
		return toString(root,0).toString();
	}
}


