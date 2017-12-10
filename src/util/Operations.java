package util;

public class Operations {
	public static double roundD(double valorInicial, int numeroDecimales) {
    double parteEntera, resultado;
    resultado = valorInicial;
    parteEntera = Math.floor(resultado);
    resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
    resultado = Math.round(resultado);
    resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
    return resultado;
  }
}
