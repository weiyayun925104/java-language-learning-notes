/*
  Rewrite Listing 8.2, GradeExam.java, to display the students in increasing
  order of the number of correct answers.
*/

public class E8_03 {
  public static void main(String[] args) {
    char[][] answers = {
      {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
      {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
      {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
      {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}
    };

    char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

    int[][] scores = getScoresArray(answers, keys);
    bubbleSort(scores);

    for (int i = 0; i < scores.length; i++) {
      System.out.println("Student " + scores[i][0] + ": " + scores[i][1]);
    }
  }

  public static int[][] getScoresArray(char[][] answers, char[] keys) {
    int[][] scores = new int[answers.length][2];
    for (int i = 0; i < answers.length; i++) {
      int correctCount = 0;
      for (int j = 0; j < answers[i].length; j++) {
        if (answers[i][j] == keys[j]) { correctCount++; }
      }
      scores[i][0] = i;
      scores[i][1] = correctCount;
    }
    return scores;
  }

  public static void bubbleSort(int[][] scores) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < scores.length - 1; i++) {
        if (scores[i][1] > scores[i + 1][1]) {
          int[] temp = scores[i];
          scores[i] = scores[i + 1];
          scores[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
