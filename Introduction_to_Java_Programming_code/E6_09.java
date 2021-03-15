/*
  Write a class that contains the following two methods:

  public static double footToMeter(double foot)
  public static double meterToFoot(double meter)

  Write a test program that invokes these methods to display the following
  tables:

                              (tables)
*/

public class E6_09 {
  public static void main(String[] args) {
    System.out.println("Feet   Meters   |   Meters   Feet");
    for (int i = 1, j = 20; i <= 10; i++, j += 5) {
      double meters = footToMeter(i);
      double feet = meterToFoot(j);
      System.out.printf("%-4.1f   %-6.3f   |   %-6.1f   %-4.3f\n",
        (double)i, meters, (double)j, feet);
    }
  }

  public static double footToMeter(double foot) {
    return 0.305 * foot;
  }

  public static double meterToFoot(double meter) {
    return 3.279 * meter;
  }
}
