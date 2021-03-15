
public class E6_26
{
    public static void main(String[] args)
    {
        final int PRIMES_PER_LINE = 10;
        int count = 0;
        for (int i = 2; count < 100; i++)
        {
            if (isPrime(i) && isPalindrome(i))
            {
                System.out.printf("%5d ", i);
                count++;
                if (count % PRIMES_PER_LINE == 0)
                {
                    System.out.println();
                }
            }
        }
    }

    public static boolean isPalindrome(int number)
    {
        return number == reverse(number);
    }

    public static int reverse(int number)
    {
        StringBuilder s = new StringBuilder(number + "");
        s = s.reverse();
        return Integer.parseInt(s.toString());
    }

    public static boolean isPrime(int n)
    {
        if (n < 2)
        {
            return false;
        }
        if (n == 2)
        {
            return true;
        }
        if (n % 2 == 0)
        {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
