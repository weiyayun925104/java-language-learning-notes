/*
  Modify the GeometricObject class to implement the Comparable interface, and
  define a static max method in the GeometricObject class for finding the
  larger of two GeometricObject objects. Write a test program that uses the
  max method to find the larger of two circles and the larger of two rectangles.
*/

public class E13_05 {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    Circle c2 = new Circle(5);

    Circle largerCirc = (Circle)GeometricObject.max(c1, c2);

    System.out.println("The larger circle is the one with area " +
      largerCirc.getArea());

    Rectangle r1 = new Rectangle(5, 10);
    Rectangle r2 = new Rectangle(10, 10);

    Rectangle largerRect = (Rectangle)GeometricObject.max(r1, r2);

    System.out.println("The larger rectangle is the one with area " +
      largerRect.getArea());
  }
}
