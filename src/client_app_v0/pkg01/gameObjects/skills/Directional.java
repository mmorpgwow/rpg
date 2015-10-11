/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.Player;
import java.util.List;

/**
 *
 * @author Broff
 */
public class Directional extends Abillity{
    
    
    private SkillType skillType = SkillType.DIRECTIONAL;
    private int damage;
    private int damageGain;
    private List<Buff> buffs;
    private SkillEntityType type;
    private Skill skill;
    
    public Directional(Skill skill, int damage, int damageGain,
            List<Buff> buffs, SkillEntityType type, int lvlCost) {
        this.damage = damage;
        this.buffs = buffs;
        this.type = type;
        this.skill = skill;
        this.damageGain = damageGain;
    }

    public boolean checkAvailability(int level, int energyPool) {
        if(level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public int getId(){
        return this.skill.getId();
    }
    
    public int use(Player target){
        skill.use();
        int dmg = getDamage();
        SkillEntityType st = this.getSkillEntityType();
        target.takeDamage(dmg, st);
        return dmg;
    }
    
    @Override
    public void tick(){
        skill.tick();
    }
    
    public int getColdown(){
        return skill.getColdown();
    }
    
    @Override
    public String getName(){
        return skill.getName();
    }
    
    public int getEnergyCost(){
        return skill.getEnergyCost();
    }
    
    private int calculateStat(int startStat, int gainStat) {
        return startStat += gainStat * skill.getLvl();
    }
    
    private int getDamage() {
        return calculateStat(damage,damageGain);
    }
    
    public List<Buff> getBuffs() {
        return buffs;
    }
    
    public SkillEntityType getSkillEntityType(){
        return type;
    }    
    
    @Override
    public SkillType getSkillType(){
        return skillType;
    }

    @Override
    public void lvlUp() {
        skill.lvlUp();
    }
    
      public int getCastTime(){
        return skill.getCastTime();
    }
}
