/*
  Write a recursive method to return the number of uppercase letters in an
  array of characters. You need to define the following two methods. The
  second one is a recursive helper method.

  public static int count(char[] chars)
  public static int count(char[] chars, int high)

  Write a test program that prompts the user to enter a list of characters in
  one line and displays the number of uppercase letters in the list.
*/

import java.util.Scanner;

public class E18_16 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a list of characters: ");
    String s = input.nextLine();
    char[] chars = s.replaceAll(" ", "").toCharArray();

    System.out.println(count(chars));
  }

  public static int count(char[] chars) {
    return count(chars, 0);
  }

  public static int count(char[] chars, int high) {
    if (high == chars.length) { return 0; }
    char c = chars[high];
    int match = Character.isLetter(c) && Character.isUpperCase(c) ? 1 : 0;
    return match + count(chars, high + 1);
  }
}
