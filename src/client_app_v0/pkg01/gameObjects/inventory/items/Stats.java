/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory.items;

/**
 *
 * @author Broff
 */
public class Stats {

    private int strenght;
    private int intellegence;
    private int physicArmor;
    private int magicResist;
    private int attackPower;
    private int spellPower;

    public Stats(int strength, int intellegence, int physicArmor, int magicResist, int attackPower, int spellPower) {
        this.strenght = strength;
        this.intellegence = intellegence;
        this.physicArmor = physicArmor;
        this.magicResist = magicResist;
        this.attackPower = attackPower;
        this.spellPower = spellPower;
    }

    public Stats addStats(Stats stats) {
        int str     = this.strenght + stats.getStrenght();
        int intel   = this.intellegence + stats.getIntellegence();
        int arm     = this.physicArmor + stats.getPhysicArmor();
        int magRes  = this.magicResist + stats.getMagicResist();
        int ap      = this.attackPower + stats.getAttackPower();
        int spd     = this.spellPower + stats.getSpellPower();
        
        Stats stat  = new Stats(str, intel, arm, magRes, ap, spd);
        return stat;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getIntellegence() {
        return intellegence;
    }

    public int getPhysicArmor() {
        return physicArmor;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getSpellPower() {
        return spellPower;
    }
}
