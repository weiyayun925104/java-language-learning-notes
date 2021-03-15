/*
  Write a program that prompts the user to enter a decimal integer and displays
  its corresponding binary value. Don't use Java's Integer.toBinaryString(int)
  in this program.
*/

import java.util.Scanner;

public class E5_37 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a decimal integer: ");
    int dec = input.nextInt();

    System.out.println(decToBin(dec));
  }

  private static String decToBin(int dec) {
    StringBuilder bin = new StringBuilder();
    do {
      bin.insert(0, dec % 2);
      dec /= 2;
    } while (dec != 0);
    return bin.toString();
  }
}
