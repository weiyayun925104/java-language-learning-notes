/*
  A shipping company uses the following function to calculate the cost (in
  dollars) of shipping based on weight of the package (in pounds).

                        (function)

  Write a program that prompts the user to enter the weight of the package and
  display the shipping cost. If the weight is greater than 50, display a
  message "the package cannot be shipped."
*/

import java.util.Scanner;

public class E3_18 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double weight;
    do {
      System.out.print("Enter the package weight (lbs): ");
      weight = input.nextDouble();
    } while (weight < 0);

    if (weight > 50) {
      System.out.println("The package cannot be shipped.");
      System.exit(1);
    }

    double cost = getShippingCost(weight);

    System.out.printf("The shipping cost is $%.2f\n", cost);
  }

  private static double getShippingCost(double weight) {
    double cost = 0.0;
    if (weight <= 1)
      cost = 3.5;
    else if (weight <= 3)
      cost = 5.5;
    else if (weight <= 10)
      cost = 8.5;
    else
      cost = 10.5;

    return cost;
  }
}
