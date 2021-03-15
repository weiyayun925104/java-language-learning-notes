/*
  Modify Listing 18.2, ComputeFibonacci.java, so that the program finds the
  number of times the fib method is called.
*/

import java.util.Scanner;

public class E18_07 {
  public static int countFibs = 0;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an index for a Fibonacci number: ");
    int index = input.nextInt();

    System.out.println("The Fibonacci number at index " + index +
      " is " + fib(index));

    System.out.println("fib called " + countFibs + " times");
  }

  public static long fib(long index) {
    countFibs++;
    if (index == 0) { return 0; }
    if (index == 1) { return 1; }
    return fib(index - 2) + fib(index - 1);
  }
}
