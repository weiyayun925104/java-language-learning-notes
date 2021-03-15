/*
  Find the first ten numbers greater than Long.MAX_VALUE that are divisible by
  5 or 6.
*/

import java.math.BigInteger;

public class E10_21 {
  public static void main(String[] args) {
    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    BigInteger five = new BigInteger("5");
    BigInteger six = new BigInteger("6");

    BigInteger longMax = new BigInteger(String.valueOf(Long.MAX_VALUE));
    BigInteger n = longMax.add(one);

    int count = 0;
    while (count < 10) {
      if (n.remainder(five).equals(zero) || n.remainder(six).equals(zero)) {
        System.out.println(n);
        count++;
      }
      n = n.add(one);
    }
  }
}
