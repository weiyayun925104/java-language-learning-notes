/*
  Rewrite Listing 21.7, CountKeywords.java, to read in a Java source code file
  and count the occurrence of each keyword in the file, but don't count the
  keyword if it is in a comment or a string literal.

  Note: this is a copy of E21_03.java
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class E21_10 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java E21_03 filename.java");
      System.exit(1);
    }

    File javaSource = new File(args[0]);

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

    try {
      System.out.println(countKeywords(javaSource));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static int countKeywords(File javaSource) throws IOException {
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

    Scanner input = new Scanner(javaSource);
    String code = "";
    while (input.hasNext()) {
      code += input.nextLine() + "\n";
    }
    input.close();

    code = code.replaceAll("(?s)/\\*.*\\*/", "");
    code = code.replaceAll("\".*\"", "");

    input = new Scanner(code);
    int count = 0;
    while (input.hasNext()) {
      String word = input.next();
      for (String keyword: keywordSet) {
        if (word.contains(keyword)) { count++; }
      }
    }
    input.close();

    return count;
  }
}
