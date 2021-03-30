// arrays/StringSorting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Sorting an array of Strings
import java.util.*;

public class StringSorting {
  public static void main(String[] args) {
    String[] sa = new Rand.String().array(20);
    ArrayShow.show("Before sort", sa);
    Arrays.sort(sa);
    ArrayShow.show("After sort", sa);
    Arrays.sort(sa, Collections.reverseOrder());
    ArrayShow.show("Reverse sort", sa);
    Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
    ArrayShow.show("Case-insensitive sort", sa);
  }
}
/* Output:
Before sort: [btpenpc, cuxszgv, gmeinne, eloztdv,
ewcippc, ygpoalk, ljlbynx, taprwxz, bhmupju, cjwzmmr,
anmkkyh, fcjpthl, skddcat, jbvlgwc, mvducuj, ydpulcq,
zehpfmm, zrxmclh, qgekgly, hyoubzl]
After sort: [anmkkyh, bhmupju, btpenpc, cjwzmmr,
cuxszgv, eloztdv, ewcippc, fcjpthl, gmeinne, hyoubzl,
jbvlgwc, ljlbynx, mvducuj, qgekgly, skddcat, taprwxz,
ydpulcq, ygpoalk, zehpfmm, zrxmclh]
Reverse sort: [zrxmclh, zehpfmm, ygpoalk, ydpulcq,
taprwxz, skddcat, qgekgly, mvducuj, ljlbynx, jbvlgwc,
hyoubzl, gmeinne, fcjpthl, ewcippc, eloztdv, cuxszgv,
cjwzmmr, btpenpc, bhmupju, anmkkyh]
Case-insensitive sort: [anmkkyh, bhmupju, btpenpc,
cjwzmmr, cuxszgv, eloztdv, ewcippc, fcjpthl, gmeinne,
hyoubzl, jbvlgwc, ljlbynx, mvducuj, qgekgly, skddcat,
taprwxz, ydpulcq, ygpoalk, zehpfmm, zrxmclh]
*/
