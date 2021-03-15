/*
  Write a program that reads the subtotal and the gratuity rate, then computes
  the gratuity and total. For example, if the user enters 10 for subtotal and
  15% for gratuity rate, the program displays $1.5 as gratuity and $11.5 as
  total.
*/

import java.util.Scanner;

public class E2_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the subtotal and gratuity rate: ");
    double subtotal = input.nextDouble();
    double gratuityRate = input.nextDouble();

    double gratuity = calculateGratuity(subtotal, gratuityRate);
    double total = calculateTotal(subtotal, gratuity);

    System.out.printf("The gratuity is $%.2f and total is $%.2f\n", gratuity,
      total);
  }

  private static double calculateGratuity(double subtotal, double gratuityRate) {
    gratuityRate /= 100.0;
    return subtotal * gratuityRate;
  }

  private static double calculateTotal(double subtotal, double gratuity) {
    return subtotal + gratuity;
  }
}
