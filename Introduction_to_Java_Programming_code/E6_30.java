/*
  Craps is a popular dice game played in casinos. Write a program to play a
  variation of the game, as follows:

  Roll two dice. Each die has six faces representing values 1, 2, ..., and 6,
  respectively. Check the sum of the two dice. If the sum is 2, 3, or 12
  (called craps), you lose; if the sum is 7 or 11 (called natural), you win;
  if the sum is another value (ie 4, 5, 6, 8, 9, or 10), a point is
  established. Continue to roll the dice until either a 7 or the same point
  value is rolled. If 7 is rolled, you lose. Otherwise, you win.
*/

public class E6_30 {
  public static void main(String[] args) {
    playCraps();
  }

  public static void playCraps() {
    int sum = getRollSum();

    int firstRoundOutcome = firstRoundWinner(sum);
    if (firstRoundOutcome == 1) {
      displayOutcome(firstRoundOutcome);
    } else if (firstRoundOutcome == -1) {
      displayOutcome(firstRoundOutcome);
    } else {
      int point = sum;
      int secondRoundOutcome;
      do {
        sum = getRollSum();
        secondRoundOutcome = secondRoundWinner(sum, point);
      } while (secondRoundOutcome == 0);
      displayOutcome(secondRoundOutcome);
    }
  }

  private static int firstRoundWinner(int sum) {
    // 1 is win, 0 is establish point, -1 is loss
    int outcome = 0;
    if (sum == 2 || sum == 3 || sum == 12) { outcome = -1; }
    else if (sum == 7 || sum == 11) { outcome = 1; }
    return outcome;
  }

  private static int secondRoundWinner(int sum, int point) {
    // 1 is win, 0 is roll again, -1 is loss
    int outcome = 0;
    if (sum == 7) { outcome = -1; }
    if (sum == point) { outcome = 1; }
    return outcome;
  }

  private static void displayOutcome(int winner) {
    // expects 1 for win, -1 for loss
    StringBuilder s = new StringBuilder("You ");
    if (winner == 1) { s.append("win"); }
    else if (winner == -1) { s.append("lose"); }
    System.out.println(s);
  }

  private static int getRollSum() {
    int d1 = rollDie();
    int d2 = rollDie();
    int sum = d1 + d2;
    System.out.println("You rolled " + d1 + " + " + d2 + " = " + sum);
    return sum;
  }

  private static int rollDie() {
    return (int)(Math.random() * 6) + 1;
  }
}
