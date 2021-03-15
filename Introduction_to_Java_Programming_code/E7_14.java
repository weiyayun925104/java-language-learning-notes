/*
  Write a method that returns the gcd of an unspecified number of integers.
  The method header is specified as follows:

  public static int gcd(int... numbers)

  Write a test program that prompts the user to enter five numbers, invokes the
  method to find the gcd of these numbers, and displays the gcd.
*/

import java.util.Scanner;

public class E7_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter five numbers: ");
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int d = input.nextInt();
    int e = input.nextInt();

    System.out.println(gcd(a, b, c, d, e));
  }

  public static int gcd(int... numbers) {
    if (numbers.length < 2) {
      return -1;
    }
    int gcd = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      gcd = gcdTwo(gcd, numbers[i]);
    }
    return gcd;
  }

  public static int gcdTwo(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
