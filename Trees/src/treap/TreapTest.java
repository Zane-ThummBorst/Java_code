package treap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TreapTest {
	@Test
	void test1() {
		System.out.println("BEGINNING OF TEST 1 CASES");
		//Tests the add function and prints out the result at the end
		// the add function should accept any new node and return true while returning false if key is already in the node.
		// the result of the tree is printed aswell as the test tree from the assignment.
		//Every iteration of testTree keeps heap properties.
		//both adds are adequatly covered becuause the only difference in their codes is that one create a priority and the 
		//other is given
		Treap t = new Treap<>();
		assertTrue(t.add(6,20));
		t.add(6,20);
		assertTrue(t.add(3,40));
		t.add(3,40);
		assertTrue(t.add(2,90));
		t.add(2,90);
		assertTrue(t.add(4,30));
		t.add(4,30);
		assertFalse(t.add(6,20));
		System.out.println(t);
		Treap<Integer> testTree = new Treap<>(); 
		testTree.add(4,19);
		System.out.println(testTree);
		testTree.add(2,31);
		System.out.println(testTree);
		testTree.add(6,70);
		System.out.println(testTree);
		testTree.add(1,84);
		System.out.println(testTree);
		testTree.add(3,12);
		System.out.println(testTree);
		testTree.add(5,83);
		System.out.println(testTree);
		testTree.add(7,26);
		

		System.out.println(testTree);
	}
	@Test
	void test2() {
		System.out.println("BEGINNING OF TEST 2 CASES");
		//focuses on Testing the delete function
		// returns true for removing a leaf, a node in the middle, and the root of the tree.
		// it should return false if trying to remove nodes that are not in the tree or were already removed
		//iterations of testTree before and after delete are shown in console.
		Treap<Integer> testTree = new Treap<>();
		assertFalse(testTree.delete(4));
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		
		System.out.println(testTree);
		assertTrue(testTree.delete(7));
		System.out.println(testTree);
		assertTrue(testTree.delete(3));
		System.out.println(testTree);
		assertTrue(testTree.delete(1));
		System.out.println(testTree);
		assertFalse(testTree.delete(1));
		assertFalse(testTree.delete(20));
	}
	
	@Test
	void test3() {
		//Tests the find function
		//Similar to add, the two find functions have a very minimal differences.Only testing one is necessary because we call 
		//find(key,node) in find(key) by using the root, so they are near identical.
		// if the node is in the function, we return true, and false if not present or otherwise the treap is empty.
		Treap<Integer> testTree = new Treap<>(); 
		assertFalse(testTree.find(4));
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		
		assertTrue(testTree.find(1));
		assertTrue(testTree.find(2));
		assertTrue(testTree.find(3));
		assertTrue(testTree.find(4));
		assertTrue(testTree.find(5));
		assertTrue(testTree.find(6));
		assertTrue(testTree.find(7));
		
		assertFalse(testTree.find(20));
		assertFalse(testTree.find(8));
		assertFalse(testTree.find(0));
	}
}
