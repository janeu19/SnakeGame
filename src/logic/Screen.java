package logic;

import frame.GameFinal;
import frame.GameSelection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
public class Screen extends JPanel implements Runnable
{
    public static final int WIDTH=720,HEIGHT=720;
    private Thread gameThread;
    private Boolean gameState=false;
    private final ArrayList<SnakeBody> snakeBody;
    private final ArrayList<SnakeFood> food;
    private final Random rn;
    static int xValue=15,yValue=15;
    static int snakeSize=5;
    public static int snakeSpeed;
    public static int score=0;
    static boolean moveRight=true,moveLeft=false,moveUp=false,moveDown=false;
    final KeyControl keyObj;
    static int bonusFlag=0;
    public Screen()
    {
        setFocusable(true);
        keyObj= new KeyControl();
        addKeyListener(keyObj);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        rn=new Random();
        snakeBody=new ArrayList<>();
        food=new ArrayList<>();
        gameStart();
    }
    public void gameControl()
    {
        SnakeBody body;
        if(snakeBody.size()==0)
        {
            body =new SnakeBody(xValue,yValue,20);
            snakeBody.add(body);
        }
        for(int i=0;i<snakeBody.size();i++)
        {
            if(xValue==snakeBody.get(i).getX() && yValue==snakeBody.get(i).getY())
            {
                if(i!=snakeBody.size()-1)
                {
                    gameStop();
                }
            }
        }
        if(xValue<2 || xValue>33 || yValue<2 || yValue>33)
        {
            gameStop();
        }
        try
        {
            Thread.sleep(snakeSpeed);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        if(moveRight)
            xValue++;
        if(moveLeft)
            xValue--;
        if(moveUp)
            yValue--;
        if(moveDown)
            yValue++;
        body =new SnakeBody(xValue,yValue,20);
        snakeBody.add(body);
        if(snakeBody.size()>snakeSize)
            snakeBody.remove(0);
        if(food.size()==0)
        {
            addFood();
            int iFood=0;
            for (SnakeBody value : snakeBody) {
                if (food.get(iFood).getX() == value.getX() && food.get(iFood).getY() == value.getY()) {
                    food.remove(iFood);
                    addFood();
                }
            }
        }
        if(bonusFlag>=5)
        {
            for(int i=0;i<food.size();i++)
            {
                if(xValue==food.get(i).getX() && yValue==food.get(i).getY())
                {
                    snakeSize++;
                    food.remove(i);
                    i--;
                    score+=5;
                    bonusFlag=0;
                }
            }
        }
        else
        {
            for(int i=0;i<food.size();i++)
            {
                if(xValue==food.get(i).getX() && yValue==food.get(i).getY())
                {
                    snakeSize++;
                    food.remove(i);
                    i--;
                    score++;
                    bonusFlag++;
                }
            }
        }
    }
    public void paint(Graphics g)
    {
        g.clearRect(0,0,WIDTH,HEIGHT);
        Color orange = new Color(210,105,30);
        g.setColor(orange);
        g.fillRect(0,0,WIDTH,20);
        g.fillRect(0,20,20,HEIGHT);
        g.fillRect(20,700,WIDTH,20);
        g.fillRect(700,20,20,HEIGHT);
        if(GameSelection.gridFlag==1)
        {
            g.setColor(Color.black);
            for(int i=0;i<WIDTH;i++)
            {
                g.drawLine(i*20,0,i*20,HEIGHT);//Vertical Lines
            }
            for(int i=0;i<WIDTH;i++)
            {
                g.drawLine(0,i*20,WIDTH,i*20);//Horizontal lines
            }
        }
        for (SnakeBody body : snakeBody) {
            body.draw(g);
        }
        for (SnakeFood snakeFood : food) {
            snakeFood.draw(g);
        }
    }
    public void addFood()
    {
        int x=rn.nextInt(31)+2;
        int y=rn.nextInt(31)+2;
        SnakeFood sFood = new SnakeFood(x, y, 20);
        food.add(sFood);
    }
    public void gameStart()
    {
        gameState=true;
        gameThread =new Thread(this,"Game Control Thread");
        gameThread.start();
    }
    public void gameStop()
    {
        gameState=false;
        new GameFinal();
        try
        {
            gameThread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        while(gameState)
        {
            gameControl();
            repaint();
        }
    }
}