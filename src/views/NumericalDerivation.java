package views;

import javax.swing.JPanel;

public class NumericalDerivation extends JPanel {
	private Principal principal;
	/**
	 * Create the panel.
	 */
	public NumericalDerivation(Principal principal) {
		this.principal = principal;
		this.principal.getFrame().setTitle("Derivación numérica");
	}

}
