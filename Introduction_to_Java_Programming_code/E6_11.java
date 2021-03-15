/*
  Write a method that computes the commission, using the scheme in
  Programming Exercise 5.39. The header of the method is as follows:

  public static double computeCommission(double salesAmount)

  Write a test program that displays the following table:

                        (table)
*/

public class E6_11 {
  public static void main(String[] args) {
    // need to earn 25,000 in commission, since base salary is $5000.
    final int COMMISSION_SOUGHT = 25_000;
    double commission = 0.0;
    double salesAmount = 0.01;
    while (commission < COMMISSION_SOUGHT) {
      commission = computeCommission(salesAmount);
      salesAmount += 0.01;
    }
    System.out.printf("Sales Needed: $%.2f\n", salesAmount);
  }

  public static double computeCommission(double salesAmount) {
    double commission;
    if (salesAmount <= 5_000) {
      commission = salesAmount * 0.8;
    } else if (salesAmount <= 10_000) {
      commission = 400 + (salesAmount - 5_000) * 0.1;
    } else {
      commission = 900 + (salesAmount - 10_000) * 0.12;
    }
    return commission;
  }
}
