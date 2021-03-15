public class Time {
  private int hour;
  private int minute;
  private int second;

  public Time() {
    this(System.currentTimeMillis());
  }

  public Time(long elapsedTime) {
    this((int)(elapsedTime / 3600000) % 24, (int)(elapsedTime / 60000) % 60,
      (int)(elapsedTime / 1000) % 60);
  }

  public Time(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  // getters
  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }

  // instance methods
  public void setTime(long elapseTime) {
    hour = (int)((elapseTime / 3600000) % 24);
    minute = (int)((elapseTime / 60000) % 60);
    second = (int)((elapseTime / 1000) % 60);
  }

  @Override
  public String toString() {
    return hour + ":" + minute + ":" + second;
  }
}
