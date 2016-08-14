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
    "Black", "Grey", "White", "Blue", "Green", "Brown", "Red", "Orange", "Yellow"
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

  public ControlPanel(Rectangle bounds) {
    super(new GridBagLayout());
    // TODO implement the control panel
    setLayout(new FlowLayout());
    setOpaque(false);
    setBounds(bounds);
    setPreferredSize(new Dimension(bounds.width, bounds.height));

    final GridBagConstraints GBC = new GridBagConstraints();
    GBC.gridx = GridBagConstraints.RELATIVE;
    GBC.fill = GridBagConstraints.HORIZONTAL;
    GBC.insets = new Insets(2, 0, 2, 10);
    GBC.anchor = GridBagConstraints.LINE_START;

    GridBagConstraints gbc = null;
    // Radio Buttons row
    gbc = (GridBagConstraints) GBC.clone();

    gbc.gridy = 0;
    add(new JLabel("Select a Shape: "), gbc);
    ButtonGroup buttonGroup = new ButtonGroup();
    gbc.weightx = 0.5;
    gbc.insets.right = 0;

    // Rectangle
    m_rbRectangle.setSelected(true);
    add(m_rbRectangle, gbc);
    buttonGroup.add(m_rbRectangle);
    m_rbRectangle.addActionListener(this);
    // Circle
    m_rbCircle.setSelected(true);
    add(m_rbCircle, gbc);
    buttonGroup.add(m_rbCircle);
    m_rbCircle.addActionListener(this);
    // Ellipse
    m_rbEllipse.setSelected(true);
    add(m_rbEllipse, gbc);
    buttonGroup.add(m_rbEllipse);
    m_rbEllipse.addActionListener(this);
    // Line
    m_rbLine.setSelected(true);
    add(m_rbLine, gbc);
    buttonGroup.add(m_rbLine);
    m_rbLine.addActionListener(this);
    // Text
    m_rbText.setSelected(true);
    add(m_rbText, gbc);
    buttonGroup.add(m_rbText);
    m_rbText.addActionListener(this);

    // Colour picker row
    gbc = (GridBagConstraints) GBC.clone();

    gbc.gridy = 1;
    add(new JLabel("Choose Colour"), gbc);
    gbc.gridwidth = GridBagConstraints.RELATIVE;
    gbc.weightx = 0;
    gbc.insets.right = 0;
    add(m_cbxColours, gbc);

    gbc.gridwidth = 1;
    gbc.weightx = 0;
    gbc.insets = new Insets(2,2,2,2);
    m_btnColours.setBackground(Color.black);
    add(m_btnColours, gbc);

    add(m_chbFill, gbc);


    // Text Row
    gbc = (GridBagConstraints) GBC.clone();
    gbc.gridy = 2;
    add(new JLabel("Text: "), gbc);
    gbc.gridwidth = GridBagConstraints.RELATIVE;
    gbc.weightx = 0;
    gbc.insets.right = 0;
    add(m_tfText, gbc);
    m_tfText.addActionListener(this);

  }

  @Override
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == m_rbRectangle) {
      System.out.println("Rectangle");
    }
  }

  public Color getCurrentColour() {
    return Color.BLACK; // TODO return the currently selected colour

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
    return false; // TODO return the currently selected fill state for shapes
  }
}