/*
  Using the BigInteger class introduced in Section 10.9, you can find the
  factorial for a large number (e.g. 100!). Implement the factorial method
  using recursion. Write a program that prompts the user to enter an integer
  and displays its factorial.
*/

import java.math.BigInteger;
import java.util.Scanner;

public class E18_01 {
  public static BigInteger factorial(int n) {
    BigInteger bn = new BigInteger(String.valueOf(n));
    return factorial(bn, BigInteger.ONE);
  }

  private static BigInteger factorial(BigInteger n, BigInteger result) {
    if (n.equals(BigInteger.ZERO)) { return result; }
    return factorial(n.subtract(BigInteger.ONE), n.multiply(result));
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();

    System.out.println(factorial(n).toString());
  }
}
