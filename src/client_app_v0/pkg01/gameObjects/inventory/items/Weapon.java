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
    
    public final ItemType _itemType = ItemType.ARMOR;
    //================================================
    private boolean _twoHands;
    private WeaponType _type;
    private Stats _stats;
    
    private int _maxDamage;
    private int _minDamage;
    //================================================
    public Weapon(int id, String name,int buyCost, int sellCost, int strength, int agility, int intellegence,
            int physicArmor, int magicResist, int attackPower, int spellPower, 
            WeaponType type, boolean twoHands, int maxDamage, int minDamage) {
        super(id, name, buyCost, sellCost);
        _stats = new Stats(strength, intellegence, physicArmor, magicResist, attackPower, spellPower);
        _type = type;
        _twoHands = twoHands;
        _maxDamage = maxDamage;
        _minDamage = minDamage;
    }
    
    public Stats GetStats(){
        return _stats;
    }
    
    public int Hit(){
        Random rnd = new Random();
        int number = _minDamage + rnd.nextInt(_maxDamage - _minDamage + 1);
        return number;
    }
    
    public WeaponType GetWeaponType(){
        return _type;
    }
    
    public boolean TwoHands(){
        return _twoHands;
    }    
    
}

