/*
  Find the first ten numbers with 50 decimal digits that are divisible by
  2 or 3.
*/

import java.math.BigInteger;

public class E10_16 {
  public static void main(String[] args) {
    BigInteger b = new BigInteger("1000000000000000000000000000000000000000" +
      "0000000000");

    int count = 0;
    while (count < 10) {
      if (b.remainder(new BigInteger("2")).equals(BigInteger.ZERO) ||
          b.remainder(new BigInteger("3")).equals(BigInteger.ZERO)) {
        count++;
        System.out.println(b);
      }
      b = b.add(BigInteger.ONE);
    }
  }
}
