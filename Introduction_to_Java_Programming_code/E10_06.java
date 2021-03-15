/*
  Write a program that displays all the prime numbers less than 120 in
  decreasing order. Use the StackOfIntegers class to store the prime numbers
  (e.g. 2, 3, 5) and retrieve and display them in reverse order.
*/

public class E10_06 {
  public static void main(String[] args) {
    StackOfIntegers s = new StackOfIntegers();
    int n = 120;

    for (int i = 2; i < n; i++) {
      if (isPrime(i)) { s.push(i); }
    }

    int size = s.getSize();
    for (int i = 0; i < size; i++) {
      System.out.print(s.pop() + " ");
    }
    System.out.println();
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
