package methods.curvesAdjustment;

public class Matriz implements Cloneable {

  public int n; // dimensión
  private double[][] x;

  public Matriz(int n) {
    this.n = n;
    x = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        x[i][j] = 0.0;
      }
    }
  }

  public Matriz(double[][] x) {
    this.x = x;
    n = x.length;
  }

  public Object clone() {
    Matriz obj = null;
    try {
      obj = (Matriz) super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(" no se puede duplicar");
    }
    // aquí está la clave para clonar la matriz bidimensional
    obj.x = (double[][]) obj.x.clone();
    for (int i = 0; i < obj.x.length; i++) {
      obj.x[i] = (double[]) obj.x[i].clone();
    }
    return obj;
  }

  double traza() {
    double tr = 0.0;
    for (int i = 0; i < n; i++) {
      tr += x[i][i];
    }
    return tr;
  }

  // suma de dos matrices
  static Matriz suma(Matriz a, Matriz b) {
    Matriz resultado = new Matriz(a.n);
    for (int i = 0; i < a.n; i++) {
      for (int j = 0; j < a.n; j++) {
        resultado.x[i][j] = a.x[i][j] + b.x[i][j];
      }
    }
    return resultado;
  }

  // producto de dos matrices
  static Matriz producto(Matriz a, Matriz b) {
    Matriz resultado = new Matriz(a.n);
    for (int i = 0; i < a.n; i++) {
      for (int j = 0; j < a.n; j++) {
        for (int k = 0; k < a.n; k++) {
          resultado.x[i][j] += a.x[i][k] * b.x[k][j];
        }
      }
    }
    return resultado;
  }

  // producto de una matriz por un escalar
  static Matriz producto(Matriz a, double d) {
    Matriz resultado = new Matriz(a.n);
    for (int i = 0; i < a.n; i++) {
      for (int j = 0; j < a.n; j++) {
        resultado.x[i][j] = a.x[i][j] * d;
      }
    }
    return resultado;
  }

  // producto de un escalar por una matriz
  static Matriz producto(double d, Matriz a) {
    Matriz resultado = new Matriz(a.n);
    for (int i = 0; i < a.n; i++) {
      for (int j = 0; j < a.n; j++) {
        resultado.x[i][j] = a.x[i][j] * d;
      }
    }
    return resultado;
  }

  // producto de un vector fila por una matriz da un vector fila (1xn) (nxn)=
  // (1xn)
  static Vector producto(Vector v, Matriz a) {
    Vector b = new Vector(v.n);
    int n = v.n; // dimensión
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < n; k++) {
        b.x[j] += v.x[k] * a.x[k][j];
      }
    }
    return b;
  }

  // producto de una matriz por un vector columna (nxn) (nx1)= (nx1)
  static Vector producto(Matriz a, Vector v) {
    int n = v.n; // dimensión
    Vector b = new Vector(n);
    for (int i = 0; i < n; i++) {
      for (int k = 0; k < n; k++) {
        b.x[i] += a.x[i][k] * v.x[k];
      }
    }
    return b;
  }

  // determinante de una matriz
  double determinante() {
    Matriz a = (Matriz) clone();
    for (int k = 0; k < n - 1; k++) {
      for (int i = k + 1; i < n; i++) {
        for (int j = k + 1; j < n; j++) {
          a.x[i][j] -= a.x[i][k] * a.x[k][j] / a.x[k][k];
        }
      }
    }
    double deter = 1.0;
    for (int i = 0; i < n; i++) {
      deter *= a.x[i][i];
    }
    return deter;
  }

  // matriz inversa
  static Matriz inversa(Matriz d) {
    int n = d.n; // dimensión de la matriz
    Matriz a = (Matriz) d.clone();
    Matriz b = new Matriz(n); // matriz de los términos independientes
    Matriz c = new Matriz(n); // matriz de las incógnitas
    // matriz unidad
    for (int i = 0; i < n; i++) {
      b.x[i][i] = 1.0;
    }
    // transformación de la matriz y de los términos independientes
    for (int k = 0; k < n - 1; k++) {
      for (int i = k + 1; i < n; i++) {
        // términos independientes
        for (int s = 0; s < n; s++) {
          b.x[i][s] -= a.x[i][k] * b.x[k][s] / a.x[k][k];
        }
        // elementos de la matriz
        for (int j = k + 1; j < n; j++) {
          a.x[i][j] -= a.x[i][k] * a.x[k][j] / a.x[k][k];
        }
      }
    }
    // cálculo de las incógnitas, elementos de la matriz inversa
    for (int s = 0; s < n; s++) {
      c.x[n - 1][s] = b.x[n - 1][s] / a.x[n - 1][n - 1];
      for (int i = n - 2; i >= 0; i--) {
        c.x[i][s] = b.x[i][s] / a.x[i][i];
        for (int k = n - 1; k > i; k--) {
          c.x[i][s] -= a.x[i][k] * c.x[k][s] / a.x[i][i];
        }
      }
    }
    return c;
  }

  // matriz traspuesta
  static Matriz traspuesta(Matriz a) {
    int n = a.n; // dimensión
    Matriz d = new Matriz(a.n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        d.x[i][j] = a.x[j][i];
      }
    }
    return d;
  }
  // polinomio característico

  public double[] polCaracteristico() {
    Matriz pot = new Matriz(n);
    // matriz unidad
    for (int i = 0; i < n; i++) {
      pot.x[i][i] = 1.0;
    }
    double[] p = new double[n + 1];
    double[] s = new double[n + 1];
    for (int i = 1; i <= n; i++) {
      pot = Matriz.producto(pot, this);
      s[i] = pot.traza();
    }
    p[0] = 1.0;
    p[1] = -s[1];
    for (int i = 2; i <= n; i++) {
      p[i] = -s[i] / i;
      for (int j = 1; j < i; j++) {
        p[i] -= s[i - j] * p[j] / i;
      }
    }
    return p;
  }

  public Matriz valoresPropios(double[] valores, int maxIter) throws ValoresExcepcion {
    final double CERO = 1e-8;
    double maximo, tolerancia, sumsq;
    double x, y, z, c, s;
    int contador = 0;
    int i, j, k, l;
    Matriz a = (Matriz) clone(); // matriz copia
    Matriz p = new Matriz(n);
    Matriz q = new Matriz(n);
    // matriz unidad
    for (i = 0; i < n; i++) {
      q.x[i][i] = 1.0;
    }
    do {
      k = 0;
      l = 1;
      maximo = Math.abs(a.x[k][1]);
      for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
          if (Math.abs(a.x[i][j]) > maximo) {
            k = i;
            l = j;
            maximo = Math.abs(a.x[i][j]);
          }
        }
      }
      sumsq = 0.0;
      for (i = 0; i < n; i++) {
        sumsq += a.x[i][i] * a.x[i][i];
      }
      tolerancia = 0.0001 * Math.sqrt(sumsq) / n;
      if (maximo < tolerancia) {
        break;
      }
      // calcula la matriz ortogonal de p
      // inicialmente es la matriz unidad
      for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
          p.x[i][j] = 0.0;
        }
      }
      for (i = 0; i < n; i++) {
        p.x[i][i] = 1.0;
      }
      y = a.x[k][k] - a.x[l][l];
      if (Math.abs(y) < CERO) {
        c = s = Math.sin(Math.PI / 4);
      } else {
        x = 2 * a.x[k][l];
        z = Math.sqrt(x * x + y * y);
        c = Math.sqrt((z + y) / (2 * z));
        s = signo(x / y) * Math.sqrt((z - y) / (2 * z));
      }
      p.x[k][k] = c;
      p.x[l][l] = c;
      p.x[k][l] = s;
      p.x[l][k] = -s;
      a = Matriz.producto(p, Matriz.producto(a, Matriz.traspuesta(p)));
      q = Matriz.producto(q, Matriz.traspuesta(p));
      contador++;
    } while (contador < maxIter);

    if (contador == maxIter) {
      throw new ValoresExcepcion("No se han podido calcular los valores propios");
    }
    // valores propios
    // double[] valores=new double[n];
    for (i = 0; i < n; i++) {
      valores[i] = (double) Math.round(a.x[i][i] * 1000) / 1000;
    }
    // vectores propios
    return q;
  }

  private int signo(double x) {
    return (x > 0 ? 1 : -1);
  }

  public String toString() {
    String texto = "\n";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        texto += "\t " + (double) Math.round(1000 * x[i][j]) / 1000;
      }
      texto += "\n";
    }
    texto += "\n";
    return texto;
  }

}
