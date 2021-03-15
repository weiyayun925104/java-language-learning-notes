/*
  Write a program that converts a Java file into an HTML file. In the HTML file,
  the keywords, comments, and literals are displayed in bold navy, green, and
  blue, respectively. Use the command line to pass a Java file and an HTML
  file. For example, the following command

  java E21_05 Welcome.java Welcome.html

  converts Welcome.java into Welcome.html.

  Note: This solution only covers single-line comments (//), keywords,
        and String literals.
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class E21_05 {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java E21_05 filename.java filename.html");
      System.exit(1);
    }

    File javaSource = new File(args[0]);
    File htmlFile = new File(args[1]);

    if (!javaSource.exists()) {
      System.out.println(javaSource.getName() + " does not exist");
      System.exit(2);
    }

    if (!javaSource.isFile()) {
      System.out.println(javaSource.getName() + " is not a file");
      System.exit(3);
    }

    if (!javaSource.getName().endsWith(".java")) {
      System.out.println(javaSource.getName() + " is not a Java source file");
      System.exit(4);
    }

    if (!htmlFile.getName().endsWith(".html")) {
      System.out.println(htmlFile.getName() + " is not an HTML file");
      System.exit(5);
    }

    try {
      generateHTML(javaSource, htmlFile);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void generateHTML(
    File javaSource, File htmlFile) throws IOException {
    String[] keywordString = {
      "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
      "class", "const", "continue", "default", "do", "double", "else", "enum",
      "extends", "for", "final", "finally", "float", "goto", "if",
      "implements", "import", "instanceof", "int", "interface", "long",
      "native", "new", "package", "private", "protected", "public", "return",
      "short", "static", "strictfp", "super", "switch", "synchronized",
      "this", "throw", "throws", "transient", "try", "void", "volatile",
      "while", "true", "false", "null"
    };

    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

    StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE html>\n<html>\n<head>");
    html.append("<link rel=\"stylesheet\" type=\"text/css\" " +
      "href=\"java.css\">\n");
    html.append("<title>" + htmlFile.getName() + "</title>\n</head>\n");
    html.append("<body>\n<pre>\n");

    Scanner input = new Scanner(javaSource);

    while (input.hasNext()) {
      String line = input.nextLine() + "\n";
      if (line.startsWith("//")) {
        html.append("<span class=\"comment\">" + line + "</span>\n");
      } else {
        StringBuilder word = new StringBuilder();
        boolean openQuote = true;
        for (int i = 0; i < line.length(); i++) {
          char c = line.charAt(i);
          if (c == '\"') {
            if (openQuote) {
              word.append("<span class=\"literal\">" + c);
              openQuote = false;
            } else {
              word.append(c + "</span>");
              openQuote = true;
            }
          } else if (c == ' ' || c == '\n') {
            if (keywordSet.contains(word.toString())) {
              html.append("<span class=\"keyword\">" + word.toString() +
                "</span> ");
            } else {
              html.append(word.toString() + " ");
            }
            word = new StringBuilder();
          } else {
            word.append(Character.toString(c));
          }
        }
        html.append("\n");
      }
    }

    input.close();

    html.append("</pre>\n</body>\n</html>");

    PrintWriter output = new PrintWriter(htmlFile);
    output.print(html.toString());
    output.close();
  }
}
