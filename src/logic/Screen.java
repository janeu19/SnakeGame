package logic;

import frame.GameFinal;
import frame.GameSelection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * The class for rendering the gameplay itself - this is where all the magic happens!
 */
public class Screen extends JPanel implements Runnable
{
    /**
     * All (auxiliary) properties that are worked with
     */
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

    /**
     * The constructor sets the dimensions of the playing area, starts the listeners and the game itself
     */
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

    /**
     *
     */
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

    /**
     * The method for painting a playing field, the "snake" and food
     * @param g for rendering and using colors
     */
    public void paint(Graphics g)
    {
        g.clearRect(0,0,WIDTH,HEIGHT);
        Color red = new Color(255,51,51);
        g.setColor(red);
        g.fillRect(0,0,WIDTH,20);
        g.fillRect(0,20,20,HEIGHT);
        g.fillRect(20,700,WIDTH,20);
        g.fillRect(700,20,20,HEIGHT);
        if(GameSelection.gridFlag==1)
        {
            g.setColor(Color.black);
            for(int i=0;i<WIDTH;i++)
            {
                g.drawLine(i*20,0,i*20,HEIGHT);
            }
            for(int i=0;i<WIDTH;i++)
            {
                g.drawLine(0,i*20,WIDTH,i*20);
            }
        }
        for (SnakeBody body : snakeBody) {
            body.draw(g);
        }
        for (SnakeFood snakeFood : food) {
            snakeFood.draw(g);
        }
    }

    /**
     * The method for adding food to a random position on the playing field
     */
    public void addFood()
    {
        int x=rn.nextInt(31)+2;
        int y=rn.nextInt(31)+2;
        SnakeFood sFood = new SnakeFood(x, y, 20); //20 je ideal
        food.add(sFood);
    }

    /**
     * The method for creating and then starting a thread that controls a part of the game
     */
    public void gameStart()
    {
        gameState=true;
        gameThread =new Thread(this,"Thread for gameControl and repaint");
        gameThread.start();
    }

    /**
     * The method for stopping the whole game and opening the GUI with the total score
     */
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

    /**
     * The method for starting a thread where the whole game is controlled and repainted until it ends
     */
    public void run()
    {
        while(gameState)
        {
            gameControl();
            repaint();
        }
    }
}