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
public class AoE extends Abillity {

    private SkillType skillType = SkillType.AOE;
    private int damage;
    private int damageGain;
    private int xPos;
    private int yPos;
    private int area;
    private int areaGain;
    private int delay;
    private int delayGain;
    private List<Buff> buffs;
    private Skill skill;
    private SkillEntityType type;
    private boolean isCasted = false;
    private int side;

    public AoE(int damage, int xPos, int yPos, int area, int delay,
            List<Buff> buffs, int damageGain, int areaGain, int delayGain,
            Skill skill, SkillEntityType type) {
        this.damage = damage;
        this.area = area;
        this.delay = delay;
        this.buffs = buffs;
        this.damageGain = damageGain;
        this.areaGain = areaGain;
        this.delayGain = delayGain;
        this.skill = skill;
        this.type = type;
    }

    public void use(int x, int y, int side) {
        isCasted = true;
        this.xPos = x;
        this.yPos = y;
        this.side = side;
    }

    private void upStats() {
        damage += damageGain;
        area += areaGain;
        delay += delayGain;
    }

    public boolean checkAvailability(int level, int energyPool) {
        if (level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setPos(int xPos, int yPos) {
        xPos = xPos;
        yPos = yPos;
    }

    public int getId() {
        return this.skill.getId();
    }

    public int getDamage() {
        return damage;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getArea() {
        return area;
    }

    public int getDelay() {
        return delay;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public void tick() {
        skill.tick();
    }

    public int getColdown() {
        return skill.getColdown();
    }

    @Override
    public String getName() {
        return this.skill.getName();
    }

    @Override
    public SkillType getSkillType() {
        return skillType;
    }

    @Override
    public void lvlUp() {
        skill.lvlUp();
        upStats();
    }

    public SkillEntityType getSkillEntityType() {
        return type;
    }

    @Override
    public int getCastTime() {
        return skill.getCastTime();
    }

    public int getEnergyCost() {
        return skill.getEnergyCost();
    }
}
