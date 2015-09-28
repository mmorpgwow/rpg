/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory;

import client_app_v0.pkg01.gameObjects.inventory.items.Item;
import java.util.ArrayList;
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
    
    public Inventory(){
        _bag = new ArrayList<Item>() {};
        _armor = new HeroArmor();
    }
    
    public int GetGold(){
        return _gold;
    }
    public int GetGem(){
        return _gem;
    }
    public List<Item> GetBag(){
        return _bag;
    }
    public HeroArmor GetArmor(){
        return _armor;
    }
    
}
