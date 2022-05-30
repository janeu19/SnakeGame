package frame;

import logic.Screen;

import java.awt.GridLayout;
import javax.swing.JFrame;
public class Game extends JFrame
{
    public Game()
    {
        createFrame();
    }
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
