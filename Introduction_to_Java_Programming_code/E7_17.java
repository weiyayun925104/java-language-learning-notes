/*
  Write a program that prompts the user to enter the number of students, the
  students' names, and their scores, and prints the student names in
  decreasing order of their scores.
*/

import java.util.Scanner;

public class E7_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of students: ");
    int numberOfStudents = input.nextInt();

    String[] names = new String[numberOfStudents];
    int[] nums = new int[numberOfStudents];
    for (int i = 0; i < numberOfStudents; i++) {
      System.out.print("Enter student name: ");
      names[i] = input.next();
      System.out.print("Enter score: ");
      nums[i] = input.nextInt();
    }

    sortDecreasing(names, nums);

    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
    }
  }

  public static void sortDecreasing(String[] str, int[] num) {
    boolean changed = true;
    while (changed) {
      changed = false;
      for (int i = 0; i < num.length - 1; i++) {
        if (num[i] < num[i + 1]) {
          // swap scores around
          int temp = num[i + 1];
          num[i + 1] = num[i];
          num[i] = temp;

          // swap names around
          String orary = str[i + 1];
          str[i + 1] = str[i];
          str[i] = orary;

          changed = true;
        }
      }
    }
  }
}
