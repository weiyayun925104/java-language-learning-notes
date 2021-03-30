
import java.lang.reflect.*;
import java.util.*;
import java.io.*;

class OSExecuteException extends RuntimeException {
  public OSExecuteException(String why) {
    super(why);
  }
}

class OSExecute {
  public static void command(String command) {
    boolean err = false;
    try {
      Process process = new ProcessBuilder(
        command.split(" ")).start();
      try(
        BufferedReader results = new BufferedReader(
          new InputStreamReader(
            process.getInputStream()));
        BufferedReader errors = new BufferedReader(
          new InputStreamReader(
            process.getErrorStream()));
      ) {
        results.lines()
          .forEach(System.out::println);
        err = errors.lines()
          .peek(System.err::println)
          .count() > 0;
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    if(err)
      throw new OSExecuteException(
        "Errors executing " + command);
  }
}

enum Explore { HERE, THERE }

public class Reflection {
  public static
  Set<String> analyze(Class<?> enumClass) {
    System.out.println(
      "_____ Analyzing " + enumClass + " _____");
    System.out.println("Interfaces:");
    for(Type t : enumClass.getGenericInterfaces())
      System.out.println(t);
    System.out.println(
      "Base: " + enumClass.getSuperclass());
    System.out.println("Methods: ");
    Set<String> methods = new TreeSet<>();
    for(Method m : enumClass.getMethods())
      methods.add(m.getName());
    System.out.println(methods);
    return methods;
  }
  public static void main(String[] args) {
    Set<String> exploreMethods =
      analyze(Explore.class);
    Set<String> enumMethods = analyze(Enum.class);
    System.out.println(
      "Explore.containsAll(Enum)? " +
      exploreMethods.containsAll(enumMethods));
    System.out.print("Explore.removeAll(Enum): ");
    exploreMethods.removeAll(enumMethods);
    System.out.println(exploreMethods);
    // Decompile the code for the enum:
    OSExecute.command(
      "javap -c -p Explore");
  }
}