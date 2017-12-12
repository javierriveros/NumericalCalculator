package methods.equationsRoots;

import util.Funcion;

public class SecantModified {

  private Double xi, eEst, dx;
  private Funcion function;

  /**
   * Numerical method: secant modified for equations roots
   *
   * @param fx function
   * @param xi current value
   * @param dx significant value
   * @param n significant numbers
   * @throws Exception
   */
  public SecantModified(String fx, Double xi, Double dx, int n) throws Exception {
    this.function = new Funcion(fx);
    this.eEst = (0.5 * Math.pow(10, 2 - n));
    this.xi = xi;
    this.dx = dx;
  }

  /**
   * Solve the equation root of a given function
   *
   * @return Xr: equation root
   * @throws Exception
   */
  public double result() throws Exception {
    double xr = 0, xrOld, ea, fi, fidx, xidx;
    do {
      xrOld = xr;

      xidx = xi + (dx * xi);

      fi = this.function.eval(xi);
      fidx = this.function.eval(xidx);

      xr = xi - ((fi * (xi * dx)) / (fidx - fi));
      ea = Math.abs((xr - xrOld) / xr) * 100;

      xi = xr;
    } while (ea > eEst);
    return xr;
  }
}
