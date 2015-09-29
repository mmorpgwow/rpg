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
    private final ClassType _class = ClassType.MAGE;

    public Mage(int startExp, int exp, ChangableStats stats) {
        super(startExp, exp, stats);
    }        
    
    public ClassType GetClass(){
        return _class;
    }
}
