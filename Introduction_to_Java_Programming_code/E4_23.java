/*
  Write a program that reads the following information and prints a payroll
  statement:

  Employee's name (eg Smith)
  Number of hours worked in a week (eg 10)
  Hourly pay rate (eg 9.75)
  Federal tax withholding rate (eg 20%)
  State tax withholding rate (eg 9%)
*/

import java.util.Scanner;

public class E4_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter employee's Name: ");
    String name = input.nextLine();
    System.out.print("Enter number of hours worked in a week: ");
    double hoursWorked = input.nextDouble();
    System.out.print("Enter hourly pay rate: ");
    double hourlyRate = input.nextDouble();
    System.out.print("Enter federal tax withholding rate: ");
    double fedTaxWHRate = input.nextDouble();
    System.out.print("Enter state tax withholding rate: ");
    double stateTaxWHRate = input.nextDouble();

    double grossPay = hoursWorked * hourlyRate;
    double fedTaxWHPercent = 100 * fedTaxWHRate;
    double stateTaxWHPercent = 100 * stateTaxWHRate;
    double fedWH = fedTaxWHRate * grossPay;
    double stateWH = stateTaxWHRate * grossPay;
    double totalDeduction = fedWH + stateWH;
    double netPay = grossPay - totalDeduction;

    System.out.println("Employee Name: " + name);
    System.out.println("Hours Worked: " + hoursWorked);
    System.out.printf("Pay Rate: $%.2f\n", hourlyRate);
    System.out.printf("Gross Pay: $%.2f\n", grossPay);
    System.out.println("Deductions:");
    System.out.printf("\tFederal Withholding (%.1f%%): $%.2f\n",
      fedTaxWHPercent, fedWH);
    System.out.printf("\tState Withholding (%.1f%%): $%.2f\n",
      stateTaxWHPercent, stateWH);
    System.out.printf("\tTotal Deduction: $%.2f\n", totalDeduction);
    System.out.printf("Net Pay: $%.2f\n", netPay);
  }
}
