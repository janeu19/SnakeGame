package logic;

import frame.GameSelection;

import java.awt.Color;
import java.awt.Graphics;
public class SnakeFood
{
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    public SnakeFood(int x,int y,int dimension)
    {
        this.x=x;
        this.y=y;
        width=dimension;
        height=dimension;
    }
    public void draw(Graphics g)
    {
        if(GameSelection.flag==1)
            g.setColor(Color.cyan);
        if(GameSelection.flag==2)
            g.setColor(Color.red);
        if(GameSelection.flag==3)
            g.setColor(Color.orange);
        if(Screen.bonusFlag==5)
        {
            g.setColor(Color.black);
            g.fillOval(x*width,y*height,width,height);
            g.setColor(Color.magenta);
            g.fillOval(x*width+2,y*height+2,width-3,height-3);
        }
        else
            g.fillRect(x*width,y*height,width,height);
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}
