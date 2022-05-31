package frame;

import logic.Screen;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * The class for creating the game window itself
 */
public class Game extends JFrame
{

    /**
     * Constructor - calls the createFrame() method
     */
    public Game()
    {
        createFrame();
    }

    /**
     * Method for setting up the GUI with a "snake" on screen
     *
     */
    public void createFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(GameIntro.titleValue);
        setResizable(false);
        Screen screen = new Screen();
        add(screen);
        setLayout(new GridLayout(1,1,0,0));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
