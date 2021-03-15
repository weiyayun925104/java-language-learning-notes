/*
  Write a program that prompts the user to enter a point (x, y) and checks
  whether the point is within the circle centered at (0, 0) with radius 10.
  For example, (4, 5) is inside the circle and (9, 9) is outside the circle.
*/

import java.util.Scanner;

public class E3_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a point with two coordinates: ");
    double x = input.nextDouble();
    double y = input.nextDouble();

    StringBuilder s = new StringBuilder();
    boolean inside = isInsideCircle(x, y, 10);
    s.append("Point (" + x + ", " + y + ") is " + (inside ? "" : "not ") +
      "in the circle");

    System.out.println(s);
  }

  private static boolean isInsideCircle(double x, double y,
    double circleRadius) {
    return distance(x, y, 0, 0) <= circleRadius;
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
