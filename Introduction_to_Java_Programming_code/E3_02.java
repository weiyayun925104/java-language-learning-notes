/*
  The program in Listing 3.1, AdditionQuiz.java, generates two integers and
  prompts the user to enter the sum of these two integers. Revise the program
  to generate three single-digit integers and prompt the user to enter the sum
  of these three integers.
*/

import java.util.Scanner;

public class E3_02 {
  public static void main(String[] args) {
    int[] numbers = new int[3];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = (int)(Math.random() * 10);
    }

    Scanner input = new Scanner(System.in);
    System.out.print("What is " + numbers[0] + " + " + numbers[1] + " + " +
      numbers[2] + "? ");
    int answer = input.nextInt();

    System.out.println(numbers[0] + " + " + numbers[1] + " + " + numbers[2] +
      " = " + answer + " is " +
      (numbers[0] + numbers[1] + numbers[2] == answer));
  }
}
