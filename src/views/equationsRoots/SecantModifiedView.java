package views.equationsRoots;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import methods.equationsRoots.SecantModified;
import util.Funcion;
import util.Graph;
import util.Messages;
import util.Operations;
import util.Validations;
import views.Principal;

public class SecantModifiedView extends JPanel {

	private JTextField xiField;
	private JTextField dxField;
	private JTextField functionField;
	private JFormattedTextField snField;
	private JTextField resultField;
	private JButton solveButton;
	private JPanel mainPanel;
	private JPanel actionsPanel;

	private Principal principal;
	private JComboBox comboBox;
	private JButton button;
	private Graph graph;
	private JPanel panel;
	private JPanel graphPanel;

	/**
	 * Create the panel.
	 */
	public SecantModifiedView(Principal principal) {
		this.principal = principal;
		configureWindow();

		this.graph = new Graph("Gráfica", null, null);
		setLayout(new GridLayout(0, 2, 10, 10));

		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		actionsPanel = new JPanel();
		panel.add(actionsPanel, BorderLayout.NORTH);
		actionsPanel.setLayout(new GridLayout(0, 2, 10, 10));

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Biseccion", "Falsa Posicion", "Newton Raphson", "Secante" }));
		comboBox.addActionListener(e -> principal.goToPanel(comboBox.getSelectedItem().toString()));
		actionsPanel.add(comboBox);

		button = new JButton("VOLVER AL INICIO");
		button.addActionListener(e -> this.principal.goToPanel("Principal"));
		actionsPanel.add(button);

		mainPanel = new JPanel();
		panel.add(mainPanel);
		mainPanel.setLayout(new GridLayout(2, 0, 20, 20));

		JPanel panelData = new JPanel();
		mainPanel.add(panelData);
		panelData.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panelXs = new JPanel();
		panelData.add(panelXs);
		panelXs.setLayout(new GridLayout(0, 3, 0, 0));

		xiField = new JTextField();
		xiField.setBorder(new TitledBorder(null, "Xi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelXs.add(xiField);
		xiField.setColumns(10);

		dxField = new JTextField("0.001");
		dxField.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "\u03B4", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelXs.add(dxField);
		dxField.setColumns(10);

		snField = new JFormattedTextField(new Integer(5));
		snField.setBorder(new TitledBorder(null, "Cifras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelXs.add(snField);
		snField.setColumns(10);

		functionField = new JTextField();
		functionField.setBorder(new TitledBorder(null, "Fx", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelData.add(functionField);
		functionField.setColumns(10);

		JPanel panelResult = new JPanel();
		mainPanel.add(panelResult);
		panelResult.setLayout(new BorderLayout(0, 0));

		solveButton = new JButton("Resolver");
		solveButton.addActionListener(e -> solve());
		panelResult.add(solveButton, BorderLayout.NORTH);

		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		resultField.setFont(new Font("Roboto Mono", Font.PLAIN, 20));
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		panelResult.add(resultField);
		resultField.setColumns(10);

		graphPanel = graph.viewGraph();
		add(graphPanel);

	}

	private void solve() {
		String xi = this.xiField.getText();
		String dx = this.dxField.getText();
		String n = this.snField.getText();
		String function = this.functionField.getText();

		if (Validations.isEmpty(xi) || Validations.isEmpty(dx) || Validations.isEmpty(function)) {
			Messages.errorMessage("Debes llenar todos los campos");
			return;
		}

		if (!Validations.isNumeric(xi) || !Validations.isNumeric(dx) || !Validations.isNumeric(n)) {
			Messages.errorMessage("Los intervalos deben ser numéricos");
			return;
		}

		Double xiD = Double.parseDouble(xi);
		Double dxD = Double.parseDouble(dx);
		Integer nI = Integer.parseInt(n);

		try {
			SecantModified sm = new SecantModified(function, xiD, dxD, nI);
			Double result = Operations.roundD(sm.result(), nI);
			this.resultField.setText(String.valueOf(result));
		} catch (Exception ex) {
			this.resultField.setText("Math ERROR");
		}

		graph.clear();
		try {
			double inter1 = Double.parseDouble(this.resultField.getText()) - 5;
			double inter2 = Double.parseDouble(this.resultField.getText()) + 5;
			Funcion f = new Funcion(function);
			double[] x = f.rango(inter1, inter2, 0.2);
			double[] y = f.eval(x);
			graph.createGraph(function, x, y);

		} catch (Exception ex) {
			this.resultField.setText("Math ERROR");
		}
	}

	private void configureWindow() {
		this.principal.getFrame().setTitle("Secante Modificado");
		this.principal.getFrame().setSize(900, 500);
		this.principal.getFrame().setLocationRelativeTo(null);
	}
}
