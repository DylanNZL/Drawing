import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Dylan on 14-Aug-16.
 */
public class Storage {
    // Starting X & Y co-ordinates
    ArrayList<Integer> startX = new ArrayList<>();
    ArrayList<Integer> startY = new ArrayList<>();
    // Finishing X & Y co-ordinates
    ArrayList<Integer> finishX = new ArrayList<>();
    ArrayList<Integer> finishY = new ArrayList<>();
    // Color
    ArrayList<Color> color = new ArrayList<>();
    // Fill
    ArrayList<Boolean> fill = new ArrayList<>();
    // Shape
    ArrayList<ControlPanel.MyShape> shape = new ArrayList<>();
    // ID
    int ids;
}
