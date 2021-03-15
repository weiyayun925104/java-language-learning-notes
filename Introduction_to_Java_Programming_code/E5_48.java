/*
  Write a program that prompts the user to enter a string and displays the
  characters at odd positions.
*/

import java.util.Scanner;

public class E5_48 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    for (int i = 0; i < entry.length(); i++) {
      if (i % 2 == 0) {
        System.out.print(entry.charAt(i));
      }
    }
    System.out.println();
  }
}
