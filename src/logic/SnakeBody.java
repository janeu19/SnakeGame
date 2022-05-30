package logic;

import frame.GameSelection;

import java.awt.Color;
import java.awt.Graphics;
public class SnakeBody
{
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    public SnakeBody(int x,int y,int dimension)
    {
        this.x=x;
        this.y=y;
        width=dimension;
        height=dimension;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(x*width,y*height,width,height);
        if(GameSelection.flag==1)
            g.setColor(Color.red);
        if(GameSelection.flag==2)
            g.setColor(Color.green);
        if(GameSelection.flag==3)
            g.setColor(Color.blue);
        g.fillRect(x*width+2,y*height+2,width-3,height-3);
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
