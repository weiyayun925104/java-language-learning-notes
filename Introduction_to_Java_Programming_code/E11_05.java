/*
  Rewrite the Course class in Listing 10.6. Use an ArrayList to replace an
  array to store students. You should not change the original contract of the
  Course class (i.e. the definition of the constructors and methods should not
  be changed, but the private members may be changed.)
*/

public class E11_05 {
  public static void main(String[] args) {
    Course course = new Course("Math 101");
    course.addStudent("Joe");
    course.addStudent("Mary");
    course.addStudent("April");
    course.addStudent("Meryl");

    String[] students = course.getStudents();
    for (int i = 0; i < students.length; i++) {
      System.out.println(students[i]);
    }

    System.out.println();

    course.dropStudent("Mary");
    students = course.getStudents();
    for (int i = 0; i < students.length; i++) {
      System.out.println(students[i]);
    }
  }
}
