public class Person {
  // fields
  private String name, address, phoneNumber, emailAddress;

  // constructors
  public Person(String name, String address, String phoneNumber,
    String emailAddress) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  // getters
  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  // overrides
  @Override
  public String toString() {
    return "class: Person\nname: " + getName();
  }
}
