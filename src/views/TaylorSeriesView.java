package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import methods.taylorSeries.TaylorSeries;
import util.Messages;
import util.Operations;
import util.Validations;

public class TaylorSeriesView extends JPanel {
	private Principal principal;
	private JTextField resultField;
	private JTextField functionField;
	private JTextField xField;

	/**
	 * Create the panel.
	 */
	public TaylorSeriesView(Principal principal) {
		this.principal = principal;
		setLayout(new GridLayout(2, 1, 10, 10));
		configureWindow();

		JPanel topPanel = new JPanel();
		add(topPanel);
		topPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel firstPanel = new JPanel();
		firstPanel.setForeground(Color.WHITE);
		topPanel.add(firstPanel);
		firstPanel.setLayout(new BorderLayout(0, 0));

		functionField = new JTextField();
		functionField.setBorder(new TitledBorder(null, "Función", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		firstPanel.add(functionField, BorderLayout.CENTER);
		functionField.setColumns(10);

		JPanel secondPanel = new JPanel();
		topPanel.add(secondPanel);
		secondPanel.setLayout(new BorderLayout(0, 0));

		xField = new JTextField();
		xField.setBorder(new TitledBorder(null, "X", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		secondPanel.add(xField);
		xField.setColumns(10);

		JPanel bottomPanel = new JPanel();
		add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		bottomPanel.add(panel, BorderLayout.NORTH);

		JButton button = new JButton("Calcular");
		button.addActionListener(e -> solve());
		panel.add(button);

		resultField = new JTextField();
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		resultField.setForeground(Color.BLACK);
		resultField.setFont(new Font("Roboto Mono", Font.PLAIN, 35));
		resultField.setEnabled(false);
		resultField.setEditable(false);
		resultField.setColumns(10);
		resultField.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "El resultado es", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		bottomPanel.add(resultField, BorderLayout.CENTER);
		
		JPanel panelBack = new JPanel();
		bottomPanel.add(panelBack, BorderLayout.SOUTH);
		
		JButton backButton = new JButton("VOLVER AL INICIO");
		backButton.addActionListener(e -> this.principal.goToPanel("Principal"));
		panelBack.add(backButton);
		this.principal.getFrame().setTitle("Derivación numérica");
	}
	
	private void solve() {
		String f = this.functionField.getText();
		String x = this.xField.getText();
		
		if (Validations.isEmpty(f) || Validations.isEmpty(x)) {
			Messages.errorMessage("Debes llenar todos los campos");
			return;
		}
		
		if (!Validations.isNumeric(x)) {
			Messages.errorMessage("El valor de X debe ser numérico");
			return;
		}
		
		try {
			double temp;
			TaylorSeries ts = new TaylorSeries(f, x);
      temp = ts.solve();
			this.resultField.setText(String.valueOf(Operations.roundD(temp, 2)));
					
		} catch(NumberFormatException e) {
			Messages.errorMessage("Hubo un error en el cálculo, intentalo de nuevo");
		}
	}

	private void configureWindow() {
		this.principal.getFrame().setTitle("Integración numérica");
		this.principal.getFrame().setSize(500, 400);
    this.principal.getFrame().setLocationRelativeTo(null);
	}
}
