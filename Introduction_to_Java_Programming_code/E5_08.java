/*
  Write a program that prompts the user to enter the number of students and
  each student's name and score, and finally displays the name of the student
  with the highest score.
*/

import java.util.Scanner;

public class E5_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int numOfStudents = input.nextInt();

    String bestStudentName = "";
    double bestStudentScore = -1.0;
    for (int i = 0; i < numOfStudents; i++) {
      System.out.print("Enter student name: ");
      String name = input.next();
      System.out.print("Enter score: ");
      double score = input.nextDouble();
      if (score > bestStudentScore) {
        bestStudentName = name;
        bestStudentScore = score;
      }
    }

    System.out.println(bestStudentName);
  }
}
