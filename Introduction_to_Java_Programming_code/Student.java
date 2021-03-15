public class Student extends Person {
  // static fields
  public static final int FRESHMAN = 0;
  public static final int SOPHOMORE = 1;
  public static final int JUNIOR = 2;
  public static final int SENIOR = 3;

  // instance fields
  private int classStatus;

  // constructors
  public Student(String name, String address, String phoneNumber,
    String emailAddress, int classStatus) {
    super(name, address, phoneNumber, emailAddress);
    this.classStatus = classStatus;
  }

  // getters
  public int getClassStatus() {
    return classStatus;
  }

  // overrides
  @Override
  public String toString() {
    return "class: Student\nname: " + getName();
  }
}
