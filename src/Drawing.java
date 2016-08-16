import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing {

  private ControlPanel m_control;
  private ContentPanel m_content;
  private int mouseX1 = -1;
  private int mouseY1 = -1;
  private int mouseX2 = -1;
  private int mouseY2 = -1;
  // Publicly accessable storage list that is used in content and drawing.
  public static ArrayList<Storage> m_storage = new ArrayList<>();

  public Drawing(final ControlPanel control, final ContentPanel content) {
    m_control = control;
    m_content = content;
    // register for events
    m_content.setController(this.new ContentEventHandler());
  }

  /**
   * A ContentEventHandler handles events from the ContentPanel view.
   */
  private class ContentEventHandler extends MouseInputAdapter implements
      ContentPanel.ContentViewListener {

    @Override
    public void mousePressed(MouseEvent event) {
      mouseX1 = event.getX();
      mouseY1 = event.getY();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
      mouseX2 = event.getY();
      mouseY2 = event.getY();
      if (m_control.getCurrentShape() == ControlPanel.MyShape.Text) {
        m_storage.add(new Storage(mouseX1, mouseX2, mouseY1, mouseY2, m_control.getCurrentColour(), m_control.getCurrentShapeFillSetting(), m_control.getCurrentShape(), m_control.getCurrentText()));
      } else {
        m_storage.add(new Storage(mouseX1, mouseX2, mouseY1, mouseY2, m_control.getCurrentColour(), m_control.getCurrentShapeFillSetting(), m_control.getCurrentShape()));
      }
      m_content.repaint();
    }
  }

  /**
   * Creates the application GUI.
   */
  private static void createGui() {
    // set-up the frame
    final JFrame frame = new JFrame("Drawing");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu applicationMenu = new JMenu("Application");
    menuBar.add(applicationMenu);

    JMenu helpMenu = new JMenu("Help");
    menuBar.add(helpMenu);

    JMenuItem quitItem = new JMenuItem("Quit");
    quitItem.addActionListener(event -> System.exit(123));
    applicationMenu.add(quitItem);

    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener(event -> JOptionPane.showMessageDialog(null, "15219491 - Dylan Cross", "About", JOptionPane.INFORMATION_MESSAGE));
    helpMenu.add(aboutItem);

    // set up the content pane
    final JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    frame.setContentPane(contentPane);

    // create the control and content panels
    final ControlPanel control = new ControlPanel();
    final ContentPanel content = new ContentPanel();
    contentPane.add(control, BorderLayout.PAGE_START);
    contentPane.add(content, BorderLayout.CENTER);

    // create the controller
    new Drawing(control, content);

    // adjust the frame size to fit its contents and make it visible
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    System.out.println("*****************************************");
    System.out.println("* 159.235 Assignment 1, Semester 2 2016 *");
    System.out.println("* Submitted by:  Cross, Dylan, 15219491 *");
    System.out.println("*****************************************");

    SwingUtilities.invokeLater(Drawing::createGui);
  }
}
