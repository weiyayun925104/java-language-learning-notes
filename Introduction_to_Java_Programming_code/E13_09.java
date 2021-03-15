/*
  Rewrite the Circle class in Listing 13.2 to extend GeometricObject and
  implement the Comparable interface. Override the equals method in the Object
  class. Two Circle objects are equal if their radii are the same.
*/

public class E13_09 {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    Circle c2 = new Circle(10);
    Circle c3 = new Circle(5);
    String s = "Hello";

    System.out.println("c1.equals(c2) ? " + c1.equals(c2));
    System.out.println("c1.equals(c3) ? " + c1.equals(c3));
    System.out.println("c1.equals(s) ? " + c1.equals(s));
  }
}
