package logic;

import frame.GameSelection;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The class for rendering the "snake" food
 */
public class SnakeFood
{
    /**
     * "Snake" food properties
     */
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    /**
     * The constructor for creating "snake" food
     * @param x the horizontal position of food
     * @param y the vertical position of food
     * @param dimension the width and height of food
     */
    public SnakeFood(int x,int y,int dimension)
    {
        this.x=x;
        this.y=y;
        width=dimension;
        height=dimension;
    }

    /**
     * The method draws a "snake´s" food and sets its color
     * @param g for rendering and using colors
     */
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

    /**
     * The getter method
     * @return the horizontal position of food
     */
    public int getX()
    {
        return x;
    }

    /**
     * The getter method
     * @return the vertical position of food
     */
    public int getY()
    {
        return y;
    }
}
