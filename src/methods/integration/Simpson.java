package methods.integration;

import java.util.function.Function;

public class Simpson {
	public static Double simpson13(Function<Double, Double> function, Double x0, Double xn, Integer n) {
		Double h = (xn - x0) / n;

		Double f0 = function.apply(0d);
		Double fn = function.apply(xn);

		Double fi = 0d, fj = 0d;

		for (double i = 1; i < (n - 1); i++) {
			if (i % 2 != 0) {
				Double xi = x0 + (i * h);
				fi += function.apply(xi);
			}
		}

		for (double j = 2; j < (n - 1); j++) {
			if (j % 2 == 0) {
				Double xj = x0 + (j * h);
				fj += function.apply(xj);
			}
		}

		Double result = (h / 3) * (f0 + (4 * fi) + (2 * fj) + fn);

		return result;
	}

	public static Double simpson38(Function<Double, Double> function, Double x0, Double xn, Integer n) {
		Double h = (xn - x0) / n;

		Double f0 = function.apply(0d);
		Double fn = function.apply(xn);

		Double fi = 0d, fj = 0d;
		Double xi, xj;

		for (double i = 1; i < (n - 1); i++) {
			if (i % 3 != 0) {
				xi = x0 + (i * h);
				fi += function.apply(xi);
			}
		}

		for (double j = 3; j < (n - 1); j++) {
			if (j % 3 == 0) {
				xj = x0 + (j * h);
				fj += function.apply(xj);
			}
		}

		Double result = ((3 * h) / 8) * (f0 + (3 * fi) + (2 * fj) + fn);

		return result;
	}

	public static Double simpsonM(Function<Double, Double> function, Double a, Double b, Integer n) {
		if (n % 2 == 1)
			n++;
		Double h = (b - a) / n;
		Double suma = function.apply(a) + function.apply(b);
		for (int i = 1; i < n; i += 2) {
			suma += 4 * function.apply(a + i * h);
		}
		for (int i = 2; i < n; i += 2) {
			suma += 2 * function.apply(a + i * h);
		}
		return (suma * h / 3);
	}

	public static String calcularIntegral(String funcion, String h0, String h2) {
		String h1 = (Double.parseDouble(h2) / 2) + "".trim();
		util.Function f = new util.Function();
		String y0 = f.evaluar(funcion, h0);
		String y1 = ((Double.parseDouble(f.evaluar(funcion, h1))) * 4) + "".trim();
		String y2 = f.evaluar(funcion, h2);
		String area = ((Double.parseDouble(h1) / 3)
				* (Double.parseDouble(y0) + Double.parseDouble(y1) + Double.parseDouble(y2))) + "".trim();
		return area;
	}
}
