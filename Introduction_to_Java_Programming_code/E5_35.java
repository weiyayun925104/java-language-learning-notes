/*
  Write a program to compute the following summation.

  1/(1 + sqrt(2)) + 1/(sqrt(2) + sqrt(3)) + ... 1/(sqrt(624) + sqrt(625))
*/

public class E5_35 {
  public static void main(String[] args) {
    double sum = 0.0;
    for (int i = 1; i <= 624; i++) {
      sum += (1.0 / (Math.sqrt(i) + Math.sqrt(i + 1)));
    }
    System.out.println(sum);
  }
}
