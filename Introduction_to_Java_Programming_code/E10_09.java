/*
  Revise the Course class as follows:

  - The array size is fixed in Listing 10.6. Improve it to automatically
    inrease the array size by creating a new larger array and copying the
    contents of the current array to it.
  - Implement the dropStudent method.
  - Add a new method named clear() that removes all students from the course.

  Write a test program that creates a course, adds three students, removes one,
  and displays the students in the course.
*/

public class E10_09 {
  public static void main(String[] args) {
    Course course = new Course("Math 101");
    course.addStudent("Jackie");
    course.addStudent("John");
    course.addStudent("Julie");
    course.dropStudent("Jackie");
    displayStudentList(course.getStudents(), course.getNumberOfStudents());
  }

  public static void displayStudentList(String[] list, int numberOfStudents) {
    for (int i = 0; i < numberOfStudents; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
