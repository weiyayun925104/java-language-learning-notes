/*
  Write a program that prompts the user to read two integers and displays their
  sum. Your program should prompt the user to read the number again if the
  input is incorrect.
*/

import java.util.Scanner;

public class E12_02 {
  public static void main(String[] args) {
    do {
      Scanner input = new Scanner(System.in);
      try {
        System.out.print("Enter two integers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("The sum is " + (a + b));
      } catch (Exception e) {
        input.reset();
        continue;
      }
      break;
    } while (true);
  }
}
