package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GameIntro extends JFrame implements ActionListener
{
    static final String titleValue="SnakeGame";
    final JLabel top;
    final JLabel about;
    final JLabel about1;
    final JLabel about2;
    final JLabel about3;
    final JLabel about4;
    final JLabel rules;
    final JLabel rule1;
    final JLabel rule2;
    final JLabel bonus;
    final JLabel bonus1;
    final JLabel bonus2;
    final JLabel bonus3;
    final JLabel bonus4;
    final JLabel bonus5;
    final JLabel bonus6;
    final JLabel bonus7;
    final JLabel bonus8;
    final JLabel enjoy;
    final JButton next;
    final JButton exit;
    public GameIntro()
    {
        setTitle(titleValue);
        setSize(500,600);
        top=new JLabel("WELCOME TO SNAKE GAME");
        about=new JLabel("ABOUT :-");
        about1=new JLabel("This Game is designed by Syed Mohd Altamash.");
        about2=new JLabel("The Game gives you options to choose your snake.");
        about3=new JLabel("The Game may improves your Reflexes.");
        about4=new JLabel("The Game may Sharpens your Mind.");
        rules=new JLabel("RULES :-");
        rule1=new JLabel("1.Snake should not run into the Walls.");
        rule2=new JLabel("2.Snake should not bite itself.");
        bonus=new JLabel("BONUS FEATURE :-");
        bonus1=new JLabel("This Game contains a Bonus Feature.");
        bonus2=new JLabel("Whenever the snake will eat food for five times,");
        bonus3=new JLabel("there will be a Bonus Food Item available for the snake,");
        bonus4=new JLabel("this item will increase your score by five.");
        bonus5=new JLabel("Bonus Food Item will be Circular in shape,");
        bonus6=new JLabel("this item is available in all Difficulty Levels.");
        bonus7=new JLabel("The Bonus Food Item is of Magenta color.");
        bonus8=new JLabel("Bonus Food Item helps you a lot in building your score.");
        enjoy=new JLabel("ENJOY THE GAME");
        next=new JButton("NEXT >");
        exit=new JButton("EXIT");
        top.setBounds(160,40,170,10);
        about.setBounds(100,80,100,10);
        about1.setBounds(100,90,300,15);
        about2.setBounds(100,105,300,15);
        about3.setBounds(100,120,300,15);
        about4.setBounds(100,135,300,15);
        rules.setBounds(100,180,100,10);
        rule1.setBounds(100,200,300,15);
        rule2.setBounds(100,215,300,15);
        bonus.setBounds(100,260,150,15);
        bonus1.setBounds(100,285,300,15);
        bonus2.setBounds(100,300,300,15);
        bonus3.setBounds(100,315,350,15);
        bonus4.setBounds(100,330,300,15);
        bonus5.setBounds(100,345,300,15);
        bonus6.setBounds(100,360,300,15);
        bonus7.setBounds(100,375,300,15);
        bonus8.setBounds(100,390,350,15);
        enjoy.setBounds(100,430,300,15);
        next.setBounds(150,480,80,40);
        exit.setBounds(250,480,80,40);
        add(top);
        add(about);
        add(about1);
        add(about2);
        add(about3);
        add(about4);
        add(rules);
        add(rule1);
        add(rule2);
        add(bonus);
        add(bonus1);
        add(bonus2);
        add(bonus3);
        add(bonus4);
        add(bonus5);
        add(bonus6);
        add(bonus7);
        add(bonus8);
        add(enjoy);
        add(next);
        add(exit);
        next.addActionListener(this);
        exit.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            new GameSelection();
            dispose();
        }
        if(e.getSource()==exit)
            dispose();
    }
}