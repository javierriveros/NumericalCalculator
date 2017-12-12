package views.equationsRoots;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import methods.equationsRoots.FakePosition;
import util.Messages;
import util.Operations;
import util.Validations;
import views.Principal;

public class FakePositionView extends JPanel {

  private JTextField xiField;
  private JTextField xuField;
  private JTextField functionField;
  private JFormattedTextField snField;
  private JTextField resultField;
  private JButton solveButton;

  private Principal principal;
  private JPanel panel;
  private JPanel actionsPanel;
  private JButton button;
  private JComboBox comboBox;

  /**
   * Create the panel.
   */
  public FakePositionView(Principal principal) {
    this.principal = principal;
    setLayout(new BorderLayout(0, 0));

    actionsPanel = new JPanel();
    add(actionsPanel, BorderLayout.NORTH);
    actionsPanel.setLayout(new GridLayout(0, 2, 0, 0));

    comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[]{"Biseccion", "Falsa Posicion", "Newton Raphson", "Secante", "Secante Modificado"}));
    comboBox.addItemListener(e -> {
      principal.goToPanel(comboBox.getSelectedItem().toString());
      principal.getFrame().setTitle(comboBox.getSelectedItem().toString());
    });
    actionsPanel.add(comboBox);

    button = new JButton("VOLVER AL INICIO");
    button.addActionListener(e -> this.principal.goToPanel("Principal"));
    actionsPanel.add(button);

    panel = new JPanel();
    add(panel);
    panel.setLayout(new GridLayout(2, 0, 20, 20));

    JPanel panelData = new JPanel();
    panel.add(panelData);
    panelData.setLayout(new GridLayout(0, 1, 10, 10));

    JPanel panelXs = new JPanel();
    panelData.add(panelXs);
    panelXs.setLayout(new GridLayout(0, 3, 0, 0));

    xiField = new JTextField();
    xiField.setBorder(new TitledBorder(null, "Xi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panelXs.add(xiField);
    xiField.setColumns(10);

    xuField = new JTextField();
    xuField.setBorder(new TitledBorder(null, "Xu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panelXs.add(xuField);
    xuField.setColumns(10);

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
    panelResult.add(resultField);
    resultField.setColumns(10);

  }

  private void solve() {
    String xi = this.xiField.getText();
    String xu = this.xuField.getText();
    String n = this.snField.getText();
    String function = this.functionField.getText();

    if (Validations.isEmpty(xi) || Validations.isEmpty(xu) || Validations.isEmpty(function)) {
      Messages.errorMessage("Debes llenar todos los campos");
      return;
    }

    if (!Validations.isNumeric(xi) || !Validations.isNumeric(xu) || !Validations.isNumeric(n)) {
      Messages.errorMessage("Los intervalos deben ser numéricos");
      return;
    }

    if (xi.equals(xu)) {
      Messages.errorMessage("Los intervalos no pueden ser iguales");
      return;
    }

    Double xiD = Double.parseDouble(xi);
    Double xuD = Double.parseDouble(xu);
    Integer nI = Integer.parseInt(n);

    try {
      FakePosition fp = new FakePosition(function, xiD, xuD, nI);
      Double result = Operations.roundD(fp.result(), nI);
      this.resultField.setText(String.valueOf(result));
    } catch (Exception ex) {
      this.resultField.setText("Math ERROR");
    }
  }
}
