package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.ComponentOrientation;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JPanel mainPanel;
	private Font mainFont;
	private EtchedBorder panelsBorder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(SyntheticaPlainLookAndFeel.class.getName());
			System.out.println("Completado");
		} catch (Exception e) {
			System.out.println("Falló");
		}

		java.awt.EventQueue.invokeLater(() -> {
			Principal window = new Principal();
			window.frame.setVisible(true);
		});
	}

	/**
	 * Create the application.
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
		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFont = new Font("Roboto", Font.PLAIN, 25);
		panelsBorder = new EtchedBorder(EtchedBorder.LOWERED, null, null);

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		mainPanel.add(topPanel);
		topPanel.setLayout(new GridLayout(0, 2, 10, 10));

		JButton firstButton = new JButton("Raices de ecuaciones");
		firstButton.setLayout(new GridLayout(2, 6));
		firstButton.setIcon(new ImageIcon(Principal.class.getResource("/img/square.png")));
		firstButton.addActionListener(e -> goToPanel("EquationsRoots"));

		JButton secondButton = new JButton("Ajuste de curvas");
		secondButton.setHorizontalAlignment(SwingConstants.CENTER);
		secondButton.setIcon(new ImageIcon(Principal.class.getResource("/img/fx.png")));
		secondButton.addActionListener(e -> goToPanel("CurvesAdjustment"));
		
		topPanel.add(firstButton);
		topPanel.add(secondButton);
		
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
	
	private void goToPanel(String className) {
		JPanel panel = null;
		switch (className) {
			case "EquationsRoots":
				panel = new EquationsRoots(this);
				break;
			case "CurvesAdjustment":
				panel = new CurvesAdjustment(this);
				break;
			case "NumericalIntegration":
				panel = new NumericalIntegration(this);
				break;
			case "NumericalDerivation":
				panel = new NumericalDerivation(this);
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
