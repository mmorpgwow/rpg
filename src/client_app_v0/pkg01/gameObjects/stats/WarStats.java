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
public class WarStats extends HeroStats{
    
    public WarStats(int strenght,int agility, int intellegence, int physicArmor,
            int magicResist, int attackPower, int spellPower){
        super(strenght,agility,intellegence,physicArmor,
            magicResist, attackPower, spellPower);
    }

    @Override
    public void LvlUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetHpReg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetMpReg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
