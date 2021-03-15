
import java.util.Scanner;

public class E18_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter two integers: ");
    int m = input.nextInt();
    int n = input.nextInt();

    System.out.println(gcd( Math.abs(m), Math.abs(n) ));
  }

  public static int gcd(int m, int n) {
    if (m % n == 0) { return n; }
    return gcd(n, m % n);
  }
}
