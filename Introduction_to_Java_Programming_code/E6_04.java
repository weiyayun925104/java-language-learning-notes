/*
  Write a method with the following header to display an integer in reverse
  order:

  public static void reverse(int number)

  For example, reverse(3456) displays 6543. Write a test program that prompts
  the user to enter an integer and displays its reversal.
*/

import java.util.Scanner;

public class E6_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int entry = input.nextInt();

    reverse(entry);
  }

  public static void reverse(int number) {
    StringBuilder s = new StringBuilder(number + "");
    System.out.println(s.reverse());
  }
}
