import java.awt.*;

/**
 * This class houses the data required to do a drawing of a shape + functions
 */
public class Storage {
    // Starting X & Y co-ordinates
    private int m_X1;
    private int m_Y1;
    // Finishing X & Y co-ordinates
    private int m_X2;
    private int m_Y2;
    // Color
    private Color m_MyColor;
    // Fill
    private Boolean m_Fill;
    // Shape
    private ControlPanel.MyShape m_Shape;
    // Text (might be blank)
    private String m_Text;

    public Storage() {

    }

    public Storage(int m_x1, int m_x2, int m_y1, int m_y2, Color m_color, Boolean m_fill, ControlPanel.MyShape m_shape) {
        // Constructor for non-text shapes
        m_X1 = m_x1;
        m_Y1 = m_y1;
        m_X2 = m_x2;
        m_Y2 = m_y2;
        m_MyColor = m_color;
        m_Fill = m_fill;
        m_Shape = m_shape;
        m_Text = "";
    }

    public Storage(int m_x1, int m_x2, int m_y1, int m_y2, Color m_color, Boolean m_fill, ControlPanel.MyShape m_shape, String m_text) {
        // Constructor for a text shape
        m_X1 = m_x1;
        m_Y1 = m_y1;
        m_X2 = m_x2;
        m_Y2 = m_y2;
        m_MyColor = m_color;
        m_Fill = m_fill;
        m_Shape = m_shape;
        m_Text = m_text;
    }
    // Swap the 2 X axis co-ordinates
    public void swapX() {
        int temp = m_X1;
        m_X1 = m_X2;
        m_X2 = temp;
    }
    // Swap the 2 Y axis co-ordinates
    public void swapY() {
        int temp = m_Y1;
        m_Y1 = m_Y2;
        m_Y2 = temp;
    }
    // Get the length of a shape
    public int length() {
        return m_X2 - m_X1;
    }
    // Get the height of a shape
    public int height() {
        return m_Y2 - m_Y1;
    }
    // Sets all X/Y values to -1 so they won't be drawn (useful for the temp variable in Drawing)
    public void zero() {
        m_X1 = -1;
        m_Y1 = -1;
        m_X2 = -1;
        m_Y2 = -1;
    }
    // Get functions
    public int getX1 () { return m_X1; }
    public int getY1 () { return m_Y1; }
    public int getX2 () { return m_X2; }
    public int getY2 () { return m_Y2; }
    public Color getMyColor () { return m_MyColor; }
    public Boolean getFill () { return m_Fill; }
    public ControlPanel.MyShape getShape () { return m_Shape; }
    public String getText () { return m_Text; }
    // Set functions
    public void setX1 (int newX) { m_X1 = newX; }
    public void setY1 (int newY) { m_Y1 = newY; }
    public void setX2 (int newX) { m_X2 = newX; }
    public void setY2 (int newY) { m_Y2 = newY; }
    public void setMyColor (Color newColor) { m_MyColor = newColor; }
    public void setFill (Boolean newFill) { m_Fill = newFill; }
    public void setShape (ControlPanel.MyShape newShape) { m_Shape = newShape; }
    public void setText (String newText) { m_Text = newText; }
}
