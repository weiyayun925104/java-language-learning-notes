/*
  Write the methods with the following headers

  public static int reverse(int number)
  public static boolean isPalindrome(int number)

  Use the reverse method to implement isPalindrome. A number is a palindrome
  if its reversal is the same as itself. Write a test program that prompts the
  user to enter an integer and reports whether the integer is a palindrome.
*/

import java.util.Scanner;

public class E6_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int entry = input.nextInt();

    StringBuilder result = new StringBuilder(entry + " is ");
    result.append(isPalindrome(entry) ? "a palindrome" : "not a palindrome");

    System.out.println(result);
  }

  public static boolean isPalindrome(int number) {
    return number == reverse(number);
  }

  public static int reverse(int number) {
    StringBuilder s = new StringBuilder(number + "");
    s = s.reverse();
    return Integer.parseInt(s.toString());
  }
}
