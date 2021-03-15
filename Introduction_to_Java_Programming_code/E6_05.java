/*
  Write a method with the following header to display three numbers in
  increasing order:

  public static void displaySortedNumbers(double num1, double num2, double num3)

  Write a test program that prompts the user to enter three numbers and invokes
  the method to display them in increasing order.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E6_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three numbers: ");
    double num1 = input.nextDouble();
    double num2 = input.nextDouble();
    double num3 = input.nextDouble();

    displaySortedNumbers(num1, num2, num3);
  }

  public static void displaySortedNumbers(double num1, double num2,
    double num3) {
    double[] numArr = { num1, num2, num3 };
    Arrays.sort(numArr);
    for (double num: numArr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
