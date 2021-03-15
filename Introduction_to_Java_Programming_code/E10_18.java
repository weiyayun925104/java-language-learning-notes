/*
  Write a program that finds five prime numbers larger than Long.MAX_VALUE.

  Note: This solution takes several minutes to execute.
*/

import java.math.BigInteger;

public class E10_18 {
  public static void main(String[] args) {
    BigInteger longMax = new BigInteger(String.valueOf(Long.MAX_VALUE));
    BigInteger n = longMax.add(BigInteger.ONE);

    int count = 0;
    while (count < 5) {
      if (isPrime(n)) {
        System.out.println(n);
        count++;
      }
      n = n.add(BigInteger.ONE);
    }
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
