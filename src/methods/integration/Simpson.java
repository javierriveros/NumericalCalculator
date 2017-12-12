package methods.integration;

import org.nfunk.jep.*;
import util.Function;

public class Simpson {

  private static Function f = new Function();

  public static Double simpson13(String function, Double x0, Double xn, Integer n) {
    Double h = (xn - x0) / n;

    String f0 = f.evaluar(function, "0");
    String fn = f.evaluar(function, String.valueOf(xn));

    Double fi = 0d, fj = 0d;

    for (double i = 1; i < (n - 1); i++) {
      if (i % 2 != 0) {
        Double xi = x0 + (i * h);
        fi += Double.parseDouble(f.evaluar(function, String.valueOf(xi)));
      }
    }

    for (double j = 2; j < (n - 1); j++) {
      if (j % 2 == 0) {
        Double xj = x0 + (j * h);
        fj += Double.parseDouble(f.evaluar(function, String.valueOf(xj)));
      }
    }

    Double result = (h / 3) * (Double.parseDouble(f0) + (4 * fi) + (2 * fj) + Double.parseDouble(fn));

    return result;
  }

//	public static Double simpson38(String function, Double x0, Double xn, Integer n) {
//		Double h = (xn - x0) / n;
//
//		Double f0 = function.apply(0d);
//		Double fn = function.apply(xn);
//
//		Double fi = 0d, fj = 0d;
//		Double xi, xj;
//
//		for (double i = 1; i < (n - 1); i++) {
//			if (i % 3 != 0) {
//				xi = x0 + (i * h);
//				fi += function.apply(xi);
//			}
//		}
//
//		for (double j = 3; j < (n - 1); j++) {
//			if (j % 3 == 0) {
//				xj = x0 + (j * h);
//				fj += function.apply(xj);
//			}
//		}
//
//		Double result = ((3 * h) / 8) * (f0 + (3 * fi) + (2 * fj) + fn);
//
//		return result;
//	}
//
//	public static Double simpsonM(Function<Double, Double> function, Double a, Double b, Integer n) {
//		if (n % 2 == 1)
//			n++;
//		Double h = (b - a) / n;
//		Double suma = function.apply(a) + function.apply(b);
//		for (int i = 1; i < n; i += 2) {
//			suma += 4 * function.apply(a + i * h);
//		}
//		for (int i = 2; i < n; i += 2) {
//			suma += 2 * function.apply(a + i * h);
//		}
//		return (suma * h / 3);
//	}
  public static String calcularIntegral(String funcion, String h0, String h2) {
    String h1 = (Double.parseDouble(h2) / 2) + "".trim();
    util.Function f = new util.Function();
    String y0 = f.evaluar(funcion, h0);
    String y1 = ((Double.parseDouble(f.evaluar(funcion, h1))) * 4) + "".trim();
    String y2 = f.evaluar(funcion, h2);
    String area = ((Double.parseDouble(h1) / 3)
            * (Double.parseDouble(y0)
            + Double.parseDouble(y1)
            + Double.parseDouble(y2))) + "".trim();
    return area;
  }

  public static String integral(String a1, String b1, String fx, int n) {
    String mensaje = "Error";
    try {
      JEP objJEP = new JEP();
      objJEP.addStandardFunctions();
      objJEP.addStandardConstants();
      objJEP.setImplicitMul(true);
      objJEP.parseExpression(a1);
      double a = objJEP.getValue();
      objJEP.parseExpression(b1);
      double b = objJEP.getValue();

      double h = (b - a) / n;
      double x[] = new double[n + 1];
      x[0] = a;
      x[n] = b;
      for (int i = 1; i < x.length; i++) {
        x[i] = x[0] + (i * h);
      }
      double fxi[] = new double[n + 1];
      double m = 0;
      for (int i = 0; i < x.length; i++) {
        fxi[i] = objJEP.addVariable("x", x[i]);
        objJEP.parseExpression(fx);
        fxi[i] = objJEP.getValue();
      }
      for (int i = 1; i <= n - 1; i++) {
        m = m + (2 * fxi[i]);
      }
      m = m + fxi[0] + fxi[n];
      m = (h * m) / 2;
      mensaje = Double.toString(m);

    } catch (Exception e) {
      mensaje = "Error";
    }

    return mensaje;
  }
}
