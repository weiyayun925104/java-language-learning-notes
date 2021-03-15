/*
  Write a program that prompts the user to enter two points (x1, y1) and
  (x2, y2) and displays the distance between them.
*/

import java.util.Scanner;

public class E2_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter x1 and y1: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    System.out.print("Enter x2 and y2: ");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();

    double distance = distance(x1, y1, x2, y2);

    System.out.println("The distance between the two points is " + distance);
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
