/*
  A positive integer is called a perfect number if it is equal to the sum of
  all its positive divisors, excluding itself. For example, 6 is the first
  perfect number because 6 = 3 + 2 + 1; The next is 28 = 14 + 7 + 4 + 2 + 1.
  There are four perfect numbers less than 10,000. Write a program to find all
  these four numbers.
*/

public class E5_33 {
  public static void main(String[] args) {
    for (int i = 6; i < 10_000; i++) {
      int sum = 0;
      for (int j = 1; j <= i / 2; j++) {
        if (i % j == 0) {
          sum += j;
        }
      }
      if (sum == i) {
        System.out.println("perfect number: " + i);
      }
    }
  }
}
