package eb1;

import java.util.Objects;

public class Cylinder extends Circle {
	private double height;
	
	public Cylinder(double height,double radius) {
		super(radius);
		this.height = height;
	}
	public double getHeight() { 
		return this.height; 
	}
	public double getVolume() { 
		return super.getArea() * height;
	}
	public double getArea() { 
		return 2.0 * Math.PI * getRadius() * height; 
	}
	 public String toString() { 
		 return "Cylinder[height=" + height + "," + super.toString() + "]";
	}
	 public boolean equals(Object o) {
		 if (this == o) {
			 System.out.print("i dont know");
			 return true;
		 }
		 if(o == null) {
			 return false;
		 }
		 if(!(o instanceof Cylinder)) {
			 return false;
		 }
		 Cylinder r = (Cylinder) o;
		 return Objects.equals(height , r.getHeight()) && Objects.equals(this.getRadius() , r.getRadius());
	 }
	 public static void main(String[] args) {
		 Circle c1 = new Cylinder(1.1, 2.2);
		 Circle c2 = null;
		 c1.getRadius();
		 //c1.getHeight(); 
		 //c1.getVolume();
		 System.out.println(c1.equals(c2)); 
		 
	 }

}
