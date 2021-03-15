/*
  Write a program that displays the following two tables side by side:

  Miles     Kilometers   |   Kilometers     Miles
  1         1.609        |   20             12.430
  2         3.218        |   25             15.538
  ...       ...          |   ...            ...
  9         14.481       |   60             37.290
  10        16.090       |   65             40.398
*/

public class E5_06 {
  public static void main(String[] args) {
    final double KILOMETERS_PER_MILE = 1.609;

    System.out.println("Miles     Kilometers   |   Kilometers     Miles");
    for (int i = 1, j = 20; i <= 10; i++, j += 5) {
      System.out.printf("%-5d     %-10.3f   |   %-10d     %-5.3f\n",
        i, KILOMETERS_PER_MILE * i, j, j / KILOMETERS_PER_MILE);
    }
  }
}
