
public class E13_16 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java E13_16 \"operand1 operator operand2\"");
      System.exit(1);
    }

    if (!args[0].matches("\\d+/\\d+\\s+[+\\-*\\/]\\s+\\d+/\\d+")) {
      System.out.println("Incorrect expression format");
      System.exit(2);
    }

    String[] components = parseCalcInput(args[0]);
    Rational a = new Rational(Long.parseLong(components[0]),
      Long.parseLong(components[1]));
    Rational b = new Rational(Long.parseLong(components[2]),
      Long.parseLong(components[3]));
    Rational result = new Rational();

    switch (components[4].charAt(0)) {
      case '+': result = a.add(b); break;
      case '-': result = a.subtract(b); break;
      case '*': result = a.multiply(b); break;
      case '/': result = a.divide(b);
    }

    System.out.println(a + " " + components[4] + " " + b +
      " = " + result);
  }

  public static String[] parseCalcInput(String s) {
    String[] expressionComponents = s.split("\\s+");
    String[] firstRational = expressionComponents[0].split("/");
    String[] secondRational = expressionComponents[2].split("/");
    return new String[]{firstRational[0], firstRational[1],
      secondRational[0], secondRational[1], expressionComponents[1]};
  }
}
