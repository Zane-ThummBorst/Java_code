package lecture2_14_20;

public class SLList<E> {
 
	public static class Node<F> {
	// data fields
		private F data;
		private Node<F> next;
	// Constructor
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
		// Methods
	}
		// date fields
		private Node<E> head;
		private int size;
		// Constructor
		SLList() {
			head=null;
			size=0;
		}
		// Methods
		public E addFirst(E item) {
			head = new Node<E>(item,head);
			size++;
			return item;
		}
		
		public E add(int index, E item) {
			if (index<0 || index>size) {
				throw new IllegalArgumentException();
			}
			if( index == 0) {
				return this.addFirst(item);
			}
			Node<E> current = head;
			for (int i = 0; i < index-1; i++) {
				current = current.next;
			}
			
			current.next = new Node<E>(item,current.next);
			size++;
			return null;
		}
		
		public E addLast(E item) {
			if (head==null) {
				return this.addFirst(item);
			}

			Node<E> current = head;
			while (current.next!=null) {
				current = current.next;
			}
			current.next = new Node<E>(item);
			size++;
			return item;
		}
		public E removeFirst() {
			if(head != null){
				E item = head.data;
				head = head.next;
				return item;
				}
			return null;
		}
		public E remove(int index) {
			return null;
		}
		public E removeLast() {
			return null;
		}
		public String toString() {
			StringBuilder s = new StringBuilder();
			Node<E> current = head;
			s.append("[");
			while (current!=null) {
				s.append(current.data.toString()+",");
				current = current.next;
			}
			s.append("]");
			return s.toString();
		}
		
		public SLList<E> clone(){
			Node<E> current = head;
			Node<E> dummy = new Node<>(null);
			Node<E> last = dummy;
			Node<E> newHead = dummy;
			
			while(current != null) {
				last.next = new Node<E> (current.data);
				current = current.next;
				last = last.next;
			}
			SLList<E> l = new SLList<>();
			l.head = newHead.next;
			l.size=this.size;
			return l;
		}
		
		public void take(int n) {
			Node<E> current = head;
			int i = 0;
			if(n == 0) {
				head = null;
				size = 0;
				return;
			}
			while (current != null && i<n-1) {
				current = current.next;
				i++;
			}
			if (current!=null) {
				current.next= null;
				size = i+1;
			}
		}
		public void drop(int n) {
			Node<E> current = head;
			int i = 0;

			while (current != null && i<n) {
				//System.out.println(current.data);
				current = current.next;
				System.out.println(current.next);
				i++;
			}
			head = current;
			size = size - i;
		}
		
		SLList<Boolean> areNull(){
			Node<E> current = head;
			SLList<Boolean> l = new SLList<>();
			while (current != null) {
				if(current.data == null) {
					l.addLast(true);
				}
				else {
					l.addLast(false);
				}
				current = current.next;
			}
			return l;
		}
		Boolean isSingleton() {
			if(head == null) {
				return false;
			}
			return head.next == null;
		}
		
		Boolean allNonNull() {
			
			Node<E> current = head;
			while (current != null) {
				if(current.data == null) {
					return false;
				}
				current = current.next;
			}
			return true;
		}
		
		Boolean mem(E el) {
			Node<E> current = head;
			while (current != null) {
				if((current.data).equals(el)) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
		
		Boolean nonDuplicates() {
			Node<E> current = head;
			Node<E> current2 = head.next;
			for(int i = 0; i < size-1; i++) {
				while(current2 != null) {
					if(current.data == current2.data) {
						return false;
					}
					current2 = current2.next;
				}
				current = current.next;
				current2 = current.next;
			}
			return true;
		}
		
		SLList<E> append(SLList<E> l2){
			Node<E> current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = l2.head;
			size = size + l2.size;
			return this;
		}
		
		void reverse() {
			Node<E> current = head;
			Node<E> current2 = head.next;
			
			while(current != null) {
				
			}
			
		}
		SLList<E> stuterLN(int n){
			Node<E> current = head;
			SLList<E> l = new SLList<>();
			while ( current != null) {
				for(int i = 0; i < n; i++) {
					l.addLast(current.data);
				}
				current = current.next;
			}
			return l;
		}
		public void removeAdjacentDuplicates(){
		Node<E> current = head;
		while(current != null && current.next != null){
			if(current.data == current.next.data){
					current.next = current.next.next;
					size--;
				}
			else{
					current = current.next;
				}
			}
		}
		
		public void removeAll(E item) {
			Node<E> current = head;
			while(current!= null) {
				if(head!=null && head.data.equals(item)) {
					head = head.next;
				}
				else if( current.data == item) {
					current.next = current.next.next;
				}
				while(current!=null) {
					if(current.next.data.equals(item)) {
						current.next = current.next.next;
					}
					else {
						current = current.next;
					}
				}
			}
		}
		public static void main(String[] args) {
			SLList<Integer> l = new SLList<>();
			l.addFirst(3);
			l.addFirst(2);
			l.addFirst(1);
			l.addLast(4);
			System.out.println(l);
			l.removeAll(1);
			//l.reverse();
			//l.add(2, 122);
			//SLList<Integer> l2 = l.clone();
			//System.out.println(l.append(l2));
			System.out.println(l);

		}
	}



