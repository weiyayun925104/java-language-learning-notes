/*
  pi can be computed using the following series:

                        m(i) = (series)

  Write a method that returns m(i) for a given i and write a test program that
  displays the following table:

                        (table)
*/

public class E6_14 {
  public static void main(String[] args) {
    System.out.println("i      m(i)");
    for (int i = 1; i <= 901; i += 100) {
      System.out.printf("%-3d    %-5.4f\n", i, approximatePi(i));
    }
  }

  public static double approximatePi(int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += Math.pow(-1, i + 1) / (2 * i - 1);
    }
    return sum * 4;
  }
}
