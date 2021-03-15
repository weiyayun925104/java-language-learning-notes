public class LinearEquation {
  private double a, b, c, d, e, f;

  public LinearEquation(double a, double b, double c, double d, double e,
    double f) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.f = f;
  }

  // getters
  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }

  public double getC() {
    return c;
  }

  public double getD() {
    return d;
  }

  public double getE() {
    return e;
  }

  public double getF() {
    return f;
  }

  // instance methods
  public boolean isSolvable() {
    return getA() * getD() - getB() * getC() != 0;
  }

  public double getX() {
    return (getE() * getD() - getB() * getF()) /
           (getA() * getD() - getB() * getC());
  }

  public double getY() {
    return (getA() * getF() - getE() * getC()) /
           (getA() * getD() - getB() * getC());
  }
}
