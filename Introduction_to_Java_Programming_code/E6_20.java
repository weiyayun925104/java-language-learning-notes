/*
  Write a method that counts the number of letters in a string using the
  following header:

  public static int countLetters(String s)

  Write a test program that prompts the user to enter a string and displays the
  number of letters in the string.
*/

import java.util.Scanner;

public class E6_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    System.out.println("There are " + countLetter(entry) + " letters in the " +
      "string");
  }

  public static int countLetter(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) { count++; }
    }
    return count;
  }
}
