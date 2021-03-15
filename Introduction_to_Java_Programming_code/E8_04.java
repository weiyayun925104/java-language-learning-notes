/*
  Suppose the weekly hours for all employees are stored in a two-dimensional
  array. Each row records an employee's seven-day work hours with seven columns.
  Write a program that displays employees and their total hours in decreasing
  order of the total hours.
*/

public class E8_04 {
  public static void main(String[] args) {
    int[][] weeklyHours = {
      {2, 4, 3, 4, 5, 8, 8},
      {7, 3, 4, 3, 3, 4, 4},
      {3, 3, 4, 3, 3, 2, 2},
      {9, 3, 4, 7, 3, 4, 1},
      {3, 5, 4, 3, 6, 3, 8},
      {3, 4, 4, 6, 3, 4, 4},
      {3, 7, 4, 8, 3, 8, 4},
      {6, 3, 5, 9, 2, 7, 9}
    };

    int[][] totalHours = getTotalHours(weeklyHours);
    bubbleSortDecreasing(totalHours);

    for (int i = 0; i < totalHours.length; i++) {
      System.out.println("Employee " + totalHours[i][0] + ": " +
        totalHours[i][1]);
    }
  }

  public static void bubbleSortDecreasing(int[][] array) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i][1] < array[i + 1][1]) {
          int[] temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }

  public static int[][] getTotalHours(int[][] hours) {
    int[][] totalHours = new int[hours.length][2];
    for (int i = 0; i < hours.length; i++) {
      int sum = 0;
      for (int j = 0; j < hours[i].length; j++) {
        sum += hours[i][j];
      }
      totalHours[i][0] = i;
      totalHours[i][1] = sum;
    }
    return totalHours;
  }
}
