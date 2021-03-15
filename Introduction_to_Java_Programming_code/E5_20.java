/*
  Modify Listing 5.15 to display all the prime numbers between 2 and 1000,
  inclusive. Display eight prime numbers per line. Numbers are separated by
  exactly one space.
*/

public class E5_20 {
  public static void main(String[] args) {
    final int PRIMES_PER_LINE = 8;
    int count = 0;

    for (int i = 2; i <= 1000; i++) {
      if (count == PRIMES_PER_LINE) {
        System.out.println();
        count = 0;
      }
      if (isPrime(i)) {
        System.out.printf("%3d ", i);
        count++;
      }
    }
    System.out.println();
  }

  private static boolean isPrime(int n) {
    if (n < 2) { return false; }
    if (n == 2) { return true; }
    if (n % 2 == 0) { return false; }
    for (int i = 3; i * i <= n; i+=2) {
      if (n % i == 0) { return false; }
    }
    return true;
  }
}
