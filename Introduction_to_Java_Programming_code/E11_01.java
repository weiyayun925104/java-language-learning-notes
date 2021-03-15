/*
  Design a class named Triangle that extends GeometricObject. The class
  contains:

  - Three double data fields named side1, side2, and side3 with default values
    1.0 to denote three sides of the triangle.
  - A no-arg constructor that creates a default triangle.
  - A constructor that creates a triangle with the specified side1, side2, and
    side3.
  - The accessor methods for all three data fields.
  - A method named getArea() that returns the area of this triangle.
  - A method named getPerimeter() that returns the perimeter of this triangle.
  - A method named toString() that returns a string description for this
    triangle.

  Write a test program that prompts the user to enter three sides of the
  triangle, a color, and a Boolean value to indicate whether the triangle is
  filled. The program should create a Triangle object with these sides and set
  the color and filled properties using the input. The program should display
  the area, perimeter, color, and true or false to indicate whether it is
  filled or not.
*/

import java.util.Scanner;

public class E11_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Triangle t = getTriangle(input);

    System.out.println("area: " + t.getArea());
    System.out.println("perimeter: " + t.getPerimeter());
    System.out.println("color: " + t.getColor());
    System.out.println("filled: " + t.isFilled());
  }

  public static Triangle getTriangle(Scanner input) {
    System.out.print("Enter three sides: ");
    Triangle t = new Triangle(input.nextDouble(), input.nextDouble(),
      input.nextDouble());
    System.out.print("Enter a color: ");
    t.setColor(input.next());
    String filled = "";
    do {
      System.out.print("Enter filled (t/f): ");
      filled = input.next();
      if (filled.equals("t")) {
        t.setFilled(true);
      } else if (filled.equals("f")) {
        t.setFilled(false);
      }
    } while (!filled.equals("t") && !filled.equals("f"));
    return t;
  }
}
