
import java.util.Scanner;

public class E5_34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int userThrow;
    int userWins = 0;
    int cpuWins = 0;
    do {
      do {
        System.out.print("scissor (0), rock (1), paper (2): ");
        userThrow = input.nextInt();
      } while (userThrow < 0 || userThrow > 2);

      int cpuThrow = getCPUThrow();

      System.out.println(getResult(userThrow, cpuThrow));

      int winner = outcome(userThrow, cpuThrow);
      if (winner == -1) {
        cpuWins++;
      } else if (winner == 1) {
        userWins++;
      }
    } while ( userWins <= (2 + cpuWins) && cpuWins <= (2 + userWins) );

    if (userWins > cpuWins) {
      System.out.println("Congratulations, you beat the CPU!");
    } else {
      System.out.println("Sorry, you lost to the CPU ...");
    }
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
