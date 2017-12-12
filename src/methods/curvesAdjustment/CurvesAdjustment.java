package methods.curvesAdjustment;

public class CurvesAdjustment {
	public static void main(String[] args) {
		double data[][] = {{6,21.2},{21.2,152.70}};
		double coef[] = {30.051, 112.347};
		Matriz a = new Matriz(data);
		Vector b = new Vector(coef);
		a = Matriz.inversa(a);
		b = Matriz.producto(a, b);
		System.out.println(b.toString());
	}
}