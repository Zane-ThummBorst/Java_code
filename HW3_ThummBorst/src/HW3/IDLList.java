package HW3;
//Zane ThummBorst
// I pledge my honor that I have abided by the Stevens Honor System.
import java.util.ArrayList;
public class IDLList<E> {
	
	public class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		
		//Node constructor without parameters
		public Node(E elem) {
			data = elem;
			prev = null;
			next = null;
		}

		//Node constructor with parameters
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	Node<E> head;
	Node<E> tail;
	int size;
	ArrayList<Node<E>> indices;
	
	//IDLList constructor
	public IDLList() {
		this.indices = new ArrayList<>();
		head = null;
		tail = null;
		size = 0;
	}
	 public boolean add (int index, E elem) {
		 if(head == null) {
			 head = new Node<E>(elem);
			 tail = head;
			 indices.add(head);
			 size++;
		 }
		 else if(index > indices.size() || index < 0) {
			 throw new IllegalArgumentException("index out of range");
		 }
		 else if(index >= indices.size()) {
			 this.append(elem);
		 }
		 else if(index == 0) {
			 this.add(elem);
		 }
		 else {	 
			 Node<E> temp = new Node<E>(elem,indices.get(index).prev, indices.get(index));
			 indices.get(index-1).next = temp;
			 indices.get(index).prev = temp;
			 indices.add(index, temp);
			 size++;
		 }
		 return true;
	 }
	 public boolean add(E elem) {
		 if(head == null) {
			 head = new Node<E>(elem);
			 tail = head;
			 indices.add(head);
		 }
		 else {
			 head.prev = new Node<E>(elem,null,head);
			 head = head.prev;
			 indices.add(0, head);
			 tail = indices.get(indices.size()-1);
		 }
		 size++;
		 return true;
	 }
	 
	 public boolean append (E elem) {
		 if(head == null) {
			 head = new Node<E>(elem);
			 tail = head;
			 indices.add(head);
		 }
		 else {
			 tail.next = new Node<E>(elem,tail,null);
			 tail = tail.next;
			 indices.add(tail);
		 }
		 size++;
		 return true;
	 }
	 
	public E get(int index) {
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		 else if(index > indices.size() || index < 0) {
			 throw new IllegalArgumentException("index out of range");
		 }
		 return indices.get(index).data;
	 }
	public E getHead() {
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		return head.data;
	}

	public E getLast() {
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		return tail.data;
	}

	public int size() {
		return size;
	}
	
	public E remove(){
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		E value = head.data;
		head = head.next;
		indices.remove(0);
		size--;
		return value;
	}
	
	public E removeLast(){
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		E value = tail.data;
		tail = tail.prev;
		tail.next = null;
		indices.remove(indices.size()-1);
		size--;
		return value;
	}
	
	public E removeAt(int index) {
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		 if(index > indices.size() || index < 0) {
			 throw new IllegalArgumentException("index out of range");
		 }
		 E value = indices.get(index).data;
		 if(index == 0) {
			 this.remove();
		 }
		 else if(index == indices.size()-1) {
			 this.removeLast();
		 }
		 else {
			 indices.get(index-1).next = indices.get(index + 1);
			 indices.get(index + 1).prev = indices.get(index-1);
			 indices.remove(index);
			 size--;
		 }
		return value;
	}
	
	public boolean remove (E elem) {
		 if(indices.size() == 0) {
			 throw new IllegalStateException("no items in array");
		 }
		for(int i = 0;i<indices.size();i++) {
			if(indices.get(i).data == elem) {
				this.removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node<E> current = head;
		s.append("front<= ");
		while (current!=null) {
			s.append(current.data.toString()+",");
			current=current.next;
		}
		return s.toString()+"<= rear";
				
	}
	 public static void main(String[] args) {
		 
		 
	 }
}
