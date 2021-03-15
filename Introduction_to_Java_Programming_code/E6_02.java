/*
  Write a method that computes the sum of the digits in an integer. Use the
  following header:

  public static int sumDigits(long n)

  For example, sumDigits(234) returns 9 (2 + 3 + 4). Write a test program that
  prompts the user to enter an integer and displays the sum of all its digits.
*/

import java.util.Scanner;

public class E6_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    long entry = input.nextLong();

    System.out.println("sum of digits: " + sumDigits(entry));
  }

  public static int sumDigits(long n) {
    int sum = 0;
    while (n != 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
