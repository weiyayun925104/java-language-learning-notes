/*
  Write a program that reads student scores, gets the best score, and then
  assigns grades based on the following scheme:

  Grade is A if score is >= best - 10
  Grade is B if score is >= best - 20
  Grade is C if score is >= best - 30
  Grade is D if score is >= best - 40
  Grade is F otherwise

  The program prompts the user to enter the total number of students, then
  prompts the user to enter all of the scores, and concludes by displaying
  the grades.
*/

import java.util.Scanner;

public class E7_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int numberOfStudents = input.nextInt();
    System.out.print("Enter " + numberOfStudents + " scores: ");
    int[] scores = new int[numberOfStudents];
    for (int i = 0; i < scores.length; i++) {
      scores[i] = input.nextInt();
    }

    int bestScore = getBestScore(scores);

    for (int i = 0; i < scores.length; i++) {
      char grade = getGrade(scores[i], bestScore);
      System.out.println("Student " + i + " score is " + scores[i] +
        " and grade is " + grade);
    }
  }

  public static char getGrade(int score, int best) {
    char c;
    if (score >= best - 10) { c = 'A'; }
    else if (score >= best - 20) { c = 'B'; }
    else if (score >= best - 30) { c = 'C'; }
    else if (score >= best - 40) { c = 'D'; }
    else { c = 'F'; }
    return c;
  }

  public static int getBestScore(int[] scores) {
    int best = scores[0];
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > best) { best = scores[i]; }
    }
    return best;
  }
}
