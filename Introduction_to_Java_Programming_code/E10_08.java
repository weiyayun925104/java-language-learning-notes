/*
  Programming Exercise 8.12 writes a program for computing taxes using arrays.
  Design a class named Tax to contain the following instance data fields:

  - int filingStatus: One of the four tax-filing statuses: 0-singer filer,
    1-married filing jointly or qualifying widow(er), 2-married filing
    separately, and 3-head of household. Use the public static constants
    SINGLE_FILER (0), MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER) (1),
    MARRIED_SEPARATELY (2), HEAD_OF_HOUSEHOLD (3) to represent the statuses.
  - int[][] brackets: Stores the tax brackets for each filing status.
  - double[] rates: Stores the tax rates for each bracket.
  - double taxableIncome: Stores the taxable income.

  Provide the getter and setter methods for each data field and the getTax()
  method that returns the tax. Also provide a no-arg constructor and the
  constructor Tax(filingStatus, brackets, rates, taxableIncome).

  Write a test program that uses the Tax class to print the 2001 and 2009 tax
  tables for taxable income $50,000 to $60,000 with intervals of $1,000 for all
  four statuses.
*/

public class E10_08 {
  public static void main(String[] args) {
    int[][] brackA = {
      {8350, 33950, 82250, 171550, 372950},
      {16700, 67900, 137050, 208850, 372950},
      {8350, 33950, 68525, 104425, 186475},
      {11950, 45500, 117450, 190200, 372950}
    };

    int[][] brackB = {
      {27050, 65550, 136750, 297350},
      {45200, 109250, 166500, 297350},
      {22600, 54625, 83250, 148675},
      {36250, 93650, 151650, 297350}
    };

    double[] rateA = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
    double[] rateB = {0.15, 0.275, 0.305, 0.355, 0.391};

    Tax t1 = new Tax(0, brackA, rateA, 50000);
    Tax t2 = new Tax(0, brackB, rateB, 50000);

    displayTable(t2, 2001);
    System.out.println();
    displayTable(t1, 2009);
  }

  public static void displayTable(Tax t, int year) {
    System.out.println("                       " + year + " Taxes" +
      "                       ");
    System.out.println("Income    Status 0     Status 1     Status 2     " +
      "Status 3");

    for (int i = 50000; i <= 60000; i += 1000) {
      System.out.printf("%-10d", i);
      for (int j = 0; j <= 3; j++) {
        t.setFilingStatus(j);
        t.setTaxableIncome(i);
        System.out.printf("%-8.2f     ", t.getTax());
      }
      System.out.println();
    }
  }
}
