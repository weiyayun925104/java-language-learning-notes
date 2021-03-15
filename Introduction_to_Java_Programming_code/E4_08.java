/*
  Write a program that receives an ASCII code (an integer between 0 and 127)
  and displays its character.
*/

import java.util.Scanner;

public class E4_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int ascii;
    do {
      System.out.print("Enter an ASCII code (0-127): ");
      ascii = input.nextInt();
    } while (ascii < 0 || ascii > 127);

    char character = (char)ascii;
    System.out.println("The character for ASCII code " + ascii + " is " +
      character);
  }
}
