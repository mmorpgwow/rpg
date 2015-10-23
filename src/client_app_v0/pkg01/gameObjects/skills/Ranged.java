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
public class Ranged extends Abillity {

    private SkillType skillType = SkillType.RANGED;
    private int width;
    private int height;
    private int speed;
    private int xPos;
    private int yPos;
    private int damage;
    private int damageGain;
    private List<Buff> buffs;
    private SkillEntityType type;
    private Skill skill;
    private boolean isCasted;
    private int xRes;
    private int yRes;
    private int xSpeed;
    private int ySpeed;
    private int err;
    private float deltaerr;
    private int side;
    private int[][] pathArr;

    public Ranged(Skill skill, int width, int height, int speed,
            int damage, List<Buff> buffs, SkillEntityType type,
            int damageGain) {
        this.err = 0;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.damage = damage;
        this.buffs = buffs;
        this.type = type;
        this.skill = skill;
        this.damageGain = damageGain;
        this.isCasted = false;
        this.pathArr = new int[speed+1][2];
    }

    public boolean checkAvailability(int level, int energyPool) {
        if (level >= skill.getLvlCost() && energyPool >= skill.getEnergyCost() && getColdown() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void use(int x, int y, int xRes, int yRes, int side) {
        isCasted = true;
        this.xPos = x;
        this.yPos = y;
        this.xRes = xRes;
        this.yRes = yRes;
        this.xSpeed = Math.abs(this.xRes - xPos);
        this.ySpeed = Math.abs(this.yRes - yPos);
        this.side = side;
    }

    public boolean getIsCasted() {
        return isCasted;
    }

    public void setIsCasted(boolean isCasted) {
        this.isCasted = isCasted;
    }

    private void BrezAlg() {
        if (xSpeed >= ySpeed) {
            deltaerr = ySpeed;
            for (int i = 0; i <= speed; i++) {
                err += deltaerr;
                if (2 * err >= xSpeed) {
                    if (yRes > yPos) {
                        yPos += 1;
                    } else {
                        yPos -= 1;
                    }
                    i++;
                    err -= xSpeed;
                }
                if (i > speed) {
                    break;
                }
                if (xRes > xPos) {
                    xPos += 1;
                } else {
                    xPos -= 1;
                }
                if (xPos == xRes && yRes == yRes) {
                    break;
                }
                addPointToPath(i);
            }
        } else {
            deltaerr = xSpeed;
            for (int i = 0; i <= speed; i++) {
                err += deltaerr;
                if (2 * err >= ySpeed) {
                    if (yRes > yPos) {
                        yPos += 1;
                    } else {
                        yPos -= 1;
                    }
                    err -= ySpeed;
                }
                if (i > speed) {
                    break;
                }
                if (xRes > xPos) {
                    xPos += 1;
                } else {
                    xPos -= 1;
                }
                if (xPos == xRes && yRes == yRes) {
                    break;
                }
                addPointToPath(i);
            }
        }
    }

    private void addPointToPath(int i) {
        pathArr[i][0] = xPos;
        pathArr[i][1] = yPos;
    }

    public int[][] getPath() {
        return pathArr;
    }

    @Override
    public void tick() {
        skill.tick();
    }

    public void physicalTick() {
        BrezAlg();
    }

    public int getEnergyCost() {
        return skill.getEnergyCost();
    }

    public void setXPos(int x) {
        this.xPos = x;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
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

    public int getSpeed() {
        return speed;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public SkillEntityType getSkillEntityType() {
        return type;
    }

    @Override
    public int getId() {
        return this.skill.getId();
    }

    @Override
    public void lvlUp() {
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

    public int getColdown() {
        return skill.getColdown();
    }
    
    public int getSide(){
        return this.side;
    }
}
