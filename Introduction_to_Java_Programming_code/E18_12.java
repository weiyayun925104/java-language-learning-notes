/*
  Rewrite Programming Exercise 18.9 using a helper method to pass the substring
  high index to the method. The helper method is:

  public static void reverseDisplay(String value, int high)

  [This is basically a copy of E18_09, which I originally created with a helper
   method]
*/

import java.util.Scanner;

public class E18_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    reverseDisplay(s);
    System.out.println();
  }

  public static void reverseDisplay(String value) {
    reverseDisplay(value, value.length() - 1);
  }

  public static void reverseDisplay(String value, int high) {
    if (high >= 0) {
      System.out.print(value.charAt(high));
      reverseDisplay(value, high - 1);
    }
  }
}
