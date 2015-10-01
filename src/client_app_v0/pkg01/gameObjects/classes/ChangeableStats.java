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
public class ChangeableStats {

    private int _strength;
    private int _strengthGain;
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

    public ChangeableStats(
            int strength, int strengthGain, int intellegence, int intellegenceGain,
            int physicArmor, int physicArmorGain, int magicResist, int magicResistGain,
            int attackPower, int attackPowerGain, int spellPower, int spellPowerGain,
            int health, int healthGain, int energy, int energyGain,
            int healthRegen, int healthRegenGain, int energyRegen, int energyRegenGain, int levelCost) {
        _strength = strength;
        _strengthGain = strengthGain;
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
        if (checkLevel()) {
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

    public void LvlUp() {
        _level++;
        IncreaseStats();
    }

    private void IncreaseStats() {
        _strength += _strengthGain;
        _intellegence += _intellegenceGain;
        _physicArmor += _physicArmorGain;
        _magicResist += _magicResistGain;
        _attackPower += _attackPowerGain;
        _spellPower += _spellPowerGain;
        _health += _healthGain;
        _energy += _energyGain;
        _healthRegen += _healthRegenGain;
        _energyRegen += _energyRegenGain;
    }

    public int GetStrength() {
        return calculateStat(_strength, _strengthGain);
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
