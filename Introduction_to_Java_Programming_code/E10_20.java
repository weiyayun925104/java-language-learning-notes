/*
  Programming Exercise 5.26 approximates e using the following series:

  e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ... + 1/i!

  In order to get better precision, use BigDecimal with 25 digits of precision
  in the computation. Write a program that displays the e value for
  i = 100, 200, ..., and 1000.
*/

import java.math.BigDecimal;
import java.math.RoundingMode;

public class E10_20 {
  public static void main(String[] args) {
    for (int i = 100; i <= 1000; i += 100) {
      BigDecimal e = new BigDecimal("1");
      BigDecimal item = new BigDecimal("1");
      for (int n = 2; n <= i; n++) {
        e = e.add(item);
        item = item.divide(new BigDecimal(String.valueOf(n)), 25,
          RoundingMode.HALF_UP);
      }
      System.out.println("i = " + i + ": " + e);
    }
  }
}
