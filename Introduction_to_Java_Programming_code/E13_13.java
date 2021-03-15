/*
  Rewrite the Course class in Listing 10.6 to add a clone method to perform a
  deep copy on the students field.
*/

public class E13_13 {
  public static void main(String[] args) throws CloneNotSupportedException {
    Course c1 = new Course("Math 101");
    c1.addStudent("Mary");
    c1.addStudent("Joey");
    c1.addStudent("Cooper");

    Course c2 = (Course)c1.clone();
    c2.addStudent("Richard");
    c2.addStudent("Sophia");

    displayStudentList(c1);
    displayStudentList(c2);
  }

  public static void displayStudentList(Course c) {
    String[] students = c.getStudents();
    for (int i = 0; i < c.getNumberOfStudents(); i++) {
      System.out.print(students[i] + " ");
    }
    System.out.println();
  }
}
