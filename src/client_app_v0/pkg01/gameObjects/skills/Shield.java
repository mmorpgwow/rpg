/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ClassType;

/**
 *
 * @author Pablo
 */
public class Shield extends Skill {
    
    private SkillEntityType _typeOfBlockingSkill;
    private int _blockingPercent;

    public Shield(int lvlcost, int cost, int cooldown, ClassType classType, 
            int id, String name, int range, int castTime, SkillEntityType typeOfBlockingSkill,
            int blockingPercent) {
        super(lvlcost, cost, cooldown, classType, id, name, range, castTime);
        _typeOfBlockingSkill = typeOfBlockingSkill;
        _blockingPercent = blockingPercent;
    }
    
    public SkillEntityType GetType(){
        return _typeOfBlockingSkill;
    }
    public int GetPercent(){
        return _blockingPercent;
    }
}
