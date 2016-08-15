import java.awt.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Dylan on 14-Aug-16.
 */
public class Storage {
    // Starting X & Y co-ordinates
    public int startX;
    public int startY;
    // Finishing X & Y co-ordinates
    public int finishX;
    public int finishY;
    // Color
    public Color myColor;
    // Fill
    public Boolean fill;
    // Shape
    ControlPanel.MyShape shape;

    public Storage(int m_x1, int m_x2, int m_y1, int m_y2, Color m_color, Boolean m_fill, ControlPanel.MyShape m_shape) {
        startX = m_x1;
        startY = m_y1;
        finishX = m_x2;
        finishY = m_y2;
        myColor = m_color;
        fill = m_fill;
        shape = m_shape;
    }
}
