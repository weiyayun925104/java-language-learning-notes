/*
  The two roots of a quadratic equation can be obtained using the following
  formula:

                  (quadratic formula)

  If the discriminant is positive, the equation has two real roots. If it is
  zero, the equation has one root. If it is negative, the equation has no real
  roots.

  Write a program that prompts the user to enter values for a, b, and c and
  displays the result based on the discriminant. If the discriminant is
  positive, display two roots. If the discriminant is 0, display one root.
  Otherwise, display "The equation has no real roots".
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E3_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();

    displayRoots(a, b, c);
  }

  private static void displayRoots(double a, double b, double c) {
    double d = discriminant(a, b, c);
    double r1 = 0.0;
    double r2 = 0.0;
    StringBuilder output = new StringBuilder("The equation has ");

    if (d > 0) {
      r1 = calculateRoot(a, b, d, true);
      r2 = calculateRoot(a, b, d, false);
      output.append("two roots " + r1 + " and " + r2);
    } else if (d < 0) {
      output.append("no real roots");
    } else {
      r1 = calculateRoot(a, b, d, true);
      output.append("one root " + r1);
    }

    System.out.println(output);
  }

  private static double calculateRoot(double a, double b, double disc,
    boolean isR1) {
    double root;
    if (isR1) {
      root = (-b + Math.sqrt(disc)) / (2 * a);
    } else {
      root = (-b - Math.sqrt(disc)) / (2 * a);
    }
    return root;
  }

  private static double discriminant(double a, double b, double c) {
    return (b * b) - (4 * a * c);
  }
}
