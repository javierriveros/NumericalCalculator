package methods.curvesAdjustment;

public class Vector {
	public int n; // dimensión
	double[] x;

	public Vector(int n) {
		this.n = n;
		x = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = 0.0;
		}
	}

	public Vector(double[] x) {
		this.x = x;
		n = x.length;
	}

	public static double productoEscalar(Vector a, Vector b) {
		double resultado = 0.0;
		for (int i = 0; i < a.n; i++) {
			resultado += a.x[i] * b.x[i];
		}
		return resultado;
	}

	public double modulo() {
		return Math.sqrt(productoEscalar(this, this));
	}

	public String toString() {
		String texto = " ";
		for (int i = 0; i < n; i++) {
			texto += "\t " + (double) Math.round(1000 * x[i]) / 1000;
		}
		texto += "\n";
		return texto;
	}
}
