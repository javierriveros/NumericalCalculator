package methods.derivation;

import org.nfunk.jep.JEP;

public class Derivation {
	public static String derivada(String fx, String x1) {
		JEP objJEP = new JEP();
		objJEP.addStandardFunctions();
		objJEP.addStandardConstants();
		objJEP.setImplicitMul(true);
		objJEP.parseExpression(x1);
		double a = objJEP.getValue();
		double h = a + (a / 1000);
		double temp, temp2;
		temp = objJEP.addVariable("x", a);
		objJEP.parseExpression(fx);
		temp = objJEP.getValue();
		temp2 = objJEP.addVariable("x", h);
		objJEP.parseExpression(fx);
		temp2 = objJEP.getValue();
		double resultado = (temp2 - temp) / (a / 1000);
		return String.valueOf(resultado);
	}

	public static String derivada2(String fx, String x1) {
		JEP objJEP = new JEP();
		objJEP.addStandardFunctions();
		objJEP.addStandardConstants();
		objJEP.setImplicitMul(true);
		objJEP.parseExpression(x1);
		double a = objJEP.getValue();
		double h = a + (a / 1000);
		double h2 = a + ((a / 1000) * 2);
		double temp, temp1, temp2;
		temp = objJEP.addVariable("x", a);
		objJEP.parseExpression(fx);
		temp = objJEP.getValue();
		temp1 = objJEP.addVariable("x", h);
		objJEP.parseExpression(fx);
		temp1 = objJEP.getValue();
		temp2 = objJEP.addVariable("x", h2);
		objJEP.parseExpression(fx);
		temp2 = objJEP.getValue();
		double resultado = (temp2 - (2 * temp1) + temp) / ((a / 1000) * (a / 1000));
		return String.valueOf(resultado);
	}

	public static String derivada3(String fx, String x1) {
		JEP objJEP = new JEP();
		objJEP.addStandardFunctions();
		objJEP.addStandardConstants();
		objJEP.setImplicitMul(true);
		objJEP.parseExpression(x1);
		double a = objJEP.getValue();
		double h = a + (a / 1000);
		double h2 = a + ((a / 1000) * 2);
		double h3 = a + ((a / 1000) * 3);
		double temp, temp1, temp2, temp3;
		temp = objJEP.addVariable("x", a);
		objJEP.parseExpression(fx);
		temp = objJEP.getValue();
		temp1 = objJEP.addVariable("x", h);
		objJEP.parseExpression(fx);
		temp1 = objJEP.getValue();
		temp2 = objJEP.addVariable("x", h2);
		objJEP.parseExpression(fx);
		temp2 = objJEP.getValue();
		temp3 = objJEP.addVariable("x", h3);
		objJEP.parseExpression(fx);
		temp3 = objJEP.getValue();
		double resultado = (temp3 - (3 * temp2) + (3 * temp1) - temp) / ((a / 1000) * (a / 1000) * (a / 1000));
		return String.valueOf(resultado);
	}

	public static String derivada4(String fx, String x1) {
		JEP objJEP = new JEP();
		objJEP.addStandardFunctions();
		objJEP.addStandardConstants();
		objJEP.setImplicitMul(true);
		objJEP.parseExpression(x1);
		double a = objJEP.getValue();
		double h = a + (a / 1000);
		double h2 = a + ((a / 1000) * 2);
		double h3 = a + ((a / 1000) * 3);
		double h4 = a + ((a / 1000) * 4);
		double temp, temp1, temp2, temp3, temp4;
		temp = objJEP.addVariable("x", a);
		objJEP.parseExpression(fx);
		temp = objJEP.getValue();
		temp1 = objJEP.addVariable("x", h);
		objJEP.parseExpression(fx);
		temp1 = objJEP.getValue();
		temp2 = objJEP.addVariable("x", h2);
		objJEP.parseExpression(fx);
		temp2 = objJEP.getValue();
		temp3 = objJEP.addVariable("x", h3);
		objJEP.parseExpression(fx);
		temp3 = objJEP.getValue();
		temp4 = objJEP.addVariable("x", h4);
		objJEP.parseExpression(fx);
		temp4 = objJEP.getValue();
		double resultado = (temp4 - (4 * temp3) + (6 * temp2) - (4 * temp1) + temp)
				/ ((a / 1000) * (a / 1000) * (a / 1000) * (a / 1000));
		return String.valueOf(resultado);
	}
}
