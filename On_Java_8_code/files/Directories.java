
import java.util.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

class RmDir {
  public static void rmdir(Path dir)
  throws IOException {
    Files.walkFileTree(dir,
      new SimpleFileVisitor<Path>() {
      @Override public FileVisitResult
      visitFile(Path file, BasicFileAttributes attrs)
      throws IOException {
        System.out.println("visitFile() " + file.toRealPath());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }
      @Override public FileVisitResult
      postVisitDirectory(Path dir, IOException exc)
      throws IOException {
        System.out.println("postVisitDirectory() " + dir.toRealPath());
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
      }
    });
  }
}

public class Directories {
  static Path test = Paths.get("test");
  static String sep =
    FileSystems.getDefault().getSeparator();
  static List<String> parts =
    Arrays.asList("foo", "bar", "baz", "bag");
  static Path makeVariant() {
    Collections.rotate(parts, 1);
    return Paths.get("test", String.join(sep, parts));
  }
  static void refreshTestDir() throws Exception {
    if(Files.exists(test))
      RmDir.rmdir(test);
    if(!Files.exists(test))
      Files.createDirectory(test);
  }
  public static void
  main(String[] args) throws Exception {
    refreshTestDir();
    Files.createFile(test.resolve("Hello.txt"));
    Path variant = makeVariant();
    // Throws exception (too many levels):
    try {
      Files.createDirectory(variant);
    } catch(Exception e) {
      System.out.println("Nope, that doesn't work.");
    }
    populateTestDir();
    Path tempdir =
      Files.createTempDirectory(test, "DIR_");
    Files.createTempFile(tempdir, "pre", ".non");
    Files.newDirectoryStream(test)
      .forEach(System.out::println);
    System.out.println("*********");
    Files.walk(test).forEach(System.out::println);
  }
  static void populateTestDir() throws Exception {
    for(int i = 0; i < parts.size(); i++) {
      Path variant = makeVariant();
      if(!Files.exists(variant)) {
        Files.createDirectories(variant);
        Path tempFile = Paths.get("Directories.java");
        System.out.println(tempFile.toRealPath());
        Files.copy(tempFile,
          variant.resolve("File.txt"));
        Files.createTempFile(variant, null, null);
      }
    }
  }
}
