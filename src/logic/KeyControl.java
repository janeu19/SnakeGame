package logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The class for listening to keys and subsequent movement of the "snake"
 */
class KeyControl extends KeyAdapter
{
    /**
     * @param e the event to be processed
     * The method listens and subsequent change of "snake" movement
     */
    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT && !Screen.moveLeft)
        {
            Screen.moveUp=false;
            Screen.moveDown=false;
            Screen.moveRight=true;
        }
        if(key==KeyEvent.VK_LEFT && !Screen.moveRight)
        {
            Screen.moveUp=false;
            Screen.moveDown=false;
            Screen.moveLeft=true;
        }
        if(key==KeyEvent.VK_UP && !Screen.moveDown)
        {
            Screen.moveUp=true;
            Screen.moveLeft=false;
            Screen.moveRight=false;
        }
        if(key==KeyEvent.VK_DOWN && !Screen.moveUp)
        {
            Screen.moveDown=true;
            Screen.moveLeft=false;
            Screen.moveRight=false;
        }
    }
}
