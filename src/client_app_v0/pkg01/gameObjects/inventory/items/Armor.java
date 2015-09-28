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
    
    public final ItemType _itemType = ItemType.ARMOR;
    //================================================
    private ArmorType _type;
    private Stats _stats;
    //================================================
    public Armor(int id, String name,int buyCost, int sellCost, int strenght, int agility, int intellegence, int physicArmor, int magicResist, int attackPower, int spellPower) {
        super(id, name, buyCost, sellCost);
        _stats = new Stats(strenght, intellegence, physicArmor, magicResist, attackPower, spellPower);
    }
    
    public Stats GetStats(){
        return _stats;
    }
    
    public ArmorType GetArmorType() {
        return _type;
    }
    
}
