/*
  A prime number is called a Mersenne prime if it can be written in the form
  2^p - 1 for some positive integer p. Write a program that finds all
  Mersenne primes with p <= 100 and displays the output.
*/

import java.math.BigInteger;

public class E10_19 {
  public static void main(String[] args) {
    BigInteger end = new BigInteger("100");
    BigInteger one = new BigInteger("1");
    BigInteger two = new BigInteger("2");
    BigInteger mersenne;

    System.out.println("p     2^p - 1");
    for (int p = 2; p <= 100; p++) {
      if (isPrime(p)) {
        mersenne = two.pow(p).subtract(one);
        if (isPrime(mersenne)) {
          System.out.printf("%-3d   %d\n", p, mersenne);
        }
      }
    }
  }

  public static boolean isPrime(int n) {
    if (n == 2) { return true; }
    if (n == 0 || n == 1 || n % 2 == 0) { return false; }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) { return false; }
    }
    return true;
  }

  public static boolean isPrime(BigInteger n) {
    BigInteger two = new BigInteger("2");
    if (n.equals(two)) { return true; }

    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    if (n.equals(zero) || n.equals(one) || n.remainder(two).equals(zero)) {
      return false;
    }

    BigInteger i = new BigInteger("3");
    BigInteger sqrt = sqrt(n);
    for (; i.compareTo(sqrt) == -1 || i.compareTo(sqrt) == 0; i = i.add(two)) {
      if (n.remainder(i).equals(zero)) { return false; }
    }

    return true;
  }

  public static BigInteger sqrt(BigInteger x) {
    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
    BigInteger div2 = div;
    // Loop until we hit the same value twice in a row, or wind
    // up alternating.
    for(;;) {
      BigInteger y = div.add(x.divide(div)).shiftRight(1);
      if (y.equals(div) || y.equals(div2))
        return y;
      div2 = div;
      div = y;
    }
  }
}
