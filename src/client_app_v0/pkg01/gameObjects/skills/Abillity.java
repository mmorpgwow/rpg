/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

/**
 *
 * @author Pablo
 */
public abstract class Abillity implements Spell {
    private SkillType skillType;
    
    public abstract void lvlUp();    
    
    public abstract void tick();    
    
    public abstract int getCastTime();
    
    public abstract String getName();
    
    public abstract int getId();

}
