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
    
    public ItemType itemType;
    protected int id;
    protected String name;
    protected int buyCost;
    protected int sellCost;
    
    public Item(int id, String name, int buyCost, int sellCost){
        this.id = id;
        this.name = name;
        this.buyCost = buyCost;
        this.sellCost = sellCost;
    }
    
    public abstract ItemType getItemType();
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBuyCost(){
        return buyCost;
    }
    
    public int getSellCost(){
        return sellCost;
    }
}
