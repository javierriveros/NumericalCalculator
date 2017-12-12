/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package methods.curvesAdjustment;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Funcion;
import util.Graph;
import views.Principal;

/**
 *
 * @author Javier Riveros
 */
public class Gradouno extends javax.swing.JFrame {

  int f, c;// variables usadas para almacenar las dimensiones de la matriz aumentada

  DefaultTableModel modelo = new DefaultTableModel();
  Boolean ban = false;

  DefaultTableModel modeloDatos = new DefaultTableModel();
  String convertir = "";

  Graph grafica = new Graph("Grafica", null, null);

  public Gradouno() {
    initComponents();

    this.setLocationRelativeTo(null);// al momento de ejecutar la aplicacion lo ventana se  centra en la pantalla 
    modeloDatos.addColumn("X");
    modeloDatos.addColumn("Y");
    ingresar.setModel(modeloDatos);

  }

  /**
   * @param m almacena los coeficientes de la matriz aumentada
   * @param r almaena los valores de la solucion de acda expresion
   * @return
   */
  public double convertir(String valor) {
    this.convertir = valor;
    Double convertido = Double.parseDouble(convertir);

    return convertido;
  }

  public double[] cargarMatriz(double m[][], double r[]) {

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

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    numerodatos = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    llenarmatriz = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    area_de_texto = new javax.swing.JTextArea();
    desviacion = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    jButtoncargar_matriz = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    ingresar = new javax.swing.JTable();
    y = new javax.swing.JTextField();
    x = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButtoncargar_matriz1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    graficaRegresion = grafica.viewGraph();
    tipo = new javax.swing.JComboBox<>();
    grado = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();
    cargar = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(null);
    jPanel1.setLayout(null);

    numerodatos.setEditable(false);
    numerodatos.setBackground(new java.awt.Color(153, 153, 153));
    numerodatos.setBorder(null);
    numerodatos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        numerodatosActionPerformed(evt);
      }
    });
    jPanel1.add(numerodatos);
    numerodatos.setBounds(20, 250, 120, 30);

    llenarmatriz.setBorder(null);
    llenarmatriz.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
    llenarmatriz.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "x"
      }
    ));
    llenarmatriz.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        llenarmatrizKeyTyped(evt);
      }
    });
    jScrollPane1.setViewportView(llenarmatriz);

    jPanel1.add(jScrollPane1);
    jScrollPane1.setBounds(10, 290, 550, 140);

    jPanel2.setBorder(null);

    area_de_texto.setEditable(false);
    area_de_texto.setColumns(20);
    area_de_texto.setRows(5);
    area_de_texto.setBorder(null);
    jScrollPane2.setViewportView(area_de_texto);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(desviacion, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(desviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jPanel1.add(jPanel2);
    jPanel2.setBounds(570, 380, 360, 120);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(0, 0, 0));
    jLabel7.setText("Número de datos");
    jPanel1.add(jLabel7);
    jLabel7.setBounds(20, 210, 120, 40);

    jButtoncargar_matriz.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
    jButtoncargar_matriz.setText("CARGAR MATRIZ");
    jButtoncargar_matriz.setBorder(null);
    jButtoncargar_matriz.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtoncargar_matrizActionPerformed(evt);
      }
    });
    jPanel1.add(jButtoncargar_matriz);
    jButtoncargar_matriz.setBounds(410, 250, 150, 30);

    ingresar.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    jScrollPane3.setViewportView(ingresar);

    jPanel1.add(jScrollPane3);
    jScrollPane3.setBounds(20, 60, 540, 150);

    y.setBackground(new java.awt.Color(153, 153, 153));
    y.setBorder(null);
    jPanel1.add(y);
    y.setBounds(160, 20, 110, 30);

    x.setBackground(new java.awt.Color(153, 153, 153));
    x.setBorder(null);
    x.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        xActionPerformed(evt);
      }
    });
    jPanel1.add(x);
    x.setBounds(20, 20, 120, 30);

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Datos para Y");
    jPanel1.add(jLabel2);
    jLabel2.setBounds(160, 0, 90, 17);

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Datos para X");
    jPanel1.add(jLabel3);
    jLabel3.setBounds(20, 0, 100, 20);

    jButton1.setText("AGREGAR");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton1);
    jButton1.setBounds(360, 20, 90, 27);

    jButtoncargar_matriz1.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
    jButtoncargar_matriz1.setText("SOLUCION");
    jButtoncargar_matriz1.setBorder(null);
    jButtoncargar_matriz1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtoncargar_matriz1ActionPerformed(evt);
      }
    });
    jPanel1.add(jButtoncargar_matriz1);
    jButtoncargar_matriz1.setBounds(370, 470, 190, 30);

    jButton2.setText("ELIMINAR");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton2);
    jButton2.setBounds(470, 20, 90, 27);

    javax.swing.GroupLayout graficaRegresionLayout = new javax.swing.GroupLayout(graficaRegresion);
    graficaRegresion.setLayout(graficaRegresionLayout);
    graficaRegresionLayout.setHorizontalGroup(
      graficaRegresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 360, Short.MAX_VALUE)
    );
    graficaRegresionLayout.setVerticalGroup(
      graficaRegresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 330, Short.MAX_VALUE)
    );

    jPanel1.add(graficaRegresion);
    graficaRegresion.setBounds(570, 10, 360, 330);

    tipo.setForeground(new java.awt.Color(0, 0, 0));
    tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lineal", "Polinomial", "Logaritmica", "Exponencial", "Potencial", " " }));
    tipo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipoActionPerformed(evt);
      }
    });
    jPanel1.add(tipo);
    tipo.setBounds(20, 470, 150, 30);

    grado.setForeground(new java.awt.Color(0, 0, 0));
    grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
    grado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        gradoActionPerformed(evt);
      }
    });
    jPanel1.add(grado);
    grado.setBounds(180, 470, 120, 30);

    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Tipo de regresion");
    jPanel1.add(jLabel1);
    jLabel1.setBounds(20, 450, 150, 15);

    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Grado");
    jPanel1.add(jLabel4);
    jLabel4.setBounds(180, 450, 70, 15);

    jButton3.setForeground(new java.awt.Color(0, 0, 0));
    jButton3.setText("Limpiar grafica");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton3);
    jButton3.setBounds(660, 350, 170, 27);

    cargar.setBackground(new java.awt.Color(0, 0, 0));
    cargar.setForeground(new java.awt.Color(255, 255, 255));
    cargar.setText("VOLVER AL INICIO");
    cargar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cargarActionPerformed(evt);
      }
    });
    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cargar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void numerodatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numerodatosActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_numerodatosActionPerformed

    private void jButtoncargar_matrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncargar_matrizActionPerformed

      try {

        // f = Integer.parseInt(numerodatos.getText());
        this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

        modelo = new DefaultTableModel(col, f);

        llenarmatriz.setModel(modelo);

      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
      }

      if (grado.getSelectedItem() == "1") {
        gradouno();
      } else {
        while (tipo.getSelectedItem() != "Lineal") {
          if (grado.getSelectedItem() == "1") {
            gradouno();
          } else if (grado.getSelectedItem() == "2") {
            gradodos();
          } else if (grado.getSelectedItem() == "3") {
            gradotres();
          } else if (grado.getSelectedItem() == "4") {
            gradocuatro();
          } else if (grado.getSelectedItem() == "5") {
            gradocinco();
          } else if (grado.getSelectedItem() == "6") {
            gradoseis();
          }

        }
        System.out.println("NO esta definido");
      }

    }//GEN-LAST:event_jButtoncargar_matrizActionPerformed
// Polinomial

  public double sumax() {
    double sumatoriax = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);
      sumatoriax = sumatoriax + valorint;
    }
    return sumatoriax;
  }

  public double sumay() {
    double sumatoriay = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 1));
      double valorint = convertir(valores);
      sumatoriay = sumatoriay + valorint;
    }
    return sumatoriay;
  }

  public double xcuadrado() {
    double xcuadrado = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuadrado = (xcuadrado + (valorint * valorint));

    }

    return xcuadrado;
  }

  public double xcubo() {
    double xcubo = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcubo = xcubo + (valorint * valorint * valorint);

    }

    return xcubo;
  }

  public double xcuatro() {
    double xcuatro = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuatro = xcuatro + (valorint * valorint * valorint * valorint);

    }

    return xcuatro;
  }

  public double xquinta() {
    double xquinta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xquinta = xquinta + (valorint * valorint * valorint * valorint * valorint);

    }

    return xquinta;
  }

  public double xsexta() {
    double xsexta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsexta = xsexta + (valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xsexta;
  }

  public double xsiete() {
    double xsiete = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsiete = xsiete + (valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xsiete;
  }

  public double xocho() {
    double xocho = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xocho = xocho + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xocho;
  }

  public double xnueve() {
    double xnueve = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xnueve = xnueve + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xnueve;
  }

  public double xdiez() {
    double xdiez = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdiez = xdiez + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xdiez;
  }

  public double xonce() {
    double xonce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xonce = xonce + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xonce;
  }

  public double xdoce() {
    double xdoce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdoce = xdoce + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xdoce;
  }

  public double xy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + mulx * muly;
    }
    return mulxy;
  }

  public double xcuadradoy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx) * muly;
    }
    return mulxy;
  }

  public double xcuboy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx * mulx) * muly;
    }
    return mulxy;
  }

  public double xcuatroy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx * mulx * mulx) * muly;
    }
    return mulxy;
  }

  public double xquintay() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx * mulx * mulx * mulx) * muly;
    }
    return mulxy;
  }

  public double xseisy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx * mulx * mulx * mulx * mulx) * muly;
    }
    return mulxy;
  }

  public void gradouno() {

    String datos = numerodatos.getText();
    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(sumay(), 0, 2);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xy(), 1, 2);
  }

  public void gradodos() {

    String datos = numerodatos.getText();

    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(xcuadrado(), 0, 2);
    modelo.setValueAt(sumay(), 0, 3);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xcubo(), 1, 2);
    modelo.setValueAt(xy(), 1, 3);

    modelo.setValueAt(xcuadrado(), 2, 0);
    modelo.setValueAt(xcubo(), 2, 1);
    modelo.setValueAt(xcuatro(), 2, 2);
    modelo.setValueAt(xcuadradoy(), 2, 3);
  }

  public void gradotres() {

    String datos = numerodatos.getText();

    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(xcuadrado(), 0, 2);
    modelo.setValueAt(xcubo(), 0, 3);
    modelo.setValueAt(sumay(), 0, 4);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xcubo(), 1, 2);
    modelo.setValueAt(xcuatro(), 1, 3);
    modelo.setValueAt(xy(), 1, 4);

    modelo.setValueAt(xcuadrado(), 2, 0);
    modelo.setValueAt(xcubo(), 2, 1);
    modelo.setValueAt(xcuatro(), 2, 2);
    modelo.setValueAt(xquinta(), 2, 3);
    modelo.setValueAt(xcuadradoy(), 2, 4);

    modelo.setValueAt(xcubo(), 3, 0);
    modelo.setValueAt(xcuatro(), 3, 1);
    modelo.setValueAt(xquinta(), 3, 2);
    modelo.setValueAt(xsexta(), 3, 3);
    modelo.setValueAt(xcuboy(), 3, 4);

  }

  public void gradocuatro() {

    String datos = numerodatos.getText();

    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(xcuadrado(), 0, 2);
    modelo.setValueAt(xcubo(), 0, 3);
    modelo.setValueAt(xcuatro(), 0, 4);
    modelo.setValueAt(sumay(), 0, 5);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xcubo(), 1, 2);
    modelo.setValueAt(xcuatro(), 1, 3);
    modelo.setValueAt(xquinta(), 1, 4);
    modelo.setValueAt(xy(), 1, 5);

    modelo.setValueAt(xcuadrado(), 2, 0);
    modelo.setValueAt(xcubo(), 2, 1);
    modelo.setValueAt(xcuatro(), 2, 2);
    modelo.setValueAt(xquinta(), 2, 3);
    modelo.setValueAt(xsexta(), 2, 4);
    modelo.setValueAt(xcuadradoy(), 2, 5);

    modelo.setValueAt(xcubo(), 3, 0);
    modelo.setValueAt(xcuatro(), 3, 1);
    modelo.setValueAt(xquinta(), 3, 2);
    modelo.setValueAt(xsexta(), 3, 3);
    modelo.setValueAt(xsiete(), 3, 4);
    modelo.setValueAt(xcuboy(), 3, 5);

    modelo.setValueAt(xcuatro(), 4, 0);
    modelo.setValueAt(xquinta(), 4, 1);
    modelo.setValueAt(xsexta(), 4, 2);
    modelo.setValueAt(xsiete(), 4, 3);
    modelo.setValueAt(xocho(), 4, 4);
    modelo.setValueAt(xcuatroy(), 4, 5);

  }

  public void gradocinco() {

    String datos = numerodatos.getText();

    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(xcuadrado(), 0, 2);
    modelo.setValueAt(xcubo(), 0, 3);
    modelo.setValueAt(xcuatro(), 0, 4);
    modelo.setValueAt(xquinta(), 0, 5);
    modelo.setValueAt(sumay(), 0, 6);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xcubo(), 1, 2);
    modelo.setValueAt(xcuatro(), 1, 3);
    modelo.setValueAt(xquinta(), 1, 4);
    modelo.setValueAt(xsexta(), 1, 5);
    modelo.setValueAt(xy(), 1, 6);

    modelo.setValueAt(xcuadrado(), 2, 0);
    modelo.setValueAt(xcubo(), 2, 1);
    modelo.setValueAt(xcuatro(), 2, 2);
    modelo.setValueAt(xquinta(), 2, 3);
    modelo.setValueAt(xsexta(), 2, 4);
    modelo.setValueAt(xsiete(), 2, 5);
    modelo.setValueAt(xcuadradoy(), 2, 6);

    modelo.setValueAt(xcubo(), 3, 0);
    modelo.setValueAt(xcuatro(), 3, 1);
    modelo.setValueAt(xquinta(), 3, 2);
    modelo.setValueAt(xsexta(), 3, 3);
    modelo.setValueAt(xsiete(), 3, 4);
    modelo.setValueAt(xocho(), 3, 5);
    modelo.setValueAt(xcuboy(), 3, 6);

    modelo.setValueAt(xcuatro(), 4, 0);
    modelo.setValueAt(xquinta(), 4, 1);
    modelo.setValueAt(xsexta(), 4, 2);
    modelo.setValueAt(xsiete(), 4, 3);
    modelo.setValueAt(xocho(), 4, 4);
    modelo.setValueAt(xnueve(), 4, 5);
    modelo.setValueAt(xcuatroy(), 4, 6);

    modelo.setValueAt(xquinta(), 5, 0);
    modelo.setValueAt(xsexta(), 5, 1);
    modelo.setValueAt(xsiete(), 5, 2);
    modelo.setValueAt(xocho(), 5, 3);
    modelo.setValueAt(xnueve(), 5, 4);
    modelo.setValueAt(xdiez(), 5, 5);
    modelo.setValueAt(xquintay(), 5, 6);

  }

  public void gradoseis() {

    String datos = numerodatos.getText();

    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(xcuadrado(), 0, 2);
    modelo.setValueAt(xcubo(), 0, 3);
    modelo.setValueAt(xcuatro(), 0, 4);
    modelo.setValueAt(xquinta(), 0, 5);
    modelo.setValueAt(xsexta(), 0, 6);
    modelo.setValueAt(sumay(), 0, 7);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xcubo(), 1, 2);
    modelo.setValueAt(xcuatro(), 1, 3);
    modelo.setValueAt(xquinta(), 1, 4);
    modelo.setValueAt(xsexta(), 1, 5);
    modelo.setValueAt(xsiete(), 1, 6);
    modelo.setValueAt(xy(), 1, 7);

    modelo.setValueAt(xcuadrado(), 2, 0);
    modelo.setValueAt(xcubo(), 2, 1);
    modelo.setValueAt(xcuatro(), 2, 2);
    modelo.setValueAt(xquinta(), 2, 3);
    modelo.setValueAt(xsexta(), 2, 4);
    modelo.setValueAt(xsiete(), 2, 5);
    modelo.setValueAt(xocho(), 2, 6);
    modelo.setValueAt(xcuadradoy(), 2, 7);

    modelo.setValueAt(xcubo(), 3, 0);
    modelo.setValueAt(xcuatro(), 3, 1);
    modelo.setValueAt(xquinta(), 3, 2);
    modelo.setValueAt(xsexta(), 3, 3);
    modelo.setValueAt(xsiete(), 3, 4);
    modelo.setValueAt(xocho(), 3, 5);
    modelo.setValueAt(xnueve(), 3, 6);
    modelo.setValueAt(xcuboy(), 3, 7);

    modelo.setValueAt(xcuatro(), 4, 0);
    modelo.setValueAt(xquinta(), 4, 1);
    modelo.setValueAt(xsexta(), 4, 2);
    modelo.setValueAt(xsiete(), 4, 3);
    modelo.setValueAt(xocho(), 4, 4);
    modelo.setValueAt(xnueve(), 4, 5);
    modelo.setValueAt(xdiez(), 4, 6);
    modelo.setValueAt(xcuatroy(), 4, 7);

    modelo.setValueAt(xquinta(), 5, 0);
    modelo.setValueAt(xsexta(), 5, 1);
    modelo.setValueAt(xsiete(), 5, 2);
    modelo.setValueAt(xocho(), 5, 3);
    modelo.setValueAt(xnueve(), 5, 4);
    modelo.setValueAt(xdiez(), 5, 5);
    modelo.setValueAt(xonce(), 5, 6);
    modelo.setValueAt(xquintay(), 5, 7);

    modelo.setValueAt(xsexta(), 6, 0);
    modelo.setValueAt(xsiete(), 6, 1);
    modelo.setValueAt(xocho(), 6, 2);
    modelo.setValueAt(xnueve(), 6, 3);
    modelo.setValueAt(xdiez(), 6, 4);
    modelo.setValueAt(xonce(), 6, 5);
    modelo.setValueAt(xdoce(), 6, 6);
    modelo.setValueAt(xseisy(), 6, 7);

  }

// Logaritmica
  public double sumalogx() {
    double sumatoriax = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);
      sumatoriax = sumatoriax + (Math.log(valorint));
    }
    return sumatoriax;
  }

  public double sumalogy() {
    double sumatoriay = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 1));
      double valorint = convertir(valores);
      sumatoriay = sumatoriay + (valorint);
    }
    return sumatoriay;
  }

  public double logxcuadrado() {
    double xcuadrado = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuadrado = (xcuadrado + (Math.log(valorint) * Math.log(valorint)));

    }

    return xcuadrado;
  }

  public double logxcubo() {
    double xcubo = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcubo = xcubo + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xcubo;
  }

  public double logxcuatro() {
    double xcuatro = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuatro = xcuatro + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xcuatro;
  }

  public double logxquinta() {
    double xquinta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xquinta = xquinta + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xquinta;
  }

  public double logxsexta() {
    double xsexta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsexta = xsexta + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xsexta;
  }

  public double logxsiete() {
    double xsiete = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsiete = xsiete + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xsiete;
  }

  public double logxocho() {
    double xocho = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xocho = xocho + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xocho;
  }

  public double logxnueve() {
    double xnueve = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xnueve = xnueve + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xnueve;
  }

  public double logxdiez() {
    double xdiez = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdiez = xdiez + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xdiez;
  }

  public double logxonce() {
    double xonce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xonce = xonce + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xonce;
  }

  public double logxdoce() {
    double xdoce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdoce = xdoce + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xdoce;
  }

  public double logxy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx)) * (muly);
    }
    return mulxy;
  }

  public double logxcuadradoy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx)) * (muly);
    }
    return mulxy;
  }

  public double logxcuboy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * (muly);
    }
    return mulxy;
  }

  public double logxcuatroy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * (muly);
    }
    return mulxy;
  }

  public double logxquintay() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * muly;
    }
    return mulxy;
  }

  public double logxseisy() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * muly;
    }
    return mulxy;
  }

  public void gradounolog() {

    String datos = numerodatos.getText();
    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumalogx(), 0, 1);
    modelo.setValueAt(sumay(), 0, 2);

    modelo.setValueAt(sumalogx(), 1, 0);
    modelo.setValueAt(logxcuadrado(), 1, 1);
    modelo.setValueAt(logxy(), 1, 2);

  }

// Exponencial
  public double sumaxex() {
    double sumatoriax = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);
      sumatoriax = sumatoriax + valorint;
    }
    return sumatoriax;
  }

  public double sumayex() {
    double sumatoriay = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 1));
      double valorint = convertir(valores);
      sumatoriay = sumatoriay + valorint;
    }
    return sumatoriay;
  }

  public double xcuadradoex() {
    double xcuadrado = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuadrado = (xcuadrado + (valorint * valorint));

    }

    return xcuadrado;
  }

  public double xcuboex() {
    double xcubo = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcubo = xcubo + (valorint * valorint * valorint);

    }

    return xcubo;
  }

  public double xcuatroex() {
    double xcuatro = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuatro = xcuatro + (valorint * valorint * valorint * valorint);

    }

    return xcuatro;
  }

  public double xquintaex() {
    double xquinta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xquinta = xquinta + (valorint * valorint * valorint * valorint * valorint);

    }

    return xquinta;
  }

  public double xsextaex() {
    double xsexta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsexta = xsexta + (valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xsexta;
  }

  public double xsieteex() {
    double xsiete = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsiete = xsiete + (valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xsiete;
  }

  public double xochoex() {
    double xocho = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xocho = xocho + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xocho;
  }

  public double xnueveex() {
    double xnueve = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xnueve = xnueve + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xnueve;
  }

  public double xdiezex() {
    double xdiez = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdiez = xdiez + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xdiez;
  }

  public double xonceex() {
    double xonce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xonce = xonce + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xonce;
  }

  public double xdoceex() {
    double xdoce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdoce = xdoce + (valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint * valorint);

    }

    return xdoce;
  }

  public double logyex() {
    double sumlogy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {

      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double logy = convertir(valoresy);

      sumlogy = sumlogy + (Math.log(logy));
    }
    return sumlogy;
  }

  public double xlogyex() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * (Math.log(muly)));
    }
    return mulxy;
  }

  public double xcuadradologyex() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (mulx * mulx) * (Math.log(muly));
    }
    return mulxy;
  }

  public void gradounoex() {

    String datos = numerodatos.getText();
    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumax(), 0, 1);
    modelo.setValueAt(logyex(), 0, 2);

    modelo.setValueAt(sumax(), 1, 0);
    modelo.setValueAt(xcuadrado(), 1, 1);
    modelo.setValueAt(xlogyex(), 1, 2);

  }

// potencial
  public double sumalogxpt() {
    double sumatoriax = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);
      sumatoriax = sumatoriax + (Math.log(valorint));
    }
    return sumatoriax;
  }

  public double sumalogypt() {
    double sumatoriay = 0;
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 1));
      double valorint = convertir(valores);
      sumatoriay = sumatoriay + (Math.log(valorint));
    }
    return sumatoriay;
  }

  public double logxcuadradopt() {
    double xcuadrado = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuadrado = (xcuadrado + (Math.log(valorint) * Math.log(valorint)));

    }

    return xcuadrado;
  }

  public double logxcubopt() {
    double xcubo = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcubo = xcubo + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xcubo;
  }

  public double logxcuatropt() {
    double xcuatro = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xcuatro = xcuatro + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xcuatro;
  }

  public double logxquintapt() {
    double xquinta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xquinta = xquinta + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xquinta;
  }

  public double logxsextapt() {
    double xsexta = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsexta = xsexta + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xsexta;
  }

  public double logxsietept() {
    double xsiete = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xsiete = xsiete + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xsiete;
  }

  public double logxochopt() {
    double xocho = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xocho = xocho + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xocho;
  }

  public double logxnuevept() {
    double xnueve = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xnueve = xnueve + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xnueve;
  }

  public double logxdiezpt() {
    double xdiez = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdiez = xdiez + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xdiez;
  }

  public double logxoncept() {
    double xonce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xonce = xonce + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xonce;
  }

  public double logxdocept() {
    double xdoce = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valores = String.valueOf(ingresar.getValueAt(i, 0));
      double valorint = convertir(valores);

      xdoce = xdoce + (Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint) * Math.log(valorint));

    }

    return xdoce;
  }

  public double logxlogypt() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx)) * (Math.log(muly));
    }
    return mulxy;
  }

  public double logxcuadradologypt() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx)) * (Math.log(muly));
    }
    return mulxy;
  }

  public double logxcubologypt() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * (Math.log(muly));
    }
    return mulxy;
  }

  public double logxcuatrologypt() {
    double mulxy = 0;

    for (int i = 0; i < ingresar.getRowCount(); i++) {
      String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
      String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

      double mulx = convertir(valoresx);
      double muly = convertir(valoresy);

      mulxy = mulxy + (Math.log(mulx) * Math.log(mulx) * Math.log(mulx) * Math.log(mulx)) * (Math.log(muly));
    }
    return mulxy;
  }

  public void gradounopt() {

    String datos = numerodatos.getText();
    modelo.setValueAt(datos, 0, 0);
    modelo.setValueAt(sumalogxpt(), 0, 1);
    modelo.setValueAt(sumalogypt(), 0, 2);

    modelo.setValueAt(sumalogxpt(), 1, 0);
    modelo.setValueAt(logxcuadradopt(), 1, 1);
    modelo.setValueAt(logxlogypt(), 1, 2);

  }

    private void jButtoncargar_matriz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncargar_matriz1ActionPerformed
      area_de_texto.setText("");
      desviacion.setText("");

      if (tipo.getSelectedItem() == "Lineal" && grado.getSelectedItem() == "1" || tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "1") {

        try {
          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado

          int n = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
          this.c = this.f + 1;

          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            //area_de_texto.append("res" + (i+1) + " = " + r[i] + "\n" );

          }
          area_de_texto.append(r[0] + " + (" + r[1] + ")*x");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.5);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);

// realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx)), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (1 + 1)));

          desviacion.setText("Sxy = " + sxy);

        } catch (Exception e) {

        }
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "2") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 3;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            //  area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.5);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);
// realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (2 + 1)));
          desviacion.setText("\n Sxy = " + sxy);
        } catch (Exception e) {

        }

      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "3") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 4;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + "+(" + r[1] + ")*x +(" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.5);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);
          // realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2)) + (r[2] * Math.pow(valorintx, 3))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (3 + 1)));
          desviacion.setText("\n Sxy = " + sxy);
        } catch (Exception e) {

        }
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "4") {
        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 5;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            //  area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");

          }
          area_de_texto.append(r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4] + ")*x^4");
          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.5);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);

          // realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2)) + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (4 + 1)));
          desviacion.setText("\n Sxy = " + sxy);
        } catch (Exception e) {

        }

      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "5") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 6;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            //  area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " +(" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4] + ")*x^4 + " + "(" + r[5] + ")*x^5");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.5);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);
          // realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2)) + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4)) + (r[2] * Math.pow(valorintx, 5))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (5 + 1)));
          desviacion.setText("\n Sxy = " + sxy);
        } catch (Exception e) {

        }
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "6") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 7;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " + (" + r[1] + ")*x + (" + r[2] + ")*x^2 + " + "(" + r[3] + ")*x^3 + " + "(" + r[4] + ")*x^4 + " + "(" + r[5] + ")*x^5 + " + "(" + r[6] + ")*x^6");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.2);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);

          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * valorintx) + (r[2] * Math.pow(valorintx, 2)) + (r[2] * Math.pow(valorintx, 3)) + (r[2] * Math.pow(valorintx, 4)) + (r[2] * Math.pow(valorintx, 5)) + (r[2] * Math.pow(valorintx, 6))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (6 + 1)));
          desviacion.setText("\n Sxy = " + sxy);

        } catch (Exception e) {

        }
      } // Logaritmica
      else if (tipo.getSelectedItem() == "Logaritmica" && grado.getSelectedItem() == "1") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 2;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " + " + r[1] + "*ln(x)");
          // realizar sxy = raiz((y-ya)^2/n -(n+1))
          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.2);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);

          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * Math.log(valorintx))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (1 + 1)));
          desviacion.setText("\n Sxy = " + sxy);

        } catch (Exception e) {

        }

      } // Exponencial
      else if (tipo.getSelectedItem() == "Exponencial" && grado.getSelectedItem() == "1") {
        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 2;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " * e^(" + r[1] + "*x)");
          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.2);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);

          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] + (r[1] * Math.log(valorintx))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (1 + 1)));
          desviacion.setText("\n Sxy = " + sxy);

        }//fin try
        catch (Exception e) {

        }

      } // potencial
      else if (tipo.getSelectedItem() == "Potencial" && grado.getSelectedItem() == "1") {

        try {

          //int n = Integer.parseInt(numerodatos.getText());// alamacena el nuemro de ingonitas ingresado por teclado
          int n = 2;
          double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada 
          double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

          for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
            for (int j = 0; j < n; j++) {//
              m[i][j] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, j)));
            }
            r[i] = Double.parseDouble(String.valueOf(llenarmatriz.getValueAt(i, n)));
          }

          double solucion[] = new double[n];// almacena la soluciones del sistema
          r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones 

          //pasamos a mostrar las soluciones del sistema en el area de texto
          for (int i = 0; i < n; i++) {
            // area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
          }
          area_de_texto.append(r[0] + " * x^(" + r[1] + ")");

          String def = area_de_texto.getText();
          Funcion f = new Funcion(def);
          double[] x = f.rango(-20, 20, 0.2);
          double[] y = f.eval(x);
          grafica.createGraph(def, x, y);
// realizar sxy = raiz((y-ya)^2/n -(n+1))
          int i = 0;
          double sr = 0;
          double sxy = 0;

          do {
            String valoresx = String.valueOf(ingresar.getValueAt(i, 0));
            String valoresy = String.valueOf(ingresar.getValueAt(i, 1));

            double valorintx = Double.parseDouble(valoresx);
            double valorinty = Double.parseDouble(valoresy);

            sr = sr + Math.pow(valorinty - (r[0] * (Math.pow(valorintx, r[1]))), 2);
            i++;

          } while (i < ingresar.getRowCount());

          double num = convertir(numerodatos.getText());

          System.out.println("sr " + sr);
          sxy = Math.sqrt(sr / (num - (1 + 1)));
          desviacion.setText("\n Sxy = " + sxy);
        }//fin try
        catch (Exception e) {

        }

      } else {
        System.out.println("no esta");
      }

    }//GEN-LAST:event_jButtoncargar_matriz1ActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_xActionPerformed

  public void contardatos() {
    for (int i = 0; i < ingresar.getRowCount(); i++) {
      numerodatos.setText("" + (i + 1));
    }
  }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      if (this.x.getText().isEmpty() || this.y.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Hay campos vacios");
      } else {
        double valorx = Double.parseDouble(x.getText());
        double valory = Double.parseDouble(y.getText());

        Object datos[] = {valorx, valory};
        modeloDatos.addRow(datos);

        contardatos();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int fila = ingresar.getSelectedRow();
      if (fila > 0) {
        modeloDatos.removeRow(fila);
      }

      contardatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
      this.dispose();
      new Principal().getFrame().setVisible(true);
    }//GEN-LAST:event_cargarActionPerformed

    private void gradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradoActionPerformed
      desviacion.setText("");
      if (tipo.getSelectedItem() == "Lineal" && grado.getSelectedItem() == "1" || tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradouno();

      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "2") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradodos();
      } // grado 3
      else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "3") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradotres();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "4") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradocuatro();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "5") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradocinco();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "6") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoseis();
      }

      // logaritmica
      if (tipo.getSelectedItem() == "Logaritmica" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradounolog();

      } // potencial
      else if (tipo.getSelectedItem() == "Potencial" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradounopt();
      } else {
        System.out.println("no hay");
      }


    }//GEN-LAST:event_gradoActionPerformed

    private void llenarmatrizKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_llenarmatrizKeyTyped

      gradouno();


    }//GEN-LAST:event_llenarmatrizKeyTyped

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
      desviacion.setText("");
      if (tipo.getSelectedItem() == "Lineal" && grado.getSelectedItem() == "1" || tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradouno();

      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "2") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradodos();
      } // grado 3
      else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "3") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradotres();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "4") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradocuatro();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "5") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradocinco();
      } else if (tipo.getSelectedItem() == "Polinomial" && grado.getSelectedItem() == "6") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradoseis();
      } // logaritmica
      else if (tipo.getSelectedItem() == "Logaritmica" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradounolog();
      } // Exponencial
      else if (tipo.getSelectedItem() == "Exponencial" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradounoex();
      } // potencial
      else if (tipo.getSelectedItem() == "Potencial" && grado.getSelectedItem() == "1") {
        try {

          // f = Integer.parseInt(numerodatos.getText());
          this.f = Integer.parseInt(this.grado.getSelectedItem().toString()) + 1;
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

          modelo = new DefaultTableModel(col, f);

          llenarmatriz.setModel(modelo);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR EN EL INGRESO DE LOS DATOS", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }

        gradounopt();
      } else {
        System.out.println("no hay");
      }


    }//GEN-LAST:event_tipoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      grafica.clear();
    }//GEN-LAST:event_jButton3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextArea area_de_texto;
  private javax.swing.JButton cargar;
  private javax.swing.JTextField desviacion;
  private javax.swing.JComboBox<String> grado;
  private javax.swing.JPanel graficaRegresion;
  private javax.swing.JTable ingresar;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButtoncargar_matriz;
  private javax.swing.JButton jButtoncargar_matriz1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable llenarmatriz;
  private javax.swing.JTextField numerodatos;
  private javax.swing.JComboBox<String> tipo;
  private javax.swing.JTextField x;
  private javax.swing.JTextField y;
  // End of variables declaration//GEN-END:variables
}
