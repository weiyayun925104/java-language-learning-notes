/*
  Rewrite Listing 3.5, ComputeTax.java, using arrays. For each filing status,
  there are six tax rates. Each rate is applied to a certain amount of taxable
  income. For example, from the taxable income of $400,000 for a single filer,
  $8,350 is taxed at 10%, (33,950 - 8,350) at 15%, and so on. The six rates
  are the same for all filing statuses, which can be represented in the
  following array:

  double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35}

  The brackets for each rate for all the filing statuses can be represented
  int a two-dimensional array as follows:

  int[][] brackets = {
    {8350, 33950, 82250, 171550, 372950}, // single filer
    {16700, 67900, 137050, 208850, 372950},  // married jointly
    {8350, 33950, 68525, 104425, 186475},  // married separately
    {11950, 45500, 117450, 190200, 372950}  // head of household
  }

  Suppose the taxable income is $400,000 for single filers. The tax can be
  computed as follows:

  tax = brackets[0][0] * rates[0] +
    (brackets[0][1] - brackets[0][0]) * rates[1] +
    (brackets[0][2] - brackets[0][1]) * rates[2] +
    (brackets[0][3] - brackets[0][2]) * rates[3] +
    (brackets[0][4] - brackets[0][3]) * rates[4] +
    (400000 - brackets[0][4]) * rates[5]
*/

import java.util.Scanner;

public class E8_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("0: Single Filer");
    System.out.println("1: Married Jointly or Qualifying Widow(er)");
    System.out.println("2: Married Separately");
    System.out.println("3: Head of Household");
    System.out.print("Enter the filing status: ");
    int status = input.nextInt();
    System.out.print("Enter the taxable income: ");
    double income = input.nextDouble();

    System.out.println("The total tax is " + computeTax(status, income));
  }

  public static double computeTax(int status, double income) {
    double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

    int[][] brackets = {
      {8350, 33950, 82250, 171550, 372950}, // 0 - single filer
      {16700, 67900, 137050, 208850, 372950},  // 1 - married jointly
      {8350, 33950, 68525, 104425, 186475},  // 2 - married separately
      {11950, 45500, 117450, 190200, 372950}  // 3 - head of household
    };

    double tax = 0.0;
    int lastIndex = -1;

    // There are three basic parts to the tax calculation process.

    // 1. The first bracket.
    if (income <= brackets[status][0]) {
      return income * rates[0];
    } else {
      tax += brackets[status][0] * rates[0];
      // 2. Middle brackets. Iterate through the brackets, calculating tax
      //    until taxable incomes does not exceed the current bracket.
      for (int i = 1; i < brackets[status].length; i++) {
        if (income > brackets[status][i]) {
          tax += (brackets[status][i] - brackets[status][i - 1]) *
            rates[i];
        } else {
          // Set the last index to the previous bracket and break from the loop.
          lastIndex = i;
          break;
        }
      }
    }
    // 3. The last bracket

    // This handles the case of a taxable income that exceeds the low bound
    // of the last tax bracket. We use the last tax bracket and the last rate
    // to calculate the final portion of taxes.
    int lastBracket = brackets[status].length - 1;
    int lastRate = rates.length - 1;
    if (income > brackets[status][lastBracket]) {
      tax += (income - brackets[status][lastBracket]) *
        rates[lastRate];
    } else {
      // And this handles all other cases. We use the last index of the loop
      // (minus 1, to get the bracket before that) along with the last index
      // of the rates (since we're calculating tax from the part that flows
      // into the next bracket) to calculate the final portion of taxes.
      tax += (income - brackets[status][lastIndex - 1]) *
        rates[lastIndex];
    }

    return tax;
  }
}
