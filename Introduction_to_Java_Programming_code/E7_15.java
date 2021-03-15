
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class E7_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextInt();
    }

    int[] uniques = eliminateDuplicates(nums);

    for (int n: uniques) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static int[] eliminateDuplicates(int[] list) {
    HashSet<Integer> nums = new HashSet<>();
    for (int i = 0; i < list.length; i++) {
      nums.add(list[i]);
    }
    int[] uniques = new int[nums.size()];
    int i = 0;
    for (int num: nums) {
      uniques[i] = num;
      ++i;
    }
    return uniques;
  }
}
