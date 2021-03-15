/*
  Given a directed line from point p0(x0, y0) to p1(x1, y1), you can use the
  following condition to decide whether a point p2(x2, y2) is on the left of
  the line, on the right, or on the same line:

                          (condition)

  Write a program that prompts the user to enter the three points for p0, p1,
  and p2 and displays whether p2 is on the left of the line from p0 to p1, on
  the right, or on the same line.
*/

import java.util.Scanner;

public class E3_32 {
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

    StringBuilder output = new StringBuilder();
    if (loc == 1) {
      output.append(p2 + " is on the left side of the line from " + p0 +
        " to " + p1);
    } else if (loc == -1) {
      output.append(p2 + " is on the right side of the line from " + p0 +
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
}
