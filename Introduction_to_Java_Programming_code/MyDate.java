import java.util.GregorianCalendar;

public class MyDate {
  private int year;
  private int month;  // 0-based
  private int day;

  public MyDate() {
    this(System.currentTimeMillis());
  }

  public MyDate(long elapsedTime) {
    this(calendarForTime(elapsedTime).get(GregorianCalendar.YEAR),
         calendarForTime(elapsedTime).get(GregorianCalendar.MONTH),
         calendarForTime(elapsedTime).get(GregorianCalendar.DAY_OF_MONTH));
  }

  public MyDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public void setDate(long elapsedTime) {
    GregorianCalendar g = calendarForTime(elapsedTime);
    year = g.get(GregorianCalendar.YEAR);
    month = g.get(GregorianCalendar.MONTH);
    day = g.get(GregorianCalendar.DAY_OF_MONTH);
  }

  public static GregorianCalendar calendarForTime(long elapsedTime) {
    GregorianCalendar g = new GregorianCalendar();
    g.setTimeInMillis(elapsedTime);
    return g;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public String toString() {
    // add 1 to month, since it is 0-based
    return (month + 1) + "/" + day + "/" + year;
  }
}
