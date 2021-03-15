/*
  Write a program that meets the following requirements:

  - Define a class named Point with two data fields x and y to represent a
    point's x- and y-coordinates. Implement the Comparable interface for
    comparing the points on x-coordinates. If two points have the same
    x-coordinates, compare their y-coordinates.
  - Define a class named CompareY that implements Comparator<Point>.
    Implement the compare method to compare two points on their y-coordinates.
    If two points have the same y-coordinates, compare their x-coordinates.
  - Randomly create 100 points and apply the Arrays.sort method to display the
    points in increasing order of their x-coordinates and in increasing order
    of their y-coordinates, respectively.
*/

import java.util.Arrays;

public class E20_04 {
  public static void main(String[] args) {
    Point[] points = new Point[100];
    for (int i = 0; i < points.length; i++) {
      double x = Math.random() * 100;
      double y = Math.random() * 100;
      points[i] = new Point(x, y);
    }

    Arrays.sort(points, new CompareY());

    for (Point p: points) {
      System.out.println("[" + p.getX() + ", " + p.getY() + "]");
    }
  }
}
