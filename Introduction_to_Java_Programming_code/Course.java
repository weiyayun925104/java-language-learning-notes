
public class Course implements Cloneable {
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
  }

  public void addStudent(String student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
  }

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public String getCourseName() {
    return courseName;
  }

  public void dropStudent(String student) {
    // not implemented
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    Course courseClone = new Course(this.getCourseName());
    courseClone.students = (String[])(students.clone());
    courseClone.numberOfStudents = this.numberOfStudents;

    return courseClone;
  }
}
