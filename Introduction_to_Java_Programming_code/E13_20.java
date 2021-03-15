/*
  Rewrite Programming Exercise 3.1 to obtain imaginary roots if the
  determinant is less than 0 using the Complex class in Programming Exercise
  3.17.
*/

import java.util.Scanner;

public class E13_20 {
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
      double real = b / 2;
      double imaginary = Math.sqrt(Math.abs(d)) / 2;
      Complex cr1 = new Complex(-real, imaginary);
      Complex cr2 = new Complex(-real, -imaginary);
      output.append("two roots " + cr1 + " and " + cr2);
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
