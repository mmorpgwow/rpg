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

    private int strength;
    private int strengthGain;
    private int intellegence;
    private int intellegenceGain;
    private int physicArmor;
    private int physicArmorGain;
    private int magicResist;
    private int magicResistGain;
    private int attackPower;
    private int attackPowerGain;
    private int spellPower;
    private int spellPowerGain;
    private int health;
    private int healthGain;
    private int energy;
    private int energyGain;
    private int healthRegen;
    private int healthRegenGain;
    private int energyRegen;
    private int energyRegenGain;

    int levelCost;
    int level;

    public ChangeableStats(
            int strength, int strengthGain, int intellegence, int intellegenceGain,
            int physicArmor, int physicArmorGain, int magicResist, int magicResistGain,
            int attackPower, int attackPowerGain, int spellPower, int spellPowerGain,
            int health, int healthGain, int energy, int energyGain,
            int healthRegen, int healthRegenGain, int energyRegen, int energyRegenGain, int levelCost) {
        this.strength = strength;
        this.strengthGain = strengthGain;
        this.intellegence = intellegence;
        this.intellegenceGain = intellegenceGain;
        this.physicArmor = physicArmor;
        this.physicArmorGain = physicArmorGain;
        this.magicResist = magicResist;
        this.magicResistGain = magicResistGain;
        this.attackPower = attackPower;
        this.attackPowerGain = attackPowerGain;
        this.spellPower = spellPower;
        this.spellPowerGain = spellPowerGain;
        this.health = health;
        this.healthGain = healthGain;
        this.energy = energy;
        this.energyGain = energyGain;
        this.healthRegen = healthRegen;
        this.healthRegenGain = healthRegenGain;
        this.energyRegen = energyRegen;
        this.energyRegenGain = energyRegenGain;
        this.levelCost = levelCost;
        level = 0;
    }

    public ChangeableStats getStats(){
        return this;
    }
    
    public void initLevel(int lvl) {
        level = lvl;
    }

    private int calculateStat(int startStat, int gainStat) {
        if (checkLevel()) {
            return startStat += gainStat * (level - levelCost);
        } else {
            return 0;
        }
    }

    public boolean checkLevel() {
        if (levelCost > level) {
            return false;
        }
        return true;
    }

    public void lvlUp() {
        level++;
    }

    private void increaseStats() {
        strength += strengthGain;
        intellegence += intellegenceGain;
        physicArmor += physicArmorGain;
        magicResist += magicResistGain;
        attackPower += attackPowerGain;
        spellPower += spellPowerGain;
        health += healthGain;
        energy += energyGain;
        healthRegen += healthRegenGain;
        energyRegen += energyRegenGain;
    }

    public int getStrength() {
        return calculateStat(strength, strengthGain);
    }

    public int getIntellegence() {
        return calculateStat(intellegence, intellegenceGain);
    }

    public int getPhysicArmor() {
        return calculateStat(physicArmor, physicArmorGain);
    }

    public int getMagicResist() {
        return calculateStat(magicResist, magicResistGain);
    }

    public int getAttackPower() {
        return calculateStat(attackPower, attackPowerGain);
    }

    public int getSpellPower() {
        return calculateStat(spellPower, spellPowerGain);
    }

    public int getHealth() {
        return calculateStat(health, healthGain);
    }

    public int getEnergy() {
        return calculateStat(energy, energyGain);
    }    

    public int getHealthRegen() {
        return calculateStat(healthRegen, healthRegenGain);
    }

    public int getEnergyRegen() {
        return calculateStat(energyRegen, energyRegenGain);
    }
}
