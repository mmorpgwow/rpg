/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects;

import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.physicBody.Body;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class Player extends Entity{
    
    private Body body;    
    private Inventory inventory;
    private Hero classHero;
    private List<Abillity> skills = new ArrayList<Abillity>();
    
    public Player(int xPos, int yPos, Body body, Inventory inventory, 
            Hero classHero, List<Abillity> skills) {
        super(xPos,yPos,body);
        this.inventory = inventory;
        this.classHero = classHero;
        this.skills = skills;
    }

    @Override
    public Body getBody() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBody(Body body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
