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
 * @author Pablo
 */
public class Melee extends Abillity {

    private SkillType skillType = SkillType.MELEE;
    private int damage;
    private int damageGain;
    private List<Buff> buffs;
    private SkillEntityType type;
    private Skill skill;

    public Melee(Skill skill, int damage, List<Buff> buffs, SkillEntityType type,
            int damageGain) {
        this.damage = damage;
        this.buffs = buffs;
        this.type = type;
        this.skill = skill;
        this.damageGain = damageGain;
    }

    public boolean checkAvailability(int level, int energyPool) {
        if (level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0) {
            return true;
        } else {
            return false;
        }
    }
 
     public int use(Player target){
        skill.use();
        int dmg = getDamage();
        SkillEntityType st = this.getSkillEntityType();
        target.takeDamage(dmg, st);
        return dmg;
    }
    
    public int getColdown() {
        return skill.getColdown();
    }

    public int getEnergyCost() {
        return skill.getEnergyCost();
    }
    
    public int getDamage(){
        return damage;
    }

    public SkillEntityType getSkillEntityType(){
        return type;
    }
    
    @Override
    public void lvlUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getId(){
        return this.skill.getId();
    }
    
    @Override
    public void tick(){        
        skill.tick();
    }
    

    @Override
    public int getCastTime() {
       return skill.getCastTime();
    }

    @Override
    public String getName() {
        return skill.getName();
    }


    @Override
    public SkillType getSkillType() {
        return skillType;
    }

}
