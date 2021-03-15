/*
  The international standard letter/number mapping for telephones is shown in
  Programming Exercise 4.15. Write a method that returns a number, given an
  uppercase letter, as follows:

  int getNumber(char uppercaseLetter)

  Write a test program that prompts the user to enter a phone number as a
  string. The input number may contain letters. The program translates a
  letter (uppercase or lowercase) to a digit and leaves all other characters
  intact.
*/

import java.util.Scanner;

public class E6_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    System.out.println(convertLettersToNumbers(entry));
  }

  public static String convertLettersToNumbers(String s) {
    s = s.toLowerCase();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) { result.append(getNumber(c)); }
      else { result.append(c); }
    }
    return result.toString();
  }

  public static int getNumber(char c) {
    int n = -1;
    if (c == 'a' || c == 'b' || c == 'c') {
      n = 2;
    } else if (c == 'd' || c == 'e' || c == 'f') {
      n = 3;
    } else if (c == 'g' || c == 'h' || c == 'i') {
      n = 4;
    } else if (c == 'j' || c == 'k' || c == 'l') {
      n = 5;
    } else if (c == 'm' || c == 'n' || c == 'o') {
      n = 6;
    } else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
      n = 7;
    } else if (c == 't' || c == 'u' || c == 'v') {
      n = 8;
    } else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
      n = 9;
    }
    return n;
  }
}
