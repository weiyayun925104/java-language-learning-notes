
public class Complex implements Cloneable {
  private double a;
  private double b;

  public Complex() {
    this(0, 0);
  }

  public Complex(double a) {
    this(a, 0);
  }

  public Complex(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double getRealPart() {
    return a;
  }

  public double getImaginaryPart() {
    return b;
  }

  public Complex add(Complex c) {
    double r = (a + c.getRealPart());
    double i = (b + c.getImaginaryPart());
    return new Complex(r, i);
  }

  public Complex subtract(Complex c) {
    double r = (a - c.getRealPart());
    double i = (b - c.getImaginaryPart());
    return new Complex(r, i);
  }

  public Complex multiply(Complex c) {
    double r = (a * c.getRealPart()) - (b * c.getImaginaryPart());
    double i = (b * c.getRealPart()) + (a * c.getImaginaryPart());
    return new Complex(r, i);
  }

  public Complex divide(Complex c) {
    double r = (a * c.getRealPart() + b * c.getImaginaryPart()) /
      (c.getRealPart() * c.getRealPart() +
       c.getImaginaryPart() * c.getImaginaryPart());
    double i = (b * c.getRealPart() - a * c.getImaginaryPart()) /
      (c.getRealPart() * c.getRealPart() +
       c.getImaginaryPart() * c.getImaginaryPart());
    return new Complex(r, i);
  }

  public double abs() {
    return Math.sqrt(a * a + b * b);
  }

  @Override
  public String toString() {
    if (b > 0 || b < 0) {
      return a + " + " + b + "i";
    }
    return a + "";
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    Complex myComplexClone = new Complex(this.getRealPart(), this.getImaginaryPart());
    return myComplexClone;
  }
}