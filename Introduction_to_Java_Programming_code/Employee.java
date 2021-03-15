import java.util.Date;

public class Employee extends Person {
  // fields
  private String office;
  private double salary;
  private Date dateHired;

  // constructors
  public Employee(String name, String address, String phoneNumber,
    String emailAddress, String office, double salary) {
    super(name, address, phoneNumber, emailAddress);
    this.office = office;
    this.salary = salary;
    dateHired = new Date();
  }

  // getters
  public String getOffice() {
    return office;
  }

  public double getSalary() {
    return salary;
  }

  public Date getDateHired() {
    return dateHired;
  }

  // overrides
  @Override
  public String toString() {
    return "class: Employee\nname: " + getName();
  }
}
