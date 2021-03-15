/*
  Write a program that displays a random coordinate in a rectangle. The
  rectangle is centered at (0,0) with width 100 and height 200.
*/

public class E3_16 {
  public static void main(String[] args) {
    displayRandomCoordInRect(0, 0, 100, 200);
  }

  private static void displayRandomCoordInRect(double centerX, double centerY,
    double width, double height) {
    double x = (Math.random() * (width)) - (width / 2) + centerX;
    double y = (Math.random() * (height)) - (height / 2) + centerY;
    System.out.printf("(%.2f, %.2f)\n", x, y);
  }
}
