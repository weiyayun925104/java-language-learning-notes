/*
  In Listing 19.1, GenericStack is implemented using composition. Define a new
  stack class that extends ArrayList. Write a test program that prompts the
  user to enter five strings and displays them in reverse order.
*/

import java.util.Scanner;

public class E19_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter five strings: ");
    GenericStack<String> s = new GenericStack<>();
    for (int i = 0; i < 5; i++) {
      s.push(input.nextLine());
    }

    int size = s.getSize();
    for (int i = 0; i < size; i++) {
      System.out.println(s.pop());
    }
  }
}
