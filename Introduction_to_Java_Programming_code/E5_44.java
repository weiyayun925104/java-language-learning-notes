/*
  A short value is stored in 16 bits. Write a program that prompts the user
  to enter a short integer and displays the 16 bits for the integer.
*/

import java.util.Scanner;

public class E5_44 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a short integer: ");
    short entry = input.nextShort();

    StringBuilder bits = new StringBuilder();
    for (int i = 1; i <= 16; i++) {
      bits.insert(0, entry & 1);
      entry >>= 1;
    }

    System.out.println(bits);
  }
}
