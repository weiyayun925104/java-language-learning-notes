/*
  Write a program that prompts the user to enter a string and displays the
  string in reverse order.
*/

import java.util.Scanner;

public class E5_46 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    StringBuilder reversed = new StringBuilder();
    for (int i = 0; i < entry.length(); i++) {
      reversed.insert(0, entry.charAt(i));
    }

    System.out.println("The reversed string is " + reversed);
  }
}
