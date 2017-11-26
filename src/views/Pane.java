package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Pane extends JPanel {

	/**
	 * Create the panel.
	 */
	public Pane(String panelClicked) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnClick = new JButton(panelClicked);
		panel.add(btnClick, BorderLayout.CENTER);

	}

}
