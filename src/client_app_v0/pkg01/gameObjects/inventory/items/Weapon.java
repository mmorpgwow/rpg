/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory.items;

import java.util.Random;

/**
 *
 * @author Broff
 */
public class Weapon extends Item{
    
    public final ItemType itemType = ItemType.ARMOR;
    //================================================
    private boolean twoHands;
    private WeaponType type;
    private Stats stats;
    
    private int maxDamage;
    private int minDamage;
    //================================================
    public Weapon(int id, String name,int buyCost, int sellCost, int strength, int agility, int intellegence,
            int physicArmor, int magicResist, int attackPower, int spellPower, 
            WeaponType type, boolean twoHands, int maxDamage, int minDamage) {
        super(id, name, buyCost, sellCost);
        this.stats = new Stats(strength, intellegence, physicArmor, magicResist, attackPower, spellPower);
        this.type = type;
        this.twoHands = twoHands;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
    }
    
    public Stats getStats(){
        return stats;
    }
    
    public int hit(){
        Random rnd = new Random();
        int number = minDamage + rnd.nextInt(maxDamage - minDamage + 1);
        return number;
    }
    
    public WeaponType getWeaponType(){
        return type;
    }
    
    public boolean twoHands(){
        return twoHands;
    }    
    
}

