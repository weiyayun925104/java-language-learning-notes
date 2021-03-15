/*
  Write a program that prompts the user to enter a three-digit integer and
  determines whether it is a palindrome number. A number is a palindrome if
  it reads the same from right to left and from left to right.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E3_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a three-digit integer: ");
    String num = input.nextLine();

    StringBuilder output = new StringBuilder(num + " ");
    if (isPalindrome(num)) {
      output.append("is a palindrome");
    } else {
      output.append("is not a palindrome");
    }
    System.out.println(output);
  }

  private static boolean isPalindrome(String s) {
    return s.equals(new StringBuilder(s).reverse().toString());
  }
}
