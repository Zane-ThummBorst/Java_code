package eb1;

public class Circle {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return this.radius;
	}
	public double getArea() { 
		return radius * radius * Math.PI; 
	}
	public String toString() { 
		return "Circle[radius=" + radius + "]"; 
	}
}
