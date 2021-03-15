/*
  Write a program that prompts the user to enter a positive integer and displays
  all its smallest factors in decreasing order. For example, if the integer is
  120, the smallest factors are displayed as 5, 3, 2, 2, 2. Use the
  StackOfIntegers class to store the factors (eg 2, 2, 2, 3, 5) and retrieve
  and display them in reverse order.
*/

import java.util.Scanner;

public class E10_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");

    StackOfIntegers s = getPrimeFactors(input.nextInt());

    int size = s.getSize();
    for (int i = 0; i < size; i++) {
      System.out.print(s.pop() + " ");
    }
    System.out.println();
  }

  public static StackOfIntegers getPrimeFactors(int n) {
    StackOfIntegers s = new StackOfIntegers();
    for (int i = 2; n > 1;) {
      if (isPrime(i) && n % i == 0) {
        s.push(i);
        n /= i;
      } else {
        i++;
      }
    }
    return s;
  }

  public static boolean isPrime(int n) {
    if (n == 2) { return true; }
    if (n == 0 || n == 1 || n % 2 == 0) { return false; }
    for (int i = 3; i <= Math.sqrt(n); i++) {
      if (n % i == 0) { return false; }
    }
    return true;
  }
}
