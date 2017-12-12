package methods.equationsRoots;

import util.Funcion;

public class FakePosition {

  private Double xi, xu, eEst;
  private Funcion function;

  public FakePosition(String fx, Double xi, Double xu, int n) throws Exception {
    this.function = new Funcion(fx);
    this.eEst = (0.5 * Math.pow(10, 2 - n));
    this.xi = xi;
    this.xu = xu;
  }

  public double result() throws Exception {
    double fi = this.function.eval(xi),
            fu = this.function.eval(xu),
            xr = 0,
            xrOld,
            fr,
            ea = 100,
            test;
    int iu = 0, ii = 0;
    do {
      xrOld = xr;
      xr = xu - fu * (xi - xu) / (fi - fu);
      fr = this.function.eval(xr);
      if (xr != 0)
        ea = Math.abs((xr - xrOld) / xr) * 100;
      test = fi * fr;
      if (test < 0) {
        xu = xr;
        fu = this.function.eval(xu);
        iu = 0;
        ii++;
        if (ii >= 2) fi = fi / 2;
      } else if (test > 0) {
        xi = xr;
        fi = this.function.eval(xi);
        ii = 0;
        iu++;
        if (iu >= 2) fu = fu / 2;
        else ea = 0;
      }
    } while (ea > eEst);

    return xr;
  }
  
  public static void main(String[] args) throws Exception {
    SecantModified fp = new SecantModified("ln(x)+e^(x)+x^(1/2)-6", 1.4, 0.0001, 5);
    System.out.println(fp.result());
  }
}
