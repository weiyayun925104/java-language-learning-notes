/*
  Write a program that reads an integer between 0 and 1000 and adds all the
  digits in the integer. For example, if an integer is 932, the sum of all
  its digits is 14.
*/

import java.util.Scanner;

public class E2_06 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number between 0 and 1000: ");
    int n = input.nextInt();

    System.out.println("The sum of the digits is " + sumDigits(n));
  }

  private static int sumDigits(int n) {
    int sum = 0;
    while (n != 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
