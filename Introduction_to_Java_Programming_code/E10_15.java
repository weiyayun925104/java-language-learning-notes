/*
  A bounding rectangle is the minimum rectangle that encloses a set of points
  in a two-dimensional plane. Write a method that returns a bounding rectangle
  for a set of points in a two-dimensional plane, as follows:

  public static MyRectangle2D getRectangle(double[][] points)

  The Rectangle2D class is defined in Programming Exercise 10.13. Write a test
  program that prompts the user to enter five points and displays the bounding
  rectangle's center, width, and height.
*/

import java.util.Scanner;

public class E10_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    MyRectangle2D rect = getRectangle(getPoints(input));

    System.out.println("The bounding rectangle's center (" + rect.getX() +
      ", " + rect.getY() + "), width " + rect.getWidth() + ", height " +
      rect.getHeight());
  }

  public static MyRectangle2D getRectangle(double[][] points) {
    // find the highest and lowest x and y
    double lowX = points[0][0];
    double lowY = points[0][1];
    double highX = points[0][0];
    double highY = points[0][1];

    for (int i = 1; i < points.length; i++) {
      if (points[i][0] < lowX) { lowX = points[i][0]; }
      if (points[i][0] > highX) { highX = points[i][0]; }
      if (points[i][1] < lowY) { lowY = points[i][1]; }
      if (points[i][1] > highY) { highY = points[i][1]; }
    }

    // create a MyRectangle2D object using this information
    double width = highX - lowX;
    double height = highY - lowY;
    double x = (width / 2) + lowX;
    double y = (height / 2) + lowY;
    return new MyRectangle2D(x, y, width, height);
  }

  public static double[][] getPoints(Scanner input) {
    System.out.print("Enter five points: ");
    double[][] points = new double[5][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = input.nextDouble();
      }
    }
    return points;
  }
}
