/*
  A regular polygon is an n-sided polygon in which all sides are of the same
  length and all angles have the same degree (i.e. the polygon is both
  equilateral and equiangular). The formula for computing the area of a regular
  polygon is

                                (formula)

  Write a program that prompts the user to enter the number of sides and their
  length for a regular polygon and displays its area.
*/

import java.util.Scanner;

public class E4_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of sides: ");
    int n = input.nextInt();
    System.out.print("Enter the side length: ");
    double s = input.nextDouble();

    double area = areaOfRegularPolygon(n, s);

    System.out.println("The area of the polygon is " + area);
  }

  private static double areaOfRegularPolygon(double n, double s) {
    return (n * s * s) / (4 * Math.tan(Math.PI / n));
  }
}
