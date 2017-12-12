package views;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import methods.curvesAdjustment.Gradouno;
import views.equationsRoots.BisectionView;
import views.equationsRoots.FakePositionView;
import views.equationsRoots.NewtonView;
import views.equationsRoots.SecantModifiedView;
import views.equationsRoots.SecantView;

public class Principal {

  private JFrame frame;
  private JPanel mainPanel;
  private Font mainFont;

  /**
   * Launch the application.
   * @param args
   */
  public static void main(String...args) {
    try {
      javax.swing.UIManager.setLookAndFeel(SyntheticaPlainLookAndFeel.class.getName());
      System.out.println("Completado");
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
      System.out.println("Falló");
    }

    java.awt.EventQueue.invokeLater(() -> {
      Principal window = new Principal();
      window.frame.setVisible(true);
    });
  }

  /**
   * Create the application.
   *
   * @wbp.parser.entryPoint
   */
  public Principal() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setSize(950, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainFont = new Font("Roboto", Font.PLAIN, 25);

    mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new GridLayout(0, 1, 10, 10));

    JPanel topPanel = new JPanel();
    topPanel.setBackground(Color.WHITE);
    mainPanel.add(topPanel);
    topPanel.setLayout(new GridLayout(0, 3, 10, 10));

    JButton firstButton = new JButton("Raices de ecuaciones");
    firstButton.setLayout(new GridLayout(2, 6));
    firstButton.setIcon(new ImageIcon(Principal.class.getResource("/img/square.png")));
    firstButton.addActionListener(e -> goToPanel("Biseccion"));

    JButton secondButton = new JButton("Ajuste de curvas");
    secondButton.setHorizontalAlignment(SwingConstants.CENTER);
    secondButton.setIcon(new ImageIcon(Principal.class.getResource("/img/fx.png")));
    secondButton.addActionListener(e -> goToPanel("CurvesAdjustment"));

    topPanel.add(firstButton);
    topPanel.add(secondButton);
    
    JButton fifthButton = new JButton("Series de Taylor");
    fifthButton.setIcon(new ImageIcon(Principal.class.getResource("/img/series.jpg")));
    fifthButton.addActionListener(e -> goToPanel("TaylorSeries"));
    topPanel.add(fifthButton);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.WHITE);
    mainPanel.add(bottomPanel);
    bottomPanel.setLayout(new GridLayout(1, 2, 10, 10));

    JButton thirdButton = new JButton("Integración numérica");
    thirdButton.setIcon(new ImageIcon(Principal.class.getResource("/img/integral.png")));
    thirdButton.setHorizontalAlignment(SwingConstants.CENTER);
    thirdButton.addActionListener(e -> goToPanel("NumericalIntegration"));

    JButton fourthButton = new JButton("Derivación numérica");
    fourthButton.setIcon(new ImageIcon(Principal.class.getResource("/img/cartesian.png")));
    fourthButton.setHorizontalAlignment(SwingConstants.CENTER);
    fourthButton.addActionListener(e -> goToPanel("NumericalDerivation"));

    bottomPanel.add(thirdButton);
    bottomPanel.add(fourthButton);

  }

  public void goToPanel(String className) {
    JPanel panel = null;
    switch (className) {
      case "CurvesAdjustment":
        panel = new JPanel();
        this.frame.dispose();
        new Gradouno().setVisible(true);
        
        break;
      case "NumericalIntegration":
        panel = new NumericalIntegrationView(this);
        break;
      case "NumericalDerivation":
        panel = new NumericalDerivationView(this);
        break;
      case "Biseccion":
        panel = new BisectionView(this);
        break;
      case "Falsa Posicion":
        panel = new FakePositionView(this);
        break;
      case "Newton Raphson":
        panel = new NewtonView(this);
        break;
      case "Secante":
        panel = new SecantView(this);
        break;
      case "Secante Modificado":
        panel = new SecantModifiedView(this);
        break;
      case "TaylorSeries":
        panel = new TaylorSeriesView(this);
        break;
      case "Principal":
        panel = mainPanel;
        this.frame.setSize(950, 600);
        this.frame.setLocationRelativeTo(null);
        break;
    }
    this.frame.setContentPane(panel);
    this.frame.repaint();
    this.frame.revalidate();
  }

  public JFrame getFrame() {
    return frame;
  }
}
