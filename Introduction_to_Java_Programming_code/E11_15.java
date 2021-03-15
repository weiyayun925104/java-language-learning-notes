/*
  A polygon is convex if it contains any line segments that connects two points
  of the polygon. Write a program that prompts the user to enter the number of
  points in a convex polygon, then enter the points clockwise, and display the
  area of the polygon.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double area = getAreaOfConvexPolygon(input);

    System.out.println("The total area is " + area);
  }

  public static double getAreaOfConvexPolygon(Scanner input) {
    ArrayList<ArrayList<Double>> points = getPoints(input);

    double sumOfProducts = 0.0;
    for (int i = 0; i < points.size() - 1; i++) {
      double x1 = points.get(i).get(0);
      double y1 = points.get(i).get(1);
      double x2 = points.get(i + 1).get(0);
      double y2 = points.get(i + 1).get(1);
      sumOfProducts += ((x1 * y2) - (y1 * x2));
    }

    return Math.abs(sumOfProducts / 2);
  }

  public static ArrayList<ArrayList<Double>> getPoints(Scanner input) {
    System.out.print("Enter the number of the points: ");
    int size = input.nextInt();
    System.out.print("Enter the coordinates of the points: ");
    ArrayList<ArrayList<Double>> points = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      ArrayList<Double> point = new ArrayList<>();
      point.add(input.nextDouble());
      point.add(input.nextDouble());
      points.add(point);
    }
    return points;
  }

  public static void displayPoints(ArrayList<ArrayList<Double>> points) {
    for (int i = 0; i < points.size(); i++) {
      for (int j = 0; j < points.get(i).size(); j++) {
        System.out.print(points.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
