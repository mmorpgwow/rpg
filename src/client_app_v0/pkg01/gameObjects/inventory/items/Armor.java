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
public class Armor extends Item{
    
    public final ItemType itemType = ItemType.ARMOR;
    //================================================
    private ArmorType type;
    private Stats stats;
    //================================================
    public Armor(int id, String name,int buyCost, int sellCost, Stats stats, ArmorType armType) {
        super(id, name, buyCost, sellCost);
        this.stats = stats;
        this.type = armType;
    }
    
    public Stats getStats(){
        return stats;
    }
    
    public ArmorType getArmorType() {
        return type;
    }
    
}
