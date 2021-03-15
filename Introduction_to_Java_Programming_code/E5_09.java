/*
  Write a program that prompts the user to enter the number of students and
  each student's name and score, and finally displays the student with the
  highest score and the student with the second-highest score.
*/

import java.util.Scanner;

public class E5_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int numberOfStudents = input.nextInt();

    String bestName = "";
    double bestScore = -1;
    String nextBestName = "";
    double nextBestScore = -1;

    for (int i = 0; i < numberOfStudents; i++) {
      System.out.print("Enter student's name: ");
      String name = input.next();
      System.out.print("Enter score: ");
      double score = input.nextDouble();
      if (score > bestScore) {
        nextBestName = bestName;
        nextBestScore = bestScore;
        bestName = name;
        bestScore = score;
      } else if (score > nextBestScore) {
        nextBestName = name;
        nextBestScore = score;
      }
    }

    System.out.println("High score: " + bestName);
    System.out.println("Runner-up: " + nextBestName);
  }
}
