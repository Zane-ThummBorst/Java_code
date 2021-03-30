package yey;

public class Stack<E> implements StackInt<E> {

	private static class Node<F> {
		// data fields
		private F data;
		private Node<F> next;

		// Constructors
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(F data) {
			super();
			this.data = data;
		}

	}

	// data fields
	private Node<E> top;
	private int size;

	// Constructor
	Stack() {
		top=null;
		size=0;
	}

	// Methods

	/**
	 * Adds element obj to the top of the stack
	 * obj may be null.
	 */
	public E push(E obj) {
		top = new Node<E>(obj,top);
		size++;
		return obj;
	}

	public E peek() {
		if (top==null) {
			throw new IllegalStateException("peek: stack is empty");
		}
		return top.data;
	}

	public E pop() {
		if (top==null) {
			throw new IllegalStateException("Pop: stack is empty");
		}
		E temp = top.data;
		top = top.next;
		size--;
		return temp;
	}

	public boolean empty() {
		return top == null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		Node<E> current = top;
		while(current != null) {
			s.append(current.data.toString()+",");
			current = current.next;
		}
		return "["+s.toString()+"]";
	}
	
	public static void main(String[] args) {
		  Stack<Integer> s = new Stack<>();
		  
		  for (int i=0; i<10; i++) {
			  s.push(i);
		  }
		  
		  System.out.println(s);
		  System.out.println(s.pop());
		  System.out.println(s);
		  
	}

}
