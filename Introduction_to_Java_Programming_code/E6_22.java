/*
  There are several techniques for implementing the sqrt method in the Math
  class. One such technique is known as the Babylonian method. It approximates
  the square root of a number, n, by repeatedly performing a calculation using
  the following formula:

  nextGuess = (lastGuess + n / lastGuess) / 2

  When nextGuess and lastGuess are almost identical, nextGuess is the
  approximated square root. The initial guess can be any positive value (eg 1).
  This value will be the starting value for lastGuess. If the difference
  between nextGuess and lastGuess is less than a very small number, such as
  0.0001 you can claim that nextGuess is the approximated square root of n. If
  not, nextGuess becomes lastGuess and the approximation process continues.
  Implement the following method that returns the square root of n.

  public static double sqrt(long n)
*/

import java.util.Scanner;

public class E6_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    long entry = input.nextLong();

    System.out.println(sqrt(entry) + " is the approximate square root");
  }

  public static double sqrt(long n) {
    final double EPSILON = 0.0001;
    double lastGuess = 1.0;
    double nextGuess;
    while (true) {
      nextGuess = (lastGuess + n / lastGuess) / 2;
      if (Math.abs(nextGuess - lastGuess) < EPSILON) {
        return nextGuess;
      } else {
        lastGuess = nextGuess;
      }
    }
  }
}
