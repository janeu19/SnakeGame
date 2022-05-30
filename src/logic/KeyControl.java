package logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
class KeyControl extends KeyAdapter
{
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
