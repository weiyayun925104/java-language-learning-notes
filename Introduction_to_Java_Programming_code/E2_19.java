/*
  Write a program that prompts the user to enter three points
  (x1, y1), (x2, y2), (x3, y3) of a triangle and displays its area. The formula
  for computing the area of a triangle is

  s = (side1 + side2 + side3) / 2
  area = sqrt(s(s - side1)(s - side2)(s- side3))
*/

import java.util.Scanner;

public class E2_19 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three points for a triangle: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double x3 = input.nextDouble();
    double y3 = input.nextDouble();

    double area = areaOfTriangle(x1, y1, x2, y2, x3, y3);

    System.out.println("The area of the triangle is " + area);
  }

  private static double areaOfTriangle(double x1, double y1, double x2,
    double y2, double x3, double y3) {
    double s1 = distance(x1, y1, x2, y2);
    double s2 = distance(x2, y2, x3, y3);
    double s3 = distance(x3, y3, x1, y1);
    double s = (s1 + s2 + s3) / 2.0;
    return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
