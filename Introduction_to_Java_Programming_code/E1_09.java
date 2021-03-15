/*
  Write a program that displays the area and perimeter of a rectangle with the
  width of 4.5 and height of 7.9 using the following formula:

  area = width * height
*/

public class E1_09 {
  public static void main(String[] args) {
    System.out.println("area: " + area(4.5, 7.9));
    System.out.println("perimeter: " + perimeter(4.5, 7.9));
  }

  private static double area(double width, double height) {
    return width * height;
  }

  private static double perimeter(double width, double height) {
    return 2 * (width + height);
  }
}
