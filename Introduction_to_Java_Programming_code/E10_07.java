/*
  Use the Account class created in Programming Exercise 9.7 to simulate an
  ATM machine. Create ten accounts in an array with id 0, 1, ..., 9, and
  initial balance $100. The system prompts the user to enter an id. If the id
  is entered incorrectly, ask the user to enter a correct id. Once an id is
  accepted, the main menu is displayed as shown in the sample run. You can
  enter a choice 1 for viewing the current balance, 2 for withdrawing money,
  3 for depositing money, and 4 for exiting the main menu. Once you exit, the
  system will prompt for an id again. Thus, once the system starts, it will
  not stop.
*/

import java.util.Scanner;

public class E10_07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Account[] accounts = getAccounts(10);

    runATM(accounts, input);
  }

  public static void runATM(Account[] accounts, Scanner input) {
    do {
      int id = enterId(accounts.length, input);
      int choice;
      do {
        choice = enterMenuChoice(accounts, input);
        if (choice == 1) {
          displayBalance(accounts, id);
          System.out.println();
        } else if (choice == 2) {
          accounts[id].withdraw(enterWithdrawalAmount(input));
          System.out.println();
        } else if (choice == 3) {
          accounts[id].deposit(enterDepositAmount(input));
          System.out.println();
        }
      } while (choice != 4);
      System.out.println();
    } while (true);
  }

  public static void displayBalance(Account[] accounts, int id) {
    System.out.printf("The balance is $%.2f\n", accounts[id].getBalance());
  }

  public static int enterMenuChoice(Account[] accounts, Scanner input) {
    displayMenu();
    String choice;
    do {
      System.out.print("Enter a choice: ");
      choice = input.next();
    } while (!isInRange(choice, 1, 5));
    return Integer.parseInt(choice);
  }

  public static double enterDepositAmount(Scanner input) {
    System.out.print("Enter an amount to deposit: ");
    return input.nextDouble();
  }

  public static double enterWithdrawalAmount(Scanner input) {
    System.out.print("Enter an amount to withdraw: ");
    return input.nextDouble();
  }

  public static int enterId(int n, Scanner input) {
    String id;
    do {
      System.out.print("Enter an id: ");
      id = input.next();
    } while (!isInRange(id, 0, n));
    return Integer.parseInt(id);
  }

  public static boolean isSingleDigit(String s) {
    if (s.length() != 1) { return false; }
    if (!Character.isDigit(s.charAt(0))) { return false; }
    return true;
  }

  public static boolean isInRange(String s, int start, int end) {
    if (!isSingleDigit(s)) { return false; }
    int sDigit = Integer.parseInt(s);
    return sDigit >= start && sDigit < end;
  }

  public static void displayMenu() {
    System.out.println("Main menu");
    System.out.println("1: check balance");
    System.out.println("2: withdraw");
    System.out.println("3: deposit");
    System.out.println("4: exit");
  }

  public static Account[] getAccounts(int n) {
    Account[] accounts = new Account[n];
    for (int i = 0; i < accounts.length; i++) {
      accounts[i] = new Account(i, 100.0);
    }
    return accounts;
  }
}
