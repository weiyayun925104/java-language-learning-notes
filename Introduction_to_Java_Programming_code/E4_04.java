/*
  The area of a hexagon can be computed using the following formula

                            (formula)

  Write a program that prompts the user to enter the side of a hexagon and
  displays its area.
*/

import java.util.Scanner;

public class E4_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the side: ");
    double side = input.nextDouble();

    double area = areaOfHexagon(side);

    System.out.println("The area of the hexagon is " + area);
  }

  private static double areaOfHexagon(double side) {
    return (6 * side * side) / (4 * Math.tan(Math.PI / 6));
  }
}
