/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.garrisonhq.megamanbattle;

import java.awt.event.KeyEvent;
import net.garrisonhq.ghqlib.Game;
import net.garrisonhq.ghqlib.controls.KeyboardInput;
import net.garrisonhq.ghqlib.engine.Match;
import net.garrisonhq.megamanbattle.controls.MMBControls;

/**
 *
 * @author gusjg
 */
public class Main extends Game
{
    public Main()
    {
        super(640, 640 * 9 / 12, "Mega Man Battle");
    }

    @Override
    public void start() 
    {
        inputArr = new KeyboardInput[1];
        inputArr[0] = new KeyboardInput(new MMBControls());
        for(KeyboardInput input : inputArr)
        {
            this.addKeyListener(input);
        }
        
        inputArr[0].getInputMap().put(KeyEvent.VK_UP, MMBControls.UP);
        inputArr[0].getInputMap().put(KeyEvent.VK_DOWN, MMBControls.DOWN);
        inputArr[0].getInputMap().put(KeyEvent.VK_LEFT, MMBControls.LEFT);
        inputArr[0].getInputMap().put(KeyEvent.VK_RIGHT, MMBControls.RIGHT);
        inputArr[0].getInputMap().put(KeyEvent.VK_SPACE, MMBControls.JUMP_ACCEPT);
        inputArr[0].getInputMap().put(KeyEvent.VK_C, MMBControls.WEAPON_1);
        inputArr[0].getInputMap().put(KeyEvent.VK_X, MMBControls.WEAPON_2);
        inputArr[0].getInputMap().put(KeyEvent.VK_Z, MMBControls.SLIDE_CANCEL);
        inputArr[0].getInputMap().put(KeyEvent.VK_ENTER, MMBControls.START);
        inputArr[0].getInputMap().put(KeyEvent.VK_SPACE, MMBControls.JUMP);
        inputArr[0].getInputMap().put(KeyEvent.VK_A, MMBControls.L_BUMPER);
        inputArr[0].getInputMap().put(KeyEvent.VK_S, MMBControls.R_BUMPER);
        inputArr[0].getInputMap().put(KeyEvent.VK_SHIFT, MMBControls.SELECT);
        
        Match match = new Match();
        handler = match;
    }
    
    public static void main(String[] args)
    {
        INSTANCE = new Main();
    }
}
