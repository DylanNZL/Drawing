import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * The ContentPanel implements the canvas and forwards any user events to the
 * registered controller.
 */
public class ContentPanel extends JPanel {

  private static final long serialVersionUID = 1L;

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
      graphics.setColor(Drawing.m_storage.get(i).getMyColor());
      if (Drawing.m_storage.get(i).getShape() == ControlPanel.MyShape.Text) {
        graphics.drawString(Drawing.m_storage.get(i).getText(), Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1());
      } else if (Drawing.m_storage.get(i).getShape() == ControlPanel.MyShape.Line) {
        graphics.drawLine(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(), Drawing.m_storage.get(i).getX2(), Drawing.m_storage.get(i).getY2());
      } else {
        if (Drawing.m_storage.get(i).getX1() > Drawing.m_storage.get(i).getX2()) {
          // if the finishing X co-ordinate is smaller than the start, switch them around.
          Drawing.m_storage.get(i).swapX();

        }
        if (Drawing.m_storage.get(i).getY1() > Drawing.m_storage.get(i).getY2()) {
          // if the finishing X co-ordinate is smaller than the start, switch them around.
          Drawing.m_storage.get(i).swapY();
        }
        if (Drawing.m_storage.get(i).getShape() == ControlPanel.MyShape.Rectangle) {
          if (Drawing.m_storage.get(i).getFill()) {
            graphics.fillRect(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY2() - Drawing.m_storage.get(i).getY1());
          } else {
            graphics.drawRect(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY2() - Drawing.m_storage.get(i).getY1());
          }
        } else if (Drawing.m_storage.get(i).getShape() == ControlPanel.MyShape.Ellipse) {
          if (Drawing.m_storage.get(i).getFill()) {
            graphics.fill(new Ellipse2D.Double(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY2() - Drawing.m_storage.get(i).getY1()));
          } else {
            graphics.draw(new Ellipse2D.Double(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY2() - Drawing.m_storage.get(i).getY1()));
          }
        } else if (Drawing.m_storage.get(i).getShape() == ControlPanel.MyShape.Circle) {
          if (Drawing.m_storage.get(i).getFill()) {
            graphics.fill(new Ellipse2D.Double(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1()));
          } else {
            graphics.draw(new Ellipse2D.Double(Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getY1(),
                    Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1(), Drawing.m_storage.get(i).getX2() - Drawing.m_storage.get(i).getX1()));
          }
        }
      }
    }
    graphics.dispose();
  }

}