/*
  Write a recursive method that finds the number of occurrences of a specified
  character in an array. You need to define the following two methods. The
  second one is a recursive helper method.

  public static int count(char[] chars, char ch)
  public static int count(char[] chars, char ch, int high)

  Write a test program that prompts the user to enter a list of characters in
  one line, and a character, and displays the number of occurrences of the
  character in the list.
*/

import java.util.Scanner;

public class E18_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a line of characters: ");
    String s = input.nextLine();
    char[] chars = s.replaceAll(" ", "").toCharArray();
    System.out.print("Enter a character: ");
    char ch = input.nextLine().charAt(0);

    System.out.println(count(chars, ch));
  }

  public static int count(char[] chars, char ch) {
    return count(chars, ch, 0);
  }

  public static int count(char[] chars, char ch, int high) {
    if (high == chars.length) { return 0; }
    int match =
      Character.toLowerCase(chars[high]) == Character.toLowerCase(ch) ? 1 : 0;
    return match + count(chars, ch, high + 1);
  }
}
