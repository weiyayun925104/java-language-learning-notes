public class Fan {
  final static int SLOW = 1;
  final static int MEDIUM = 2;
  final static int FAST = 3;

  private int speed;
  private boolean on;
  private double radius;
  private String color;

  public Fan() {
    speed = SLOW;
    on = false;
    radius = 5.0;
    color = "blue";
  }

  // getters
  public int getSpeed() {
    return speed;
  }

  public boolean isOn() {
    return on;
  }

  public double getRadius() {
    return radius;
  }

  public String getColor() {
    return color;
  }

  // setters
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setOn(boolean on) {
    this.on = on;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public void setColor(String color) {
    this.color = color;
  }

  // instance methods
  public String toString() {
    return "speed: " + getSpeed() + "\n" +
           "color: " + getColor() + "\n" +
           "radius: " + getRadius() + "\n" +
           (isOn() ? "" : "fan is off");
  }
}
