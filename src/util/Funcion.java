package util;

import org.nfunk.jep.JEP;

/**
 *
 * @author Javier Riveros <javiiriveros@hotmail.com>
 */
public class Funcion {

	JEP j = new JEP();

	public Funcion(String def) throws Exception {
		// con la variable x
		j.addVariable("x", 0);
		// constantes Estandar
		j.addStandardConstants();
		// funciones estandar
		j.addStandardFunctions();
		// Analizar la definicio
		j.parseExpression(def);
		if (j.hasError()) {
			System.out.println(j.getErrorInfo());
		}
	}
	// Evaluar la funcion

	public double eval(double x) throws Exception {
		double resultado;
		j.addVariable("x", x);
		resultado = j.getValue();
		if (j.hasError()) {
			System.out.println(j.getErrorInfo());
		}
		return resultado;
	}

	public double[] eval(double[] x) throws Exception {
		int n = x.length;
		double[] resultado = new double[n];
		for (int i = 0; i < n; i++) {
			resultado[i] = eval(x[i]);

		}
		return resultado;
	}

	public double[] rango(double x0, double x1, double d) {
		int n = (int) (Math.abs(x1 - x0) / d);
		double[] resultado = new double[n];
		for (int i = 0; i < n; i++) {
			resultado[i] = x0;
			x0 += d;
		}
		return resultado;
	}

}
