/*
  Programming Exercise 3.32 shows how to test whether a point is on the left
  side of a directed line, on the right, or on the same line. Write the methods
  with the following headers:

  // Return true if point (x2, y2) is on the left side of the directed line
  // from (x0, y0) to (x1, y1)
  public static boolean leftOfTheLine(double x0, double y0, double x1,
    double y1, double x2, double y2)

  // Return true if point (x2, y2) is on the same line from (x0, y0) to
  // (x1, y1)
  public static boolean onTheSameLine(double x0, double y0, double x1,
    double y1, double x2, double y2)

  // Return true if point (x2, y2) is on the line segment from (x0, y0) to
  // (x1, y1)
  public static boolean onTheLineSegment(double x0, double y0, double x1,
    double y1, double x2, double y2)

  Write a program that prompts the user to enter the three points for p0, p1,
  and p2 and displays whether p2 is on the left of the line from p0 to p1,
  right, the same line, or on the line segment.
*/

import java.util.Scanner;

public class E6_39 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three points for p0, p1, and p2: ");
    double x0 = input.nextDouble();
    double y0 = input.nextDouble();
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();

    StringBuilder s = new StringBuilder(String.format("(%.2f, %.2f)", x2, y2));
    if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
      s.append(" is on the left side of the line");
    } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
      if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
        s.append(" is on the line segment");
      } else {
        s.append(" is on the same line");
      }
    } else {
      s.append(" is on the right side of the line");
    }
    s.append(String.format(" from (%.2f, %.2f) to (%.2f, %.2f)", x0, y0, x1,
      y1));

    System.out.println(s);
  }

  public static boolean leftOfTheLine(double x0, double y0, double x1,
    double y1, double x2, double y2) {
    return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) > 0;
  }

  public static boolean onTheSameLine(double x0, double y0, double x1,
    double y1, double x2, double y2) {
    return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) == 0;
  }

  public static boolean onTheLineSegment(double x0, double y0, double x1,
    double y1, double x2, double y2) {
    boolean onSegment = false;
    if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
      double segmentDistance = distance(x0, y0, x1, y1);
      double d1 = distance(x0, y0, x2, y2);
      double d2 = distance(x1, y1, x2, y2);
      if (d1 + d2 <= segmentDistance) {
        onSegment = true;
      }
    }
    return onSegment;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
