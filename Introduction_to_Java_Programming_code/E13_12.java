/*
  Write a method that sums the areas of all the geometric objects in an array.
  The method signature is:

  public static double sumArea(GeometricObject[] a)

  Write a test program that creates an array of four objects (two circles and
  two rectangles) and computes their total using the sumArea method.
*/

public class E13_12 {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    Circle c2 = new Circle(23);
    Rectangle r1 = new Rectangle(5, 6);
    Rectangle r2 = new Rectangle(10, 2);
    GeometricObject[] arr = {c1, c2, r1, r2};

    double sum = sumArea(arr);
    System.out.println("The sum of the areas is " + sum);
  }

  public static double sumArea(GeometricObject[] a) {
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i].getArea();
    }
    return sum;
  }
}
