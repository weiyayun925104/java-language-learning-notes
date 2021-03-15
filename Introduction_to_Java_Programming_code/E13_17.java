/*
  A complex number is a number in the form a + bi, where a and b are real
  numbers and i is sqrt(-1). The numbers a and b are known as the real part
  and the imaginary part of the complex number, respectively. You can perform
  addition, subtraction, multiplication, and division for complex numbers
  using the following formulas:

  a + bi + c + di = (a + c) + (b + d)i
  a + bi - (c + di) = (a - c) + (b - d)i
  (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
  (a + bi) / (c + di) = (ac + bd) / (c^2 + d^2) + (bc - ad)i / (c^2 + d^2)

  You can also obtain the absolute value for a complex number using the
  following formula:

  |a + bi| = sqrt(a^2 + b^2)

  Design a class named Complex for representing complex numbers and the methods
  add, subtract, multiply, divide, and abs for performing complex-number
  operations, and override toString method for returning a string representation
  of a complex number. The toString method returns (a + bi) as a string. If
  b is 0, it simply returns a. Your Complex class should also implement the
  Cloneable interface.

  Provide three constructors Complex(a, b), Complex(a), and Complex().
  Complex() creates a Complex object for number 0 and Complex(a) creates a
  Complex object with 0 for b. Also provide the getRealPart() and
  getImaginaryPart() methods for returning the real and imaginary part of the
  complex number, respectively.

  Write a test program that prompts the user to enter two complex numbers and
  displays the result of their addition, subtraction, multiplication,
  division, and absolute value.
*/

import java.util.Scanner;

public class E13_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first complex number: ");
    Complex c1 = new Complex(input.nextDouble(), input.nextDouble());
    System.out.print("Enter the second complex number: ");
    Complex c2 = new Complex(input.nextDouble(), input.nextDouble());

    System.out.println("(" + c1 + ") + (" + c2 + ") = " + c1.add(c2));
    System.out.println("(" + c1 + ") - (" + c2 + ") = " + c1.subtract(c2));
    System.out.println("(" + c1 + ") * (" + c2 + ") = " + c1.multiply(c2));
    System.out.println("(" + c1 + ") / (" + c2 + ") = " + c1.divide(c2));
    System.out.println("|(" + c1 + ")| = " + c1.abs());
  }
}
