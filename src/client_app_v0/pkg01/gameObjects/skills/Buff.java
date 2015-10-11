/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;

/**
 *
 * @author qw
 */
public class Buff extends Abillity{

    private SkillType skillType = SkillType.BUFF;
    private int time;
    private int timeValue = 0;
    private int timeGain;
    private ChangeableStats stats;
    private Skill skill;
    
    public Buff(Skill skill, ChangeableStats stats, int time, int timeGain) {
        this.time = time;
        this.timeGain = timeGain;
        this.skill = skill;
        this.stats = stats;
    }
    
    public boolean checkAvailability(int level, int energyPool) {
        if(level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public void use(Player target){
        skill.use();
        timeValue = time;
        target.addBuff(this);        
    }
    
    public int getTime(){
        return time;
    }
    
    public int getTimeValue(){
        return timeValue;
    }
    
    public ChangeableStats getStats(){
        return stats;
    }
    
    public void tick(){
        if(timeValue > 0){
            timeValue--;
        }
    }
    
    public void tickCuldown(){        
        skill.tick();
    }
    
    public int getColdown(){
        return skill.getColdown();
    }
    
    public String getName(){
        return skill.getName();
    }
    
    public int getEnergyCost(){
        return skill.getEnergyCost();
    }
    
    @Override
    public SkillType getSkillType(){
        return skillType;
    }
    
    @Override
    public void lvlUp() {
        time+=timeGain;
        stats.lvlUp();
        skill.lvlUp();
    }
      public int getCastTime(){
        return skill.getCastTime();
    }
}
