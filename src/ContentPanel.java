import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The ContentPanel implements the canvas and forwards any user events to the
 * registered controller.
 */
public class ContentPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  // Mouse co-ordinates (*1 = start, *2 = end)
  private int mouseX1 = -1;
  private int mouseY1 = -1;
  private int mouseX2 = -1;
  private int mouseY2 = -1;

  private Color myColor = Color.red;

  /**
   * The callback interface for controllers of this class.
   */
  public interface ContentViewListener extends MouseListener {
  }

  public ContentPanel() {
    super(null); // no layout manager
    setPreferredSize(new Dimension(600, 400));
    setOpaque(true);
  }

  /**
   * Registers the controller for this view, which will be notified of all user
   * actions.
   *
   * @param controller The controller.
   */
  public void setController(final ContentViewListener controller) {
    // update the event listeners
    addMouseListener(controller);
  }

  @Override
  protected void paintComponent(Graphics g) {
    final Graphics2D graphics = (Graphics2D) g.create();
    // Anti-alias so that lines look nicer
    graphics.addRenderingHints(new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON ));
    // TODO draw


    graphics.dispose();
  }
  @Override
  public void mousePressed(MouseEvent mev) {
    mouseX1 = mev.getX();
    mouseY1 = mev.getY();
    myColor = Color.black;
  }

  @Override
  public void mouseReleased(MouseEvent mev) {
    mouseX2 = mev.getX();
    mouseY2 = mev.getY();
    System.out.println("Drawing line  from " + mouseX1 + "," + mouseY1
            + " to " + mouseX2 + "," + mouseY2);
    myColor = Color.red;
    repaint();
  }
}