/*
  Design a new Triangle class that extends the abstract GeometricObject class.
  Write a test program that prompts the user to enter three sides of the
  triangle, a color, and a Boolean value to indicate whether the triangle is
  filled. The program should create a Triangle object with these sides and set
  the color and filled properties using the input. The program should display
  the area, perimeter, color, and true or false to indicate whether it is
  filled or not.
*/

import java.util.Scanner;

public class E13_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three sides of a triangle: ");
    double s1 = input.nextDouble();
    double s2 = input.nextDouble();
    double s3 = input.nextDouble();
    System.out.print("Enter a color: ");
    String color = input.next();
    System.out.print("Enter a filled value (T/F): ");
    String fillString = input.next();
    boolean filled = false;
    if (fillString.toLowerCase().equals("t")) {
      filled = true;
    } else if (fillString.toLowerCase().equals("f")) {
      filled = false;
    } else {
      System.out.println("Invalid entry: must enter T or F.");
      System.exit(1);
    }

    Triangle t = new Triangle(s1, s2, s3);
    t.setColor(color);
    t.setFilled(filled);

    System.out.println("area: " + t.getArea());
    System.out.println("perimeter: " + t.getPerimeter());
    System.out.println("color: " + t.getColor());
    System.out.println("filled: " + t.isFilled());
  }
}
