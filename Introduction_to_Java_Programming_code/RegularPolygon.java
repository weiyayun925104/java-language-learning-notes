public class RegularPolygon {
  private int n;
  private double side;
  private double x;
  private double y;

  public RegularPolygon() {
    this(3, 1, 0, 0);
  }

  public RegularPolygon(int n, double side) {
    this(n, side, 0, 0);
  }

  public RegularPolygon(int n, double side, double x, double y) {
    this.n = n;
    this.side = side;
    this.x = x;
    this.y = y;
  }

  // getters
  public int getN() {
    return n;
  }

  public double getSide() {
    return side;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // setters
  public void setN(int n) {
    this.n = n;
  }

  public void setSide(double side) {
    this.side = side;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  // instance methods
  public double getPerimeter() {
    return getN() * getSide();
  }

  public double getArea() {
    return (getN() * getSide() * getSide()) /
      (4 * Math.tan(Math.PI / getN()));
  }
}
