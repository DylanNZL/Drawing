import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
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
    }

    @Override
    public void mouseReleased(MouseEvent event) {
      // TODO handle mouse release
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


    // set up the content pane
    final JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    frame.setContentPane(contentPane);

    // create the control and content panels
    final ControlPanel control = new ControlPanel(new Rectangle(0, 0, 450, 450));
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
