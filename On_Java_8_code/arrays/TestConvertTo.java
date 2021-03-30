// arrays/TestConvertTo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

public class TestConvertTo {
  static final int SIZE = 6;
  public static void main(String[] args) {
    Boolean[] a1 = new Boolean[SIZE];
    Arrays.setAll(a1, new Rand.Boolean()::get);
    boolean[] a1p = ConvertTo.primitive(a1);
    ArrayShow.show("a1p", a1p);
    Boolean[] a1b = ConvertTo.boxed(a1p);
    ArrayShow.show("a1b", a1b);

    Byte[] a2 = new Byte[SIZE];
    Arrays.setAll(a2, new Rand.Byte()::get);
    byte[] a2p = ConvertTo.primitive(a2);
    ArrayShow.show("a2p", a2p);
    Byte[] a2b = ConvertTo.boxed(a2p);
    ArrayShow.show("a2b", a2b);

    Character[] a3 = new Character[SIZE];
    Arrays.setAll(a3, new Rand.Character()::get);
    char[] a3p = ConvertTo.primitive(a3);
    ArrayShow.show("a3p", a3p);
    Character[] a3b = ConvertTo.boxed(a3p);
    ArrayShow.show("a3b", a3b);

    Short[] a4 = new Short[SIZE];
    Arrays.setAll(a4, new Rand.Short()::get);
    short[] a4p = ConvertTo.primitive(a4);
    ArrayShow.show("a4p", a4p);
    Short[] a4b = ConvertTo.boxed(a4p);
    ArrayShow.show("a4b", a4b);

    Integer[] a5 = new Integer[SIZE];
    Arrays.setAll(a5, new Rand.Integer()::get);
    int[] a5p = ConvertTo.primitive(a5);
    ArrayShow.show("a5p", a5p);
    Integer[] a5b = ConvertTo.boxed(a5p);
    ArrayShow.show("a5b", a5b);

    Long[] a6 = new Long[SIZE];
    Arrays.setAll(a6, new Rand.Long()::get);
    long[] a6p = ConvertTo.primitive(a6);
    ArrayShow.show("a6p", a6p);
    Long[] a6b = ConvertTo.boxed(a6p);
    ArrayShow.show("a6b", a6b);

    Float[] a7 = new Float[SIZE];
    Arrays.setAll(a7, new Rand.Float()::get);
    float[] a7p = ConvertTo.primitive(a7);
    ArrayShow.show("a7p", a7p);
    Float[] a7b = ConvertTo.boxed(a7p);
    ArrayShow.show("a7b", a7b);

    Double[] a8 = new Double[SIZE];
    Arrays.setAll(a8, new Rand.Double()::get);
    double[] a8p = ConvertTo.primitive(a8);
    ArrayShow.show("a8p", a8p);
    Double[] a8b = ConvertTo.boxed(a8p);
    ArrayShow.show("a8b", a8b);
  }
}
/* Output:
a1p: [true, false, true, true, true, false]
a1b: [true, false, true, true, true, false]
a2p: [123, 33, 101, 112, 33, 31]
a2b: [123, 33, 101, 112, 33, 31]
a3p: [b, t, p, e, n, p]
a3b: [b, t, p, e, n, p]
a4p: [635, 8737, 3941, 4720, 6177, 8479]
a4b: [635, 8737, 3941, 4720, 6177, 8479]
a5p: [635, 8737, 3941, 4720, 6177, 8479]
a5b: [635, 8737, 3941, 4720, 6177, 8479]
a6p: [6882, 3765, 692, 9575, 4439, 2638]
a6b: [6882, 3765, 692, 9575, 4439, 2638]
a7p: [4.83, 2.89, 2.9, 1.97, 3.01, 0.18]
a7b: [4.83, 2.89, 2.9, 1.97, 3.01, 0.18]
a8p: [4.83, 2.89, 2.9, 1.97, 3.01, 0.18]
a8b: [4.83, 2.89, 2.9, 1.97, 3.01, 0.18]
*/
