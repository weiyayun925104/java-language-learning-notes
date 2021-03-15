public class ComplexMatrix extends GenericMatrix<Complex> {
  @Override
  public Complex add(Complex o1, Complex o2) {
    return o1.add(o2);
  }

  @Override
  public Complex multiply(Complex o1, Complex o2) {
    return o1.multiply(o2);
  }

  @Override
  public Complex zero() {
    return new Complex(0, 0);
  }
}
