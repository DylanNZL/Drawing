package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

/**
 * The Assignment1.ContentPanel implements the canvas and forwards any user events to the
 * registered controller.
 */
public class ContentPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  /**
   * The callback interface for controllers of this class.
   */
  public interface ContentViewListener extends MouseListener {

  }

  public interface ContentViewMotionListener extends MouseMotionListener {

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
  public void setController(final ContentViewListener controller, final ContentViewMotionListener cont) {
    // update the event listeners
    addMouseListener(controller);
    addMouseMotionListener(cont);
  }

  @Override
  protected void paintComponent(Graphics g) {
    final Graphics2D graphics = (Graphics2D) g.create();
    // Anti-alias so that lines look nicer
    graphics.addRenderingHints(new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON ));
    graphics.setColor(Color.white);
    graphics.fillRect(0,0, getWidth(), getHeight());
    for (int i = 0; i < Drawing.m_storage.size(); i++) {
      drawShape(Drawing.m_storage.get(i), graphics);
    }
    drawShape(Drawing.m_Temp, graphics);
    graphics.dispose();
  }
  // Moved method out of paint component to make it possible to have a temp (but i couldn't get mouseDragged to work)
  private void drawShape(Storage draw, Graphics2D graphics) {
    graphics.setColor(draw.getMyColor());
    if (draw.getShape() == ControlPanel.MyShape.Text) {
      graphics.drawString(draw.getText(), draw.getX1(), draw.getY1());
    } else if (draw.getShape() == ControlPanel.MyShape.Line) {
      graphics.drawLine(draw.getX1(), draw.getY1(), draw.getX2(), draw.getY2());
    } else {
      if (draw.getX1() > draw.getX2()) {
        // if the finishing X co-ordinate is smaller than the start, switch them around.
        draw.swapX();
      }
      if (draw.getY1() > draw.getY2()) {
        // if the finishing X co-ordinate is smaller than the start, switch them around.
        draw.swapY();
      }
      if (draw.getShape() == ControlPanel.MyShape.Rectangle) {
        if (draw.getFill()) {
          graphics.fillRect(draw.getX1(), draw.getY1(), draw.length(), draw.height());
        } else {
          graphics.drawRect(draw.getX1(), draw.getY1(), draw.length(), draw.height());
        }
      } else if (draw.getShape() == ControlPanel.MyShape.Ellipse) {
        if (draw.getFill()) {
          graphics.fill(new Ellipse2D.Double(draw.getX1(), draw.getY1(), draw.length(), draw.height()));
        } else {
          graphics.draw(new Ellipse2D.Double(draw.getX1(), draw.getY1(), draw.length(), draw.height()));
        }
      } else if (draw.getShape() == ControlPanel.MyShape.Circle) {
        if (draw.getFill()) {
          graphics.fill(new Ellipse2D.Double(draw.getX1(), draw.getY1(), draw.length(), draw.length()));
        } else {
          graphics.draw(new Ellipse2D.Double(draw.getX1(), draw.getY1(), draw.length(), draw.length()));
        }
      }
    }
  }
}