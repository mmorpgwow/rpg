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
public class Shield{
    
    private SkillEntityType _typeOfBlockingSkill;
    private int _blockingDamage;
    private int _blockingDamageChange;
    private Skill _skill;

    public Shield(Skill skill, SkillEntityType typeOfBlockingSkill,
            int blockingDamage, int blockingDamageChange) {
        _typeOfBlockingSkill = typeOfBlockingSkill;
        _blockingDamage = blockingDamage;
        _blockingDamageChange = _blockingDamageChange;
        _skill = skill;
    }
    
    public void LvlUp(){
        _skill.LvlUp();
        ChangeStats();
    }
    private void ChangeStats(){
        _blockingDamage += _blockingDamageChange;
    }
    
    public SkillEntityType GetType(){
        return _typeOfBlockingSkill;
    }
    public int GetDamage(){
        return _blockingDamage;
    }
}
