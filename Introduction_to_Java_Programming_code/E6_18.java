
import java.util.Scanner;

public class E6_18
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = input.nextLine();

        StringBuilder result = new StringBuilder(" Password");
        result.insert(0, isValidPassword(password) ? "Valid" : "Invalid");

        System.out.println(result);
    }

    public static boolean isValidPassword(String password)
    {
        int letterCount = 0;
        int digitCount = 0;
        boolean isValid = true;
        for (int i = 0; i < password.length(); i++)
        {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c))
            {
                isValid = false;
                return isValid;
            }
            if (Character.isLetter(c))
            {
                letterCount++;
            }
            else
            {
                digitCount++;
            }
        }
        if (digitCount < 2 || (digitCount + letterCount) < 8 )
        {
            isValid = false;
        }
        return isValid;
    }
}
