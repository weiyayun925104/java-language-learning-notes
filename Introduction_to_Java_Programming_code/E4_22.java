/*
  Write a program that prompts the user to enter two strings and reports
  whether the second string is a substring of the first string.
*/

import java.util.Scanner;

public class E4_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter string s1: ");
    String s1 = input.nextLine();
    System.out.print("Enter string s2: ");
    String s2 = input.nextLine();

    boolean substring = s1.contains(s2);
    StringBuilder result = new StringBuilder();
    result.append(s2 + " is " + (substring ? "" : "not ") + "a substring " +
      "of " + s1);

    System.out.println(result);
  }
}
