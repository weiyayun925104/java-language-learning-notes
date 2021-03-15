/*
  Banks lend money to each other. In tough economic times, if a bank goes
  bankrupt, it may not be able to pay back the loan. A bank's total assets are
  its current balance plus its loans to other banks. If a bank's total assets
  are under a certain limit, the bank is unsafe. The money it borrowed cannot
  be returned to the lender, and the lender cannot count the loan in its total
  assets. Consequently, the lender may also be unsafe, if its total assets are
  under the limit.

  Write a program to find all the unsafe banks. Your program reads the input as
  follows. It first reads two integers n and limit, where n indicates the number
  of banks and limit is the minimum total assets for keeping a bank safe. It
  then reads n lines that describe the information for n banks with IDs from
  0 to n-1.

  The first number in the line is the bank's balance, the second number
  indicates the number of banks that borrowed money from the bank, and the rest
  are pairs of two numbers. Each pair describes a borrower. The first number in
  the pair is the borrower's ID and the second is the amount borrowed. For
  example, the input for five banks might be:

  5 201
  25 2 1 100.5 4 320.5
  125 2 2 40 3 85
  175 2 0 125 3 75
  75 1 0 125
  181 1 2 125

  The total assets of bank 3 are (75 + 125), which is under 201, so bank 3 is
  unsafe. After bank 3 becomes unsafe, the total assets of bank 1 fall below
  (125 + 40). Thus, bank 1 is also unsafe. The output of the program should be

  Unsafe banks are 3 1
*/

import java.util.Scanner;

public class E8_17 {
  public static void main(String[] args) {
    // Get data regarding banks and loans
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of banks: ");
    int numBanks = input.nextInt();

    System.out.print("Enter the limit: ");
    double limit = input.nextDouble();

    double[] bankBalances = new double[numBanks];
    double[][] borrowers = new double[numBanks][numBanks];

    for (int i = 0; i < numBanks; i++) {
      System.out.print("Enter bank " + i + " balance: ");
      bankBalances[i] = input.nextDouble();
      System.out.print("Enter number of loans given: ");
      int loansGiven = input.nextInt();

      for (int j = 1; j <= loansGiven; j++) {
        System.out.print("Enter bank for loan " + j + ": ");
        int bank = input.nextInt();
        System.out.print("Enter loan amount: ");
        double amount = input.nextDouble();
        borrowers[i][bank] = amount;
      }
    }

    System.out.println(tsunami(limit, bankBalances, borrowers));
  }

  // method name is reference to a "financial tsunami," in which bank failures
  // trigger other banks to fail down the line. returns a string reporting any
  // bank failures.
  public static String tsunami(double limit, double[] bankBalances,
    double[][] borrowers) {

    boolean changed;
    // list of unsafe banks. 0 = safe, 1 = unsafe
    int[] unsafe = new int[bankBalances.length];

    do {
      changed = false;
      // (re)calculate each bank's assets, taking into account any failures
      // from the previous iteration
      double[] assets = getAssets(bankBalances, borrowers);

      // compare bank's assets to the limit, set it "unsafe" if assets < limit,
      // and mark its loans not able to be repaid
      for (int i = 0; i < assets.length; i++) {
        if (assets[i] < limit && unsafe[i] == 0) {
          unsafe[i] = 1;
          clearLoans(i, borrowers);
          changed = true;
        }
      }

    } while (changed); // exit the loop once no changes have been made

    // produce output
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < unsafe.length; i++) {
      if (unsafe[i] == 1) { sb.append(i + " "); }
    }

    if (sb.equals("")) {
      sb.append("All banks are safe");
    } else {
      sb.insert(0, "Unsafe banks are ");
    }

    return sb.toString();
  }

  public static void clearLoans(int bank, double[][] borrowers) {
    for (int i = 0; i < borrowers.length; i++) {
      borrowers[i][bank] = 0.0;
    }
  }

  public static double[] getAssets(double[] bankBalances,
    double[][] borrowers) {
    double[] assets = new double[bankBalances.length];

    for (int i = 0; i < borrowers.length; i++) {
      double sum = bankBalances[i];
      for (int j = 0; j < borrowers[i].length; j++) {
        sum += borrowers[i][j];
      }
      assets[i] = sum;
    }

    return assets;
  }
}
