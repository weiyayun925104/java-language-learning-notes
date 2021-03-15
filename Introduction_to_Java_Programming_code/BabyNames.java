import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BabyNames {
  private List<Map<String, String>> boyData;
  private List<Map<String, String>> girlData;

  public BabyNames() throws IOException {
    boyData = generateData("b");
    girlData = generateData("g");
  }

  public List<Map<String, String>> getBoyData() {
    return boyData;
  }

  public List<Map<String, String>> getGirlData() {
    return girlData;
  }

  private static List<Map<String, String>> generateData(String gender)
    throws IOException {
    List<Map<String, String>> array = new ArrayList<>();
    for (int i = 2001; i <= 2010; i++) {
      File file = new File("babynamesranking" + i + ".txt");
      Scanner input = new Scanner(file);
      Map<String, String> map = new HashMap<>();
      while (input.hasNext()) {
        if (gender.equals("b")) {
          // parse boy names
          String rank = input.next();
          String name = input.next();
          map.put(name, rank);
          for (int j = 0; j < 3; j++) { input.next(); } // skip unused data
        } else if (gender.equals("g")) {
          // parse girl names
          String rank = input.next();
          for (int j = 0; j < 2; j++) { input.next(); } // skip unused data
          String name = input.next();
          map.put(name, rank);
          input.next(); // skip unused data
        }
      }
      input.close();
      array.add(map);
    }
    return array;
  }
}
