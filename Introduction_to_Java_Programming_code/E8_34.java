/*
  In computational geometry, often you need to find the rightmost lowest point
  in a set of points. Write the following method that returns the rightmost
  lowest point in a set of points.

  public static double[] getRightmostLowestPoint(double[][] points)

  Write a test program that prompts the user to enter the coordinates of six
  points and displays the rightmost lowest point.
*/

import java.util.Scanner;

public class E8_34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 6 points: ");
    double[][] points = new double[6][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = input.nextDouble();
      }
    }

    double[] rightmostLowest = getRightmostLowestPoint(points);

    System.out.println("The rightmost lowest point is " +
      formatPoint(rightmostLowest));
  }

  public static double[] getRightmostLowestPoint(double[][] points) {
    // sort points to bring rightmost lowest point to the front of the array
    sortPoints(points);
    return points[0];
  }

  public static void displayPoints(double[][] points) {
    for (int i = 0; i < points.length; i++) {
      System.out.println(formatPoint(points[i]));
    }
  }

  public static String formatPoint(double[] point) {
    return "(" + point[0] + ", " + point[1] + ")";
  }

  public static void sortPoints(double[][] points) {
    // this sort is designed to sort first by lowest y-values
    // then secondarily by largest x-values
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < points.length - 1; i++) {
        if (points[i + 1][1] <= points[i][1]) {
          if (points[i + 1][0] < points[i][0]) {
            continue;
          }
          double[] temp = points[i + 1];
          points[i + 1] = points[i];
          points[i] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
