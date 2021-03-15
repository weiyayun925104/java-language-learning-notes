/*
  Suppose two line segments intersect. The two end-points for the first line
  segment are (x1, y1) and (x2, y2) and for the second line segment are
  (x3, y3) and (x4, y4). Write a program that prompts the user to enter these
  four endpoints and displays the intersecting point. As discussed in
  Programming Exercise 3.25, the intersecting point can be found by solving
  a linear equation. Use the LinearEquation class in Programming Exercise
  9.11 to solve this equation.
*/

import java.util.Scanner;

public class E9_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
    double[][] points = new double[4][2];
    for (int i = 0; i < points.length; i++) {
      points[i][0] = input.nextDouble();
      points[i][1] = input.nextDouble();
    }

    double a = points[0][1] - points[1][1];
    double b = -1 * (points[0][0] - points[1][0]);
    double c = points[2][1] - points[3][1];
    double d = -1 * (points[2][0] - points[3][0]);
    double e = a * points[0][0] - (points[0][0] - points[1][0]) * points[0][1];
    double f = c * points[2][0] - (points[2][0] - points[3][0]) * points[2][1];

    LinearEquation lin = new LinearEquation(a, b, c, d, e, f);

    if (!lin.isSolvable()) {
      System.out.println("The two lines are parallel");
    } else {
      System.out.println("x: " + lin.getX() + " y: " + lin.getY());
    }
  }
}
