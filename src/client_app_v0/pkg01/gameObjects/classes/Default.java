/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.classes;

/**
 *
 * @author Pablo
 */
public class Default extends Hero {

    public Default() {
        super(0);
        heroClass = ClassType.DEFAULT;
    }

    @Override
    public ClassType getHeroClass() {
        return heroClass;
    }
}
