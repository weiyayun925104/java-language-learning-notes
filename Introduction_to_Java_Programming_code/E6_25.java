/*
  Write a method that converts milliseconds to hours, minutes, and seconds
  using the following header:

  public static String convertMillis(long millis)

  The method returns a string as hours:minutes:seconds. For example,
  convertMillis(5500) returns a string 0:0:5, convertMillis(100000) returns a
  string 0:1:40, and convertMillis(555550000) returns a string 154:19:10.
*/

import java.util.Scanner;

public class E6_25 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter milliseconds: ");
    long millis = input.nextLong();

    System.out.println(convertMillis(millis));
  }

  public static String convertMillis(long millis) {
    long hours = millis / 3_600_000;
    millis %= 3_600_000;
    long minutes = millis / 60_000;
    millis %= 60_000;
    long seconds = millis / 1_000;
    return hours + ":" + minutes + ":" + seconds;
  }
}
