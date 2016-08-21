package Assignment1;

import java.awt.*;

/**
 * This class houses the data required to do a drawing of a shape + functions
 * The functions & constructors were made package-private as I felt there wasn't a need for them to be public.
 */
class Storage {
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
    // Default Constructor
    Storage() {

    }
    // Constructor for non-text shapes
    Storage(int m_x1, int m_x2, int m_y1, int m_y2, Color m_color, Boolean m_fill, ControlPanel.MyShape m_shape) {
        m_X1 = m_x1;
        m_X2 = m_x2;
        m_Y1 = m_y1;
        m_Y2 = m_y2;
        m_MyColor = m_color;
        m_Fill = m_fill;
        m_Shape = m_shape;
        m_Text = "";
    }
    // Constructor for a text shape
    Storage(int m_x1, int m_x2, int m_y1, int m_y2, Color m_color, Boolean m_fill, ControlPanel.MyShape m_shape, String m_text) {
        m_X1 = m_x1;
        m_X2 = m_x2;
        m_Y1 = m_y1;
        m_Y2 = m_y2;
        m_MyColor = m_color;
        m_Fill = m_fill;
        m_Shape = m_shape;
        m_Text = m_text;
    }
    // Swap the 2 X axis co-ordinates
    void swapX() {
        int temp = m_X1;
        m_X1 = m_X2;
        m_X2 = temp;
    }
    // Swap the 2 Y axis co-ordinates
    void swapY() {
        int temp = m_Y1;
        m_Y1 = m_Y2;
        m_Y2 = temp;
    }
    // Get the length of a shape
    int length() {
        return m_X2 - m_X1;
    }
    // Get the height of a shape
    int height() {
        return m_Y2 - m_Y1;
    }
    // Sets all X/Y values to -1 so they won't be drawn (useful for the temp variable in Assignment1.Drawing)
    void zero() {
        m_X1 = -1;
        m_Y1 = -1;
        m_X2 = -1;
        m_Y2 = -1;
    }
    // Get functions
    int getX1 () { return m_X1; }
    int getY1 () { return m_Y1; }
    int getX2 () { return m_X2; }
    int getY2 () { return m_Y2; }
    Color getMyColor () { return m_MyColor; }
    Boolean getFill () { return m_Fill; }
    ControlPanel.MyShape getShape () { return m_Shape; }
    String getText () { return m_Text; }
    // Set functions
    void setX1 (int newX) { m_X1 = newX; }
    void setY1 (int newY) { m_Y1 = newY; }
    void setX2 (int newX) { m_X2 = newX; }
    void setY2 (int newY) { m_Y2 = newY; }
    void setMyColor (Color newColor) { m_MyColor = newColor; }
    void setFill (Boolean newFill) { m_Fill = newFill; }
    void setShape (ControlPanel.MyShape newShape) { m_Shape = newShape; }
    void setText (String newText) { m_Text = newText; }
}
