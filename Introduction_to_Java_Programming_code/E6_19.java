/*
  Create a class that contains the following two methods:

  // Return true if the sum of any two sides is greater than the third side.
  public static boolean isValid(double side1, double side2, double side3)

  // Return the area of the triangle.
  public static double area(double side1, double side2, double side3)

  Write a test program that reads three sides for a triangle and computes the
  area if the input is valid. Otherwise, it displays that the input is invalid.
*/

import java.util.Scanner;

public class E6_19 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three sides: ");
    double side1 = input.nextDouble();
    double side2 = input.nextDouble();
    double side3 = input.nextDouble();

    if (isValid(side1, side2, side3)) {
      System.out.println("area: " + area(side1, side2, side3));
    } else {
      System.out.println("Not a triangle.");
    }
  }

  public static boolean isValid(double s1, double s2, double s3) {
    return (s1 + s2 > s3 && s2 + s3 > s1 && s3 + s1 > s2);
  }

  public static double area(double s1, double s2, double s3) {
    double s = (s1 + s2 + s3) / 2.0;
    return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
  }
}
