// enums/EnumSets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Operations on EnumSets
// {java enums.EnumSets}
import java.util.*;

public class EnumSets {
  public static void main(String[] args) {
    EnumSet<AlarmPoints> points =
      EnumSet.noneOf(AlarmPoints.class); // Empty
    points.add(AlarmPoints.BATHROOM);
    System.out.println(points);
    points.addAll(
      EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
    System.out.println(points);
    points = EnumSet.allOf(AlarmPoints.class);
    points.removeAll(
      EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
    System.out.println(points);
    points.removeAll(
      EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
    System.out.println(points);
    points = EnumSet.complementOf(points);
    System.out.println(points);
  }
}
/* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM,
UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4,
KITCHEN]
*/
