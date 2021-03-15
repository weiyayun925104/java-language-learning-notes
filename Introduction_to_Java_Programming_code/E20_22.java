/*
  Implement the moveDisks method in Listing 18.8 using a stack instead of
  recursion.
*/

import java.util.Scanner;
import java.util.Stack;

public class E20_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of disks: ");
    int n = input.nextInt();

    Stack<Integer> source = new Stack<>();
    Stack<Integer> auxiliary = new Stack<>();
    Stack<Integer> destination = new Stack<>();

    System.out.println("The moves are:");
    moveDiscs(n, source, auxiliary, destination);
  }

  public static void moveDiscs(int numDiscs, Stack<Integer> source,
    Stack<Integer> auxiliary, Stack<Integer> destination) {
    char s = 'S';
    char d = 'D';
    char a = 'A';

    if (numDiscs % 2 == 0) {
      char temp = d;
      d = a;
      a = temp;
    }

    int numberOfMoves = (int)(Math.pow(2, numDiscs)) - 1;

    for (int i = numDiscs; i >= 1; i--) {
      source.push(i);
    }

    for (int i = 1; i <= numberOfMoves; i++) {
      if (i % 3 == 1) {
        moveDiscsBetweenPoles(source, destination, s, d);
      } else if (i % 3 == 2) {
        moveDiscsBetweenPoles(source, auxiliary, s, a);
      } else if (i % 3 == 0) {
        moveDiscsBetweenPoles(auxiliary, destination, a, d);
      }
    }
  }

  public static void moveDiscsBetweenPoles(Stack<Integer> source,
    Stack<Integer> destination, char s, char d) {
    int topDisc1 = source.isEmpty() ? Integer.MIN_VALUE : source.pop();
    int topDisc2 =
      destination.isEmpty() ? Integer.MIN_VALUE : destination.pop();

    if (topDisc1 == Integer.MIN_VALUE) {
      source.push(topDisc2);
      moveDisc(d, s, topDisc2);
    } else if (topDisc2 == Integer.MIN_VALUE) {
      destination.push(topDisc1);
      moveDisc(s, d, topDisc1);
    } else if (topDisc1 > topDisc2) {
      source.push(topDisc1);
      source.push(topDisc2);
      moveDisc(d, s, topDisc2);
    } else {
      destination.push(topDisc2);
      destination.push(topDisc1);
      moveDisc(s, d, topDisc1);
    }
  }

  public static void moveDisc(char fromPeg, char toPeg, int disc) {
    System.out.println("Move the disc " + disc + " from " + fromPeg + " to " +
      toPeg);
  }
}
