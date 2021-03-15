/*
  Programming Exercise 3.32 shows how to test whether a point is on an
  unbounded line. Revise Programming Exercise 3.32 to test whether a point is
  on a line segment. Write a program that prompts the user to enter the
  three points for p0, p1, and p2 and displays whether p2 is on the line
  segment from p0 to p1.
*/

import java.util.Scanner;

public class E3_34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three points for p0, p1, and p2: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double px = input.nextDouble();
    double py = input.nextDouble();

    String p0 = "(" + x1 + ", " + y1 + ")";
    String p1 = "(" + x2 + ", " + y2 + ")";
    String p2 = "(" + px + ", " + py + ")";
    int loc = pointLoc(x1, y1, x2, y2, px, py);

    double subSegments = distance(x1, y1, px, py) + distance(x2, y2, px, py);
    double segment = distance(x1, y1, x2, y2);
    double difference = subSegments - segment;
    final double EPSILON = 0.00001;
    boolean liesBetween = -EPSILON < difference && difference < EPSILON;

    StringBuilder output = new StringBuilder();
    if ((loc == 1 || loc == -1) ||
        (loc == 0 && !liesBetween)) {
      output.append(p2 + " is not on the line segment from " + p0 +
        " to " + p1);
    } else {
      output.append(p2 + " is on the line from " + p0 + " to " + p1);
    }

    System.out.println(output);
  }

  private static int pointLoc(double x1, double y1, double x2, double y2,
    double px, double py) {
    // 1 for left of line, 0 for on the line, -1 for right of line
    double t = (x2 - x1) * (py - y1) - (px - x1) * (y2 - y1);
    int loc;
    if (t > 0) loc = 1;
    else if (t < 0) loc = -1;
    else loc = 0;
    return loc;
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
