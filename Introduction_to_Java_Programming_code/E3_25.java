/*
  Two points on line 1 are given as (x1, y1) and (x2, y2) and on line 2 as
  (x3, y3) and (x4, y4). The intersecting point of the two lines can be found
  by solving the following linear equation:

                        (equation)

  This linear equation can be solved using Cramer's rule. If the equation has
  no solutions, the two lines are parallel. Write a program that prompts the
  user to enter four points and displays the intersecting point.
*/

import java.util.Scanner;

public class E3_25 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double x3 = input.nextDouble();
    double y3 = input.nextDouble();
    double x4 = input.nextDouble();
    double y4 = input.nextDouble();

    double a = y1 - y2;
    double b = -1 * (x1 - x2);
    double c = y3 - y4;
    double d = -1 * (x3 - x4);
    double e = a * x1 - (x1 - x2) * y1;
    double f = c * x3 - (x3 - x4) * y3;

    cramer(a, b, c, d, e, f);
  }

  private static void cramer(double a, double b, double c, double d, double e,
    double f) {
    StringBuilder output = new StringBuilder();
    double disc = a * d - b * c;
    if (disc > 0 || disc < 0) {
      double x = (e * d - b * f) / disc;
      double y = (a * f - e * c) / disc;
      output.append("The intersecting point is at (" + x + ", " + y + ")");
    } else {
      output.append("The two lines are parallel");
    }
    System.out.println(output);
  }
}
