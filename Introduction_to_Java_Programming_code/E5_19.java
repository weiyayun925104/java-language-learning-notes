/*
  Write a nested for loop that prints the following output:

                        (pyramid of multiples of 2 up to 128)
*/

public class E5_19 {
  public static void main(String[] args) {
    final int N = 128;
    final int POWER = getPowerOfTwo(N);
    String padding = "    ";
    for (int i = 1, pad = POWER; i <= N; i *= 2, pad--) {
      // print padding (each successive tier tied to the power - 1)
      for (int j = pad; j > 0; j--) {
        System.out.print(padding);
      }
      // print left half-pyramid
      for (int k = 1; k <= i; k *= 2) {
        System.out.printf("%-4d", k);
      }
      // print right half-pyramid
      for (int m = i / 2; m >= 1; m /= 2) {
        if (i == 1) { continue; } // ignore the top of the pyramid
        System.out.printf("%-4d", m);
      }
      System.out.println();
    }
  }

  private static int getPowerOfTwo(int n) {
    // only works with valid powers of two (e.g. 128)
    int power = 0;
    while (n != 1) {
      n /= 2;
      power++;
    }
    return power;
  }
}
