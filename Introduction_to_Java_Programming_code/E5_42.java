
import java.util.Scanner;

public class E5_42
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter commission sought: ");
        double commissionSought = input.nextDouble();

        double salesAmount = 0.0;
        double commission = 0.0;
        for (; commission < commissionSought; )
        {
            salesAmount += 0.01;
            if (salesAmount <= 5_000)
            {
                commission = salesAmount * 0.08;
            }
            else if (salesAmount <= 10_000)
            {
                commission = 400 + (salesAmount - 5_000) * 0.1;
            }
            else
            {
                commission = 900 + (salesAmount - 10_000) * 0.12;
            }
        }

        System.out.printf("Sales needed: $%.2f\n", salesAmount);
    }
}
