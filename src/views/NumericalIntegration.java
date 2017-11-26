package views;

import javax.swing.JPanel;

public class NumericalIntegration extends JPanel {
	private Principal principal;
	/**
	 * Create the panel.
	 */
	public NumericalIntegration(Principal pricipal) {
		this.principal = principal;
		this.principal.getFrame().setTitle("Integración numérica");
	}

}
