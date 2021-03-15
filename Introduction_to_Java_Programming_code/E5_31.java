/*
  Suppose you put $10000 into a CD with an annual percentage yield of 5.75%.
  After one month, the CD is worth

      10000 + 10000 * 5.75 / 1200 = 10047.92

  After two months, the CD is worth

      10047.91 + 10047.91 * 5.75 / 1200 = 10096.06

  After three months, the CD is worth

      10096.06 + 10096.06 * 5.75 / 1200 = 10144.44

  and so on.

  Write a program that prompts the user to enter an amount (eg 10000), the
  annual percentage yield (eg 5.75), and the number of months (eg 18) and
  displays the table as shown in the sample run.
*/

import java.util.Scanner;

public class E5_31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the initial deposit amount: ");
    double depositAmount = input.nextDouble();
    System.out.print("Enter annual percentage yield: ");
    double annualYield = input.nextDouble();
    System.out.print("Enter maturity period (number of months): ");
    int months = input.nextInt();

    double monthlyYield = annualYield / 1200.0;

    System.out.println("Month  CD Value");
    for (int i = 1; i <= months; i++) {
      depositAmount *= (1 + monthlyYield);
      System.out.printf("%-5d  %-8.2f\n", i, depositAmount);
    }
  }
}
