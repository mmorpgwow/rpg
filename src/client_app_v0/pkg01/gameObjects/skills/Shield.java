/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.ClassType;

/**
 *
 * @author Pablo
 */
public class Shield extends Abillity{
    
    private SkillType skillType = SkillType.SHIELD;
    private SkillEntityType type;
    private int time;
    private int timeValue = 0;
    private int blockingDamage;
    private int blockingDamageGain;
    private Skill skill;

    public Shield(Skill skill, SkillEntityType typeOfBlockingSkill, int time ,
            int blockingDamage, int blockingDamageChange) {
        this.type = typeOfBlockingSkill;
        this.blockingDamage = blockingDamage;
        this.blockingDamageGain = blockingDamageChange;
        this.time = time;
        this.skill = skill;
    }
    
    public boolean checkAvailability(int level, int energyPool) {
        if(level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void lvlUp(){
        skill.lvlUp();
        changeStats();
    }
    private void changeStats(){
        blockingDamage += blockingDamageGain;
    }
    
    public void takeDamage(int dmg){
        if(this.blockingDamage >= dmg){
            this.blockingDamage -= dmg;
        } else if(this.blockingDamage < dmg){
            this.blockingDamage = 0;
        } 
    }
    
    public void use(Player target){
        skill.use();
        timeValue = time;
        target.addShield(this);        
    }
    
    public int getTime(){
        return time;
    }
    
    public int getTimeValue(){
        return timeValue;
    }
    
    public void tick(){
        if(timeValue > 0){
            timeValue--;
        }
    }
    
    public int getId(){
        return this.skill.getId();
    }
    
    public void tickCuldown(){        
        skill.tick();
    }
    
    
    public int getColdown(){
        return skill.getColdown();
    }
    
    public SkillEntityType getSkillEntityType(){
        return type;
    }
    
    public int getDamage(){
        return blockingDamage;
    }
    
    public int getEnergyCost(){
        return skill.getEnergyCost();
    }
    
    @Override
    public String getName(){
        return this.skill.getName();
    }
    
    @Override
    public SkillType getSkillType(){
        return skillType;
    }
    
      public int getCastTime(){
        return skill.getCastTime();
    }
}
