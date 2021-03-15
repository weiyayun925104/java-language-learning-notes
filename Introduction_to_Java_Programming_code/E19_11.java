/*
  Use the Complex class introduced in Programming Exercise 13.17 to develop the
  ComplexMatrix class for performing matrix operations involving complex
  numbers. The ComplexMatrix class should extend the GenericMatrix class and
  implement the add, multiply, and zero methods. You need to modify
  GenericMatrix and replace every occurrence of Number by Object, because
  Complex is not a subtype of Number. Write a test program that creates the
  following two matrices and displays the result of addition and multiplication
  of the matrices by invoking the printResult method.
*/

public class E19_11 {
  public static void main(String[] args) {
    Complex[][] m1 = new Complex[3][3];
    Complex[][] m2 = new Complex[3][3];
    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[i].length; j++) {
        m1[i][j] = new Complex(roundedRandom(), roundedRandom());
        m2[i][j] = new Complex(roundedRandom(), roundedRandom());
      }
    }

    ComplexMatrix complexMatrix = new ComplexMatrix();

    System.out.println("\nm1 + m2 is ");
    GenericMatrix.printResult(m1, m2, complexMatrix.addMatrix(m1, m2), '+');

    System.out.println("\nm1 + m2 is ");
    GenericMatrix.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2), '*');
  }

  public static double roundedRandom() {
    return Math.round(Math.random() * 10);
  }
}
