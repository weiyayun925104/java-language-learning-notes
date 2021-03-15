/*
  Revise Exercise 6.30 to run it 10,000 times and display the number of
  winning games.
*/

public class E6_32 {
  public static void main(String[] args) {
    int winCount = 0;
    for (int i = 0; i < 10_000; i++) {
      if (playCraps() == 1) { winCount++; }
    }
    System.out.println("wins: " + winCount);
  }

  public static int playCraps() {
    int sum = getRollSum();

    int firstRoundOutcome = firstRoundWinner(sum);
    if (firstRoundOutcome == 1 || firstRoundOutcome == -1) {
      return firstRoundOutcome;
    } else {
      int point = sum;
      int secondRoundOutcome;
      do {
        sum = getRollSum();
        secondRoundOutcome = secondRoundWinner(sum, point);
      } while (secondRoundOutcome == 0);
      return secondRoundOutcome;
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

  private static int getRollSum() {
    int d1 = rollDie();
    int d2 = rollDie();
    int sum = d1 + d2;
    return sum;
  }

  private static int rollDie() {
    return (int)(Math.random() * 6) + 1;
  }
}
