/*
  Write a program that prompts the user to enter a string and displays its
  length and its first character.
*/

import java.util.Scanner;

public class E4_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String entry = input.nextLine();

    int length = entry.length();
    String firstChar = length > 0 ? entry.substring(0, 1) : "<empty string>";

    System.out.println("length: " + length);
    System.out.println("first character: " + firstChar);
  }
}
