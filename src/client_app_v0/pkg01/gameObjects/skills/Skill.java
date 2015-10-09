/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ClassType;

/**
 *
 * @author qw
 */
public class Skill {

    private int lvl;
    private int lvlCost;
    private int energyCost;
    private int costGain;
    private int cooldown;
    private int coldownValue = 0;
    private int cooldownGain;
    private ClassType classType;
    private int id;
    private String name;
    private int range;
    private int rangeGain;
    private int castTime;

    public Skill(int lvlcost, int cost, int cooldown,
            ClassType classType, int id, String name, int range, int castTime,
            int costChange, int cooldownChange,int rangeChange) {
        this.lvl = 0;
        this.lvlCost = lvlcost;
        this.energyCost = cost;
        this.cooldown = cooldown;
        this.classType = classType;
        this.id = id;
        this.name = name;
        this.range = range;
        this.castTime = castTime;
        this.costGain = costChange;
        this.cooldownGain = cooldownChange;
        this.rangeGain = rangeChange;
    }
    
    public void lvlUp(){
        lvl++;
        //energyCost += costChange;
        //cooldown += cooldownChange;
        //range += rangeChange;
    }
    
    private int calculateStat(int startStat, int gainStat) {        
        return startStat += gainStat * (lvl);        
    }
    
    public int getLvl(){
        return lvl;
    }
    public int getLvlCost(){
        return lvlCost;
    }
    public int getEnergyCost(){
        return calculateStat(energyCost, costGain);
    }
    
    public boolean use(){
        if(coldownValue == 0){
            coldownValue = cooldown;
            return true;
        } else {
            return false;
        }
    }
    
    public void tick(){
        if(coldownValue > 0){
            coldownValue--;
        }
    }
    
    public int getColdown(){
        return coldownValue;
    }
    
    public ClassType getClassType(){
        return classType;
    }
    
    public int getRange(){
        return range;
    }
    
    public String getName(){
        return name;
    }
}
