package methods.taylorSeries;

import methods.derivation.Derivation;
import org.nfunk.jep.JEP;

public class TaylorSeries {

  private String fx, x;

  public TaylorSeries(String fx, String x) {
    this.fx = fx;
    this.x = x;
  }

  public double solve() {
    JEP objJEP = new JEP();
    objJEP.addStandardFunctions();
    objJEP.addStandardConstants();
    objJEP.setImplicitMul(true);
    objJEP.parseExpression(x);
    double a = objJEP.getValue();
    double f;
    double h = 0.02;
    objJEP.addVariable("x", a);
    objJEP.parseExpression(fx);
    f = objJEP.getValue();
    Double f1 = Double.parseDouble(Derivation.derivada(fx, x));
    Double f2 = Double.parseDouble(Derivation.derivada2(fx, x));
    Double f3 = Double.parseDouble(Derivation.derivada3(fx, x));
    Double f4 = Double.parseDouble(Derivation.derivada4(fx, x));
    double resultado = f + (f1 * h) + ((f2 * (Math.pow(h, 2))) / factorial(2) + ((f3 * (Math.pow(h, 3))) / factorial(3))) + ((f4 * (Math.pow(h, 4))) / factorial(4));

    return resultado;
  }

  public double factorial(double num) {
    double aux = 1;
    for (int i = 2; i <= num; i++) {
      aux *= 1;
    }
    return aux;
  }
}
