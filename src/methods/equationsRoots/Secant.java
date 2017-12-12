package methods.equationsRoots;

import util.Funcion;

public class Secant {
	private Double xi1, xi, eEst;
	private Funcion function;
	
	/**
	 * Numerical method: secant for equations roots
	 * @param fx function
	 * @param xi1 prev value
   * @param xi current value
	 * @param n  significant numbers
	 * @throws Exception
	 */
	public Secant(String fx, Double xi1, Double xi, int n) throws Exception {
		this.function = new Funcion(fx);
		this.eEst = (0.5 * Math.pow(10, 2-n));
    this.xi1 = xi1;
    this.xi = xi;
	}

  /**
   * Solve the equation root of a given function
   * @return Xr: equation root
   * @throws Exception 
   */
  public double result() throws Exception {
    double xr = 0, xrOld, ea, fi, fi1;
    do {
      xrOld = xr;
      
      fi = this.function.eval(xi);
      fi1 = this.function.eval(xi1);
      
      xr = xi - ((fi * (xi - xi1))/(fi - fi1));
      ea = Math.abs((xr - xrOld) / xr) * 100;
      
      xi1 = xi;
      xi = xr;
    } while (ea > eEst);
    return xr;
  }
}
