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
    private int abilityPoints;
    
    public Player(int xPos, int yPos,int xBattle,int yBattle,int speed, Body body, Inventory inventory, 
            Hero classHero, List<Abillity> skills) {
        super(xPos, yPos, xBattle, yBattle,speed, body);
        this.inventory = inventory;
        this.classHero = classHero;
        this.skills = skills;
        this.battleState = false;
    }

    public int getLevel(){
        return this.classHero.getLevel();
    }
    
    public void startBattle(){
        this.battleState = true;
    }
    
    public void finishtBattle(){
        this.battleState = false;
    }
    
    public void abilityLvlUp(int abilityId){
        
    }
    
    public List<Abillity> getAbilityList(){
        return skills;
    }
    
    public Abillity getAbility(int id){
        if(skills.size() > id && id >=0){
            return skills.get(id);
        } else {
            return null;
        }
    }
}
