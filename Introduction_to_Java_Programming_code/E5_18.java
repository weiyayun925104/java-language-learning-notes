/*
  Use nested loops that display the following patterns in four separate
  programs:

  Pattern A     Pattern B     Pattern C     Pattern D
  1             1 2 3 4 5 6             1   1 2 3 4 5 6
  1 2           1 2 3 4 5             2 1     1 2 3 4 5
  1 2 3         1 2 3 4             3 2 1       1 2 3 4
  1 2 3 4       1 2 3             4 3 2 1         1 2 3
  1 2 3 4 5     1 2             5 4 3 2 1           1 2
  1 2 3 4 5 6   1             6 5 4 3 2 1             1
*/

public class E5_18 {
  public static void main(String[] args) {
    patternA();
    System.out.println();
    patternB();
    System.out.println();
    patternC();
    System.out.println();
    patternD();
  }

  private static void patternA() {
    System.out.println("Pattern A");
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.printf("%-2d", j);
      }
      System.out.println();
    }
  }

  private static void patternB() {
    System.out.println("Pattern B");
    for (int i = 6; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.printf("%-2d", j);
      }
      System.out.println();
    }
  }

  private static void patternC() {
    String padding = "  ";
    System.out.println("Pattern C");
    for (int i = 1; i <= 6; i++) {
      // print padding
      for (int j = i; j < 6; j++) {
        System.out.print(padding);
      }
      // print left half-pyramid
      for (int k = i; k >= 1; k--) {
        System.out.printf("%-2d", k);
      }
      System.out.println();
    }
  }

  private static void patternD() {
    String padding = "  ";
    System.out.println("Pattern D");
    for (int i = 6; i >= 1; i--) {
      // print padding
      for (int j = i; j < 6; j++) {
        System.out.print(padding);
      }
      // print left half-pyramid (upside down)
      for (int k = 1; k <= i; k++) {
        System.out.printf("%-2d", k);
      }
      System.out.println();
    }
  }
}
