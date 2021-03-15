
public class E5_39 {
  public static void main(String[] args) {
    // need to earn 25,000 in commission, since base salary is $5000.
    final int COMMISSION_SOUGHT = 25_000;
    double commission = 0.0;
    double salesAmount = 0.0;
    do
    {
      salesAmount += 0.01;
      if (salesAmount <= 5_000) {
        commission = salesAmount * 0.8;
      } else if (salesAmount <= 10_000) {
        commission = 400 + (salesAmount - 5000) * 0.1;
      } else {
        commission = 900 + (salesAmount - 10000) * 0.12;
      }
    } while (commission < COMMISSION_SOUGHT);
    System.out.printf("Sales Needed: $%.2f\n", salesAmount);
  }
}
