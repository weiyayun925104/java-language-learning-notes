/*
  The US Census Bureau projects population based on the following assumptions:

  One birth every 7 seconds
  One death every 13 seconds
  One new immigrant every 45 seconds

  Write a program to display the population for each of the next five years.
  Assume the current population is 312,032,486 and one year has 365 days.
*/

public class E1_11 {
  public static void main(String[] args) {
    int currentPopulation = 312_032_486;
    int secondsPerYear = 365 * 24 * 60 * 60;

    for (int i = 1; i <= 5; i++) {
      currentPopulation += (secondsPerYear / 7);
      currentPopulation += (secondsPerYear / 45);
      currentPopulation -= (secondsPerYear / 13);
      System.out.println("Year " + i + ": " + currentPopulation);
    }
  }
}
