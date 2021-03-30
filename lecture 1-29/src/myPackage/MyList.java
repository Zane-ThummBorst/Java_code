package myPackage;

public class MyList<E> {
	// data fields
	private E[] data;
	private int free;
	// Constructors
	MyList(int size) {
	data = (E[]) new Object[size];
	free = 0;
	}
	// Methods
	/**
	 * Add element elem at the end of the list.
	 * Returns null if the list is full
	 * @param elem Element to insert
	 * @return The element just inserted
	 */
	public E addLast(E elem) {
		if (free==data.length) { // array is full
			throw new IllegalStateException();
		}
		data[free]=elem;
		free++;
		return elem;
	}
	
	public E addFirst(E elem) {
		return add(0,elem);
	}
	
	public E add(int index, E elem) {
		if (index<0 || index>free) { // index out of range
			throw new IllegalArgumentException();
		}
		if (free==data.length) { // array is full
			throw new IllegalStateException();
		}
		for (int i=free; i>index; i--) {
			data[i]=data[i-1];
		}
		data[index]=elem;
		free++;
		return elem;
	}
	
	public E removeLast() {
		if (free == 0) {
			throw new IllegalStateException();
		}
		free--;
		return data[0];
	}
	
	public E removeFirst() {
		if (free == 0) {
			throw new IllegalStateException();
		}
		for (int i = 0; i < free-1; i++) {
			data[i] = data[i+1];
		}
		free--;
		return data[0];
	}
	
	public E remove(int index) {
		if (free == 0) {
			throw new IllegalStateException();
		}
		if (index<0 || index>free) {
			throw new IllegalArgumentException();
		}
		for (int i = index; i < free-1; i++) {
			data[i] = data[i+1];
		}
		free--;
		return data[0];
	
	}
	
	public int size() {
		return free;
	}
	
	public Boolean member(E elem) {
		if (free == 0) {
			throw new IllegalStateException();
		}
		for(int i = 0; i < free; i++) {
			if(data[i] == elem) {
				return true;
			}
		}
		return false;
	}
	
	public int find(E elem) {
		if (free == 0) {
			throw new IllegalStateException();
		}
		for(int i = 0; i < free; i++) {
			if(data[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}
	
	public Boolean included_in(MyList<E> l) {
		int i = 0;
		while(i<free && l.member(data[i])){
			i++;
		}
		return !(i<free);
	}
	
	public MyList<Pair<E,E>>zip(MyList<E> l){
		int len = Math.min(this.size(),l.size());
		MyList<Pair<E,E>> result = new MyList<Pair<E,E>>(len);
		for (int i=0; i<len; i++)
		{
			result.addLast(new Pair<E,E>(this.data[i],l.data[i]));
		}
		return result;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i=0; i<free; i++) {
			s.append(data[i].toString()+",");
		}
		return "["+s.toString()+"]";
	}
	
	public static void main(String[] args) {
		MyList<Integer> l = new MyList<>(20);
		for (int i=0; i<10; i++) {
			l.addFirst(i);
		}
		System.out.println(l);
		l.member(1);
		MyList<Integer> l2 = new MyList<>(20);
		for (int i=0; i<10; i+=2) {
			l2.addFirst(i);
		}
		System.out.println(l.zip(l2));
		//MyList<String> l2 = new MyList<String>(20);
		}
	}



