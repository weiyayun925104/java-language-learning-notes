/*
  Nine coins are placed in a 3-by-3 matrix with some face up and some face
  down. You can represent the state of the coins using a 3-by-3 matrix with
  values 0 (heads) and 1 (tails). Here are some examples:

  0 0 0    1 0 1    1 1 0    1 0 1    1 0 0
  0 1 0    0 0 1    1 0 0    1 1 0    1 1 1
  0 0 0    1 0 0    0 0 1    1 0 0    1 1 0

  Each state can also be represented using a binary number. For example, the
  preceding matrices correspond to the numbers

  000010000 101001100 110100001 101110100 100111110

  There are a total of 512 possibilities, so you can use the decimal numbers
  0, 1, 2, 3, ..., and 511 to represent all states of the matrix. Write a
  program that prompts the user to enter a number between 0 and 511 and displays
  the corresponding matrix with the character H and T.
*/

import java.util.Scanner;

public class E8_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number between 0 and 511: ");
    int n = input.nextInt();

    displayCoins(n);
  }

  public static void displayCoins(int n) {
    String bin = decToBin(n);

    for (int i = 0; i < bin.length(); i++) {
      if (i % 3 == 0) { System.out.println(); }
      if (bin.charAt(i) == '0') {
        System.out.print("H ");
      } else {
        System.out.print("T ");
      }
    }
    System.out.println();
  }

  public static String decToBin(int dec) {
    StringBuilder bin = new StringBuilder();
    if (dec == 0) {
      bin.append("0");
    } else {
      while (dec != 0) {
        bin.insert(0, dec % 2);
        dec /= 2;
      }
    }
    return padToNinePlaces(bin.toString());
  }

  public static String padToNinePlaces(String bin) {
    if (bin.length() < 9) {
      for (int i = bin.length(); i < 9; i++) {
        bin = "0" + bin;
      }
    }
    return bin;
  }
}
