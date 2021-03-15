/*
  A convex 4-vertex polygon is divided into four triangles.

  Write a program that prompts the user to enter the coordinates of four
  vertices and displays the areas of the four triangles in increasing order.
*/

import java.util.Scanner;

public class E8_33 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] points = getInput(input);

    double[] areas = getSubTriangleAreas(points);
    sort(areas);

    System.out.print("The areas are ");
    for (int i = 0; i < areas.length; i++) {
      System.out.printf("%.2f ", areas[i]);
    }
    System.out.println();
  }

  public static double[] getSubTriangleAreas(double[][] points) {
    // make copy of points and swap vertex 2 with vertex 3
    // (small hack to make array work with getIntersectingPoint method)
    double[][] copy = copyMatrix(points);
    double[] temp = copy[1];
    copy[1] = copy[2];
    copy[2] = temp;

    // get intersecting point of lines connecting opposite vertices
    double[] intersect = getIntersectingPoint(copy);

    // find areas of subtriangles
    double[] areas = new double[4];
    areas[0] = getTriangleArea(points[0], points[1], intersect);
    areas[1] = getTriangleArea(points[1], points[2], intersect);
    areas[2] = getTriangleArea(points[2], points[3], intersect);
    areas[3] = getTriangleArea(points[3], points[0], intersect);

    return areas;
  }

  public static void sort(double[] m) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < m.length - 1; i++) {
        if (m[i] > m[i + 1]) {
          double temp = m[i];
          m[i] = m[i + 1];
          m[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }

  public static double getTriangleArea(double[] p1, double[] p2, double[] p3) {
    double[][] points = {p1, p2, p3};
    if (sameLine(points)) {
      return -1;
    }

    double s1 = distance(p1[0], p1[1], p2[0], p2[1]);
    double s2 = distance(p2[0], p2[1], p3[0], p3[1]);
    double s3 = distance(p3[0], p3[1], p1[0], p1[1]);
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

  public static double[][] copyMatrix(double[][] matrix) {
    double[][] copy = new double[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        copy[i][j] = matrix[i][j];
      }
    }
    return copy;
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

  public static void displayMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(formatPoint(matrix[i]));
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
}
