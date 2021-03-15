/*
  Write a method that finds the number of occurrences of a specified character
  in a string using the following header:

  public static int count(String str, char a)

  For example, count("Welcome", 'e') returns 2. Write a test program that
  prompts the user to enter a string followed by a character and displays the
  number of occurrences of the character in the string.
*/

import java.util.Scanner;

public class E6_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    System.out.print("Enter a character: ");
    char c = input.nextLine().charAt(0);

    int occurrences = count(s, c);
    System.out.println(c + " occurs " + occurrences + " times in " + s);
  }

  public static int count(String str, char a) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (a == c) { count++; }
    }
    return count;
  }
}
