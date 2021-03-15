/*
  In Programming Exercise 9.7, the Account class was defined to model a bank
  account. An account has the properties account number, balance, annual
  interest rate, and date created, and methods to deposit and withdraw funds.
  Create two subclasses for checking sand saving accounts. A checking account
  has an overdraft limit, but a savings account cannot be overdrawn.

  Write a test program that creates objects of Account, SavingsAccount, and
  CheckingAccount and invokes their toString() methods.
*/

public class E11_03 {
  public static void main(String[] args) {
    Account a = new Account(123, 526.70);
    CheckingAccount c = new CheckingAccount(456, 872.20, 100);
    SavingsAccount s = new SavingsAccount(789, 232.54);

    System.out.println(a);
    System.out.println(c);
    System.out.println(s);
  }
}
