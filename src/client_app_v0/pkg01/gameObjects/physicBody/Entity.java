/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.physicBody;

import client_app_v0.pkg01.gameObjects.physicBody.interfaces.DynamicEntity;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;

/**
 *
 * @author qw
 */
public abstract class Entity implements DynamicEntity {
    
    private int xPos;
    private int yPos;
    
    private Body body;
    private Inventory inventory;
        
    private float health;
    private float energy;
    
    public Entity(int x, int y, float health, float energy,Body body){
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        this.energy = energy;
        this.body = body;
        //this.inventory = new Inventory();
    }

    @Override
    public float getHealth() {
        return health;
    }

    @Override
    public float setHealth(float health) {
        if(health < 0){
            return this.health;
        } else {
            return this.health = health;
        }
    }

    @Override
    public float getEnergy() {
        return this.energy;
    }

    @Override
    public float setEnergy(float energy) {
       if(energy < 0){
           return this.energy;
       } else {
           return this.energy = energy;
       }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        return xPos;
    }

    @Override
    public int getY() {
        return yPos;
    }
    
    @Override
    public void setXpos(int x) {
        this.xPos = x;
    }

    @Override
    public void setYpos(int y) {
        this.yPos = y;
    }
}
