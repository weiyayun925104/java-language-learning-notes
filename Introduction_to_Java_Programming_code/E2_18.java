/*
  Write a program that displays the following table. Cast floating-point
  numbers into integers.

              pow(a, b) for a of values 1-5 and b of values 2-6
*/

public class E2_18 {
  public static void main(String[] args) {
    System.out.println("a     b     pow(a, b)");
    for (int i = 1; i <= 5; i++) {
      int a = i;
      int b = i + 1;
      int pow = (int)Math.pow(a, b);
      System.out.printf("%d     %d     %-9d\n", a, b, pow);
    }
  }
}
