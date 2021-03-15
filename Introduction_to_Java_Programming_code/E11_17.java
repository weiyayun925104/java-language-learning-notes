/*
  Write a program that prompts the user to enter an integer m and find the
  smallest integer n such that m * n is a perfect square.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int m = getInput(input);
    int n = getSmallestNForPerfectSquare(m);

    System.out.println("The smallest number n for m * n to be a perfect " +
      "square is " + n);
    System.out.println("m * n is " + (m * n));
  }

  public static int getSmallestNForPerfectSquare(int m) {
    // Get the prime factors of m.
    ArrayList<Integer> factors = getSmallestFactors(m);

    // The strategy is to find the product of factors that appear an odd
    // number of times in the list of factors. To make sure we don't include
    // the same factor twice, we need to keep a list of factors we've seen
    // before, and have the loop continue if the current factor is in that list.
    ArrayList<Integer> seenFactors = new ArrayList<>();
    int product = 1;
    for (int i = 0; i < factors.size(); i++) {
      int currentFactor = factors.get(i);
      if (seenFactors.contains(currentFactor)) { continue; }
      int count = 1;
      for (int j = i + 1; j < factors.size(); j++) {
        if (currentFactor == factors.get(j)) { count++; }
      }
      if (count % 2 != 0) {
        product *= currentFactor;
      }
      seenFactors.add(currentFactor);
    }
    return product;
  }

  public static ArrayList<Integer> getSmallestFactors(int m) {
    ArrayList<Integer> factors = new ArrayList<>();
    int i = 2;
    while (m > 1) {
      if (isPrime(i) && m % i == 0) {
        factors.add(i);
        m /= i;
      } else {
        i++;
      }
    }
    return factors;
  }

  public static boolean isPrime(int n) {
    if (n == 2) { return true; }
    if (n == 0 || n == 1 || n % 2 == 0) { return false; }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) { return false; }
    }
    return true;
  }

  public static int getInput(Scanner input) {
    System.out.print("Enter an integer m: ");
    return input.nextInt();
  }
}
