/*
  Write a method to compute the following series:

    m(i) = 1/2 + 2/3 + ... + i/(i + 1)
*/

public class E6_13 {
  public static void main(String[] args) {
    System.out.println("i     m(i)");
    for (int i = 1; i <= 20; i++) {
      System.out.printf("%-2d    %-4.4f\n", i, computeSeries(i));
    }
  }

  public static double computeSeries(int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += (double)i / ((double)i + 1);
    }
    return sum;
  }
}
