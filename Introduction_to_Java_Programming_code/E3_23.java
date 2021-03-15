/*
  Write a program that prompts the user to enter a point (x, y) and checks
  whether the point is within the rectangle centered at (0, 0) with width 10
  and height 5. For example, (2, 2) is inside the rectangle and (6, 4) is
  outside the rectangle.
*/

import java.util.Scanner;

public class E3_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a point with two coordinates: ");
    double x = input.nextDouble();
    double y = input.nextDouble();

    boolean isInRect = isInRect(x, y, 0, 0, 10, 5);
    StringBuilder result = new StringBuilder();
    result.append("Point (" + x + ", " + y + ") is " + (isInRect ? "" : "not ")
      + "in the rectangle");

    System.out.println(result);
  }

  private static boolean isInRect(double x, double y, double centerX,
    double centerY, double width, double height) {
    double xLow = -(width / 2.0) + centerX;
    double xHigh = (width / 2.0) + centerX;
    double yLow = -(height / 2.0) + centerY;
    double yHigh = (height / 2.0) + centerY;

    return (x >= xLow && x <= xHigh) && (y >= yLow && y <= yHigh);
  }
}
