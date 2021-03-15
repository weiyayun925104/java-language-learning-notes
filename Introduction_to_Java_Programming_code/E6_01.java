
public class E6_01 {
  public static void main(String[] args) {
    final int PENTAGONAL_NUMBERS_PER_LINE = 10;
    for (int i = 1; i <= 100; i++) {
      System.out.printf("%-6d ", getPentagonalNumber(i));
      if (i % PENTAGONAL_NUMBERS_PER_LINE == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }

  public static int getPentagonalNumber(int n) {
    return n * (3 * n - 1) / 2;
  }
}
