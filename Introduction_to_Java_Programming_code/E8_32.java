/*
  Write a method that returns the area of a triangle using the following
  header:

  public static double getTriangleArea(double[][] points)

  The points are stored in a 3-by-2 two-dimensional array points with
  points[0][0] and points[0][1] for (x1, y1). The triangle area can be
  computed using the formula in Programming Exercise 2.19. The method returns
  0 if the three points are on the same line. Write a program that prompts the
  user to enter three points of a triangle and displays the triangle's area.
*/

import java.util.Scanner;

public class E8_32 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter x1, y1, x2, y2, x3, y3: ");
    double[][] points = new double[3][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = input.nextDouble();
      }
    }

    double area = getTriangleArea(points);

    if (area == -1) {
      System.out.println("The three points are on the same line");
    } else {
      System.out.println("The area of the triangle is " + area);
    }
  }

  public static double getTriangleArea(double[][] points) {
    if (sameLine(points)) {
      return -1;
    }

    double s1 = distance(points[0][0], points[0][1], points[1][0], points[1][1]);
    double s2 = distance(points[1][0], points[1][1], points[2][0], points[2][1]);
    double s3 = distance(points[2][0], points[2][1], points[0][0], points[0][1]);
    double s = (s1 + s2 + s3) / 2.0;
    return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  public static boolean onTheSameLine(double x0, double y0, double x1,
    double y1, double x2, double y2) {
    return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) == 0;
  }

  public static boolean sameLine(double[][] points) {
    boolean sameLine = true;

    for (int i = 0; i < points.length - 2; i++) {
      if (!onTheSameLine(points[i][0], points[i][1], points[i + 1][0],
        points[i + 1][1], points[i + 2][0], points[i + 2][1])) {
        sameLine = false;
        break;
      }
    }

    return sameLine;
  }
}
