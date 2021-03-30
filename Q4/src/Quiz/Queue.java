package Quiz;

//import yey.Stack.Node;

public class Queue<E> {
	
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
			this.next = null;
		}
		
		
		
	}
	// date fields
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	// Constructor
	Queue() {
		front=null;
		rear=null;
		size=0;
	}
	
	// Methods
	
	/**
	 * Adds a new element to the rear of the queue
	 * @param item to be added
	 * @return item that was added
	 */
	public E offer(E item) {
		if(front == null) {
			front = new Node<E>(item);
			rear = front;
		}
		else {
			rear.next = new Node<E>(item);
			size++;
		}
		return item;
	}
	/**
	 * Inspects the item at the front
	 * @return the element at the front
	 * @throws IllegalStateException if the queue is empty
	 */
	public E peek() {
		if(front == null) {
			throw new IllegalStateException();
		}
		else {
			return front.data;
		}
	}
	
	/** 
	 * Inspects and removes the item at the front
	 * @return the item at the front
	 * @throws IllegalStateException if the queue is empty 
	 */
	public E poll() {
		if(front == null) {
			throw new IllegalStateException();
		}
			E temp = front.data;
			front = front.next;
			size--;
		return temp;
	}
	
	/**
	 * Size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		Node<E> current = front;
		while(current != null) {
			s.append(current.data.toString()+",");
			current = current.next;
		}
		return "["+s.toString()+"]";
	}
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		//for(int i = 0;)
	}
	
}
