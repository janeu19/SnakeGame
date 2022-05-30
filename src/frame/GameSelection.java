package frame;
import logic.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
public class GameSelection extends JFrame implements ActionListener
{
    final JLabel selection1;
    final JLabel selection2;
    final JLabel selection3;
    final JButton play;
    final JButton exit;
    final JRadioButton redSnake;
    final JRadioButton greenSnake;
    final JRadioButton blueSnake;
    final JRadioButton easy;
    final JRadioButton medium;
    final JRadioButton hard;
    final JRadioButton yes;
    final JRadioButton no;
    final ButtonGroup snakeColor;
    final ButtonGroup difficultyLevel;
    final ButtonGroup grids;
    public static int flag=0;
    public static int gridFlag=0;
    GameSelection()
    {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(GameIntro.titleValue);
        setResizable(false);
        selection1=new JLabel("Select the Color of Snake and Food :-");
        selection2=new JLabel("Select the Difficulty Level of the Game :-");
        selection3=new JLabel("Do you want the Grids in Game ?");
        play=new JButton("PLAY");
        exit=new JButton("EXIT");
        redSnake=new JRadioButton("Snake Color = Red ; Food Color = Cyan");
        greenSnake=new JRadioButton("Snake Color = Green ; Food Color = Red");
        blueSnake=new JRadioButton("Snake Color = Blue ; Food Color = Orange",true);
        snakeColor=new ButtonGroup();
        snakeColor.add(redSnake);
        snakeColor.add(greenSnake);
        snakeColor.add(blueSnake);
        easy=new JRadioButton("EASY");
        medium=new JRadioButton("MEDIUM",true);
        hard=new JRadioButton("HARD");
        difficultyLevel=new ButtonGroup();
        difficultyLevel.add(easy);
        difficultyLevel.add(medium);
        difficultyLevel.add(hard);
        yes=new JRadioButton("YES");
        no=new JRadioButton("NO",true);
        grids=new ButtonGroup();
        grids.add(yes);
        grids.add(no);
        selection1.setBounds(70,30,300,20);
        redSnake.setBounds(70,50,300,20);
        greenSnake.setBounds(70,70,300,20);
        blueSnake.setBounds(70,90,300,20);
        selection2.setBounds(70,120,300,20);
        easy.setBounds(70,140,100,20);
        medium.setBounds(70,160,100,20);
        hard.setBounds(70,180,100,20);
        selection3.setBounds(70,210,300,20);
        yes.setBounds(70,230,300,20);
        no.setBounds(70,250,300,20);
        play.setBounds(90,300,100,30);
        exit.setBounds(200,300,100,30);
        add(selection1);
        add(redSnake);
        add(greenSnake);
        add(blueSnake);
        add(selection2);
        add(easy);
        add(medium);
        add(hard);
        add(selection3);
        add(yes);
        add(no);
        add(play);
        add(exit);
        play.addActionListener(this);
        exit.addActionListener(this);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==play)
        {
            if(redSnake.isSelected())
                flag=1;
            if(greenSnake.isSelected())
                flag=2;
            if(blueSnake.isSelected())
                flag=3;
            if(easy.isSelected())
                Screen.snakeSpeed=60;
            if(medium.isSelected())
                Screen.snakeSpeed=50;
            if(hard.isSelected())
                Screen.snakeSpeed=40;
            if(yes.isSelected())
                gridFlag=1;
            new GameStart();
            dispose();
        }
        if(e.getSource()==exit)
            dispose();
    }
}