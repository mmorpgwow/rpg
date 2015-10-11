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
public class Components extends Item{

    public final ItemType itemType = ItemType.COMPONENT;
    //================================================
    
    //================================================
    
    public Components(int id, String name, int buyCost, int sellCost) {
        super(id, name, buyCost, sellCost);
    }

    @Override
    public ItemType getItemType(){
        return itemType;
    }
    
}
