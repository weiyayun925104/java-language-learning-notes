/*
  Write a program that computes the following summation series using the
  Rational class:

  1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100

  You will discover that the output is incorrect because of integer overflow
  (too large). To fix this problem, see Programming Exercise 13.15.

  Note: This program has a long running time.
*/

import java.math.BigInteger;

public class E13_18 {
  public static void main(String[] args) {
    Rational sum = new Rational();
    for (int i = 1; i <= 99; i++) {
      Rational r = new Rational(new BigInteger(String.valueOf(i)),
        new BigInteger(String.valueOf(i + 1)));
      sum = sum.add(r);
    }

    System.out.println(sum);
  }
}
