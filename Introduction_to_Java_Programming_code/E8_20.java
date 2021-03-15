
import java.util.Scanner;

public class E8_20
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        startGame(input);
    }

    public static int startGame(Scanner input)
    {
        int[][] board = getNewBoard();
        int gameStatus; // 1 = winner, 0 = continue, -1 = tie
        boolean redTurn = true;

        do
        {
            gameStatus = 0;
            String token = redTurn ? "red" : "yellow";

            displayBoard(board);

            // get input
            int row;
            int column;
            do
            {
                System.out.print("Enter a row (0-5) for player " + token + ": ");
                row = input.nextInt();
                System.out.print("Enter a column (0-6) for player " + token + ": ");
                column = input.nextInt();
            }
            while ((row > 5 || row < 0) || (column > 6 || column < 0) || (board[row][column] != -1));

            board[row][column] = redTurn ? 1 : 0;

            if (isConsecutiveFour(redTurn ? 1 : 0, board))
            {
                displayBoard(board);
                System.out.println("The " + token + " player won");
                gameStatus = 1;
            }
            else if (isDrawGame(board))
            {
                displayBoard(board);
                System.out.println("Draw game");
                gameStatus = -1;
            }
            else
            {
                redTurn = !redTurn;
            }

        }
        while (gameStatus == 0);

        return gameStatus;
    }

    public static boolean isDrawGame(int[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == -1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] getNewBoard()
    {
        int[][] board = new int[6][7];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = -1;
            }
        }
        return board;
    }

    public static void displayBoard(int[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.println("---------------");
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == 1)
                {
                    System.out.print("|R");
                }
                else if (board[i][j] == 0)
                {
                    System.out.print("|Y");
                }
                else
                {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    public static boolean isConsecutiveFour(int player, int[][] board)
    {
        int count;

        // check rows
        for (int i = 0; i < board.length; i++)
        {
            count = 0;
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count >= 4)
                {
                    return true;
                }
            }
        }

        // check columns
        for (int i = 0; i < board[0].length; i++)
        {
            count = 0;
            for (int j = 0; j < board.length; j++)
            {
                if (board[j][i] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count == 4)
                {
                    return true;
                }
            }
        }

        // check left-rising diagonals
        for (int i = 0; i < board.length; i++)
        {
            count = 0;
            for (int j = i, k = 0; j < board.length && k < board[j].length; j++, k++)
            {
                if (board[j][k] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count == 4)
                {
                    return true;
                }
            }
        }

        for (int i = 1; i < board[0].length; i++)
        {
            count = 0;
            for (int j = 0, k = i; j < board.length && k < board[j].length; j++, k++)
            {
                if (board[j][k] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count == 4)
                {
                    return true;
                }
            }
        }

        // check right-rising diagonals
        for (int i = 0; i < board.length; i++)
        {
            count = 0;
            for (int j = i, k = board[i].length - 1; j < board.length && k >= 0; j++, k--)
            {
                if (board[j][k] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count == 4)
                {
                    return true;
                }
            }
        }

        for (int i = board[0].length - 2; i >= 0; i--)
        {
            count = 0;
            for (int j = 0, k = i; j < board.length && k >= 0; j++, k--)
            {
                if (board[j][k] == player)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
                if (count == 4)
                {
                    return true;
                }
            }
        }

        return false;
    }

}
