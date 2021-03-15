import java.io.IOException;

public class TestBabyNames {
  public static void main(String[] args) throws IOException {
    BabyNames bn = new BabyNames();

    System.out.println(bn.getBoyData().get(0).get("Michael"));
    System.out.println(bn.getGirlData().get(5).get("Hannah"));
  }
}
