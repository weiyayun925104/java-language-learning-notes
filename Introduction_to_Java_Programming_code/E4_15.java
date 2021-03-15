/*
  Write a program that prompts the user to enter a letter and displays its
  corresponding number on the international standard letter/number telephone
  mapping.
*/

import java.util.Scanner;

public class E4_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a letter: ");
    String entry = input.nextLine();

    if(!isLetter(entry)) {
      System.out.println(entry + " is an invalid input");
      System.exit(1);
    }

    int number = getNumber(entry);

    if (number == -1) {
      // Shouldn't happen with previous validation in place.
      System.out.println("Error. Input not a letter.");
      System.exit(2);
    }

    System.out.println("The corresponding number is " + number);
  }

  private static int getNumber(String s) {
    int n = -1;
    char c = s.toLowerCase().charAt(0);
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
}
