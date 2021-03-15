
public class E6_24
{
    public static void main(String[] args)
    {
        long totalMilliseconds = System.currentTimeMillis();

        String output = getDate(totalMilliseconds) + " " + getTime(totalMilliseconds);

        System.out.println("Current date and time is " + output);
    }

    private static String getDate(long millis)
    {
        long[] yearAndRemainingDays = getYear(getDays(millis));
        long year = yearAndRemainingDays[0];
        long remainingDays = yearAndRemainingDays[1];
        long[] monthAndRemainingDays = getMonth(remainingDays, year);
        String month = getMonthName(monthAndRemainingDays[0]);
        long day = monthAndRemainingDays[1];
        day++;
        return month + " " + day + ", " + year;
    }

    private static long[] getMonth(long days, long year)
    {
        // Returns a long array containing the month at index 0
        // and remaining days at index 1
        int month = 1;
        long totalDays = getDaysInMonth(month, year);
        while (days >= totalDays)
        {
            days -= totalDays;
            month++;
            totalDays = getDaysInMonth(month, year);
        }
        long[] monthAndDaysLeft = {month, days};
        return monthAndDaysLeft;
    }

    private static long[] getYear(long days)
    {
        // Returns a long array containing the year at index 0
        // and remaining days at index 1
        int yearCount = 1970;
        long totalDays = (isLeapYear(yearCount) ? 366 : 365);
        while (days >= totalDays)
        {
            days -= totalDays;
            yearCount++;
            totalDays = (isLeapYear(yearCount) ? 366 : 365);
        }
        long[] yearAndDaysLeft = {yearCount, days};
        return yearAndDaysLeft;
    }

    private static long getDays(long millis)
    {
        return millis / 86_400_000;
    }

    private static String getTime(long millis)
    {
        long totalSeconds = millis / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
        return currentHour + ":" + currentMinute + ":" + currentSecond;
    }

    private static boolean isLeapYear(long year)
    {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static int getDaysInMonth(int m, long y)
    {
        int days;
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            days = 31;
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            days = 30;
        }
        else
        {
            days = isLeapYear(y) ? 29 : 28;
        }
        return days;
    }

    private static String getMonthName(long m)
    {
        StringBuilder s = new StringBuilder();
        switch ((int)m)
        {
        case 1:
            s.append("January");
            break;
        case 2:
            s.append("February");
            break;
        case 3:
            s.append("March");
            break;
        case 4:
            s.append("April");
            break;
        case 5:
            s.append("May");
            break;
        case 6:
            s.append("June");
            break;
        case 7:
            s.append("July");
            break;
        case 8:
            s.append("August");
            break;
        case 9:
            s.append("September");
            break;
        case 10:
            s.append("October");
            break;
        case 11:
            s.append("November");
            break;
        case 12:
            s.append("December");
        }
        return s.toString();
    }
}
