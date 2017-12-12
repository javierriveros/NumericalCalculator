package views.equationsRoots;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import methods.equationsRoots.Bisection;
import methods.equationsRoots.Newton;
import methods.integration.Simpson;
import util.Messages;
import util.Operations;
import util.Validations;
import views.Principal;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NewtonView extends JPanel {
	private JTextField xiField;
	private JTextField functionField;
	private JFormattedTextField snField;
	private JTextField resultField;
	private JButton solveButton;
	private JPanel panel;
	private JPanel actionsPanel;
	private JComboBox typecomboBox;

	private Principal principal;
	private JButton btnVolverAlInicio;

	/**
	 * Create the panel.
	 */
	public NewtonView(Principal principal) {
		this.principal = principal;
		configureWindow();
		
		setLayout(new BorderLayout(0, 0));

		actionsPanel = new JPanel();
		add(actionsPanel, BorderLayout.NORTH);
		actionsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JComboBox typecomboBox = new JComboBox();
		typecomboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Biseccion", "Falsa Posicion", "Newton Raphson", "Secante", "Secante Modificado" }));
		typecomboBox.addItemListener(e -> principal.goToPanel(typecomboBox.getSelectedItem().toString()));
		actionsPanel.add(typecomboBox);

		btnVolverAlInicio = new JButton("VOLVER AL INICIO");
		btnVolverAlInicio.addActionListener(e -> this.principal.goToPanel("Principal"));
		actionsPanel.add(btnVolverAlInicio);

		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 0, 10, 10));

		JPanel panelData = new JPanel();
		panel.add(panelData);
		panelData.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panelXs = new JPanel();
		panelData.add(panelXs);
		panelXs.setLayout(new GridLayout(0, 2, 0, 0));

		xiField = new JTextField();
		xiField.setBorder(new TitledBorder(null, "Xi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelXs.add(xiField);
		xiField.setColumns(10);

		snField = new JFormattedTextField(new Integer(5));
		snField.setBorder(new TitledBorder(null, "Cifras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelXs.add(snField);
		snField.setColumns(10);

		functionField = new JTextField();
		functionField.setBorder(new TitledBorder(null, "Fx", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelData.add(functionField);
		functionField.setColumns(10);

		JPanel panelResult = new JPanel();
		panel.add(panelResult);
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

	}

	private void solve() {
		String xi = this.xiField.getText();
		String n = this.snField.getText();
		String function = this.functionField.getText();

		if (Validations.isEmpty(xi) || Validations.isEmpty(function)) {
			Messages.errorMessage("Debes llenar todos los campos");
			return;
		}

		if (!Validations.isNumeric(xi) || !Validations.isNumeric(n)) {
			Messages.errorMessage("Los intervalos deben ser numéricos");
			return;
		}

		Double xiD = Double.parseDouble(xi);
		Integer nI = Integer.parseInt(n);

		try {
			Newton newton = new Newton(function, xiD, nI);
			Double result = Operations.roundD(newton.result(), nI);
			this.resultField.setText(String.valueOf(result));
		} catch (Exception ex) {
			this.resultField.setText("Math ERROR");
		}
	}
	
	private void configureWindow() {
		this.principal.getFrame().setTitle("Newton Raphson");
		this.principal.getFrame().setSize(600, 400);
    this.principal.getFrame().setLocationRelativeTo(null);
	}
}
