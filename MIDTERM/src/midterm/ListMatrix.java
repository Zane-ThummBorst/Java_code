package midterm;

import java.util.ArrayList;
import java.util.List;

public class ListMatrix extends ListCollection<Integer> {
  private int rows;
  private int columns;

  /**
   * Initializes a `ListMatrix` with the specified number of rows and columns. By
   * default, ALL elements are set to 0.
   * 
   * @param rows
   * @param columns
   */
  public ListMatrix(int rows, int columns) {
	  this.rows = rows;
	  this.columns = columns;
  }

  /**
   * @return the number of rows
   */
  public int numRows() {
    return this.rows;
  }

  /**
   * 
   * @return the number of columns
   */
  public int numColumns() {
    return this.columns;
  }

  /**
   * Adds the `ListMatrix` to `ListMatrix other`, storing the result in the caller
   * (this)
   * 
   * @throws IllegalArgumentException if dimensions do not peoperly coincide
   * @param other
   * @complexity Your big-o and supporting explanation here
   * big - o of this function is n^3. each for loop within the function is linear and therfore has a big - o of n. combined 
   * they have n^2. then, there is a call to setElem which eventually leads to another linear for loop of big-o n at worst case.
   * The reason why we ponly take into account one of the three function calls (set,get,set) is because all of them combined
   * would be something like 3n, but we are only concerned with our n and its exponents, not its constants. Our combined code 
   * would produce three for-loops nested in one another iterated linearly with big-o of n, producing an overall big-o of n^3.
   */
  public void add(ListMatrix other) {
	  if(rows != other.rows || columns != other.columns) {
		  throw new IllegalArgumentException("ThE DiMeNsIoNs Do NoT mAtCh");
	  }
	  for(int i = 0; i < columns; i++) {
		  for(int j = 0; j < rows; j++) {
			  this.setElem(i, j, this.getElem(i, j) + other.getElem(i, j));
		  }
	  }
  }

  /**
   * Returns the transpose of the matrix
   * 
   * @param matrix
   * @return matrix tranpose
   */
  public static ListMatrix transpose(ListMatrix matrix) {
	  ListMatrix tran = new ListMatrix(matrix.columns, matrix.rows);
	  for(int i = 0; i < matrix.rows; i++) {
		  tran.addList(new SingleLL<>());
		  for(int j = 0; j < matrix.columns; j++) {
			  tran.getList(i).append(matrix.getElem(j, i));
		  }
	  }
	  return tran;
  }

  /**
   * Multiplies the `ListMatrix` with `ListMatrix other`, returning the result as
   * a new `ListMatrix.
   * 
   * @throws IllegalArgumentException if dimensions do not peoperly coincide
   * @param other
   * @return
   */
  public ListMatrix multiply(ListMatrix other) {
	  if(rows != other.columns || columns != other.rows) {
		  throw new IllegalArgumentException("ThE DiMeNsIoNs Do NoT mAtCh");
	  }
	  ListMatrix mult = new ListMatrix(rows, other.columns);
	  transpose(other);
	  for(int i = 0; i < columns; i++) {
		  mult.addList(new SingleLL<>());
		  for(int j = 0; j < other.rows; j++) {
			  mult.addElem(i, j, 0);
			  for(int k = 0; k < rows; k++) {
				  mult.setElem(i, j, mult.getElem(i, j) + (this.getElem(j, k) * other.getElem(k, i)));
			  }
		  }
	  }
	  return mult;
  }
//  public static void main(String[] args) {
//	  SingleLL<Integer> l1 = new SingleLL<>();
//	  l1.append(1);
//	  l1.append(2);
//	  l1.append(3);
//	  SingleLL<Integer> l2 = new SingleLL<>();
//	  l2.append(4);
//	  l2.append(5);
//	  l2.append(6);
//	  SingleLL<Integer> l3 = new SingleLL<>();
//	  l3.append(7);
//	  l3.append(8);
//	  l3.append(9);
//	  
//	  List<Integer> lil = new ArrayList<>();
//	  lil.add(10);
//	  lil.add(11);
//	  lil.add(12);
//	  ListMatrix c = new ListMatrix(3,3);
//	  ListMatrix c2 = new ListMatrix(3,3);
//	  c.addList(l1);
//	  c.addList(l2);
//	  c.addList(l3);
//	  c2.addList(l2);
//	  c2.addList(l3);
//	  c2.addList(lil);
//	  System.out.println(c);
////	  c2 = (transpose(c2));
//	  System.out.println(c2);
////	  System.out.println(c2.multiply(c));
//////	  System.out.println(c);
//////	  System.out.println(c2);
//	  	c.add(c2);
//	  System.out.println(c);
//
//	  
//  }

}
