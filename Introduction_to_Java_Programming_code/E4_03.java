/*
  Find the GPS locations for Atlanta, Georgia; Orlando, Florida; Savannah,
  Georgia; and Charlotte, North Carolina from (link) and compute the estimated
  area enclosed by these four cities.
*/

public class E4_03 {
  public static void main(String[] args) {
    Location atlanta = new Location(33.7405800, -84.5545400);
    Location orlando = new Location(28.4115300, -81.5250400);
    Location savannah = new Location(32.1672300, -81.1998900);
    Location charlotte = new Location(35.2072400, -80.9567600);

    double area = Location.areaOfThreeLocs(atlanta, charlotte, savannah) +
      Location.areaOfThreeLocs(atlanta, savannah, orlando);

    System.out.println("The area enclosed by the cities of Atlanta (GA), " +
      "Orlando (FL), Savannah (GA), and Charlotte (NC) is " + area + " sq km");
  }

  private static class Location {
    private double lat;
    private double lon;

    public Location(double lat, double lon) {
      this.lat = lat;
      this.lon = lon;
    }

    public double getLat() {
      return lat;
    }

    public double getLon() {
      return lon;
    }

    public static double gcDistance(Location a, Location b) {
      double x1 = Math.toRadians(a.getLat());
      double y1 = Math.toRadians(a.getLon());
      double x2 = Math.toRadians(b.getLat());
      double y2 = Math.toRadians(b.getLon());

      final double RADIUS = 6371.01;
      double d = RADIUS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) *
        Math.cos(x2) * Math.cos(y1 - y2));

      return d;
    }

    public static double areaOfThreeLocs(Location a, Location b, Location c) {
      double s1 = gcDistance(a, b);
      double s2 = gcDistance(b, c);
      double s3 = gcDistance(c, a);
      double s = (s1 + s2 + s3) / 2.0;
      return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
  }
}
