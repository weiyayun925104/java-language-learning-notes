/*
  Suppose the tuition for a university is $10,000 this year and increases 5%
  every year. In one year, the tuition will be $10,500. Write a program that
  computes the tuition in ten years and the total cost of four years' worth
  of tuition after the tenth year.
*/

public class E5_07 {
  public static void main(String[] args) {
    double currentTuition = 10000.0;
    double tuitionIncreaseRate = 0.05;

    for (int i = 1; i <= 10; i++) {
      currentTuition += currentTuition * tuitionIncreaseRate;
    }

    System.out.printf("Year 10 Tuition: $%.2f\n", currentTuition);

    double sum = 0.0;
    for (int i = 1; i <= 4; i++) {
      currentTuition += currentTuition * tuitionIncreaseRate;
      sum += currentTuition;
    }

    System.out.printf("Cost of 4 Years after Year 10: $%.2f\n", sum);
  }
}
