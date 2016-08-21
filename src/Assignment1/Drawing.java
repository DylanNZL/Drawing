package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Drawing {

  private ControlPanel m_control;
  private ContentPanel m_content;
  private int mouseX1 = -1;
  private int mouseY1 = -1;
  private int mouseX2 = -1;
  private int mouseY2 = -1;

  static ArrayList<Storage> m_storage = new ArrayList<>();
  static Storage m_Temp = new Storage();

  private Drawing(final ControlPanel control, final ContentPanel content) {
    m_control = control;
    m_content = content;
    // register for events
    m_content.setController(this.new ContentEventHandler(), this.new ContentEventHandler());
  }

  /**
   * A ContentEventHandler handles events from the Assignment1.ContentPanel view.
   * Changed from MouseInputAdaptor to MouseAdaptor as it handles more events (including mouseDragged)
   */
  private class ContentEventHandler extends MouseAdapter implements
      ContentPanel.ContentViewListener, ContentPanel.ContentViewMotionListener {

    @Override
    public void mousePressed(MouseEvent event) {
      mouseX1 = event.getX();
      mouseY1 = event.getY();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
      m_Temp.zero(); // this wipes the co-ordinates on the temp Storage object so that it is not drawn in a visible place.
      mouseX2 = event.getX();
      mouseY2 = event.getY();
      if (m_control.getCurrentShape() == ControlPanel.MyShape.Text) {
        m_storage.add(new Storage(mouseX1, mouseX2, mouseY1, mouseY2, m_control.getCurrentColour(), m_control.getCurrentShapeFillSetting(), m_control.getCurrentShape(), m_control.getCurrentText()));
      } else {
        m_storage.add(new Storage(mouseX1, mouseX2, mouseY1, mouseY2, m_control.getCurrentColour(), m_control.getCurrentShapeFillSetting(), m_control.getCurrentShape()));
      }
      m_content.repaint();
    }

    // This function fills the temp Storage object with the current X/Y values of the mouse so the user can see where the shape will end up.
    @Override
    public void mouseDragged(MouseEvent event) {
      if (m_control.getCurrentShape() != ControlPanel.MyShape.Text) {
        mouseX2 = event.getX();
        mouseY2 = event.getY();
        m_Temp.setX1(mouseX1);
        m_Temp.setY1(mouseY1);
        m_Temp.setX2(mouseX2);
        m_Temp.setY2(mouseY2);
        m_Temp.setFill(m_control.getCurrentShapeFillSetting());
        m_Temp.setShape(m_control.getCurrentShape());
        m_Temp.setMyColor(Color.CYAN.darker());
        m_content.repaint();
      }
    }
  }

  /**
   * Creates the application GUI.
   */
  private static void createGui() {
    // set-up the frame
    final JFrame frame = new JFrame("Assignment1.Drawing");
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
    aboutItem.addActionListener(event -> JOptionPane.showMessageDialog(null, "159.235 Assignment 1, Semester 2 2016\n          15219491 - Dylan Cross", "About", JOptionPane.INFORMATION_MESSAGE));
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
