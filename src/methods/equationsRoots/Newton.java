package methods.equationsRoots;

import methods.derivation.Derivation;
import util.Funcion;

public class Newton {
  private Double xi, eEst;
	private Funcion function;
  private String fx;
	
	/**
	 * Numerical method: Bisection for equations roots
	 * @param fx function
	 * @param xi first value
	 * @param n  significant numbers
	 * @throws Exception
	 */
	public Newton(String fx, Double xi, int n) throws Exception {
		this.fx = fx;
    this.function = new Funcion(fx);
    
		this.eEst = (0.5 * Math.pow(10, 2-n));
    this.xi = xi;
	}
  
  public double result() throws Exception {
    double xr = 0, xrOld, ea = 100, fi, fiD;
    
    do {
      xrOld = xr;
      
      fi = this.function.eval(xi);
      fiD = Double.parseDouble(Derivation.derivada(fx, String.valueOf(xi)));
      
      xr = xi - (fi / fiD);
      
      ea = Math.abs((xr - xrOld) / xr) * 100;
      
      xi = xr;
    } while (ea > this.eEst);
    return xr;
  }
}
