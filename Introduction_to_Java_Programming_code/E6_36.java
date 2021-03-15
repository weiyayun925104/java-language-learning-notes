/*
  A regular polygon is an n-sided polygon in which all sides are of the same
  length and all angles have the same degree (ie the polygon is both
  equilateral and equiangular). The formula for computing the area of a regular
  polygon is

                              (formula)

  Write a method that returns the area of a regular polygon using the following
  header:

  public static double area(int n, double side)

  Write a main method that prompts the user to enter the number of sides and
  the side of a regular polygon and displays its area.
*/

import java.util.Scanner;

public class E6_36 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of sides: ");
    int n = input.nextInt();
    System.out.print("Enter the side: ");
    double side = input.nextDouble();

    double area = area(n, side);

    System.out.println("The area of the polygon is " + area);
  }

  public static double area(int n, double side) {
    return (n * side * side) / (4 * Math.tan(Math.PI / n));
  }
}
