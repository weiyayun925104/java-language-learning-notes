
import java.util.ArrayList;

public class E7_06
{
    public static void main(String[] args)
    {
        final int NUMBER_OF_PRIMES = 50;
        final int NUMBER_OF_PRIMES_PER_LINE = 10;
        int count = 0;
        int number = 2;
        ArrayList<Integer> primes = new ArrayList<>();

        System.out.println("The first 50 prime numbers are \n");

        while (count < NUMBER_OF_PRIMES)
        {
            boolean isPrime = true;

            for (int i = 0; i < primes.size() && primes.get(i) <= Math.sqrt(number); i++)
            {
                if (number % primes.get(i) == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                count++;
                primes.add(number);

                if (count % NUMBER_OF_PRIMES_PER_LINE == 0)
                {
                    System.out.println(number);
                }
                else
                {
                    System.out.print(number + " ");
                }
            }

            number++;
        }
    }
}
