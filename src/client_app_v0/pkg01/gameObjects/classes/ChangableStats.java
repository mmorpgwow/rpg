/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.classes;

/**
 *
 * @author Broff
 */
public class ChangableStats {

    private int _strenght;
    private int _strenghtGain;
    private int _intellegence;
    private int _intellegenceGain;
    private int _physicArmor;
    private int _physicArmorGain;
    private int _magicResist;
    private int _magicResistGain;
    private int _attackPower;
    private int _attackPowerGain;
    private int _spellPower;
    private int _spellPowerGain;
    private int _health;
    private int _healthGain;
    private int _energy;
    private int _energyGain;
    private int _healthRegen;
    private int _healthRegenGain;
    private int _energyRegen;
    private int _energyRegenGain;

    int _levelCost;
    int _level;

    public ChangableStats(
            int strenght, int strenghtGain, int intellegence, int intellegenceGain,
            int physicArmor, int physicArmorGain, int magicResist, int magicResistGain,
            int attackPower, int attackPowerGain, int spellPower, int spellPowerGain,
            int health, int healthGain, int energy, int energyGain,
            int healthRegen, int healthRegenGain, int energyRegen, int energyRegenGain, int levelCost) {
        _strenght = strenght;
        _strenghtGain = strenghtGain;
        _intellegence = intellegence;
        _intellegenceGain = intellegenceGain;
        _physicArmor = physicArmor;
        _physicArmorGain = physicArmorGain;
        _magicResist = magicResist;
        _magicResistGain = magicResistGain;
        _attackPower = attackPower;
        _attackPowerGain = attackPowerGain;
        _spellPower = spellPower;
        _spellPowerGain = spellPowerGain;
        _health = health;
        _healthGain = healthGain;
        _energy = energy;
        _energyGain = energyGain;
        _healthRegen = healthRegen;
        _healthRegenGain = healthRegenGain;
        _energyRegen = energyRegen;
        _energyRegenGain = energyRegenGain;
        _levelCost = levelCost;
        _level = 0;
    }

    public void initLevel(int lvl) {
        _level = lvl;
    }

    private int calculateStat(int startStat, int gainStat) {
        if(checkLevel()){
            return startStat += gainStat * (_level - _levelCost);
        } else {
            return 0;
        }
    }

    public boolean checkLevel() {
        if (_levelCost > _level) {
            return false;
        }
        return true;
    }

    public int GetStrenght() {
        return calculateStat(_strenght, _strenghtGain);
    }

    public int GetIntellegence() {
        return calculateStat(_intellegence, _intellegenceGain);
    }

    public int GetPhysicArmor() {
        return calculateStat(_physicArmor, _physicArmorGain);
    }

    public int GetMagicResist() {
        return calculateStat(_magicResist, _magicResistGain);
    }

    public int GetAttackPower() {
        return calculateStat(_attackPower, _attackPowerGain);
    }

    public int GetSpellPower() {
        return calculateStat(_spellPower, _spellPowerGain);
    }

    public int GetHealth() {
        return calculateStat(_health, _healthGain);
    }

    public int GetEnergy() {
        return calculateStat(_energy, _energyGain);
    }
    
    public int GetHealthRegen() {
        return calculateStat(_healthRegen, _healthRegenGain);
    }

    public int GetEnergyRegen() {
        return calculateStat(_energyRegen, _energyRegenGain);
    }
}
