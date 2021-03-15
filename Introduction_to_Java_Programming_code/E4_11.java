/*
  Write a program that prompts the user to enter an integer between 0 and 15
  and displays its corresponding hex number.
*/

import java.util.Scanner;

public class E4_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int value;
    do {
      System.out.print("Enter a decimal value (0 to 15): ");
      value = input.nextInt();
    } while (value < 0 || value > 15);

    System.out.println("The hex value is " + getHexValue(value));
  }

  private static String getHexValue(int n) {
    StringBuilder s = new StringBuilder();
    if (n >= 0 && n <= 9) {
      s.append(n);
    } else {
      switch (n) {
        case 10: s.append("A"); break;
        case 11: s.append("B"); break;
        case 12: s.append("C"); break;
        case 13: s.append("D"); break;
        case 14: s.append("E"); break;
        case 15: s.append("F");
      }
    }
    return s.toString();
  }
}
