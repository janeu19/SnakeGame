package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GameStart extends JFrame implements ActionListener
{
    final JLabel alert;
    final JButton start;
    final Font f1;
    GameStart()
    {
        setTitle(GameIntro.titleValue);
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alert=new JLabel("Get ready for the Game");
        start=new JButton("START");
        f1=new Font("Arial",Font.PLAIN,25);
        alert.setBounds(65,40,350,40);
        start.setBounds(145,120,100,40);
        alert.setFont(f1);
        add(alert);
        add(start);
        start.addActionListener(this);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start)
        {
            new Game();
            dispose();
        }

    }


}