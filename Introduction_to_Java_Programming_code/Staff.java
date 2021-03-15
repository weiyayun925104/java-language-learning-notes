public class Staff extends Employee {
  // fields
  private String title;

  // constructors
  public Staff(String name, String address, String phoneNumber,
    String emailAddress, String office, double salary, String title) {
    super(name, address, phoneNumber, emailAddress, office, salary);
    this.title = title;
  }

  // getters
  public String getTitle() {
    return title;
  }

  // overrides
  @Override
  public String toString() {
    return "class: Staff\nname: " + getName();
  }
}
