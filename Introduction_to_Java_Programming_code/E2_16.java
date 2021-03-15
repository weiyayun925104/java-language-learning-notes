/*
  Write a program that prompts the user to enter the side of a hexagon and
  displays its area.
*/

import java.util.Scanner;

public class E2_16 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the side: ");
    double side = input.nextDouble();

    double area = areaOfHexagon(side);

    System.out.println("The area of the hexagon is " + area);
  }

  private static double areaOfHexagon(double s) {
    return ((3.0 * Math.sqrt(3)) / 2.0) * (s * s);
  }
}
