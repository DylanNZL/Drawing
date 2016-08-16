import com.sun.org.apache.xpath.internal.operations.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * The ContentPanel implements the canvas and forwards any user events to the
 * registered controller.
 */
public class ContentPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  // Mouse co-ordinates (*1 = start, *2 = end)

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
    for (int i = 0; i < Drawing.m_storage.size(); i++) {
      System.out.println(Drawing.m_storage.get(i).startX + " " + Drawing.m_storage.get(i).startY + " " + Drawing.m_storage.get(i).finishY
              + " " + Drawing.m_storage.get(i).finishY + " " + Drawing.m_storage.get(i).shape + " " + Drawing.m_storage.get(i).fill);
      graphics.setColor(Drawing.m_storage.get(i).myColor);
      if (Drawing.m_storage.get(i).shape == ControlPanel.MyShape.Text) {
        graphics.drawString(Drawing.m_storage.get(i).text, Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY);
      } else if (Drawing.m_storage.get(i).shape == ControlPanel.MyShape.Line) {
        graphics.drawLine(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY, Drawing.m_storage.get(i).finishX, Drawing.m_storage.get(i).finishY);
      } else {
        if (Drawing.m_storage.get(i).startX > Drawing.m_storage.get(i).finishX) {
          // if the finishing X co-ordinate is bigger than the start, switch them around.
          int temp = Drawing.m_storage.get(i).startX;
          Drawing.m_storage.get(i).startX = Drawing.m_storage.get(i).finishX;
          Drawing.m_storage.get(i).finishX = temp;
        }
        if (Drawing.m_storage.get(i).startY > Drawing.m_storage.get(i).finishY) {
          // if the finishing X co-ordinate is bigger than the start, switch them around.
          int temp = Drawing.m_storage.get(i).startY;
          Drawing.m_storage.get(i).startY = Drawing.m_storage.get(i).finishY;
          Drawing.m_storage.get(i).finishY = temp;
        }
        if (Drawing.m_storage.get(i).shape == ControlPanel.MyShape.Rectangle) {
          if (Drawing.m_storage.get(i).fill) {
            graphics.fillRect(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishY - Drawing.m_storage.get(i).startY);
          } else {
            graphics.drawRect(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishY - Drawing.m_storage.get(i).startY);
          }
        } else if (Drawing.m_storage.get(i).shape == ControlPanel.MyShape.Ellipse) {
          if (Drawing.m_storage.get(i).fill) {
            graphics.fill(new Ellipse2D.Double(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishY - Drawing.m_storage.get(i).startY));
          } else {
            graphics.draw(new Ellipse2D.Double(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishY - Drawing.m_storage.get(i).startY));
          }
        } else if (Drawing.m_storage.get(i).shape == ControlPanel.MyShape.Circle) {
          if (Drawing.m_storage.get(i).fill) {
            graphics.fill(new Ellipse2D.Double(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX));
          } else {
            graphics.draw(new Ellipse2D.Double(Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).startY,
                    Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX, Drawing.m_storage.get(i).finishX - Drawing.m_storage.get(i).startX));
          }
        }
      }
    }
    graphics.dispose();
  }

}