public class MyInteger {
  private int value;

  public MyInteger() {
    this(0);
  }

  public MyInteger(int value) {
    this.value = value;
  }

  // getters
  public int getValue() {
    return value;
  }

  // instance methods
  public boolean isEven() {
    return getValue() % 2 == 0;
  }

  public boolean isOdd() {
    return !isEven();
  }

  public boolean isPrime() {
    int n = getValue();
    if (n == 2) { return true; }
    if (isEven() || n == 0 || n == 1) { return false; }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) { return false; }
    }
    return true;
  }

  public boolean equals(int n) {
    return getValue() == n;
  }

  public boolean equals(MyInteger n) {
    return getValue() == n.getValue();
  }

  // static methods
  public static boolean isEven(MyInteger n) {
    return n.isEven();
  }

  public static boolean isOdd(MyInteger n) {
    return n.isOdd();
  }

  public static boolean isPrime(MyInteger n) {
    return n.isPrime();
  }

  public static int parseInt(char[] c) {
    return parseInt(new String(c));
  }

  public static int parseInt(String s) {
    return Integer.parseInt(s);
  }
}
