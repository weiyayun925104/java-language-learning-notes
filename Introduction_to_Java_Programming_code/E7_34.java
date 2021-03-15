/*
  Write a method that returns a sorted string using the following header:

  public static String sort(String s)

  For example, sort("acb") returns abc.

  Write a test program that prompts the user to enter a string and displays
  the sorted string.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E7_34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    System.out.println(sort(s));
  }

  public static String sort(String s) {
    String[] chunked = s.split("");
    Arrays.sort(chunked);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chunked.length; i++) {
      sb.append(chunked[i]);
    }

    return sb.toString();
  }
}
