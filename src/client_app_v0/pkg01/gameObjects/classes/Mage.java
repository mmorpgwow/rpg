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
public class Mage extends Hero {
    public final ClassType heroClass = ClassType.MAGE;

    public Mage(int startExp, int innerExp, ChangeableStats stats) {
        super(startExp, stats);
        this.addExp(innerExp);
    }        
    
    @Override
    public ClassType getHeroClass(){
        return heroClass;
    }
}
