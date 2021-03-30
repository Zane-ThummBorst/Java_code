package HW3;
//Zane ThummBorst
// I pledge my honor that I have abided by the Stevens Honor System.
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class IDLListTest {
	@Test
	void test1() {
		//TESTS FOR ADD(with and without index),APPEND & GET(INT)
		//add(int e) and append *note append is in the function add(int e)*
		IDLList<Integer> l = new IDLList<>();
		l.add(0,1);
		assertEquals(1, l.get(0));
		l.add(1,3);
		assertEquals(3, l.get(1));		
		l.add(2,5);
		assertEquals(5, l.get(2));
		System.out.println(l);
		
		//add(int e) and add(e) *note add(e) is in the function add(int e)*
		l.add(0,7);
		assertEquals(7,l.get(0));
		
		//add(int e) for when an index is in the middle of the list. Checks to see if index shifts are correct.
		l.add(2,9);
		assertEquals(9, l.get(2));
		assertEquals(3, l.get(3));
		System.out.println(l);
		
		try{ // index out of range case
			l.add(20,20);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		try{ // index invalid case
			l.add(-1,20);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		System.out.println("END OF TEST 1");
		System.out.println("");
	}
	
	@Test
	void test2() {
		//TESTS FOR ALL GETTER METHODS
		IDLList<Integer> l = new IDLList<>();
		try{ // no items in list for get
			l.get(2);
		} catch(IllegalStateException e) {
			assert(true);
		}
		try{ // no items in list for getHead
			l.getHead();
		} catch(IllegalStateException e) {
			assert(true);
		}
		try{ // no items in list for getLast
			l.getLast();
		} catch(IllegalStateException e) {
			assert(true);
		}
		 for(int i = 0; i < 10; i++) {
			 l.add(i);
		 }
		try{ // index invalid case for get
			l.get(-1);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		try{ // index invalid case for get #2
			l.get(200);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		 System.out.println(l);
		 assertEquals(9,l.getHead());
		 assertEquals(0,l.getLast());
		 assertEquals(4,l.get(5));
		 assertEquals(10,l.size());
		 System.out.println("END OF TEST 2");
		 System.out.println();
	}
	
	@Test
	void test3(){
		// TEST FOR BOTHE REMOVE METHODS,REMOVELAST, AND REMOVE FIRST
		IDLList<Integer> l = new IDLList<>();
		try{ // no items in list for removeAt
			l.removeAt(2);
		} catch(IllegalStateException e) {
			assert(true);
		}
		try{ // no items in list for remove()
			l.remove();
		} catch(IllegalStateException e) {
			assert(true);
		}
		try{ // no items in list for removeLast
			l.removeLast();
		} catch(IllegalStateException e) {
			assert(true);
		}
		try{ // no items in list for remove(int)
			l.remove(2);
		} catch(IllegalStateException e) {
			assert(true);
		}
		 for(int i = 0; i < 10; i++) {
			 l.append(i);
		}
		try{ // index invalid case for removeAt
			l.removeAt(-1);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		try{ // index invalid case for removeAt #2
			l.removeAt(200);
		} catch(IllegalArgumentException e) {
			assert(true);
		}
		
		//Next assertions will test the removeAt function,which contains the remove and remove last functions
		System.out.println(l);
		assertEquals(0,l.removeAt(0));
		System.out.println(l);
		assertEquals(9,l.removeAt(l.size-1));
		System.out.println(l);
		assertEquals(4,l.removeAt(3));
		System.out.println(l);
		System.out.println();
		
		l.append(1);
		l.add(3,1);
		System.out.println(l);
		assertEquals(true,l.remove(1));
		System.out.println(l);
		assertEquals(true,l.remove(1));
		System.out.println(l);
		assertEquals(true,l.remove(1));
		System.out.println(l);
		assertEquals(false,l.remove(1));
		System.out.println("END OF TEST 3");
	}
	
	@Test
	void test4() {
		//MISCELLANEOUS TESTS
		IDLList<Integer> l = new IDLList<>();
		 for(int i = 0; i < 10; i++) {
			 l.append(i);
		}
		 l.add(20);
		 l.append(40);
		 assertEquals(20,l.get(0));
		 assertEquals(40, l.get(l.size-1));
		 assertEquals(20,l.remove());
		 assertEquals(40,l.removeLast());
	}
}