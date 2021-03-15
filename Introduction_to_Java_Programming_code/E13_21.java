/*
  The equation of a parabola can be expressed in either standard form
  (y = ax^2 + bx + c) or vertex form (y = a(x-h)^2 + k). Write a program that
  prompts the user to enter a, b, and c as integers in standard form and
  displays h and k in the vertex form.
*/

import java.util.Scanner;

public class E13_21 {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    Rational a = new Rational(input.nextLong(), 1);
    Rational b = new Rational(input.nextLong(), 1);
    Rational c = new Rational(input.nextLong(), 1);

    Rational h = new Rational(-b.getNumerator(), 2 * a.getNumerator());
    Rational k = ((a.multiply(h).multiply(h)).add(b.multiply(h))).add(c);

    System.out.println("h is " + h + " and k is " + k);
  }
}
