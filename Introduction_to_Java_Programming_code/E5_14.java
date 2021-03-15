/*
  Another solution for Listing 5.9 to find the greatest common divisor of two
  integers n1 and n2 is as follows: First find d to be the minimum of n1 and n2,
  then check whether d, d-1, d-2, ..., 2, or 1 is a divisor for both n1 and n2
  in this order. The first such common divisor is the greatest common divisor
  for n1 and n2. Write a program that prompts the user to enter two positive
  integers and displays the gcd.
*/

import java.util.Scanner;

public class E5_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter n1: ");
    int n1 = input.nextInt();
    validate(n1);
    System.out.print("Enter n2: ");
    int n2 = input.nextInt();
    validate(n2);

    System.out.println(gcd(n1, n2));
  }

  private static int gcd(int n1, int n2) {
    int d = Math.min(n1, n2);
    for (int i = d; i >= 1; i--) {
      if (n1 % i == 0 && n2 % i == 0) {
        d = i;
        break;
      }
    }
    return d;
  }

  private static void validate(int n) {
    if (n < 1) {
      errorOut();
    }
  }

  private static void errorOut() {
    System.out.println("Invalid input. Only positive integers allowed.");
    System.exit(1);
  }
}
