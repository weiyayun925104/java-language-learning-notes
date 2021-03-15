/*
  Write a program that prompts the user to enter two strings and displays the
  largest common prefix of the two strings.
*/

import java.util.Scanner;

public class E5_51 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String s1 = input.nextLine();
    System.out.print("Enter the second string: ");
    String s2 = input.nextLine();

    // find length of smaller string
    int smaller = Math.min(s1.length(), s2.length());

    StringBuilder s = new StringBuilder();
    // user length of smaller string as max loop iteration
    for (int i = 0; i < smaller; i++) {
      char c = s1.charAt(i);
      if (c == s2.charAt(i)) {
        s.append(c);
      } else {
        break;
      }
    }

    if (s.length() == 0) {
      System.out.println(s1 + " and " + s2 + " have no common prefix");
    } else {
      System.out.println("The common prefix is " + s);
    }
  }
}
