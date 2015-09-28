/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.stats;

/**
 *
 * @author Pablo
 */
public abstract class HeroStats {

    private int _lvl;
    private int _exp;

    private int _strenght;
    private int _agility;
    private int _intellegence;
    private int _physicArmor;
    private int _magicResist;
    private int _attackPower;
    private int _spellPower;
    
    public HeroStats(int strenght,int agility, int intellegence, int physicArmor,
            int magicResist, int attackPower, int spellPower){
        _lvl = 1;
        _exp = 0;
        _strenght = strenght;
        _agility = agility;
        _intellegence = intellegence;
        _physicArmor = physicArmor;
        _magicResist = magicResist;
        _attackPower = attackPower;
        _spellPower = spellPower;
    }
    
    public int GetLvl() {
        return _lvl;
    }

    public void AddExp(int exp) {
        _exp += exp;
        CheckLvlUp();
    }

    private void CheckLvlUp() {

    }
    
    public abstract void LvlUp();
    public abstract int GetHpReg();
    public abstract int GetMpReg();

    public int GetExp() {
        return _exp;
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
