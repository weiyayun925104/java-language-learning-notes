/*
  Write a recursive method to compute the following series:

    m(i) = 1/3 + 2/5 + 3/7 + 4/9 + 5/11 + 6/13 + ... + i/(2i+1)

  Write a test program that displays m(i) for i = 1, 2, ..., 10.
*/

public class E18_05 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(i + ": " + m(i));
    }
  }

  public static double m(int n) {
    return m(n, 1.0/3);
  }

  private static double m(int n, double result) {
    if (n == 1) { return result; }
    return m(n - 1, ((double)n / (2 * n + 1)) + result);
  }
}
