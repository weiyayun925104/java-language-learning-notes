/*
  Write a program that prompts the user to enter the center coordinates and
  radii of two circles and determines whether the second circle is inside the
  first or overlaps with the first.
*/

import java.util.Scanner;

public class E3_29 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter circle1's center x-, y-coords, and radius: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double r1 = input.nextDouble();
    System.out.print("Enter circle2's center x-, y-coords, and radius: ");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double r2 = input.nextDouble();

    double dist = distance(x1, y1, x2, y2);
    StringBuilder output = new StringBuilder();
    if (dist <= Math.abs(r1 - r2)) {
      output.append("circle2 is inside circle1");
    } else if (dist <= r1 + r2) {
      output.append("circle2 overlaps circle1");
    } else {
      output.append("circle2 does not overlap circle1");
    }

    System.out.println(output);
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
