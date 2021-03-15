/*
  Write a program that prompts the user to enter an integer from 1 to 15 and
  displays a pyramid.
*/

import java.util.Scanner;

public class E5_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of lines (1-15): ");
    int n = input.nextInt();
    String padding = "   ";

    for (int i = 1; i <= n; i++) {
      // print padding
      for (int j = i; j < n; j++) {
        System.out.print(padding);
      }
      // print left numbers
      for (int k = i; k > 0; k--) {
        System.out.printf("%3d", k);
      }
      // print the right numbers
      for (int m = 2; m <= i; m++) {
        System.out.printf("%3d", m);
      }
      System.out.println();
    }
  }
}
