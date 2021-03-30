package treap;

import java.util.Random;
import stacks.Stack;

//Zane ThummBorst
//I pledge my honor that I have abided by the Stevens Honor System.
public class Treap<E extends Comparable<E>> {
	private static class Node<E> {
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		//Constructors
		public Node(E data, int priority) {
			if(data.equals(null)) {
				throw new IllegalArgumentException("GiVe DaTa");
			}
			this.data = data;
			this.priority = priority;
			left = null;
			right = null;
		}
		
		//Uses a temporary variable to rotate the Tree (and returns the new root of that tree)
		public Node<E> rotateRight(){

			Node<E>temp1 = left;
			left=left.right;
			temp1.right = this;
			return temp1;
		}
		public Node<E> rotateLeft(){

			Node<E>temp1 = right;
			right= right.left;
			temp1.left = this;
			return temp1;
		}
	}
	private Random priorityGenerator;
	private Node<E> root;
	
	//Constructors
	public Treap() {
		priorityGenerator = new Random();
		root = null;
	}
	public Treap(long seed) {
		priorityGenerator = new Random(seed);
		root = null;
	}
	
	//reheap helps add and delete in keeping the treap with heap properties
	private void reheap(Stack<Node<E>> s, Node<E> n) {
		while(!(s.empty()) && n.priority > s.peek().priority) { //checks if the stack is empty and if our nodes priority is greater than its current parent
			Node<E> temp = s.pop(); // need to do this in order to also keep track of temps parent
			if(temp.right == n) { // checks if we need to perform a left rotation
				n = temp.rotateLeft(); // performs rotation if our new node is to the right of the parent
				if(s.empty()) {
					root = n;
				}
				else {
					Node<E> temp2 = s.peek();
					if(temp2.left != null || temp2.right != null) { // checks for children if temp2 has any, then swaps n with which ever one is temp
						if(temp2.right == temp) {
							temp2.right = n;
						}
						else {
							temp2.left = n;
						}
					}
					else if((temp2.left == null)) {
						temp2.left = n;
					}
					else {
						temp.right = n;
					}
				}
			}
			else if(temp.left ==n) { // checks if we need to perform a right rotation
				n = temp.rotateRight();
				if(s.empty()) {
					root = n;
				}
				else {
					Node<E> temp2 = s.peek();
					if(temp2.left != null || temp2.right != null) {
						if(temp2.left == temp) {
							temp2.left = n;
						}
						else {
							temp2.right = n;
						}
					}
					else if((temp2.right == null)) {
						temp2.right = n;
					}
					else {
						temp2.left = n;
					}
				}
			}
		}
	}
	public boolean add(E key) {
		return add(key,priorityGenerator.nextInt()); // calls add with extra parameter to save code
	}

	// adds a node to a treap by placing it as a leaf for a bst, then using reheap to maintin heap proporties using its priority.
	public boolean add(E key, int priority) {
		if(root == null) { // if the treap has nothing inside, add to the root.
			root = new Node<E>(key,priority);
			return true;
		}
		if(find(key)) { // if the key is already in the treap, then you cannot re add it
			return false;
		}
		Node<E> temp = root; // keeps track of the root without modifying the treap
		Node<E> n = new Node<E>(key,priority);
		Stack<Node<E>> s = new Stack<Node<E>>(); // used to keep track of the path from the root to the new node( for keeping track of many parent nodes.
		
		while(temp!= null) { // keeps going until we reach keys place in the BST
			if(temp.data.compareTo(key) < 0) {
				s.push(temp);
				temp = temp.right;
			}
			else {
				s.push(temp);
				temp = temp.left;
			}
		}
		if(s.peek().data.compareTo(key) < 0) { // determines what side of the parent node our new node is placed in.
			s.peek().right = n;

		}
		else{
			s.peek().left = n;
		}

		reheap(s,n); // called to reorganize treap.
		return true;
	}
	
	
	private Node<E> delete(E key, Node<E> n) {
		if(n != null) { // checks of n has value as a node
			if(key.compareTo(n.data) < 0) {
				n.left = delete(key,n.left);
			}
			else if(key.compareTo(n.data) > 0) {
				n.right = delete(key,n.right);
			}
			else {
				if(n.left == null && n.right == null) { // if n is a leaf make it null, and it is deleted
					n = null;
				}
				else if(n.left == null) {
					if(n == root) {// if n is the root of our treap we must replace the value of root for the first time around, otherwise most of the treap is deleted besides the node we wanted to delete
						
						n = n.rotateLeft();
						root = n;
					}
					else {
						n = n.rotateLeft();
					}
					}
				else if(n.right == null) {
					if(n == root) {
						n = n.rotateRight();
						root = n;
					}
					else {
						n = n.rotateRight();
					}
				}
				else if(n.left.priority < n.right.priority) { // special case where n has two children. We determine what rotation we do based on their priority.
					n = n.rotateRight();
				}
				else {
					n = n.rotateLeft();
				}
				if(n != null) { // if by the end n is not null, do it again until it is made null or i.e. it is a leaf and changed.
					n = delete(key,n);
				}
			}
		}
		return n;
	}
	public boolean delete(E key) {
		if(!find(key)) { // if you can't find the key in the treap, then returns false
			return false;
		}
		delete(key, root);
		return true;
		
	}

	private boolean find(Node<E> root, E key) {
		Node<E> temp = root;
		while(temp != null && temp.data != key) { // drops out if either you've reach the bottom or the treap or you've founf your node.
			if(temp.data.compareTo(key) < 0) {
				temp = temp.right;
			}
			else if(temp.data.compareTo(key) > 0) {
				temp = temp.left;
			}
		}
		if(temp == null) { // confirms why the while loop was dropped
			return false;
		}
		else {
			return true;
		}
	}
	public boolean find(E key) {
		// to save space, we can call the other find function with the root of the whole treap.
		return find(root, key);
	}
	
	private StringBuilder toString(Node<E> current, int i) {
		StringBuilder r = new StringBuilder() ;
		for (int j=0; j<i; j++) {
			r.append("  ");
		}
		
		if (current==null) {
			r.append("null\n");
		} else {
			r.append("(key:" + current.data.toString() +", priority: " + current.priority + ")" +"\n");
			r.append(toString(current.left,i+1));
			r.append(toString(current.right,i+1));
			
		}
		return r;
		
	}
	public String toString() {
		return toString(root,0).toString();
	}
}
