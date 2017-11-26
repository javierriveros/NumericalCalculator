package views;

import javax.swing.JPanel;

public class EquationsRoots extends JPanel {
	private Principal principal;
	
	/**
	 * Create the panel.
	 */
	public EquationsRoots(Principal principal) {
		this.principal = principal;
		this.principal.getFrame().setTitle("Raices de ecuaciones");
	}

}
