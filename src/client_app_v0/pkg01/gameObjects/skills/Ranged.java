/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import java.util.List;

/**
 *
 * @author Pablo
 */
public class Ranged extends Abillity{

    private SkillType skillType = SkillType.RANGED;
    private int width;
    private int height;
    private int xSpeed;
    private int ySpeed;
    private int damage;
    private int damageGain;
    private List<Buff> buffs;
    private SkillEntityType type;
    private Skill skill;

    public Ranged(Skill skill, int width, int height, int xSpeed,
            int ySpeed, int damage, List<Buff> buffs, SkillEntityType type,
            int damageGain) {
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.damage = damage;
        this.buffs = buffs;
        this.type = type;
        this.skill = skill;
        this.damageGain = damageGain;
    }

    public int getDamage() {
        return damage;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getXSpeed(){
        return xSpeed;
    }
    public int getYSpeed(){
        return ySpeed;
    }
    public List<Buff> getBuffs() {
        return buffs;
    }
    
    public void tick(){
        skill.tick();
    }
    
    public int getColdown(){
        return skill.getColdown();
    }
    
    public SkillEntityType getSkillEntityType(){
        return type;
    }    
    
    public int getId(){
        return this.skill.getId();
    }
    
    @Override
    public String getName(){
        return this.skill.getName();
    }
   
    @Override
    public SkillType getSkillType(){
        return skillType;
    }
    
    @Override
    public void lvlUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public int getCastTime(){
        return skill.getCastTime();
    }
}
