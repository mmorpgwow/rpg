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

    private SkillType skillType;
    private int lvl;
    private int lvlCost;
    private int cost;
    private int costChange;
    private int cooldown;
    private int cooldownChange;
    private ClassType classType;
    private int id;
    private String name;
    private int range;
    private int rangeChange;
    private int castTime;

    public Skill(int lvlcost, int cost, int cooldown, SkillType skillType,
            ClassType classType, int id, String name, int range, int castTime,
            int costChange, int cooldownChange,int rangeChange) {
        this.skillType = skillType;
        this.lvl = 0;
        this.lvlCost = lvlcost;
        this.cost = cost;
        this.cooldown = cooldown;
        this.classType = classType;
        this.id = id;
        this.name = name;
        this.range = range;
        this.castTime = castTime;
        this.costChange = costChange;
        this.cooldownChange = cooldownChange;
        this.rangeChange = rangeChange;
    }
    
    public void lvlUp(){
        lvl++;
        cost += costChange;
        cooldown += cooldownChange;
        range += rangeChange;
    }
    
    public int getLvl(){
        return lvl;
    }
    public int getLvlCost(){
        return lvlCost;
    }
    public int getCost(){
        return cost;
    }
    public ClassType getClassType(){
        return classType;
    }
    public int getRange(){
        return range;
    }
}
