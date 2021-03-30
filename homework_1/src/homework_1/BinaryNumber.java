// Zane ThummBorst
// I pledge my honor that I have abided by the Stevens Honor System.

package homework_1;

import java.util.Arrays;

public class BinaryNumber {
	private int data[];
	private int length;
	
	public BinaryNumber(int length) {
		this.length = length;
		data = new int[length];
		for(int i = 0; i < length;i++) {
			data[i] = 0;
		}
	}
	
	public BinaryNumber(String str) {
		this.length = str.length();
		data = new int[length];
		char c;
		int t;
		for(int i = 0; i < length;i++) {
			c = str.charAt(i);
			t = Character.getNumericValue(c);
			data[i] = t;
		}
		
	}
	// returns the length of data
	public int getLength() {
		return this.length;
	}
	
	// returns the data arraylist
	public int[] getInnerArray() {
		return data;
	}
	
	// retrieves the digit of the given index in data. If the given index is not found to be in data, then an error is thrown.
	public int getDigit(int index) {
		if (index < 0 || index > data.length - 1) {
			System.out.println("cease this buffoonery.");
			throw new IllegalArgumentException();
		}
		return data[index];
	}
	
	// converts from binary to decimal.
	public int toDecimal() {
		double len = data.length - 1;
		double dec = 0;
		for(int i = 0; i < data.length;i++) {
			if(data[i] == 1) {
				dec = dec + Math.pow(2.0, len);
			}
			len--;
		}
		return (int) dec;
	}
	// shifts the binary number in a given direction for a given amount. An error is thrown if the direction is invalid 
	//or the amount is greater than the length of the list( when shifting to the left);
	public void bitShift(int direction, int amount) {
		if(Math.abs(direction)!= 1) {
			System.out.println("how dare you. postivie or negative one dingus.");
			throw new IllegalArgumentException();
		}		
		if(direction == 1) {
			int data2[] = new int[(this.data.length) + amount];
			for (int i = 0; i < data.length;i++) {
				data2[i] = data[i];
			}
			data = data2.clone();
		}
		else {
			if(amount > data.length) {
				System.out.println("aight thats too much m8. There's only so much in the list");
				throw new IllegalArgumentException();
			}
			int data2[] = new int[(this.data.length) - amount];
			for (int i = 0; i < data2.length;i++) {
				data2[i] = data[i];
			}
		data = data2.clone();
		}
	}
	
	//returns the bitwise or of two binary numbers. An error is thrown when the given binary values are not the same length.
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() !=bn2.getLength()) {
			System.out.println("can't be doin that. Make them the same length.");
			throw new IllegalArgumentException();
		}
		int[] or = new int[bn1.length];
		for(int i = 0;i < bn1.length;i++) {
			if(bn1.data[i] + bn2.data[i] != 0) {
				or[i] = 1;
			}
			else {
				or[i] = 0;
			}
		}
		return or;
	}
	//returns the bitwise and of two binary numbers. An error is thrown when the given binary values are not the same length.
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() !=bn2.getLength()) {
			System.out.println("can't be doin that. Make them the same length.");
			throw new IllegalArgumentException();
		}
		int[] and = new int[bn1.length];
		for(int i = 0;i < bn1.length;i++) {
			if(bn1.data[i] + bn2.data[i] == 2) {
				and[i] = 1;
			}
			else {
				and[i] = 0;
			}
		}
		return and;
	}
	
	//adds two binary numbers together with the help of a carry and prepend.
	public void add(BinaryNumber aBinaryNumber) {
		int c = 0;
		if(length < aBinaryNumber.length) {
			prepend(Math.abs(this.length - aBinaryNumber.length), this);
		}
		if(length > aBinaryNumber.length) {
			prepend(Math.abs(this.length - aBinaryNumber.length), aBinaryNumber);
		}
		int added[] = new int[this.length];
		for(int i = data.length-1;i >= 0; i--) {
			if(aBinaryNumber.data[i] + data[i] + c == 0) {
				added[i] = 0;
				c = 0;
			}
			else if(aBinaryNumber.data[i] + data[i] + c == 2) {
				added[i] = 0;
				c = 1;
			}
			else if (aBinaryNumber.data[i] + data[i] + c == 3){
				added[i] = 1;
				c = 1;
			}
			else {
				added[i] = 1;
				c=0;
			}
		}
		this.data = added.clone();
		if( c == 1)
		{
			prepend(c, this);
			data[0] = 1;
		}	
	}
	//adjusts a binary numbers size by adding 0's to the beggining of the list given a specified amount.
	public static void prepend(int amount, BinaryNumber bn) {
		int more[]=new int[amount + bn.length];
		for(int i = 0; i < more.length;i++) {
			more[i] = 0;
		}
		int j = more.length-1;
		for (int i = bn.data.length-1; i >= 0;i--) {
			more[j] = bn.data[i];
			j--;
		}
		bn.data =more.clone();
	}
	
	//overrides the toString function
	public String toString() {
		return  Arrays.toString(data);
	}

	public static void main(String[] Args) {
		BinaryNumber l1 = new BinaryNumber("10");
		BinaryNumber l2 = new BinaryNumber("11011");
		l1.add(l2);
		System.out.println(l1);

	}
}

/*	 CONSTRUCTOR TEST CASES (and toString)
		BinaryNumber l1 = new BinaryNumber(5);
		BinaryNumber l2 = new BinaryNumber("10100");
		System.out.println(l1);
		System.out.println(l2);
		
		CONSOLE:
		[0, 0, 0, 0, 0]
		[1, 0, 1, 0, 0]
 */
/* getLength & getInnerArray TEST CASES
		BinaryNumber l1 = new BinaryNumber(5);
		int len = l1.getLength();
		int arr[] = l1.getInnerArray();
		System.out.println(len);
		System.out.println(Arrays.toString(arr));
		
		CONOLE:
		5
		[0, 0, 0, 0, 0]
 */

/* getDigit TESTCASE #1
 		BinaryNumber l1 = new BinaryNumber("10101");
		int digit = l1.getDigit(20);
		System.out.println(digit);
 		
 		CONSOLE:
 		cease this buffoonery.
		Exception in thread "main" java.lang.IllegalArgumentException
*/

/* getDigit TESTCASE #2
		BinaryNumber l1 = new BinaryNumber("10101");
		int digit = l1.getDigit(2);
		System.out.println(digit);
	
		CONSOLE:
		1
*/

/* toDecimal TESTCASES
 		BinaryNumber l1 = new BinaryNumber("1011");
		BinaryNumber l2 = new BinaryNumber("11111");
		System.out.println(l1.toDecimal());
		System.out.println(l2.toDecimal());
		
		CONSOLE:
		11
		31
 */
/*BitShift TESTCASE#1
 		BinaryNumber l1 = new BinaryNumber("1011");
		BinaryNumber l2 = new BinaryNumber("11111");
		l1.bitShift(-1, 2);
		l2.bitShift(1,3);
		System.out.println(l1);
		System.out.println(l2);
		
		CONSOLE:
		[1, 0]
		[1, 1, 1, 1, 1, 0, 0, 0]
 */

/*BitShift TESTCASE#2
		BinaryNumber l1 = new BinaryNumber("1011");
		l1.bitShift(-1, 2);
		System.out.println(l1);

		CONSOLE:
		how dare you. postivie or negative one dingus.
		Exception in thread "main" java.lang.IllegalArgumentException
*/

/*BitShift TESTCASE#3
		BinaryNumber l1 = new BinaryNumber("1011");
		l1.bitShift(-1, 500);
		System.out.println(l1);

		CONSOLE:
		aight thats too much m8. There's only so much in the list
		Exception in thread "main" java.lang.IllegalArgumentException
*/
/*bwor TESTCASE#1
		BinaryNumber l1 = new BinaryNumber("0101");
		BinaryNumber l2 = new BinaryNumber("1010");
		int or[] = bwor(l1,l2);
		System.out.println(Arrays.toString(or));
		
		CONSOLE:
		[1, 1, 1, 1]
*/

/*bwor TESTCASE#2
		BinaryNumber l1 = new BinaryNumber("01010");
		BinaryNumber l2 = new BinaryNumber("1010");
		int or[] = bwor(l1,l2);
		System.out.println(Arrays.toString(or));

		CONSOLE:
		can't be doin that. Make them the same length.
		Exception in thread "main" java.lang.IllegalArgumentException
*/

/*bwand TESTCASE#1
		BinaryNumber l1 = new BinaryNumber("0101");
		BinaryNumber l2 = new BinaryNumber("1010");
		int and[] = bwand(l1,l2);
		System.out.println(Arrays.toString(and));

		CONSOLE:
		[0, 0, 0, 0]
*/

/*bwand TESTCASE#2
		BinaryNumber l1 = new BinaryNumber("01010");
		BinaryNumber l2 = new BinaryNumber("1010");
		int and[] = bwand(l1,l2);
		System.out.println(Arrays.toString(and));

		CONSOLE:	
		can't be doin that. Make them the same length.
		Exception in thread "main" java.lang.IllegalArgumentException
*/

/*add TESTCASE#1
 		BinaryNumber l1 = new BinaryNumber("01101");
		BinaryNumber l2 = new BinaryNumber("01001");
		l1.add(l2);
		System.out.println(l1);

		CONSOLE:
		[1, 0, 1, 1, 0]
*/

/*add TESTCASE#2
		BinaryNumber l1 = new BinaryNumber("10110");
		BinaryNumber l2 = new BinaryNumber("11101");
		l1.add(l2);
		System.out.println(l1);

		CONSOLE:
		[1, 1, 0, 0, 1, 1]
*/