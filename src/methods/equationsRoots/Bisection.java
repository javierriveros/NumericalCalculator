package methods.equationsRoots;

import util.Funcion;

public class Bisection {
	private Double xi, xu, eEst;
	private Funcion function;
	
	/**
	 * Numerical method: Bisection for equations roots
	 * @param fx function
	 * @param xi first value
	 * @param xu second value
	 * @param n  significant numbers
	 * @throws Exception
	 */
	public Bisection(String fx, Double xi, Double xu, int n) throws Exception {
		this.function = new Funcion(fx);
		this.eEst = (0.5 * Math.pow(10, 2-n));
    this.xi = xi;
    this.xu = xu;
	}

  /**
   * Solve the equation root of a given function
   * @return Xr: equation root
   * @throws Exception 
   */
  public double result() throws Exception {
    double xr = 0, xrOld, ea, test;
    do {
      xrOld = xr;
      xr = (xi + xu) / 2;
      ea = Math.abs((xr - xrOld) / xr) * 100;
      
      test = this.function.eval(xi) * this.function.eval(xr);
      
      if (test < 0) xu = xr;
      else if(test > 0) xi = xr;
      else ea = 0;
    } while (ea > eEst);
    return xr;
  }
}
