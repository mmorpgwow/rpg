/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory.items;

/**
 *
 * @author Pablo
 */
public abstract class Item {
    
    private int _id;
    private String _name;
    private int _buyCost;
    private int _sellCost;
    
    public Item(int id, String name, int buyCost, int sellCost){
        _id = id;
        _name = name;
        _buyCost = buyCost;
        _sellCost = sellCost;
    }
    
    public int GetId(){
        return _id;
    }
    
    public String GetName(){
        return _name;
    }
    
    public int GetBuyCost(){
        return _buyCost;
    }
    
    public int GetSellCost(){
        return _sellCost;
    }
}
