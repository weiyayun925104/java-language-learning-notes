// enums/RoShamBo3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using constant-specific methods
// {java enums.RoShamBo3}

public enum RoShamBo3 implements Competitor<RoShamBo3> {
  PAPER {
    @Override public Outcome compete(RoShamBo3 it) {
      switch(it) {
        default: // To placate the compiler
        case PAPER: return Outcome.DRAW;
        case SCISSORS: return Outcome.LOSE;
        case ROCK: return Outcome.WIN;
      }
    }
  },
  SCISSORS {
    @Override public Outcome compete(RoShamBo3 it) {
      switch(it) {
        default:
        case PAPER: return Outcome.WIN;
        case SCISSORS: return Outcome.DRAW;
        case ROCK: return Outcome.LOSE;
      }
    }
  },
  ROCK {
    @Override public Outcome compete(RoShamBo3 it) {
      switch(it) {
        default:
        case PAPER: return Outcome.LOSE;
        case SCISSORS: return Outcome.WIN;
        case ROCK: return Outcome.DRAW;
      }
    }
  };
  @Override
  public abstract Outcome compete(RoShamBo3 it);
  public static void main(String[] args) {
    RoShamBo.play(RoShamBo3.class, 20);
  }
}
/* Output:
ROCK vs. ROCK: DRAW
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
PAPER vs. PAPER: DRAW
PAPER vs. SCISSORS: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. SCISSORS: DRAW
ROCK vs. SCISSORS: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
ROCK vs. PAPER: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
*/
