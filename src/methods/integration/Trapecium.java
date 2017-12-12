package methods.integration;

import java.util.function.Function;

public class Trapecium {

  public static Double trapecium(Function<Double, Double> function, Double x0, Double xn, Integer n) {
    Double h = (xn - x0) / n;

    Double f0 = function.apply(0d);
    Double fn = function.apply(xn);

    Double fi = 0d;

    for (double i = 1; i < (n - 1); i++) {
      Double xi = x0 + (i * h);
      fi += function.apply(xi);
    }

    Double result = (h / 2) * (f0 + (2 * fi) + fn);

    return result;
  }
}
