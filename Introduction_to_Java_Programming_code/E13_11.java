/*
  Write a class named Octogon that extends GeometricObject and implements
  the Comparable and Cloneable interfaces. Assume that all eight sides of the
  octogon are of equal length. The area can be computed using the following
  formula:

  area = (2 + 4/sqrt(2)) * side * side

  Write a test program that creates an Octogon object with side value 5 and
  displays its area and perimeter. Create a new object using the clone method
  and compare the two objects using the compareTo method.
*/

public class E13_11 {
  public static void main(String[] args) throws CloneNotSupportedException {
    Octogon o1 = new Octogon(5);

    System.out.println("area: " + o1.getArea());
    System.out.println("perimeter: " + o1.getPerimeter());

    Octogon o2 = (Octogon)o1.clone();

    if (o1.compareTo(o2) == 0) {
      System.out.println("o1 and o2 are equal");
    } else {
      System.out.println("o1 and o2 are not equal");
    }
  }
}
