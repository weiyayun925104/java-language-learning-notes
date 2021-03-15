/*
  Use a while loop to find the largest integer n such that n^3 is less than
  12,000.
*/

public class E5_13 {
  public static void main(String[] args) {
    int n = 1;
    while (n * n * n < 12000) {
      n++;
    }
    // n will overshoot by 1 before breaking the loop, so the correct answer is
    // obtained by subtracting 1 from n.
    System.out.println(n - 1);
  }
}
