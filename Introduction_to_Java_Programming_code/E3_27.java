/*
  Suppose a right triangle is placed in a plane. The right-angle point is
  placed at (0, 0), and the other two points are placed at (200, 0) and
  (0, 100). Write a program that prompts the user to enter a point with
  x- and y-coordinates and determines whether the point is inside the triangle.

  Note: The formula in Exercise 3.32 for determining which side of a line a
  point is on is useful here. If the point is to the right of each line in
  the triangle (working clockwise), then it is inside the triangle.
*/


import java.util.Scanner;

public class E3_27 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a point's x- and y-coordinates: ");
    double px = input.nextDouble();
    double py = input.nextDouble();

    boolean a = isRightOfLine(0, 0, 0, 100, px, py);
    boolean b = isRightOfLine(0, 100, 200, 0, px, py);
    boolean c = isRightOfLine(200, 0, 0, 0, px, py);

    StringBuilder output = new StringBuilder();
    if (a && b && c) {
      output.append("The point is in the triangle");
    } else {
      output.append("The point is not in the triangle");
    }

    System.out.println(output);
  }

  private static boolean isRightOfLine(double x1, double y1, double x2, double y2,
    double px, double py) {
    return (x2 - x1) * (py - y1) - (px - x1) * (y2 - y1) <= 0;
  }
}
