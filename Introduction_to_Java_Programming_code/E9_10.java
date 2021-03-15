/*
  Design a class named QuadraticEquation for a quadratic equation
  ax^2 + bx + x = 0. The class contains:

  - Private data fields for a, b, and c that represent three coefficients.
  - A constructor for the arguments a, b, and c.
  - Three getter methods for a, b, and c.
  - A method named getDiscriminant() that returns the discriminant, which is
    b^2 - 4ac.
  - The methods named getRoot1() and getRoot2() for returning two roots of
    the quadratic formula. These methods are useful only if the discriminant
    is nonnegative. Let these methods return 0 if the discriminant is negative.

  Write a test program that prompts the user to enter values for a, b, and c
  and displays the result based on the discriminant. If the discriminant is
  positive, display the two roots. If the discriminant is 0, display the one
  root. Otherwise, display "The equation has no roots."
*/

import java.util.Scanner;

public class E9_10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    QuadraticEquation quad = new QuadraticEquation(input.nextDouble(),
      input.nextDouble(), input.nextDouble());

    double discriminant = quad.getDiscriminant();

    if (discriminant > 0) {
      System.out.println("root1: " + quad.getRoot1());
      System.out.println("root2: " + quad.getRoot2());
    } else if (discriminant == 0) {
      System.out.println("root: " + quad.getRoot1());
    } else {
      System.out.println("The equation has no roots.");
    }
  }
}
