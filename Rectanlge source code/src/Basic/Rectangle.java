

package Basic;
public class Rectangle {
// data fields
private double height;
private double width;
// constructor
Rectangle() {
}
Rectangle(double height, double width) {
this.height=height;
this.width=width;
}
// methods
public double getHeight() {
return height;
}
public double getWidth() {
return width;
}
public void setHeight(double height) {
this.height = height;
}
public void setWidth(double w) {
width = w;
}
public static void main(String[] args) {
Rectangle r1 = new Rectangle();
Rectangle r2 = new Rectangle(3.4,7.7);
r1.setHeight(7.3);
System.out.println(r1.getHeight());
System.out.println(r2.getHeight());
}
}


