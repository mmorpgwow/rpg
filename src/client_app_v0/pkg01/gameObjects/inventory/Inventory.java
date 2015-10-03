/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory;

import client_app_v0.pkg01.gameObjects.inventory.items.Item;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class Inventory {
    
    private int gold;
    private int gem;
    private List<Item> bag;
    private HeroArmor armor;
    
    public Inventory(List<Item> bag, HeroArmor armor ){
        this.bag = bag;
        this.armor = armor;
    }
    
    public int getGold(){
        return gold;
    }
    
    public boolean giveGold(int gold){
        if(gold < gold){
            return false;
        } else {
            gold -= gold;
            return true;
        }
    }
    
    public void addGold(int gold){
        gold += gold;
    }
    
    public int getGem(){
        return gem;
    }
    
    public boolean giveGem(int gem){
        if(gem < gem){
            return false;
        } else {
            gem -= gem;
            return true;
        }
    }
    
    public void addGem(int gems){
        gem += gems;
    }
    
    public List<Item> getBag(){
        return bag;
    }
    
    public HeroArmor getArmor(){
        return armor;
    }
    
}
