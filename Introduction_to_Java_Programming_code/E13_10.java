/*
  Rewrite the Rectangle class in Listing 13.3 to extend GeometricObject and
  implement the Comparable interface. Override the equals method in the
  Object class. Two Rectangle objects are equal if their areas are the same.
*/

public class E13_10 {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(10, 5);
    Rectangle r2 = new Rectangle(5, 5);
    Rectangle r3 = new Rectangle(10, 5);
    String s = "Hello";

    System.out.println("r1.equals(r2) ? " + r1.equals(r2));
    System.out.println("r1.equals(r3) ? " + r1.equals(r3));
    System.out.println("r1.equals(s) ? " + r1.equals(s));
  }
}
