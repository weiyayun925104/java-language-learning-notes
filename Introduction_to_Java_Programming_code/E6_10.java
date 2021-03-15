/*
  Listing 6.7, PrimeNumberMethod.java, provides the isPrime(int number) method
  for testing whether a number is prime. Use this method to find the number of
  prime numbers less than 10000.
*/

public class E6_10 {
  public static void main(String[] args) {
    int primeCount = 0;
    for (int i = 2; i < 10_000; i++) {
      if (isPrime(i)) { primeCount++; }
    }
    System.out.println("There are " + primeCount + " prime numbers " +
      "less than 10,000");
  }

  public static boolean isPrime(int number) {
    for (int divisor = 2; divisor * divisor <= number; divisor++) {
      if (number % divisor == 0) {
        return false;
      }
    }
    return true;
  }
}
