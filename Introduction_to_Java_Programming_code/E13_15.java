/*
  Redesign and implement the Rational class in Listing 13.13 using BigInteger
  for the numerator and denominator.
*/

import java.math.BigInteger;

public class E13_15 {
  public static void main(String[] args) {
    Rational r1 = new Rational(new BigInteger("2"), new BigInteger("3"));
    Rational r2 = new Rational(new BigInteger("3"), new BigInteger("4"));

    System.out.println("r1.add(r2): " + r1.add(r2));
    System.out.println("r1.subtract(r2): " + r1.subtract(r2));
    System.out.println("r1.multiply(r2): " + r1.multiply(r2));
    System.out.println("r1.divide(r2): " + r1.divide(r2));
  }
}
