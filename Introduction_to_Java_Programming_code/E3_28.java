/*
  Write a program that prompts the user to enter the center x- and
  y-coordinates, width, and height of two rectangles and determines whether
  the second rectangle is inside the first or overlaps with the first.
*/

import java.util.Scanner;

public class E3_28 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter r1's center x-, y-coords, width, and height: ");
    double r1X = input.nextDouble();
    double r1Y = input.nextDouble();
    double r1Width = input.nextDouble();
    double r1Height = input.nextDouble();
    System.out.print("Enter r2's center x-, y-coords, width, and height: ");
    double r2X = input.nextDouble();
    double r2Y = input.nextDouble();
    double r2Width = input.nextDouble();
    double r2Height = input.nextDouble();

    // find r2's corner points
    double xLow = -(r2Width / 2.0) + r2X;
    double xHigh = (r2Width / 2.0) + r2X;
    double yLow = -(r2Height / 2.0) + r2Y;
    double yHigh = (r2Height / 2.0) + r2Y;
    // determine if they lie in r1
    boolean upperLeft = pointInRect(xLow, yHigh, r1X, r1Y, r1Width, r1Height);
    boolean lowerLeft = pointInRect(xLow, yLow, r1X, r1Y, r1Width, r1Height);
    boolean upperRight = pointInRect(xHigh, yHigh, r1X, r1Y, r1Width, r1Height);
    boolean lowerRight = pointInRect(xHigh, yLow, r1X, r1Y, r1Width, r1Height);

    StringBuilder output = new StringBuilder();
    if (upperLeft && lowerLeft && upperRight && lowerRight) {
      output.append("r2 is inside r1");
    } else if (upperLeft || lowerLeft || upperRight || lowerRight) {
      output.append("r2 overlaps r1");
    } else {
      output.append("r2 does not overlap r1");
    }

    System.out.println(output);
  }

  private static boolean pointInRect(double x, double y, double centerX,
    double centerY, double width, double height) {
      double xLow = -(width / 2.0) + centerX;
      double xHigh = (width / 2.0) + centerX;
      double yLow = -(height / 2.0) + centerY;
      double yHigh = (height / 2.0) + centerY;

      return (x >= xLow && x <= xHigh) && (y >= yLow && y <= yHigh);
  }
}
