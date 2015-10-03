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
public class Shield implements Abillity{
    
    private SkillEntityType typeOfBlockingSkill;
    private int blockingDamage;
    private int blockingDamageChange;
    private Skill skill;

    public Shield(Skill skill, SkillEntityType typeOfBlockingSkill,
            int blockingDamage, int blockingDamageChange) {
        this.typeOfBlockingSkill = typeOfBlockingSkill;
        this.blockingDamage = blockingDamage;
        this.blockingDamageChange = blockingDamageChange;
        this.skill = skill;
    }
    
    @Override
    public void lvlUp(){
        skill.lvlUp();
        changeStats();
    }
    private void changeStats(){
        blockingDamage += blockingDamageChange;
    }
    
    public SkillEntityType getType(){
        return typeOfBlockingSkill;
    }
    public int getDamage(){
        return blockingDamage;
    }
}
