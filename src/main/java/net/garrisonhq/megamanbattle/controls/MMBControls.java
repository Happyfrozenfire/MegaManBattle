/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.garrisonhq.megamanbattle.controls;

import net.garrisonhq.ghqlib.controls.ControlsObject;

/**
 *
 * @author gusjg
 */
public final class MMBControls extends ControlsObject.Short
{
    /**
     * Up. 2^0
     */
    public static final short UP =          0b00000000000001;
    
    /**
     * Down. 2^1
     */
    public static final short DOWN =        0b00000000000010;
    
    /**
     * Left. 2^2
     */
    public static final short LEFT =        0b00000000000100;
    
    /**
     * Right. 2^3
     */
    public static final short RIGHT =       0b00000000001000;
    
    /**
     * Jump. 2^4
     */
    public static final short JUMP =        0b00000000010000;
    
    /**
     * Weapon 1. 2^5
     */
    public static final short WEAPON_1 =    0b00000000100000;
    
    /**
     * Weapon 2. 2^6
     */
    public static final short WEAPON_2 =    0b00000001000000;
    
    /**
     * Slide/Dash/etc button. 2^7
     */
    public static final short SLIDE =       0b00000010000000;
    
    /**
     * Start. 2^8
     */
    public static final short START =       0b00000100000000;
    
    /**
     * Select. Current purpose unknown, but it brings the whole SNES controller
     * vibe together. 2^9
     */
    public static final short SELECT =      0b00001000000000;
    
    /**
     * The left bumper. Will be used for switching pallettes on the CSS. 2^10
     */
    public static final short L_BUMPER =    0b00010000000000;
    
    /**
     * The right bumper. Will be used for switching pallettes on the CSS. 2^11
     */
    public static final short R_BUMPER =    0b00100000000000;
    
    /**
     * Accept. By default, it's mapped to the same input as Jump, but it can be
     * mapped to a different input if the player wants. 2^12
     */
    public static final short ACCEPT =      0b01000000000000;
    
    /**
     * Cancel. By default, it's mapped to the same input as Slide, but it can be
     * mapped to a different input if the player wants. 2^13
     */
    public static final short CANCEL =      0b10000000000000;
    
    /**
     * Jump + Accept for default mapping purposes.
     */
    public static final short JUMP_ACCEPT = JUMP | ACCEPT;
    
    /**
     * Slide + Cancel for default mapping purposes.
     */
    public static final short SLIDE_CANCEL = SLIDE | CANCEL;
    
    public MMBControls()
    {
        super();
    }

    public MMBControls(short controls, boolean pressed)
    {
        super(controls, pressed);
    }

    public MMBControls(short pressedControls, short heldControls)
    {
        super(pressedControls, heldControls);
    }
    
    @Override
    public boolean[][] toBoolArr()
    {
        boolean[][] arr = new boolean[2][14];
        short pressed = getPressedControls().shortValue();
        short held = getHeldControls().shortValue();
        for(int i = 0; i < 14; i++)
        {
            arr[0][i] = (0b1 << i) == (pressed & (0b1 << i));
            arr[1][i] = (0b1 << i) == (held & (0b1 << i));
        }

        return arr;
    }
}
