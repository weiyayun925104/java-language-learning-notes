public class Tax {
  // static fields
  public static final int SINGLE_FILER = 0;
  public static final int MARRIED_JOINTLY = 1;
  public static final int MARRIED_SEPARATELY = 2;
  public static final int HEAD_OF_HOUSEHOLD = 3;

  // instance fields
  int filingStatus;
  int[][] brackets;
  double[] rates;
  double taxableIncome;

  public Tax() {
    this(SINGLE_FILER,
      new int[][]{
        {8350, 33950, 82250, 171550, 372950},
        {16700, 67900, 137050, 208850, 372950},
        {8350, 33950, 68525, 104425, 186475},
        {11950, 45500, 117450, 190200, 372950}
      },
      new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35},
      50000.0);
  }

  public Tax(int filingStatus, int[][] brackets, double[] rates,
    double taxableIncome) {
    this.filingStatus = filingStatus;
    this.brackets = brackets;
    this.rates = rates;
    this.taxableIncome = taxableIncome;
  }

  public double getTax() {
    double tax = 0.0;
    int lastIndex = -1;

    // There are three basic parts to the tax calculation process.

    // 1. The first bracket.
    if (taxableIncome <= brackets[filingStatus][0]) {
      return taxableIncome * rates[0];
    } else {
      tax += brackets[filingStatus][0] * rates[0];
      // 2. Middle brackets. Iterate through the brackets, calculating tax
      //    until taxable incomes does not exceed the current bracket.
      for (int i = 1; i < brackets[filingStatus].length; i++) {
        if (taxableIncome > brackets[filingStatus][i]) {
          tax += (brackets[filingStatus][i] - brackets[filingStatus][i - 1]) *
            rates[i];
        } else {
          // Set the last index to the previous bracket and break from the loop.
          lastIndex = i;
          break;
        }
      }
    }
    // 3. The last bracket

    // This handles the case of a taxable income that exceeds the low bound
    // of the last tax bracket. We use the last tax bracket and the last rate
    // to calculate the final portion of taxes.
    int lastBracket = brackets[filingStatus].length - 1;
    int lastRate = rates.length - 1;
    if (taxableIncome > brackets[filingStatus][lastBracket]) {
      tax += (taxableIncome - brackets[filingStatus][lastBracket]) *
        rates[lastRate];
    } else {
      // And this handles all other cases. We use the last index of the loop
      // (minus 1, to get the bracket before that) along with the last index
      // of the rates (since we're calculating tax from the part that flows
      // into the next bracket) to calculate the final portion of taxes.
      tax += (taxableIncome - brackets[filingStatus][lastIndex - 1]) *
        rates[lastIndex];
    }

    return tax;
  }

  // getters
  public int getFilingStatus() {
    return filingStatus;
  }

  public int[][] getBrackets() {
    return brackets;
  }

  public double[] getRates() {
    return rates;
  }

  public double getTaxableIncome() {
    return taxableIncome;
  }

  // setters
  public void setFilingStatus(int filingStatus) {
    this.filingStatus = filingStatus;
  }

  public void setBrackets(int[][] brackets) {
    this.brackets = brackets;
  }

  public void setRates(double[] rates) {
    this.rates = rates;
  }

  public void setTaxableIncome(double taxableIncome) {
    this.taxableIncome = taxableIncome;
  }
}
