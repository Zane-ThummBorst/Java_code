package midterm;
//Zane ThummBorst
//I pledge my honor that I have abided by the Stevens Honor System.
import java.util.ArrayList;
import java.util.List;

public class ListCollection<E> {
  private int nodeCount;
  protected List<SingleLL<E>> collection;

  /**
   * Base constructor, initializes an empty ListCollection.
   */
  public ListCollection() {
	  this.collection = new ArrayList<SingleLL<E>>();
  }

  /**
   * Initializes a ListCollection with `numLists` lists.
   * 
   * @param numLists
   */
  public ListCollection(int numLists) {
	  this.collection = new ArrayList<SingleLL<E>>(numLists);
	  for(int i = 0; i < numLists; i++) {
		  collection.add(new SingleLL<>()); 
	  }
  }

  /**
   * @return The size of the `ListCollection`
   */
  public int size() {
	  return collection.size();
  }

  /**
   * Sets the nodeCount
   * 
   * @param nodeCount
   */
  public void setNodeCount(int nodeCount) {
	  this.nodeCount = nodeCount;
  }

  /**
   * @return the nodeCount
   */
  public int getNodeCount() {
	  return nodeCount;
  }

  /**
   * Adds the specified `SingleLL` to the end of the `ListCollection`
   * 
   * @param list
   */
  public void addList(SingleLL<E> list) {
	  collection.add(list);
	  nodeCount = nodeCount +  list.size();

  }

  /**
   * Adds the specified `List` to the `ListCollection`
   * 
   * @param list
   * @complexity Your big-o and supporting explanation here
   * The big-o of this function would be at worst case n^2. In the function we see it has one for loop that will execute n 
   * amount of times due to its linear iteration of i. For each iteration of that loop, there is a function call to append 
   * ( which calls insert in worst case) which also has one for-loop of a time complexity of n (for the same reasons). 
   * Essentially we have overall a for loop in a for loop, whose complexities make n^2. 
   */
  public void addList(List<E> list) {
	  SingleLL<E> temp = new SingleLL<>();
	  for(int i = 0; i < list.size(); i++) {
		  temp.append(list.get(i));
	  }
	  collection.add(temp);
	  nodeCount = nodeCount +  list.size();
  }

  /**
   * Returns the list at the specified index
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @return the list
   */
  public SingleLL<E> getList(int listIndex) {
	  if(listIndex < 0 || listIndex > this.size()) {
		  throw new IllegalArgumentException("InDeX oUt Of BoUnDs");
	  }
	  return collection.get(listIndex);
  }

  /**
   * Adds an element to the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @param elem
   * @complexity Your big-o and supporting explanation here
   * The time complexity of addElem is n. The function has no loops with a complexity of 1, but calls on insert which at
   * worst case iterates through a linear loop n times. Overall complexity as a result of calling addElem is n.
   */
  public void addElem(int listIndex, int elemIndex, E elem) {
	  if(listIndex < 0 || listIndex > this.size()) {
		  throw new IllegalArgumentException("InDeX oUt Of BoUnDs");
	  }
	  collection.get(listIndex).insert(elemIndex,elem);
	  nodeCount = nodeCount + 1;
  }

  /**
   * Sets the element at the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @param elem
   */
  public void setElem(int listIndex, int elemIndex, E elem) {
	  if(listIndex < 0 || listIndex > this.size()) {
		  throw new IllegalArgumentException("InDeX oUt Of BoUnDs");
	  }
	  collection.get(listIndex).set(elemIndex,elem); 
  }

  /**
   * Returns the element at the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @return
   */
  public E getElem(int listIndex, int elemIndex) {
	  if(listIndex < 0 || listIndex > this.size()) {
		  throw new IllegalArgumentException("InDeX oUt Of BoUnDs");
	  }
	 return collection.get(listIndex).get(elemIndex);
  }

  /**
   * Returns the `ListCollection` in string form, following STRICTLY the rule of
   * "[LIST1, LIST2, LIST3, ... ]" Ex: [[0, 1, 2], [3, 4, 5] [6, 7, 8]]
   */
  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for(int i = 0; i<collection.size(); i++) {
	    	sb.append(collection.get(i).toString());
	    	if(i != collection.size()-1) {
	    		sb.append(", ");
	    	}
	    }
	    sb.append("]");
	    return sb.toString();
	  }
  
}
