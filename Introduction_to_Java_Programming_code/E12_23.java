/*
  Suppose that the text file on the Web
  http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified number
  of scores. Write a program that reads the scores from the file and displays
  their total and average. Scores are separated by blanks.
*/

import java.util.Scanner;
import java.net.URL;

public class E12_23 {
  public static void main(String[] args) {
    try {
      URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
      Scanner input = new Scanner(url.openStream());
      int total = 0;
      int count = 0;
      while (input.hasNext()) {
        total += input.nextInt();
        count++;
      }
      System.out.println("total: " + total);
      System.out.println("average: " + ((double)total / count));
    } catch (Exception e) {
      System.out.println("Unable to find resource or open connection");
      System.exit(1);
    }
  }
}
