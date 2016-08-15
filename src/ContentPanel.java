import com.sun.org.apache.xpath.internal.operations.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

  // Attributes
  private Color myColor = Color.red;
  private Boolean fillShape = false;
  private ControlPanel.MyShape shapeToDraw = ControlPanel.MyShape.Rectangle;
  private String text = "";


  /**
   * The callback interface for controllers of this class.
   */
  public interface ContentViewListener extends MouseListener {

  }

  public ContentPanel() {
    super(null); // no layout manager
    setPreferredSize(new Dimension(500, 500));
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
    graphics.setColor(Color.white);
    graphics.fillRect(0,0, getWidth(), getHeight());
    graphics.setColor(myColor);
    graphics.drawLine(mouseX1, mouseY1, mouseX2, mouseY2);

    }

  public void mousePressed(MouseEvent mev) {
    mouseX1 = mev.getX();
    mouseY1 = mev.getY();
  }

  void mouseReleased(MouseEvent mev) {
    System.out.println("Drawing line  from " + mouseX1 + "," + mouseY1
            + " to " + mev.getX() + "," + mev.getY());
    mouseX2 = mev.getX();
    mouseY2 = mev.getY();
    repaint();
  }

  public void mouseDragged(MouseEvent mev) {
    mouseX2 = mev.getX();
    mouseY2 = mev.getY();
    repaint();
  }

  public void setMyColor (Color change) {
    myColor = change;
  }

  public void setFillShape (Boolean fill) {
    fillShape = fill;
  }

  public void setShapeToDraw (ControlPanel.MyShape shape) {
    shapeToDraw = shape;
  }

  public void setText (String newText) {
    text = newText;
  }

}