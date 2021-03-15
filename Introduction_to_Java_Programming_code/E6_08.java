/*
  Write a class that contains the following two methods:

  public static double celsiusToFahrenheit(double celsius)
  public static double fahrenheitToCelsius(double fahrenheit)

  Write a test program that invokes these methods to display the following
  tables:

                            (tables)
*/

public class E6_08 {
  public static void main(String[] args) {
    System.out.println("Celsius   Fahrenheit   |   Fahrenheit   Celsius");
    for (int i = 40, j = 120; i >= 31; i--, j -= 10) {
      double fahrenheit = celsiusToFahrenheit(i);
      double celsius = fahrenheitToCelsius(j);
      System.out.printf("%-7.1f   %-10.1f   |   %-10.1f   %-7.2f\n",
        (double)i, fahrenheit, (double)j, celsius);
    }
    System.out.println();
  }

  public static double celsiusToFahrenheit(double celsius) {
    return (9.0 / 5) * celsius + 32;
  }

  public static double fahrenheitToCelsius(double fahrenheit) {
    return (5.0 / 9) * (fahrenheit - 32);
  }
}
