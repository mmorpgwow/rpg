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

    private SkillType _skillType;
    private int _lvl;
    private int _lvlCost;
    private int _cost;
    private int _costChange;
    private int _cooldown;
    private int _cooldownChange;
    private ClassType _classType;
    private int _id;
    private String _name;
    private int _range;
    private int _rangeChange;
    private int _castTime;

    public Skill(int lvlcost, int cost, int cooldown, SkillType skillType,
            ClassType classType, int id, String name, int range, int castTime,
            int costChange, int cooldownChange,int rangeChange) {
        _skillType = skillType;
        _lvl = 0;
        _lvlCost = lvlcost;
        _cost = cost;
        _cooldown = cooldown;
        _classType = classType;
        _id = id;
        _name = name;
        _range = range;
        _castTime = castTime;
        _costChange = costChange;
        _cooldownChange = cooldownChange;
        _rangeChange = rangeChange;
    }
    
    public void LvlUp(){
        _lvl++;
        _cost += _costChange;
        _cooldown += _cooldownChange;
        _range += _rangeChange;
    }
    
    public int GetLvl(){
        return _lvl;
    }
    public int GetLvlCost(){
        return _lvlCost;
    }
    public int GetCost(){
        return _cost;
    }
    public ClassType GetClassType(){
        return _classType;
    }
    public int GetRange(){
        return _range;
    }
}
