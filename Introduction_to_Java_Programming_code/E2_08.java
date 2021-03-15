/*
  Listing 2.7, ShowCurrentTime.java, gives a program that displays the current
  time in GMT. Revise the program so that it prompts the user to enter the
  time zone offset to GMT and displays the time in the specified time zone.
*/

import java.util.Scanner;

public class E2_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the time zone offset to GMT: ");
    int offset = input.nextInt();

    long totalMilliseconds = System.currentTimeMillis();
    long totalSeconds = totalMilliseconds / 1000;
    long currentSecond = totalSeconds % 60;
    long totalMinutes = totalSeconds / 60;
    long currentMinute = totalMinutes % 60;
    long totalHours = totalMinutes / 60;
    long currentHour = (totalHours + offset) % 24;

    System.out.println("Current time is " + currentHour + ":" + currentMinute +
      ":" + currentSecond);
  }
}
