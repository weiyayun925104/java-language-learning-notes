public class QuadraticEquation {
  private double a;
  private double b;
  private double c;

  public QuadraticEquation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
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

  // instance methods
  public double getDiscriminant() {
    return (getB() * getB()) - (4 * getA() * getC());
  }

  public double getRoot1() {
    if (getDiscriminant() < 0) { return 0; }
    return (-getB() + Math.sqrt(getDiscriminant())) / (2 * getA());
  }

  public double getRoot2() {
    if (getDiscriminant() < 0) { return 0; }
    return (-getB() - Math.sqrt(getDiscriminant())) / (2 * getA());
  }
}
