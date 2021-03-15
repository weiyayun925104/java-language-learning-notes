/*
  Write a program that displays the area and perimeter of a circle that has
  a radius of 5.5 using the following formula:

  perimeter = 2 * radius * PI
  area = radius * radius * PI
*/

public class E1_08 {
  public static void main(String[] args) {
    double perimeter = perimeter(5.5);
    double area = area(5.5);
    System.out.println("perimeter: " + perimeter);
    System.out.println("area: " + area);
  }

  private static double perimeter(double radius) {
    return 2 * radius * Math.PI;
  }

  private static double area(double radius) {
    return radius * radius * Math.PI;
  }
}
