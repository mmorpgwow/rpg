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

    private int _strenght;
    private int _intellegence;
    private int _physicArmor;
    private int _magicResist;
    private int _attackPower;
    private int _spellPower;

    public Stats(int strenght, int intellegence, int physicArmor, int magicResist, int attackPower, int spellPower) {
        _strenght = strenght;
        _intellegence = intellegence;
        _physicArmor = physicArmor;
        _magicResist = magicResist;
        _attackPower = attackPower;
        _spellPower = spellPower;
    }

    public Stats addStats(Stats stats) {
        int str     = this._strenght + stats.GetStrenght();
        int intel   = this._intellegence + stats.GetIntellegence();
        int arm     = this._physicArmor + stats.GetPhysicArmor();
        int magRes  = this._magicResist + stats.GetMagicResist();
        int ap      = this._attackPower + stats.GetAttackPower();
        int spd     = this._spellPower + stats.GetSpellPower();
        
        Stats stat  = new Stats(str, intel, arm, magRes, ap, spd);
        return stat;
    }

    public int GetStrenght() {
        return _strenght;
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
