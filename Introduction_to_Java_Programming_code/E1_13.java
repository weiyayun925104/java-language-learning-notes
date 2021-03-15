/*
  You can use Cramer's rule to solve the following 2x2 system of linear
  equation:

  ax + by = e
  cx + dy = f
  x = (ed - bf) / (ad - bc)
  y = (af - ec) / (ad - bc)

  Write a program that solves the following equation and displays the value
  for x and y:

  3.4x + 50.2y = 44.5
  2.1x + 0.55y = 5.9
*/

public class E1_13 {
  public static void main(String[] args) {
    cramer(3.4, 50.2, 2.1, 0.55, 44.5, 5.9);
  }

  private static void cramer(double a, double b, double c, double d, double e,
    double f) {
    double x = (e * d - b * f) / (a * d - b * c);
    double y = (a * f - e * c) / (a * d - b * c);
    System.out.println("x: " + x + " y: " + y);
  }
}
