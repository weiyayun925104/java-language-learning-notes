/*
  Write a program that pays the popular scissor-rock-paper game. (A scissor
  can cut a paper, a rock can knock a scissor, and a paper can wrap a rock.)
  The program randomly generates a number 0, 1, or 2 representing scissor,
  rock, and paper. The program prompts the user to enter a number 0, 1, or 2
  and displays a message indicating whether the user or the computer wins,
  loses, or draws.
*/

import java.util.Scanner;

public class E3_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int userThrow;
    do {
      System.out.print("scissor (0), rock (1), paper (2): ");
      userThrow = input.nextInt();
    } while (userThrow < 0 || userThrow > 2);

    int cpuThrow = getCPUThrow();

    System.out.println(getResult(userThrow, cpuThrow));
  }

  private static String getResult(int userThrow, int cpuThrow) {
    StringBuilder s = new StringBuilder();
    String user = getThrowName(userThrow);
    String cpu = getThrowName(cpuThrow);
    int outcome = outcome(userThrow, cpuThrow);
    boolean same = (outcome == 0);

    s.append("The computer is " + cpu + ". ");
    s.append("You are " + user + (same ? " too" : "") + ". ");
    if (outcome == -1)
      s.append("You lost.");
    else if (outcome == 0)
      s.append("It is a draw.");
    else
      s.append("You won.");

    return s.toString();
  }

  private static int outcome(int userThrow, int cpuThrow) {
    // -1 is loss, 0 is draw, 1 is win
    int outcome;
    if (userThrow == 0 && cpuThrow == 2 ||
        userThrow == 1 && cpuThrow == 0 ||
        userThrow == 2 && cpuThrow == 1) {
      outcome = 1;
    } else if (userThrow == 0 && cpuThrow == 1 ||
               userThrow == 1 && cpuThrow == 2 ||
               userThrow == 2 && cpuThrow == 0) {
      outcome = -1;
    } else {
      outcome = 0;
    }
    return outcome;
  }

  private static String getThrowName(int t) {
    StringBuilder s = new StringBuilder();
    switch (t) {
      case 0: s.append("scissor"); break;
      case 1: s.append("rock"); break;
      case 2: s.append("paper");
    }
    return s.toString();
  }

  private static int getCPUThrow() {
    return (int)(Math.random() * 3);
  }
}
