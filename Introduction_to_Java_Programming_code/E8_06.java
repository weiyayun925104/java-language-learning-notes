
import java.util.Scanner;

public class E8_06
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double[][] a = readMatrix("matrix1", input);
        double[][] b = readMatrix("matrix2", input);
        double[][] product = multiplyMatrix(a, b);

        displayMatrix(a);
        System.out.println("*");
        displayMatrix(b);
        System.out.println("=");
        displayMatrix(product);
    }

    public static void displayMatrix(double[][] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                System.out.printf("%3.1f ", a[i][j]);
            }
            System.out.println();
        }
    }

    public static double[][] readMatrix(String name, Scanner input)
    {
        System.out.print("Enter " + name + ": ");
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] multiplyMatrix(double[][] a, double[][] b)
    {
        if (a[0].length != b.length)
        {
            System.out.println("No. of columns in A must be the same as the " + "no. of rows in B");
            System.exit(1);
        }

        double[][] result = new double[a.length][b[0].length];

        // for each row in a
        for (int i = 0; i < a.length; i++)
        {
            for (int k = 0; k < b[i].length; k++)
            {
                double sum = 0.0;
                for (int j = 0; j < a[0].length; j++)
                {
                    sum += a[i][j] * b[j][k];
                }
                result[i][k] = sum;
            }
        }

        return result;
    }
}
