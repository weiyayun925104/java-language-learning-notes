import java.util.Date;

public class Account {
  private int id;
  private double balance;
  private double annualInterestRate;
  private Date dateCreated;

  public Account() {
    this(0, 0.0);
  }

  public Account(int id, double balance) {
    this.id = id;
    this.balance = balance;
    annualInterestRate = 0.0;
    dateCreated = new Date();
  }

  // getters
  public int getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  // setters
  public void setId(int id) {
    this.id = id;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate / 100;
  }

  // instance methods
  public double getMonthlyInterestRate() {
    return getAnnualInterestRate() / 12;
  }

  public double getMonthlyInterest() {
    return getBalance() * getMonthlyInterestRate();
  }

  public void withdraw(double amount) {
    setBalance(getBalance() - amount);
  }

  public void deposit(double amount) {
    setBalance(getBalance() + amount);
  }

  @Override
  public String toString() {
    return "balance: " + getBalance() + "\nmonthly interest: " +
      getMonthlyInterest() + "\ndate created: " + getDateCreated();
  }
}
