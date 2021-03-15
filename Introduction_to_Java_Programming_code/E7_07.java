/*
  Write a program that generates 100 random integers between 0 and 9 and
  displays the count for each number.
*/

public class E7_07 {
  public static void main(String[] args) {
    int[] counts = new int[10];
    for (int i = 0; i < 100; i++) {
      counts[(int)(Math.random() * 10)]++;
    }

    for (int i = 0; i < counts.length; i++) {
      System.out.println(i + ": " + counts[i]);
    }
  }
}
