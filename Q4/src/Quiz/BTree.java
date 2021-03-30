package Quiz;
//Zane ThummBorst
//I pledge my honor that I have abided by the Stevens Honor System.
public class BTree<E> {
	private static class Node<F>{
		// data fields
		private F data;
		private Node<F> left;
		private Node<F> right;
		
		
		public Node(F data, Node<F> left, Node<F> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}


		public Node(F data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

		
		
	}
	// data fields
	private Node<E> root;
	private int size;
	
	// Constructors
	
	BTree() {
		root=null;
		size=0;
	}
	
	BTree(E item) {
		root = new Node<E>(item);
		size=1;
	}
	
	BTree(E item, BTree<E> left, BTree<E> right) {
		root = new Node<E>(item,left.root,right.root);
		size = 1 +  left.size + right.size;
	}
	
	// Methods

	public int height_helper(Node<E> current) {
		if (current==null) {
			return 0;
		} else {
			return 1+ Math.max(height_helper(current.left), height_helper(current.right));
		}
	}
	public int height() {
		return height_helper(root);
	}
	
	
	private int no_of_nodes_helper(Node<E> current) {
		if (current==null) {
			return 0;
		} else {
			return 1+ no_of_nodes_helper(current.left) + no_of_nodes_helper(current.right);
		}
	}
	public int no_of_nodes() {
		return no_of_nodes_helper(root);
	}

	/** 
	 * Modify the tree by turning it into its mirror image
	 * Mirror image: tree resulting from swapping left and right children of each node
	 */
	public void mirror() {
		
	}

	/**
	 * Clones the recipient tree
	 * @return (Shallow) Copy of the recipient tree
	 */


    	private Boolean is_balanced_helper(Node<E> current) {
		if (current==null) {
			return true;
		} else {
			return Math.abs(height_helper(current.left)-height_helper(current.right))<=1 &&
					is_balanced_helper(current.left) &&
					is_balanced_helper(current.right);
		}
	}
	/** 
	 * A binary tree is said to be balanced if both of its subtrees are balanced and 
	 * the height of its left subtree differs from the height of its right subtree 
	 * by at most 1.
	 * @return true if the tree is balanced, false otherwise
	 */
	public Boolean is_balanced() {
		return is_balanced_helper(root);
	}
	

	/**
	 * A full binary tree is a binary tree where all nodes have 
	 * either 2 children or 0 children (the leaf nodes)
	 * @return
	 */

	public Boolean is_perfect() {
		return null;
	}
	
	private boolean is_complete(Node<E> curr) {
		return true;
	}
	/** Hint: use a queue */
	public Boolean is_complete() {
		return is_complete(root);
	}
	
     private boolean isomorphic(Node<E> curr1, Node<E> curr2) {
    	 if(curr1 == null || curr2 == null) {
    		 return true;
    	 }
    	 else {
    		 return curr1.data == curr2.data && (isomorphic(curr1.left,curr2.left) || (isomorphic(curr1.right,curr2.left))) && (isomorphic(curr1.left,curr2.right) || (isomorphic(curr1.right,curr2.right)));
    	 }
     }
	
	public boolean  isomorphic(BTree<E> t2) {
		if(no_of_nodes() != t2.no_of_nodes()) {
			return false;
		}
		return isomorphic(root, t2.root);
	}
	
	private int no_of_leaves()

	private StringBuilder toString_helper(Node<E> current, int level) {
		StringBuilder r = new StringBuilder();
		for (int i=0; i<level; i++) {
			r.append("-");
		}
		if (current==null) {
			r.append("null\n");
		} else {
			r.append(current.data.toString()+ "\n");
			r.append(toString_helper(current.left,level+1));
			r.append(toString_helper(current.right,level+1));
		}
		return r;
	}
	
	public String toString() {
		return toString_helper(root,1).toString();
	}
	
	public static void main(String[] args) {
		BTree<Integer> t5 = new BTree<>(5);
		BTree<Integer> t4 = new BTree<>(4,t5,new BTree<>());
		BTree<Integer> t12 = new BTree<>(12);
		BTree<Integer> t7 = new BTree<>(7,t4,t12);
//		System.out.println(t7.height());
//		System.out.println(t7.no_of_nodes());
		// System.out.println(t7); 
		System.out.println(t7.isomorphic(t7));
		BTree<Integer> t1 = new BTree<>(1);
		BTree<Integer> t2 = new BTree<>(2,t1,new BTree<>());
		
		//System.out.println(t1.is_balanced());
		//System.out.println(t2.is_balanced());
		
		BTree<Integer> t3 = new BTree<>(3, t1, t2);
		
		BTree<Integer> m7 = new BTree<>(7);
		BTree<Integer> m3 = new BTree<>(3);
		BTree<Integer> m12 = new BTree<>(12);
		BTree<Integer> m10 = new BTree<>(10);
		BTree<Integer> m24 = new BTree<>(24);
		BTree<Integer> m14 = new BTree<>(14);
		
		BTree<Integer> b1 = new BTree<>(7,m3,m12);
		BTree<Integer> b2 = new BTree<>(7,m12,m3);
		System.out.println(b1.isomorphic(b2));
		
		

		
	}
	
	
}
