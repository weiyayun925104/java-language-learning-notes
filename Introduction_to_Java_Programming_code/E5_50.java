/*
  Write a program that prompts the user to enter a string and displays the
  number of the uppercase letters in the string.
*/

import java.util.Scanner;

public class E5_50 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    int count = 0;
    for (int i = 0; i < entry.length(); i++) {
      char c = entry.charAt(i);
      if (c >= 'A' && c <= 'Z') { count ++; }
    }

    System.out.println("The number of uppercase letters is " + count);
  }
}
