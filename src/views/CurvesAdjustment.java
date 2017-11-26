package views;

import javax.swing.JPanel;

public class CurvesAdjustment extends JPanel {
	private Principal principal;
	/**
	 * Create the panel.
	 */
	public CurvesAdjustment(Principal principal) {
		this.principal = principal;
		this.principal.getFrame().setTitle("Ajuste de curvas");
	}

}
