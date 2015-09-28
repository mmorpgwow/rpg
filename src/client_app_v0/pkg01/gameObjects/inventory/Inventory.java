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
    
    private int _gold;
    private int _gem;
    private List<Item> _bag;
    private HeroArmor _armor;
    
    public Inventory(List<Item> bag, HeroArmor armor ){
        _bag = bag;
        _armor = armor;
    }
    
    public int GetGold(){
        return _gold;
    }
    
    public boolean GiveGold(int gold){
        if(_gold < gold){
            return false;
        } else {
            _gold -= gold;
            return true;
        }
    }
    
    public void AddGold(int gold){
        _gold += gold;
    }
    
    public int GetGem(){
        return _gem;
    }
    
    public boolean GiveGem(int gem){
        if(_gem < gem){
            return false;
        } else {
            _gem -= gem;
            return true;
        }
    }
    
    public void AddGem(int gems){
        _gem += gems;
    }
    
    public List<Item> GetBag(){
        return _bag;
    }
    
    public HeroArmor GetArmor(){
        return _armor;
    }
    
}
