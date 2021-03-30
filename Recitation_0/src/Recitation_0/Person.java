package Recitation_0;

public class Person {
	protected String name;
	private int age;
	
	void setName(String name) {
		this.name = name;
	}
	void setName(int age) {
		this.age = age;
	}
	
	int getAge() {
		return this.age;
	}
	
	String getName() {
		return this.name;
	}
	
	Person(){
		this.name = "Tom";
		this.age = 15;
	}
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person p = new Person(21, "ayo");
		System.out.println(p.getAge());
		System.out.println(p.name);
	}
}
