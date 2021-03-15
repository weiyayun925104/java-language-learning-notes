/*
  Modify Listing 18.8, TowerOfHanoi.java, so that the program finds the number
  of moves needed to move n disks from tower A to tower B.
*/

import java.util.Scanner;

public class E18_18 {
  public static int countCalls = 0;

  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.print("Enter number of disks: ");
  int n = input.nextInt();

  System.out.println("The moves are:");
  moveDisks(n, 'A', 'B', 'C');

  System.out.println("moveDisks() called " + countCalls + " times");
}

public static void moveDisks(int n, char fromTower, char toTower,
  char auxTower) {
  countCalls++;
  if (n == 1) {
    System.out.println("Move disk " + n + " from " + fromTower + " to " +
      toTower);
  } else {
    moveDisks(n - 1, fromTower, auxTower, toTower);
    System.out.println("Move disk " + n + " from " + fromTower + " to " +
      toTower);
    moveDisks(n - 1, auxTower, toTower, fromTower);
  }
}
}
