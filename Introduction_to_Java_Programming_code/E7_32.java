
import java.util.Scanner;

public class E7_32
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int[] list = getList(input);

        partition(list);
    }

    public static int partition(int[] list)
    {
        int[] partitionedList = new int[list.length];
        int pivot = list[0];
        int pivotIndex = 0;

        int leftMarker = 0;
        int rightMarker = list.length - 1;
        int listMarker = 1;

        while (leftMarker <= rightMarker)
        {
            if (leftMarker == rightMarker)
            {
                partitionedList[leftMarker] = pivot;
                pivotIndex = leftMarker;
                leftMarker++;
                rightMarker--;
            }
            else if (list[listMarker] <= pivot)
            {
                partitionedList[leftMarker] = list[listMarker];
                leftMarker++;
            }
            else
            {
                partitionedList[rightMarker] = list[listMarker];
                rightMarker--;
            }
            listMarker++;
        }

        displayList(partitionedList);
        return pivotIndex;
    }

    public static int[] getList(Scanner input)
    {
        System.out.print("Enter list: ");
        int[] list = new int[input.nextInt()];
        for (int i = 0; i < list.length; i++)
        {
            list[i] = input.nextInt();
        }
        return list;
    }

    public static void displayList(int[] list)
    {
        System.out.print("After the partition, the list is ");
        for (int n : list)
        {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
