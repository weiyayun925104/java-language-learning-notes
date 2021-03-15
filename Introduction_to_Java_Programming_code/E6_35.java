/*
  The area of a pentagon can be computed using the following formula:

                          (formula)

  Write a method that returns the area of a pentagon using the following
  header:

  public static double area(double side)

  Write a main method that prompts the user to enter the side of a pentagon
  and displays its area.
*/

import java.util.Scanner;

public class E6_35 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the side: ");
    double side = input.nextDouble();

    double area = area(side);

    System.out.println("The area of the pentagon is " + area);
  }

  public static double area(double side) {
    return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
  }
}
