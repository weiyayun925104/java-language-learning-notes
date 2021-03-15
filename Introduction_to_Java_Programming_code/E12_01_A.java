/*
  Listing 7.9, Calculator.java, is a simple commandline calculator. Note that
  the program terminates if any operand is nonnumeric. Write a program with an
  exception handler that deals with nonnumeric operands.
*/

public class E12_01_A {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java E12_01_A operand1 operator operand2");
      System.exit(1);
    }

    try {
      Integer.parseInt(args[0]);
    } catch (Exception e) {
      displayInputError(args[0]);
      System.exit(2);
    }

    try {
      Integer.parseInt(args[2]);
    } catch (Exception e) {
      displayInputError(args[2]);
      System.exit(3);
    }

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[2]);

    int result = 0;

    switch (args[1].charAt(0)) {
      case '+': result = a + b; break;
      case '-': result = a - b; break;
      case '.': result = a * b; break;
      case '/': result = a / b;
    }

    System.out.println(a + " " + args[1] + " " + b +
      " = " + result);
  }

  public static void displayInputError(String arg) {
    System.out.println("Wrong input: " + arg);
  }
}
