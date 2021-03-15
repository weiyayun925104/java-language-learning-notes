/*
  Write a program that simulates flipping a coin one million times and displays
  the number of heads and tails.
*/

public class E5_40 {
  public static void main(String[] args) {
    int headsCount = 0;
    int tailsCount = 0;
    for (int i = 0; i < 1_000_000; i++) {
      int flip = (int)(Math.random() * 2);
      if (flip == 1) { headsCount++; }
      else { tailsCount++; }
    }
    System.out.println("heads: " + headsCount);
    System.out.println("tails: " + tailsCount);
  }
}
