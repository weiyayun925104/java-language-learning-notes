/*
  Write a recursive method that computes the sum of the digits in an integer.
  Use the following header:

  public static int sumDigits(long n)

  For example, sumDigits(234) returns 2 + 3 + 4 = 9. Write a test program that
  prompts the user to enter an integer and displays its sum.
*/

import java.util.Scanner;

public class E18_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    long n = input.nextLong();

    System.out.println(sumDigits(n));
  }

  public static int sumDigits(long n) {
    if (n == 0) { return 0; }
    return (int)(n % 10 + sumDigits(n / 10));
  }
}
