/*
  Pi can be computed using the following formula:

  pi = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ...)

  Write a program that displays the result of
    4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11)
                and
    4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13)
*/

public class E1_07 {
  public static void main(String[] args) {
    System.out.println(approximatePi(11));
    System.out.println(approximatePi(13));
  }

  private static double approximatePi(int index) {
    boolean positive = true;
    double sum = 0.0;
    for (int i = 1; i <= index; i += 2) {
      if (positive) {
        sum += (1.0 / i);
        positive = false;
      } else {
        sum -= (1.0 / i);
        positive = true;
      }
    }

    return 4.0 * sum;
  }
}
