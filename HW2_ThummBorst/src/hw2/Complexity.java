package hw2;

public class Complexity {
	private static int count = 0;
	public static void method1(int n) {
		
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Operation "+counter); 
				counter++;
			}
		}
	}
	
	public static void method2(int n) {
		
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for ( int k = 0; k < n; k++) {
					System.out.println("Operation "+counter); 
					counter++;
				}
			}
		}
	}
	
	public static void method3(int n) {
		
		int counter = 0;
		for (int i = 1; i < n; i= i*2) {
			System.out.println("Operation "+counter); 
			counter++;
		}
	}
	
	public static void method4(int n) {
		
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j = j*2) {
				System.out.println("Operation "+counter); 
				counter++;
			}
		}
	}
	public static void method5(int n) {
		
		int counter = 0;
		for (double i = 2; i < n; i = Math.pow(i,2.0 )) {
			System.out.println("Operation "+counter); 
			counter++;	
		}
//		for (double i = n; i > 1; i= Math.sqrt(i)-1) {
//			System.out.println("Operation "+counter); 
//			counter++;
//		}
	}
	
	public static int method6(int n) {

	  //  if (n <= 1) {
	    //	return n;
	    //}
	    while(n>1) {
	    	System.out.println("Operation "+count);
	    	count++;
	    return method6(n - 1) + method6(n - 1);
	    }
		System.out.println("Operation "+count);
		count++;
	    return n;
	}
	public static void main(String[] args) {
		method6(4);
	}
}