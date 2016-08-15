import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Drawing {

  private ControlPanel m_control;
  private ContentPanel m_content;

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
      // TODO handle mouse press
      m_content.setMyColor(m_control.getCurrentColour());
      m_content.setFillShape(m_control.getCurrentShapeFillSetting());
      m_content.setShapeToDraw(m_control.getCurrentShape());
      m_content.setText(m_control.getCurrentText());
      m_content.mousePressed(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
      m_content.mouseDragged(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
      m_content.setMyColor(m_control.getCurrentColour());
      m_content.setFillShape(m_control.getCurrentShapeFillSetting());
      m_content.setShapeToDraw(m_control.getCurrentShape());
      m_content.setText(m_control.getCurrentText());
      // TODO handle mouse release
      m_content.mouseReleased(event);
    }
  }

  /**
   * Creates the application GUI.
   */
  private static void createGui() {
    // set-up the frame
    final JFrame frame = new JFrame("Drawing");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // TODO add the menu
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu applicationMenu = new JMenu("Application");
    menuBar.add(applicationMenu);

    JMenu helpMenu = new JMenu("Help");
    menuBar.add(helpMenu);

    JMenuItem quitItem = new JMenuItem("Quit");
    //quitItem.addActionListener(this);
    applicationMenu.add(quitItem);

    JMenuItem aboutItem = new JMenuItem("About");
    //aboutItem.addActionListener(this);
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
