package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import util.Funcion;
import util.Graph;
import util.Messages;
import util.Validations;

public class CurvesAdjustmentView extends JPanel {

  private Principal principal;

  private DefaultTableModel dataModel;
  private DefaultTableModel resultsModel;

  private JTable dataTable;
  private JTable resultsTable;
  private JTextField xDataField;
  private JTextField yDataField;
  private JTextField dataCountField;
  private JTextArea resultsField;
  private JTextField sXYField;
  private JComboBox gradoComboBox;
  private JComboBox typeComboBox;
  private Graph graph;

  private int f, c;// variables usadas para almacenar las dimensiones de la matriz aumentada

  /**
   * Create the panel.
   * @param principal
   */
  public CurvesAdjustmentView(Principal principal) {
    this.principal = principal;
    setLayout(new BorderLayout(0, 0));
    configureWindow();

    this.graph = new Graph("Gráfica", null, null);

    JPanel mainPanel = new JPanel();
    add(mainPanel);
    mainPanel.setLayout(new GridLayout(0, 2, 20, 20));

    JPanel leftPanel = new JPanel();
    mainPanel.add(leftPanel);
    leftPanel.setLayout(new GridLayout(2, 0, 20, 20));

    JPanel topPanel = new JPanel();
    leftPanel.add(topPanel);
    topPanel.setLayout(new BorderLayout(0, 0));

    JPanel topActionsPanel = new JPanel();
    topPanel.add(topActionsPanel, BorderLayout.NORTH);
    topActionsPanel.setLayout(new GridLayout(0, 4, 5, 10));

    xDataField = new JTextField();
    xDataField.setBorder(new TitledBorder(null, "Datos para X", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    topActionsPanel.add(xDataField);
    xDataField.setColumns(10);

    yDataField = new JTextField();
    yDataField.setBorder(new TitledBorder(null, "Datos para Y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    topActionsPanel.add(yDataField);
    yDataField.setColumns(10);

    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.addActionListener(e -> this.addDataRow());
    topActionsPanel.add(btnAgregar);

    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(e -> this.deleteDataRow());
    topActionsPanel.add(btnEliminar);

    dataModel = new DefaultTableModel();
    dataModel.addColumn("X");
    dataModel.addColumn("Y");

    dataTable = new JTable(dataModel);

    JScrollPane dataScrollBar = new JScrollPane(dataTable);
    topPanel.add(dataScrollBar);

    JPanel bottomPanel = new JPanel();
    leftPanel.add(bottomPanel);
    bottomPanel.setLayout(new BorderLayout(0, 0));

    JPanel bottomActionsPanel = new JPanel();
    bottomPanel.add(bottomActionsPanel, BorderLayout.NORTH);
    bottomActionsPanel.setLayout(new GridLayout(0, 2, 5, 10));

    dataCountField = new JTextField();
    dataCountField.setEditable(false);
    dataCountField.setColumns(10);
    dataCountField.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "N\u00FAmero de datos",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
    bottomActionsPanel.add(dataCountField);

    JButton loadMatrizButton = new JButton("Cargar matriz");
    loadMatrizButton.addActionListener(e -> loadMatriz());
    bottomActionsPanel.add(loadMatrizButton);

    resultsModel = new DefaultTableModel();
    resultsModel.addColumn("Sisas");

    resultsTable = new JTable();

    JScrollPane resultsScrollBar = new JScrollPane(resultsTable);
    bottomPanel.add(resultsScrollBar);

    JPanel bottomActionsTwoPanel = new JPanel();
    bottomPanel.add(bottomActionsTwoPanel, BorderLayout.SOUTH);
    bottomActionsTwoPanel.setLayout(new GridLayout(0, 3, 10, 10));

    typeComboBox = new JComboBox();
    typeComboBox.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    typeComboBox.setModel(
            new DefaultComboBoxModel(new String[]{"Lineal", "Polinomial", "Logaritmica", "Exponencial", "Potencial"}));
    typeComboBox.addActionListener(e -> typeComboPerformed());
    bottomActionsTwoPanel.add(typeComboBox);

    gradoComboBox = new JComboBox();
    gradoComboBox.setBorder(new TitledBorder(null, "Grado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    gradoComboBox.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6"}));
    bottomActionsTwoPanel.add(gradoComboBox);

    JButton btnSolve = new JButton("Resolver sistema");
    btnSolve.addActionListener(e -> solve());
    bottomActionsTwoPanel.add(btnSolve);

    JPanel rightPanel = new JPanel();
    mainPanel.add(rightPanel);
    rightPanel.setLayout(new BorderLayout(0, 0));

    JPanel graphPanel = this.graph.viewGraph();
    rightPanel.add(graphPanel, BorderLayout.CENTER);

    JPanel resultsPanel = new JPanel();
    rightPanel.add(resultsPanel, BorderLayout.SOUTH);
    resultsPanel.setLayout(new GridLayout(3, 1, 0, 0));

    JButton btnClearGraph = new JButton("Limpiar grafica");
    btnClearGraph.addActionListener(e -> this.graph.clear());
    resultsPanel.add(btnClearGraph);

    resultsField = new JTextArea();
    resultsField.setEditable(false);
    resultsField.setBorder(
            new TitledBorder(null, "Resolución del sistema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    resultsField.setFont(new Font("Roboto Mono", Font.PLAIN, 18));
    resultsField.setColumns(10);

    JScrollPane resultsScrollPane = new JScrollPane(resultsField);
    resultsPanel.add(resultsScrollPane);

    sXYField = new JTextField();
    sXYField.setFont(new Font("Roboto Mono", Font.PLAIN, 18));
    sXYField.setEditable(false);
    sXYField.setColumns(10);
    sXYField.setBorder(new TitledBorder(null, "Sxy", TitledBorder.LEADING, TitledBorder.TOP, null, null));

    JScrollPane sXYScrollPane = new JScrollPane(sXYField);
    resultsPanel.add(sXYScrollPane);

    JPanel backPanel = new JPanel();
    add(backPanel, BorderLayout.SOUTH);

    JButton btnVolverAlInicio = new JButton("VOLVER AL INICIO");
    btnVolverAlInicio.addActionListener(e -> this.principal.goToPanel("Principal"));
    backPanel.add(btnVolverAlInicio);
  }

  private void addDataRow() {
    String x = this.xDataField.getText();
    String y = this.yDataField.getText();

    if (Validations.isEmpty(x) || Validations.isEmpty(y)) {
      Messages.errorMessage("Debes llenar todos los campos");
      return;
    }

    if (!Validations.isNumeric(x) || !Validations.isNumeric(y)) {
      Messages.errorMessage("Los datos deben ser numéricos");
      return;
    }

    double xValue = Double.parseDouble(x), yValue = Double.parseDouble(y);
    Object data[] = {xValue, yValue};
    this.dataModel.addRow(data);
    this.countData();
  }

  private void deleteDataRow() {
    int row = dataTable.getSelectedRow();
    if (row >= 0) {
      dataModel.removeRow(row);
    }
    countData();
  }

  private void countData() {
    this.dataCountField.setText(String.valueOf(this.dataTable.getRowCount()));
  }
  
  private void typeComboPerformed() {
    this.sXYField.setText("");
      if (this.typeComboBox.getSelectedItem() == "Lineal" && this.gradoComboBox.getSelectedItem() == "1" || this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoUno();

      } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "2") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoDos();
      } // grado 3
      else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "3") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoTres();
      } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "4") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoCuatro();
      } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "5") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoCinco();
      } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "6") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;
          // 
          Object col[] = new Object[c];
          for (int j = 0; j < c; j++) {
            if (j < c - 1) {
              col[j] = "i " + (j + 1);
            } else {
              col[j] = "R";
            }
          }

          resultsModel = new DefaultTableModel(col, f);

          resultsTable.setModel(resultsModel);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoSeis();
      }
  }

  private void loadMatriz() {
    try {
      int f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
      int c = f + 1;
      //
      Object col[] = new Object[c];
      for (int j = 0; j < c; j++) {
        if (j < c - 1) {
          col[j] = "i" + (j + 1);
        } else {
          col[j] = "R";
        }
      }

      this.resultsModel = new DefaultTableModel(col, f);
      this.resultsTable.setModel(resultsModel);

      switch (this.gradoComboBox.getSelectedIndex()) {
        case 0:
          gradoUno();
          break;
        case 1:
          gradoDos();
          break;
        case 2:
          gradoTres();
          break;
        case 3:
          gradoCuatro();
          break;
        case 4:
          gradoCinco();
        case 5:
          gradoSeis();
          break;
      }

    } catch (Exception e) {
      Messages.errorMessage("Error en el ingreso de los datos");
    }
  }

  // Polinomial
  public double sumax() {
    double sumatoriax = 0;
    for (int i = 0; i < this.dataTable.getRowCount(); i++) {
      String valores = String.valueOf(this.dataTable.getValueAt(i, 0));
      double valorint = convertir(valores);
      sumatoriax = sumatoriax + valorint;
    }
    return sumatoriax;
  }

  public double sumay() {
    double sumatoriay = 0;
    for (int i = 0; i < this.dataTable.getRowCount(); i++) {
      String valores = String.valueOf(this.dataTable.getValueAt(i, 1));
      double valorint = convertir(valores);
      sumatoriay = sumatoriay + valorint;
    }
    return sumatoriay;
  }

  public double xGrado(int grado) {
    double x = 0;

    for (int i = 0; i < this.dataTable.getRowCount(); i++) {
      String valores = String.valueOf(this.dataTable.getValueAt(i, 0));
      double valorint = convertir(valores);

      x = (x + Math.pow(valorint, grado));

    }

    return x;
  }

  public double xGradoy(int grado) {
    double mulxy = 0;

    for (int i = 0; i < this.dataTable.getRowCount(); i++) {
      String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
      String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + Math.pow(mulx, grado) * muly;
    }
    return mulxy;
  }

  public void gradoUno() {
    String datos = this.dataCountField.getText();
    this.resultsModel.setValueAt(datos, 0, 0);
    this.resultsModel.setValueAt(sumax(), 0, 1);
    this.resultsModel.setValueAt(sumay(), 0, 2);

    this.resultsModel.setValueAt(sumax(), 1, 0);
    this.resultsModel.setValueAt(xGrado(2), 1, 1);
    this.resultsModel.setValueAt(xGradoy(1), 1, 2);
  }

  public void gradoDos() {
    gradoUno();

    this.resultsModel.setValueAt(xGrado(2), 2, 0);
    this.resultsModel.setValueAt(xGrado(3), 2, 1);
    this.resultsModel.setValueAt(xGrado(4), 2, 2);
    this.resultsModel.setValueAt(xGradoy(2), 2, 3);
  }

  public void gradoTres() {
    gradoDos();

    this.resultsModel.setValueAt(xGrado(3), 3, 0);
    this.resultsModel.setValueAt(xGrado(4), 3, 1);
    this.resultsModel.setValueAt(xGrado(5), 3, 2);
    this.resultsModel.setValueAt(xGrado(6), 3, 3);
    this.resultsModel.setValueAt(xGradoy(3), 3, 4);

  }

  public void gradoCuatro() {
    gradoTres();

    this.resultsModel.setValueAt(xGrado(4), 4, 0);
    this.resultsModel.setValueAt(xGrado(5), 4, 1);
    this.resultsModel.setValueAt(xGrado(6), 4, 2);
    this.resultsModel.setValueAt(xGrado(7), 4, 3);
    this.resultsModel.setValueAt(xGrado(8), 4, 4);
    this.resultsModel.setValueAt(xGradoy(4), 4, 5);

  }

  public void gradoCinco() {
    gradoCuatro();

    this.resultsModel.setValueAt(xGrado(5), 5, 0);
    this.resultsModel.setValueAt(xGrado(6), 5, 1);
    this.resultsModel.setValueAt(xGrado(6), 5, 2);
    this.resultsModel.setValueAt(xGrado(7), 5, 3);
    this.resultsModel.setValueAt(xGrado(9), 5, 4);
    this.resultsModel.setValueAt(xGrado(10), 5, 5);
    this.resultsModel.setValueAt(xGradoy(5), 5, 6);
  }

  public void gradoSeis() {
    gradoCinco();

    this.resultsModel.setValueAt(xGrado(6), 6, 0);
    this.resultsModel.setValueAt(xGrado(7), 6, 1);
    this.resultsModel.setValueAt(xGrado(8), 6, 2);
    this.resultsModel.setValueAt(xGrado(9), 6, 3);
    this.resultsModel.setValueAt(xGrado(10), 6, 4);
    this.resultsModel.setValueAt(xGrado(11), 6, 5);
    this.resultsModel.setValueAt(xGrado(12), 6, 6);
    this.resultsModel.setValueAt(xGradoy(6), 6, 7);
  }

  public double convertir(String valor) {
    return Double.parseDouble(valor);
  }

  private void solve() {
    this.resultsField.setText("");
    this.sXYField.setText("");

    if (this.typeComboBox.getSelectedItem() == "Lineal" && this.gradoComboBox.getSelectedItem() == "1"
            || this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "1") {

      try {
        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado

        int n = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
        this.f = Integer.parseInt(this.gradoComboBox.getSelectedItem().toString()) + 1;
        this.c = this.f + 1;

        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("res" + (i+1) + " = " + r[i] + "\n" );

        }
        this.resultsField.append(r[0] + " + (" + r[1] + ")*x");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.5);
        double[] y = f.eval(x);
        this.graph.createGraph(def, x, y);

        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx)), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (1 + 1)));

        this.sXYField.setText("Sxy = " + sxy);

      } catch (Exception e) {

      }
    } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "2") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 3;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
//				this.resultsField.append(r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.5);
        double[] y = f.eval(x);
        this.graph.createGraph(def, x, y);
        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (2 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);
      } catch (Exception e) {

      }

    } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "3") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 4;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + "+(" + r[1] + ")*x +(" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.5);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);
        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty
                  - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2)) + (r[2] * Math.pow(valorintx, 3))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (3 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);
      } catch (Exception e) {

      }
    } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "4") {
      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 5;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");

        }
        this.resultsField.append(
                r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4] + ")*x^4");
        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.5);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);

        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2))
                  + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (4 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);
      } catch (Exception e) {

      }

    } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "5") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 6;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + " +(" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4]
                + ")*x^4 + " + "(" + r[5] + ")*x^5");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.5);
        double[] y = f.eval(x);
        this.graph.createGraph(def, x, y);
        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2))
                  + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4)) + (r[2] * Math.pow(valorintx, 5))),
                  2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (5 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);
      } catch (Exception e) {

      }
    } else if (this.typeComboBox.getSelectedItem() == "Polinomial" && this.gradoComboBox.getSelectedItem() == "6") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 7;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4]
                + ")*x^4 + " + "(" + r[5] + ")*x^5 + " + "(" + r[6] + ")*x^6");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.2);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);

        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2))
                  + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4)) + (r[2] * Math.pow(valorintx, 5))
                  + (r[2] * Math.pow(valorintx, 6))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (6 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);

      } catch (Exception e) {

      }
    } // Logaritmica
    else if (this.typeComboBox.getSelectedItem() == "Logaritmica" && this.gradoComboBox.getSelectedItem() == "1") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 2;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + " + " + r[1] + "*ln(x)");
        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.2);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);

        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * Math.log(valorintx))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (1 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);

      } catch (Exception e) {

      }

    } // Exponencial
    else if (this.typeComboBox.getSelectedItem() == "Exponencial" && this.gradoComboBox.getSelectedItem() == "1") {
      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 2;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + " * e^(" + r[1] + "*x)");
        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.2);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);

        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] + (r[1] * Math.log(valorintx))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (1 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);

      } // fin try
      catch (Exception e) {

      }

    } // potencial
    else if (this.typeComboBox.getSelectedItem() == "Potencial" && this.gradoComboBox.getSelectedItem() == "1") {

      try {

        // int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de
        // ingonitas ingresado por teclado
        int n = 2;
        double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
        double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3
        // entonces debera ingresar el los cuadors 2 4 3 en donde , m[0][1]=2,m[0][2]=4
        // y r[0]=3

        for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
          for (int j = 0; j < n; j++) {//
            m[i][j] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, j)));
          }
          r[i] = Double.parseDouble(String.valueOf(this.resultsTable.getValueAt(i, n)));
        }

        double solucion[] = new double[n];// almacena la soluciones del sistema
        r = this.loadMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

        // pasamos a mostrar las soluciones del sistema en el area de texto
        for (int i = 0; i < n; i++) {
          // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
        }
        this.resultsField.append(r[0] + " * x^(" + r[1] + ")");

        String def = this.resultsField.getText();
        Funcion f = new Funcion(def);
        double[] x = f.rango(-20, 20, 0.2);
        double[] y = f.eval(x);
        graph.createGraph(def, x, y);
        // realizar sxy = raiz((y-ya)^2/n -(n+1))
        int i = 0;
        double sr = 0;
        double sxy = 0;

        do {
          String valoresx = String.valueOf(this.dataTable.getValueAt(i, 0));
          String valoresy = String.valueOf(this.dataTable.getValueAt(i, 1));

          double valorintx = Double.parseDouble(valoresx);
          double valorinty = Double.parseDouble(valoresy);

          sr = sr + Math.pow(valorinty - (r[0] * (Math.pow(valorintx, r[1]))), 2);
          i++;

        } while (i < this.dataTable.getRowCount());

        double num = convertir(this.dataCountField.getText());

        System.out.println("sr " + sr);
        sxy = Math.sqrt(sr / (num - (1 + 1)));
        this.sXYField.setText("\n Sxy = " + sxy);
      } // fin try
      catch (Exception e) {

      }

    } else {
      System.out.println("no esta");
    }
  }

  public double[] loadMatriz(double m[][], double r[]) {
    
    // recuerde que el metodo de Gauss Jordan trabaja con la idea de convertir la matriz aumentada en la matriz identidad
    for (int i = 0; i <= r.length - 1; i++) {
      double d, c = 0;
      d = m[i][i];// seleccionamos el pivote
      // area_de_texto.append(Double.toString(d/2) + "*fila" + (i + 1) + "\n");// muesra en el area de texto el pivote seleccionado
      for (int s = 0; s <= r.length - 1; s++) {// pasamos a convertir en 1 al pivote seleionado
        m[i][s] = ((m[i][s]) / d);
      }
      r[i] = ((r[i]) / d);

      // paso a mostrar las opraciones realizadas en la matriz aumentada
      for (int j = 0; j < r.length; j++) {

        for (int k = 0; k < r.length; k++) {
          //  area_de_texto.append(Double.toString(m[j][k]) + "\t");
        }
        //area_de_texto.append("|\t" + Double.toString(r[j]) + "\n");
      }
      //area_de_texto.append("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada

      for (int x = 0; x <= r.length - 1; x++) {
        if (i != x) {
          c = m[x][i];
          //   area_de_texto.append("-" + Double.toString(c) + " * fila" + (i + 1) + "+ fila" + (x + 1) + "\n");// mustra en pantalla las opraciones que se realizaran por fila
          for (int y = 0; y <= r.length - 1; y++) {// se hace cero a todos los elemntos de la colunma que no sean el pivote
            m[x][y] = m[x][y] - c * m[i][y];

          }
          r[x] = r[x] - c * r[i];

          // paso a mostrar las opraciones realizadas en la matriz aumentada
          for (int j = 0; j < r.length; j++) {

            for (int k = 0; k < r.length; k++) {
              //   area_de_texto.append(Double.toString(m[j][k]) + "\t");
            }
            // area_de_texto.append("|\t" + Double.toString(r[j]) + "\n");
          }
          // area_de_texto.append("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada

        }// fin if (i != x)
      }// fin for (int x = 0; x <= r.length - 1; x++)

    }//fin bucle i
    return r;// retorna la solucion l sistema

  }

  private void configureWindow() {
    this.principal.getFrame().setTitle("Ajuste de curvas");
    this.principal.getFrame().setSize(900, 600);
    this.principal.getFrame().setLocationRelativeTo(null);
  }
}
