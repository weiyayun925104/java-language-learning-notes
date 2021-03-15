public class Circle2D {
  private double x;
  private double y;
  private double radius;

  public Circle2D() {
    this(0, 0, 1);
  }

  public Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  public boolean contains(double x, double y) {
    return distance(this.x, this.y, x, y) <= radius;
  }

  public boolean contains(Circle2D circle) {
    double x1 = getX();
    double y1 = getY();
    double x2 = circle.getX();
    double y2 = circle.getY();
    return distance(x1, y1, x2, y2) + circle.getRadius() <= getRadius();
  }

  public boolean overlaps(Circle2D circle) {
    double x1 = getX();
    double y1 = getY();
    double x2 = circle.getX();
    double y2 = circle.getY();
    return distance(x1, y1, x2, y2) <= (getRadius() + circle.getRadius());
  }

  private static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getRadius() {
    return radius;
  }
}
