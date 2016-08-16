import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The control panel implements a pull mechanism to retrieve the current user
 * settings.
 */
public class ControlPanel extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  // Radio buttons to select shape
  private JRadioButton m_rbRectangle = new JRadioButton("Rectangle");
  private JRadioButton m_rbCircle = new JRadioButton("Circle");
  private JRadioButton m_rbEllipse = new JRadioButton("Ellipse");
  private JRadioButton m_rbLine = new JRadioButton("Line");
  private JRadioButton m_rbText = new JRadioButton("Text");
  // Colour Pickers (Combo Box & button)
  private JComboBox<String> m_cbxColours = new JComboBox<>(new String[] {
    "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "White"
  });
  private JButton m_btnColours = new JButton();
  // Fill Button
  private JCheckBox m_chbFill = new JCheckBox("Fill Shapes?");
  // Text
  private JTextField m_tfText = new JTextField(20);


  /**
   * The geometric shapes supported by this control panel.
   */
  public enum MyShape {
    Rectangle, Circle, Ellipse, Line, Text, Unknown
  }

  public ControlPanel() {
    super(new GridBagLayout());
    // TODO implement the control panel

    final GridBagConstraints GBC = new GridBagConstraints();
    GBC.gridx = GridBagConstraints.RELATIVE;
    GBC.fill = GridBagConstraints.HORIZONTAL;
    GBC.insets = new Insets(2, 0, 2, 10);
    GBC.anchor = GridBagConstraints.LINE_START;

    GridBagConstraints gbc;
    // Radio Buttons row
    gbc = (GridBagConstraints) GBC.clone();

    gbc.gridy = 0;
    gbc.gridx = 0;
    add(new JLabel("Select a Shape: "), gbc);
    gbc.gridx = 1;
    ButtonGroup buttonGroup = new ButtonGroup();
    // Rectangle
    m_rbRectangle.setSelected(true);
    add(m_rbRectangle, gbc);
    buttonGroup.add(m_rbRectangle);
    m_rbRectangle.addActionListener(this);
    // Circle
    gbc.gridx = 2;
    add(m_rbCircle, gbc);
    buttonGroup.add(m_rbCircle);
    m_rbCircle.addActionListener(this);
    // Ellipse
    gbc.gridx = 3;
    add(m_rbEllipse, gbc);
    buttonGroup.add(m_rbEllipse);
    m_rbEllipse.addActionListener(this);
    // Line
    gbc.gridx = 4;
    add(m_rbLine, gbc);
    buttonGroup.add(m_rbLine);
    m_rbLine.addActionListener(this);
    // Text
    gbc.gridx = 5;
    add(m_rbText, gbc);
    buttonGroup.add(m_rbText);
    m_rbText.addActionListener(this);

    // row 2
    gbc = (GridBagConstraints) GBC.clone();
    gbc.gridy = 1;
    gbc.gridx = 0;
    add(new JLabel("Choose Colour"), gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    add(m_cbxColours, gbc);

    gbc.gridx = 3;
    gbc.gridwidth = 1;
    m_btnColours.setBackground(Color.black);
    add(m_btnColours, gbc);

    gbc.gridx = 4;
    add(m_chbFill, gbc);

    // Row three
    gbc = (GridBagConstraints) GBC.clone();
    gbc.gridy = 2;
    gbc.gridx = 1;
    add(new JLabel("Text: "), gbc);

    gbc.gridx = 3;
    gbc.gridwidth = 2;
    add(m_tfText, gbc);
    m_tfText.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == m_rbRectangle) {
      System.out.println("Rectangle");
    } else if (ev.getSource() == m_rbCircle) {
      System.out.println("Circle");
    } else if (ev.getSource() == m_rbEllipse) {
      System.out.println("Ellipse");
    } else if (ev.getSource() == m_rbLine) {
      System.out.println("Line");
    } else if (ev.getSource() == m_rbText) {
      System.out.println("Text");
    } else if (ev.getSource() == m_cbxColours) {
      System.out.println("Colour changed to:");
      System.out.println(m_cbxColours.getSelectedItem());
      m_btnColours.setBackground(getCurrentColour());
    } else if (ev.getSource() == m_btnColours) {
      System.out.println("Colour Button");
    } else if (ev.getSource() == m_chbFill) {
      System.out.println("Fill Button");
    }
  }

  public Color getCurrentColour() {
    // "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "White"
    switch(m_cbxColours.getSelectedIndex()) {
      case 0:
        return Color.BLACK;
      case 1:
        return Color.RED;
      case 2:
        return Color.ORANGE;
      case 3:
        return Color.YELLOW;
      case 4:
        return Color.GREEN;
      case 5:
        return Color.BLUE;
      case 6:
        return Color.MAGENTA;
      case 7:
        return Color.WHITE;
      default:
        return Color.BLACK;
    }
  }

  public MyShape getCurrentShape() {
    // Returns the currently selected shape
    if (m_rbRectangle.isSelected()) {
      return MyShape.Rectangle;
    } else if (m_rbCircle.isSelected()) {
      return MyShape.Circle;
    } else if (m_rbEllipse.isSelected()) {
      return MyShape.Ellipse;
    } else if (m_rbLine.isSelected()) {
      return MyShape.Line;
    } else if (m_rbText.isSelected()) {
      return MyShape.Text;
    }
    return MyShape.Unknown;
  }

  public String getCurrentText() {
    // Returns the current text in the text box
    return m_tfText.getText();
  }

  public boolean getCurrentShapeFillSetting() {
    // Returns the currently selected fill state for shapes
    return m_chbFill.isSelected();
  }

}