/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.battleGround;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class BattleGround {
    private int xSize;
    private int ySize;
    private int roundTime;
    
    public BattleGround(int xSize, int ySize, int roundTime){
        this.xSize = xSize;
        this.ySize = ySize;
        this.roundTime = roundTime;
    }
}
