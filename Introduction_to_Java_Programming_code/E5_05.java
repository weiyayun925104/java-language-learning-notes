/*
  Write a program that displays the following two tables side by side:

  Kilograms     Pounds     |     Pounds     Kilograms
  1             2.2        |     20         9.09
  3             6.6        |     25         11.36
  ...           ...        |     ...        ...
  197           433.4      |     510        231.82
  199           437.8      |     515        234.09
*/

public class E5_05 {
  public static void main(String[] args) {
    final double POUNDS_PER_KILOGRAM = 2.2;

    System.out.println("Kilograms     Pounds     |     Pounds     Kilograms");
    for (int i = 1, j = 20; i < 200; i += 2, j += 5) {
      System.out.printf("%-9d     %6.1f     |     %-6d     %9.2f\n",
        i, POUNDS_PER_KILOGRAM * i, j, j / POUNDS_PER_KILOGRAM);
    }
  }
}
