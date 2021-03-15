public class Faculty extends Employee {
  // fields
  private String officeHours;
  private String rank;

  // constructors
  public Faculty(String name, String address, String phoneNumber,
    String emailAddress, String office, double salary, String officeHours,
    String rank) {
    super(name, address, phoneNumber, emailAddress, office, salary);
    this.officeHours = officeHours;
    this.rank = rank;
  }

  // getters
  public String getOfficeHours() {
    return officeHours;
  }

  public String getRank() {
    return rank;
  }

  // overrides
  @Override
  public String toString() {
    return "class: Faculty\nname: " + getName();
  }
}
