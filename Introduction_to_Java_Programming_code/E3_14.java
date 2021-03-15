/*
  Write a program that lets the user guess whether the flip of a coin results
  in heads or tails. The program randomly generates an integer 0 or 1, which
  represents head or tail. The program prompts the user to enter a guess and
  reports whether the guess is correct or incorrect.
*/

import java.util.Scanner;

public class E3_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String guess;
    do {
      System.out.print("Enter 'h' (heads) or 't' (tails): ");
      guess = input.nextLine().toLowerCase();
    } while (!guess.equals("h") && !guess.equals("t"));

    String flip = sideName(flipCoin());
    System.out.println("Flip: " + flip);
    StringBuilder output = new StringBuilder();
    if (guess.equals(flip.charAt(0) + "")) {
      output.append("You guessed correctly!");
    } else {
      output.append("You guessed wrong!");
    }

    System.out.println(output);
  }

  private static int flipCoin() {
    return (int)(Math.random() * 2);
  }

  private static String sideName(int s) {
    return s == 0 ? "heads" : "tails";
  }
}
