
public class Rational extends Number implements Comparable<Rational> {
  private long[] r = new long[2];

  public Rational() {
    this(0, 1);
  }

  public Rational(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    r[0] = ((denominator > 0) ? 1: -1) * numerator / gcd;
    r[1] = Math.abs(denominator) / gcd;
  }

  private static long gcd(long n, long d) {
    long n1 = Math.abs(n);
    long n2 = Math.abs(d);
    int gcd = 1;

    for (int k = 1; k <= n1 && k <= n2; k++) {
      if (n1 % k == 0 && n2 % k == 0) {
        gcd = k;
      }
    }

    return gcd;
  }

  public long getNumerator() {
    return r[0];
  }

  public long getDenominator() {
    return r[1];
  }

  public Rational add(Rational secondRational) {
    long n = getNumerator() * secondRational.getDenominator() +
      getDenominator() * secondRational.getNumerator();
    long d = getDenominator() * secondRational.getDenominator();
    return new Rational(n, d);
  }

  public Rational subtract(Rational secondRational) {
    long n = getNumerator() * secondRational.getDenominator() -
      getDenominator() * secondRational.getNumerator();
    long d = getDenominator() * secondRational.getDenominator();
    return new Rational(n, d);
  }

  public Rational multiply(Rational secondRational) {
    long n = getNumerator() * secondRational.getNumerator();
    long d = getDenominator() * secondRational.getDenominator();
    return new Rational(n, d);
  }

  public Rational divide(Rational secondRational) {
    long n = getNumerator() * secondRational.getDenominator();
    long d = getDenominator() * secondRational.getNumerator();
    return new Rational(n, d);
  }

  public Rational not() {
    return new Rational(-r[0], r[1]);
  }

  @Override
  public String toString() {
    if (getDenominator() == 1) {
      return getNumerator() + "";
    } else {
      return getNumerator() + "/" + getDenominator();
    }
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((Rational)(other))).getNumerator() == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int intValue() {
    return (int)doubleValue();
  }

  @Override
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override
  public double doubleValue() {
    return getNumerator() * 1.0 / getDenominator();
  }

  @Override
  public long longValue() {
    return (long)doubleValue();
  }

  @Override
  public int compareTo(Rational o) {
    if (this.subtract(o).getNumerator() > 0) {
      return 1;
    } else if (this.subtract(o).getNumerator() < 0) {
      return -1;
    }
    return 0;
  }
}
