/*
  Write a program that prompts the user to enter the length from the center
  of a pentagon to a vertex and computes the area of the pentagon.
*/

import java.util.Scanner;

public class E4_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the length from the center to a vertex: ");
    double v = input.nextDouble();

    double area = areaOfPentagon(v);

    System.out.println("The area of the pentagon is " + area);
  }

  private static double getSideLength(double v) {
    return 2 * v * Math.sin(Math.PI / 5);
  }

  private static double areaOfPentagon(double v) {
    double s = getSideLength(v);
    return (5 * s * s) / (4 * Math.tan(Math.PI / 5));
  }
}
