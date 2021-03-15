/*
  Listing 3.5 gives a program to compute tax. Write a method for computing
  tax using the following header:

  public static double computeTax(int status, double taxableIncome)

  Use this method to write a program that prints a tax table for taxable
  income from $50,000 to $60,000 with intervals of $50 for all statuses.
*/

public class E6_15 {
  public static void main(String[] args) {
    System.out.println("Income   Status 0   Status 1   Status 2   Status 3");
    for (int i = 50_000; i <= 60_000; i += 50) {
      // print taxable income
      System.out.printf("%-6d   ", i);
      // print taxes for each status
      for (int j = 0; j <= 3; j++) {
        long tax = Math.round(computeTax(j, i));
        System.out.printf("%-8d   ", tax);
      }
      System.out.println();
    }
  }

  public static double computeTax(int status, double taxableIncome) {
    // status
    // 0: Single
    // 1: Married Joint or Qualifying Widow(er)
    // 2: Married Separate
    // 3: Head of a House
    double tax = 0;
    if (status == 0) {
      if (taxableIncome <= 8350)
        tax = taxableIncome * 0.10;
      else if (taxableIncome <= 33950)
        tax = 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
      else if (taxableIncome <= 82250)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) *
          0.25;
      else if (taxableIncome <= 171550)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
          (taxableIncome - 82250) * 0.28;
      else if (taxableIncome <= 372950)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
          (171550 - 82250) * 0.28 + (taxableIncome - 171550) * 0.33;
      else
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
          (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 +
          (taxableIncome - 372950) * 0.35;
    } else if (status == 1) {
      if (taxableIncome <= 16700)
        tax = taxableIncome * 0.10;
      else if (taxableIncome <= 67900)
        tax = 16700 * 0.10 + (taxableIncome - 16700) * 0.15;
      else if (taxableIncome <= 137050)
        tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (taxableIncome - 67900) *
          0.25;
      else if (taxableIncome <= 208850)
        tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 +
          (taxableIncome - 137050) * 0.28;
      else if (taxableIncome <= 372950)
        tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 +
          (208850 - 137050) * 0.28 + (taxableIncome - 208850) * 0.33;
      else
        tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 +
          (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 +
          (taxableIncome - 372950) * 0.35;
    } else if (status == 2) {
      if (taxableIncome <= 8350)
        tax = taxableIncome * 0.10;
      else if (taxableIncome <= 33950)
        tax = 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
      else if (taxableIncome <= 68525)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) *
          0.25;
      else if (taxableIncome <= 104425)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 +
          (taxableIncome - 68525) * 0.28;
      else if (taxableIncome <= 186475)
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 +
          (104425 - 68525) * 0.28 + (taxableIncome - 104425) * 0.33;
      else
        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 +
          (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 +
          (taxableIncome - 186475) * 0.35;
    } else if (status == 3) {
      if (taxableIncome <= 11950)
        tax = taxableIncome * 0.10;
      else if (taxableIncome <= 45500)
        tax = 11950 * 0.10 + (taxableIncome - 11950) * 0.15;
      else if (taxableIncome <= 117450)
        tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (taxableIncome - 45500) *
          0.25;
      else if (taxableIncome <= 190200)
        tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 +
          (taxableIncome - 117450) * 0.28;
      else if (taxableIncome <= 372950)
        tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 +
          (190200 - 117450) * 0.28 + (taxableIncome - 190200) * 0.33;
      else
        tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 +
          (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 +
          (taxableIncome - 372950) * 0.35;
    }
    return tax;
  }
}
