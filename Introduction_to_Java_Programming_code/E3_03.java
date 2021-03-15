/*
  A linear equation can be solved using Cramer's rule given in Programming
  Exercise 1.13. Write a program that prompts the user to enter a, b, c, d, e,
  and f and displays the result. If ad - bc is 0, report that "The equation has
  no solution."
*/

import java.util.Scanner;

public class E3_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c, d, e, f: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();
    double d = input.nextDouble();
    double e = input.nextDouble();
    double f = input.nextDouble();

    cramer(a, b, c, d, e, f);
  }

  private static void cramer(double a, double b, double c, double d, double e,
    double f) {
    StringBuilder output = new StringBuilder();
    double disc = a * d - b * c;
    if (disc > 0 || disc < 0) {
      double x = (e * d - b * f) / disc;
      double y = (a * f - e * c) / disc;
      output.append("x is " + x + " and y is " + y);
    } else {
      output.append("The equation has no solution");
    }
    System.out.println(output);
  }
}
