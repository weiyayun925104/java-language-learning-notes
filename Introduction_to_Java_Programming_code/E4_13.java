/*
  Write a program that prompts the user to enter a letter and check whether
  the letter is a vowel or a consonant.
*/

import java.util.Scanner;

public class E4_13 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a letter: ");
    String entry = input.nextLine();

    if (!isLetter(entry)) {
      System.out.println(entry + " is an invalid input");
      System.exit(1);
    }

    StringBuilder result = new StringBuilder(entry + " is a ");
    result.append(isVowel(entry) ? "vowel" : "consonant");

    System.out.println(result);
  }

  private static boolean isLetter(String s) {
    boolean letter = true;
    String sLC = s.toLowerCase();
    if (sLC.length() != 1) {
      letter = false;
    } else if (!Character.isLetter(sLC.charAt(0))) {
      letter = false;
    }
    return letter;
  }

  private static boolean isVowel(String s) {
    char c = s.toLowerCase().charAt(0);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
