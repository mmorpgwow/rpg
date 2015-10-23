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
public class Warrior extends Hero{

    public Warrior(int innerExp) {
        super(innerExp);
        super.setHeroClass(heroClass.WARRIOR);
        super.setStats();
    }        
}
