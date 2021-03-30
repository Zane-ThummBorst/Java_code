package yey;

public class PalindromeChecker {
	// data fields
	private Stack<Character> st;
	private String str;
	
	// Constructor
	PalindromeChecker(String s) {
		fillStack(s);
		this.str=s;
	}
	
	private void fillStack(String s) {
		// consider using s.CharAt(i) to grab i-th char in s
			st = new Stack<>();
			for(int i = 0; i < s.length()-1;i++) {
				st.push(s.charAt(i));
			}
	}
	
	private String reverseString() {
		StringBuilder ey = new StringBuilder();
		while(st.empty() != true) {
			ey.append(st.pop());
		}
		return ey.toString();
	}
	
	public Boolean isPalindrome() {
		return str.equals(reverseString());
	}
	
	public static void main(String[] args) {
		// code to test your solution 
		// include examples and non-examples
	}
}

