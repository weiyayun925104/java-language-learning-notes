/*
  Write a program that receives a character and displays its Unicode.

  Note: The question appears to ask for Unicode (eg, E = \u0045), but the
  sample run indicates it's looking for ASCII (eg, E = 69).
*/

import java.util.Scanner;

public class E4_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a character: ");
    String charString = input.nextLine();

    int ascii = charString.charAt(0);

    System.out.println("The ASCII for the character " + charString + " is " +
      ascii);
  }
}
