/*
  Write a recursive method to return the number of uppercase letters in a
  string. Write a test program that prompts the user to enter a string and
  displays the number of uppercase letters in the string.
*/

import java.util.Scanner;

public class E18_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    System.out.println(countUpperCaseLetters(s));
  }

  public static int countUpperCaseLetters(String str) {
    return countUpperCaseLetters(str, 0);
  }

  private static int countUpperCaseLetters(String str, int index) {
    if (index == str.length()) { return 0; }
    char c = str.charAt(index);
    int match = Character.isLetter(c) && Character.isUpperCase(c) ? 1 : 0;
    return match + countUpperCaseLetters(str, index + 1);
  }
}
