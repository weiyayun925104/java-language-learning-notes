/*
  You can approximate pi by using the following series:

                        (series)

  Write a program that displays the pi value for i = 10000, 20000, ..., and
  100000.
*/

public class E5_25 {
  public static void main(String[] args) {
    for (int i = 10_000; i <= 100_000; i += 10_000) {
      double sum = 0.0;
      for (int n = 1; n <= i; n++) {
        sum += Math.pow(-1, n + 1) / (2 * n - 1);
      }
      sum *= 4;
      System.out.printf("i = %d\napprox pi = %f\n\n", i, sum);
    }
  }
}
