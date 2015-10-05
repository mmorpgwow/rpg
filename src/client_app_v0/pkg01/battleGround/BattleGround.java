/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.battleGround;

import client_app_v0.pkg01.gameObjects.physicBody.Entity;
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
    private boolean battleState = false;

    private List<Entity> players = new ArrayList<Entity>();

    public BattleGround(int xSize, int ySize, int roundTime) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.roundTime = roundTime;
    }
    
    public void start(){
        battleState = true;
    }
    
    public void stop(){
        battleState = false;
    }

    public void addPlayer(Entity e) {
        if (!battleState) {
            players.add(e);
        }
    }
    
    public Entity getEntity(int id){
        if(id >= 0 && id < players.size()){
            players.get(id);
        }
        return null;
    }
    
    public List<Entity> getEntityList(){
        return this.players;
    }
    
    public int getXSize(){
        return xSize;
    }
    
    public int getYSize(){
        return ySize;
    }
}
