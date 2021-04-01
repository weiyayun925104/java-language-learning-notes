// enums/Rock.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Rock implements Item {
  @Override public Outcome compete(Item it) {
    return it.eval(this);
  }
  @Override
  public Outcome eval(Paper p) { return Outcome.WIN; }
  @Override
  public Outcome eval(Scissors s) { return Outcome.LOSE; }
  @Override
  public Outcome eval(Rock r) { return Outcome.DRAW; }
  @Override public String toString() {
    return "Rock";
  }
}