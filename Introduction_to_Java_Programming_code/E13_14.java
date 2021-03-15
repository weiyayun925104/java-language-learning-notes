/*
  Rewrite the Rational class in Listing 13.13 using a new internal
  representation for the numerator and denominator. Create an array of two
  integers as follows:

  private long[] r = new long[2];

  Use r[0] to represent the numerator and r[1] to represent the denominator.
  The signatures of the methods in the Rational class are not changed, so a
  client application that uses the previous Rational class can continue to use
  this new Rational class without being recompiled.
*/

public class E13_14 {
  public static void main(String[] args) {
    Rational r1 = new Rational(2, 3);
    Rational r2 = new Rational(3, 4);

    System.out.println("r1.add(r2): " + r1.add(r2));
    System.out.println("r1.subtract(r2): " + r1.subtract(r2));
    System.out.println("r1.multiply(r2): " + r1.multiply(r2));
    System.out.println("r1.divide(r2): " + r1.divide(r2));
  }
}
