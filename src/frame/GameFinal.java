package frame;

import logic.Screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The class to create a GUI that contains the player's final score
 */
public class GameFinal extends JFrame implements ActionListener
{
    /**
     * JavaX swing components for the GUI
     */
    final JButton exit;
    final JLabel over;
    final JLabel scoreFinal;
    final Font f2;

    /**
     * Method for setting up the GUI with a final score (used a WindowBuilder)
     */
    public GameFinal()
    {
        setTitle(GameIntro.titleValue);
        setSize(400,270);
        f2=new Font("Arial",Font.PLAIN,30);
        over=new JLabel("GAME OVER");
        over.setFont(f2);
        over.setBounds(103,30,200,40);
        scoreFinal=new JLabel("Your Score = "+ Screen.score);
        scoreFinal.setFont(f2);
        scoreFinal.setBounds(95,90,220,30);
        exit=new JButton("EXIT");
        exit.setBounds(150,150,100,40);
        exit.addActionListener(this);
        add(exit);
        add(over);
        add(scoreFinal);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param e the event to be processed - closes the GUI
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit)
            System.exit(EXIT_ON_CLOSE);
    }
}