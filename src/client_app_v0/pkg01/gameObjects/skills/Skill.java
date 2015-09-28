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
public abstract class Skill {

    private SkillType _skillType;
    private int _lvl;
    private int _lvlcost;
    private int _cost;
    private int _cooldown;
    private ClassType _classType;
    private int _id;
    private String _name;
    private int _range;

    public Skill(SkillType skillType, int lvlcost, int cost, int cooldown,
            ClassType classType, int id, String name, int range) {
        _skillType = skillType;
        _lvl = 0;
        _lvlcost = lvlcost;
        _cost = cost;
        _cooldown = cooldown;
        _classType = classType;
        _id = id;
        _name = name;
        _range = range;
    }
    
    public void LvlUp(){
        _lvl += 1;
    }
}
