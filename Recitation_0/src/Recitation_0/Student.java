package Recitation_0;

public class Student extends Person {
	private double GPA;
	private int SSID;
	
	Student(int age, String name, int SSID, double GPA){
		super(age,name);
		this.SSID = SSID;
		this.GPA = GPA;
	}
	
	public String toString(){
		return super.name ;
	}
	public static void main(String[] args) {
		Student stud = new Student(20,"mike",00000,3.0);
		System.out.println(stud.toString());
	}

}
