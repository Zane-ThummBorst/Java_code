package Quiz;

public class PQueues<E extends Comparable<E>> {


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
		private Node<E> front;
		private Node<E> rear;
		private int size;
		
		// Constructor
		PQueues() {
			front=null;
			rear=null;
			size=0;
		}
		
		// Methods
		
		/**
		 * Adds the new item at the rear of the queue
		 * @param item is the item to be added
		 * @return the item
		 */
		public E offer(E item) {
			if(front == null) {
				front = new Node<>(item);
				rear = front;
			}
			else {
				Node<E> temp = front;
				while(temp.next != null && item.compareTo(temp.next.data) == 1) {
					temp = temp.next;	
				}
				temp.next = new Node<>(item, temp.next);
			}
			return item;
		}
		
		/**
		 * Returns the item at the front
		 * @return item at the front
		 * @throws IllegalStateException if the queue is empty
		 */
		public E peek() {
			if (front==null) {
				throw new IllegalStateException("peek: queue is empty");
			}
			return front.data;
		}
		
		/** 
		 * Returns the item at the front and removes it
		 * @return item at the front
		 * @throws IllegalStateException is the queue is empty
		 */
		public E poll() {
			if (front==null) {
				throw new IllegalStateException("poll: queue is empty");
			}
			E temp = front.data;
			front = front.next;
			size--;
			return temp;
		}
		
		/**
		 * Returns the size of the queue
		 * @return
		 */
		public int size() {
			return size;
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			Node<E> current = front;
			s.append("front<= ");
			while (current!=null) {
				s.append(current.data.toString()+",");
				current=current.next;
			}
			return s.toString()+"<= rear";
					
		}
		
		public static void main(String[] args) {
			PQueues<Integer> q = new PQueues<>();
			
			for (int i=1;i<10; i= i*2) {
				q.offer(i);
			}
			System.out.println(q);
			q.offer(6);
			System.out.println(q);
			
			
			
		}

}
