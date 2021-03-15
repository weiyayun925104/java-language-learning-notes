/*
  Write a recursive method to compute the following series:

    m(i) = 1/2 + 2/3 + ... + i/(i + 1)

  Write a test program that displays m(i) for i = 1, 2, ... 10.
*/

public class E18_06 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(i + ": " + m(i));
    }
  }

  public static double m(int n) {
    return m(n, 1.0/2);
  }

  private static double m(int n, double result) {
    if (n == 1) { return result; }
    return m(n - 1, ((double)n / (n + 1)) + result);
  }
}
