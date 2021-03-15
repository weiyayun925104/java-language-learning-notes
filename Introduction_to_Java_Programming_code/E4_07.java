/*
  Suppose a pentagon is centered at (0, 0) with one point at the 0 o'clock
  position. Write a program that prompts the user to enter the radius of the
  bounding circle of a pentagon and displays the coordinates of the five
  corner points on the pentagon.
*/

import java.util.Scanner;

public class E4_07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the radius of the bounding circle: ");
    double radius = input.nextDouble();

    final double SLICE = Math.toRadians(360 / 5.0);
    double angle = SLICE;
    System.out.println("The coordinates of five points on the pentagon are");
    for (int i = 0; i < 5; i++) {
      System.out.println(getPointOnCircle(radius, angle));
      angle += SLICE;
    }
  }

  private static Point getPointOnCircle(double radius, double angle) {
    return new Point(radius * Math.sin(angle), radius * Math.cos(angle));
  }

  private static class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double getX() {
      return x;
    }

    public double getY() {
      return y;
    }

    public String toString() {
      return String.format("(%f, %f)", x, y);
    }
  }
}
