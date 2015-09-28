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
    
    private int _strenght;
    private int _agility;
    private int _intellegence;
    private int _physicArmor;
    private int _magicResist;
    private int _attackPower;
    private int _spellPower;
    private ArmorType _type;
    
    public Armor(int id, String name, int strenght,int agility, int intellegence, 
            int physicArmor,int magicResist,int attackPower,int spellPower,
            ArmorType type){
    super(id, name);
    _strenght = strenght;  
    _agility = agility;
    _intellegence = intellegence;
    _physicArmor = physicArmor;
    _magicResist = magicResist;
    _attackPower = attackPower;
    _spellPower = spellPower;
    _type = type;
    }
    
    public ArmorType GetArmorType() {
        return _type;
    }
    
    public int GetStrenght() {
        return _strenght;
    }

    public int GetAgility() {
        return _agility;
    }

    public int GetIntellegence() {
        return _intellegence;
    }

    public int GetPhysicArmor() {
        return _physicArmor;
    }

    public int GetMagicResist() {
        return _magicResist;
    }

    public int GetAttackPower() {
        return _attackPower;
    }

    public int GetSpellPower() {
        return _spellPower;
    }
}
