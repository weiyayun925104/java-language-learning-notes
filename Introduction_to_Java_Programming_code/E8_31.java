/*
  Write a method that returns the intersecting point of two lines. The
  intersecting point of the two lines can be found by using the formula shown
  in Programming Exercise 3.25. Assume that (x1, y1) and (x2, y2) are the two
  points on line 1 and (x3, y3) and (x4, y4) are on line 2. The method header
  is

  public static double[] getIntersectingPoint(double[][] points)

  The points are stored in a 4-by-2 two-dimensional array points with
  (points[0][0], points[0][1]) for (x1, y1). The method returns the intersecting
  point or null if the two lines are parallel. Write a program that prompts
  the user to enter four points and displays the intersecting point. See
  Programming Exercise 3.25 for a sample run.
*/

import java.util.Scanner;

public class E8_31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] points = getInput(input);
    double[] intersectingPoint = getIntersectingPoint(points);

    if (intersectingPoint == null) {
      System.out.println("The two lines are parallel");
    } else {
      System.out.println("The intersecting point is at " +
        formatPoint(intersectingPoint));
    }
  }

  public static String formatPoint(double[] point) {
    return "(" + point[0] + ", " + point[1] + ")";
  }

  public static double[][] getInput(Scanner input) {
    System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
    double[][] points = new double[4][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = input.nextDouble();
      }
    }
    return points;
  }

  public static double[] getIntersectingPoint(double[][] points) {
    double a = points[0][1] - points[1][1];
    double b = -1 * (points[0][0] - points[1][0]);
    double c = points[2][1] - points[3][1];
    double d = -1 * (points[2][0] - points[3][0]);
    double e = a * points[0][0] - (points[0][0] - points[1][0]) * points[0][1];
    double f = c * points[2][0] - (points[2][0] - points[3][0]) * points[2][1];

    double disc = a * d - b * c;

    if (disc == 0) {
      return null;
    }

    double x = (e * d - b * f) / disc;
    double y = (a * f - e * c) / disc;

    return new double[]{x, y};
  }
}
