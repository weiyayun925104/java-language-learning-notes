/*
  Write a program that prompts the user to enter an integer and determines
  whether it is divisible by 5 and 6, whether it is divisible by 5 or 6, and
  whether it is divisible by 5 or 6, but not both.
*/

import java.util.Scanner;

public class E3_26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();

    System.out.println("Is " + n + " divisible by 5 and 6? " +
      (n % 5 == 0 && n % 6 == 0));
    System.out.println("Is " + n + " divisible by 5 or 6? " +
      (n % 5 == 0 || n % 6 == 0));
    System.out.println("Is " + n + " divisible by 5 or 6, but not both? " +
      (n % 5 == 0 ^ n % 6 == 0));
  }
}
