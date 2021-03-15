
import java.util.Scanner;

public class E8_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter five points: ");
    double[][] points = new double[5][2];
    for (int i = 0; i < points.length; i++) {
      points[i][0] = input.nextDouble();
      points[i][1] = input.nextDouble();
    }

    if (sameLine(points)) {
      System.out.println("The five points are on the same line");
    } else {
      System.out.println("The five points are not on the same line");
    }
  }

  public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2)
  {
    return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) > 0;
  }

  public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2)
  {
    return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) == 0;
  }

  public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2)
  {
    boolean onSegment = false;
    if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
      double segmentDistance = distance(x0, y0, x1, y1);
      double d1 = distance(x0, y0, x2, y2);
      double d2 = distance(x1, y1, x2, y2);
      if (d1 + d2 <= segmentDistance) {
        onSegment = true;
      }
    }
    return onSegment;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
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