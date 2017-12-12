package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import methods.integration.Simpson;
import util.Messages;
import util.Operations;
import util.Validations;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumericalIntegrationView extends JPanel {
	private Principal principal;
	private JTextField bTextField;
	private JTextField aTextField;
	private JTextField functionTextField;
	private JTextField resultField;
	/**
	 * Create the panel.
	 */
	public NumericalIntegrationView(Principal principal) {
		this.principal = principal;
		configureWindow();
		setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel topPanel = new JPanel();
		add(topPanel);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setForeground(Color.WHITE);
		topPanel.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		leftPanel.add(panel_3, BorderLayout.NORTH);
		
		bTextField = new JTextField();
		bTextField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(bTextField);
		bTextField.setColumns(2);
		
		JPanel panel_2 = new JPanel();
		leftPanel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(NumericalIntegrationView.class.getResource("/img/integral.png")));
		panel_2.add(lblImg);
		
		functionTextField = new JTextField();
		functionTextField.setFont(new Font("Roboto Mono", Font.PLAIN, 20));
		panel_2.add(functionTextField);
		functionTextField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		leftPanel.add(panel_4, BorderLayout.SOUTH);
		
		aTextField = new JTextField();
		aTextField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(aTextField);
		aTextField.setColumns(2);
		
		JPanel bottomPanel = new JPanel();
		add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		resultField = new JTextField();
		resultField.setForeground(Color.BLACK);
		resultField.setFont(new Font("Roboto Mono", Font.PLAIN, 35));
		resultField.setEditable(false);
		resultField.setEnabled(false);
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		resultField.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "El resultado es", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		bottomPanel.add(resultField);
		resultField.setColumns(10);
		
		JPanel panel = new JPanel();
		bottomPanel.add(panel, BorderLayout.NORTH);
		
		JButton btnSolve = new JButton("Calcular");
		panel.add(btnSolve);
		
		JPanel panelBack = new JPanel();
		bottomPanel.add(panelBack, BorderLayout.SOUTH);
		
		JButton button = new JButton("VOLVER AL INICIO");
		button.addActionListener(e -> this.principal.goToPanel("Principal"));
		panelBack.add(button);
		btnSolve.addActionListener(e -> solve());
	}

	private void solve() {
		String a = this.aTextField.getText();
		String b = this.bTextField.getText();
		String function = this.functionTextField.getText();
		
		if (Validations.isEmpty(a) || Validations.isEmpty(b) || Validations.isEmpty(function)) {
			Messages.errorMessage("Debes llenar todos los campos");
			return;
		}
		
		if (!Validations.isNumeric(a) || !Validations.isNumeric(b)) {
			Messages.errorMessage("Los intervalos de integración deben ser numéricos");
			return;
		}
    
    if (a.equals(b)) {
      Messages.errorMessage("Los intervalos no pueden ser iguales");
			return;
    }
		
		try {
      new Thread(() -> {
        Double temporal = Double.valueOf(Simpson.integral(a, b, function, 500));
        resultField.setText(String.valueOf(Operations.roundD(temporal, 3)));
      }).start();
    } catch (Exception ex) {
      this.resultField.setText("Math ERROR");
    }
		
//		double temp = Double.valueOf(Simpson.calcularIntegral(function, a, b));
//		this.resultField.setText(String.valueOf(Operations.roundD(temp, 3)));
	}
	
	private void configureWindow() {
		this.principal.getFrame().setTitle("Integración numérica");
		this.principal.getFrame().setSize(700, 460);
    this.principal.getFrame().setLocationRelativeTo(null);
	}
}
