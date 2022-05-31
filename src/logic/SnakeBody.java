package logic;

import frame.GameSelection;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The class for rendering the "snake"
 */
public class SnakeBody
{
    /**
     * "Snake" properties
     */
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    /**
     * The constructor for creating the body of the "snake"
     * @param x the horizontal position of the "snake"
     * @param y the vertical position of the "snake"
     * @param dimension the width and height of the "snake" body
     */
    public SnakeBody(int x,int y,int dimension)
    {
        this.x=x;
        this.y=y;
        width=dimension;
        height=dimension;
    }

    /**
     * The method draws a "snake" and sets its color
     * @param g for rendering and using colors
     */
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

    /**
     * The getter method
     * @return the horizontal position of the "snake"
     */
    public int getX()
    {
        return x;
    }

    /**
     * The getter method
     * @return the vertical position of the "snake"
     */
    public int getY()
    {
        return y;
    }
}
