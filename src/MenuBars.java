import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dylan on 14-Aug-16.
 */
public class MenuBars extends JFrame implements ActionListener {
    private JMenu applicationMenu;
    private JMenu helpMenu;
    private JMenuItem quitItem;
    private JMenuItem aboutItem;

    public MenuBars() {
        super("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);


        JMenuBar menuBar = new JMenuBar();

        this.setJMenuBar(menuBar);

        applicationMenu = new JMenu("Application");
        applicationMenu.addActionListener(this);
        menuBar.add(applicationMenu);

        helpMenu = new JMenu("Help");
        helpMenu.addActionListener(this);
        menuBar.add(helpMenu);

        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        applicationMenu.add(quitItem);

        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComponent source = (JComponent) event.getSource();
        if (source == aboutItem) {
            // TODO implement the message box
        } else if (source == quitItem) {
            System.out.println("Quitting ...");
            System.exit(0);
        }
    }
}
