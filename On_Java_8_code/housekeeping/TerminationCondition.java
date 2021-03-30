

import java.util.concurrent.*;

class Book
{
    boolean checkedOut = false;
    Book(boolean checkOut)
    {
        checkedOut = checkOut;
    }
    void checkIn()
    {
        checkedOut = false;
    }
    @SuppressWarnings("deprecation")
    @Override public void finalize()
    {
        if(checkedOut)
            System.out.println("Error: checked out");
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }
}

public class TerminationCondition
{
    public static void main(String[] args)
    {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
        timedDelay(1, "timedDelay end"); // One second delay
    }

    public static void timedDelay(double t, String msg)
    {
        try
        {
            System.out.println("begin");
            TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println(msg);
    }

}
