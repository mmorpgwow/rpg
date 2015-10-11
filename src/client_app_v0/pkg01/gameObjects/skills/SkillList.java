/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.ClassType;

/**
 *
 * @author Pablo
 */
public class SkillList {

    private Abillity fireBall;
    private Abillity frostBolt;
    private Abillity fireWall;
    private Abillity fireShield;
    private Abillity frostShield;
    private Abillity lightningShield;
    private Abillity strengthBuff;
    private Abillity intellegenceBuff;
    private Abillity frostHit;
    private Abillity fireHit;
    private Abillity lightningHit;
    private Abillity hit;

    public SkillList() {
        init();
    }

    private void init() { // -_-
        Skill skill = new Skill(1, 10, 20, ClassType.MAGE, 0, "FireBall", 100, 2, 1, 0, 2);
        fireBall = new Ranged(skill, 0, 0, 50, 50, 100, null, SkillEntityType.MFIRE, 5);
        skill = new Skill(1, 8, 30, ClassType.MAGE, 1, "FrostBall", 150, 1, 1, 0, 2);
        frostBolt = new Ranged(skill, 0, 0, 50, 50, 80, null, SkillEntityType.MFIRE, 4);
        skill = new Skill(1, 20, 50, ClassType.MAGE, 2, "FireWall", 100, 5, 5, 1, 2);
        fireWall = new AoE(200, 0, 0, 20, 5, null, 5, 2, 0, skill, SkillEntityType.MFIRE);
        skill = new Skill(1, 5, 50, ClassType.MAGE, 3, "FireShield", 0, 5, 2, 1, 0);
        fireShield = new Shield(skill, SkillEntityType.MFIRE, 4, 100, 80);
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        frostShield = new Shield(skill, SkillEntityType.MFROST, 4, 120, 80);
        skill = new Skill(1, 4, 45, ClassType.MAGE, 5, "LightningShield", 0, 3, 2, 1, 0);
        lightningShield = new Shield(skill, SkillEntityType.MLIGHTNING, 4, 80, 80);
        skill = new Skill(1, 10, 10, ClassType.MAGE, 6, "StrengthBuff", 0, 5, 5, 0, 0);
        ChangeableStats stats = new ChangeableStats(10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        strengthBuff = new Buff(skill, stats, 100, 5);
        skill = new Skill(1, 10, 3, ClassType.MAGE, 7, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        intellegenceBuff = new Buff(skill, stats, 8, 5);
        skill = new Skill(1, 300, 3, ClassType.MAGE, 8, "FrostHit", 50, 1, 1, 0, 5);
        frostHit = new Directional(skill, 150, 10, null, SkillEntityType.MFROST, 1);
        skill = new Skill(1, 400, 2, ClassType.MAGE, 9, "FireHit", 50, 1, 1, 0, 5);
        fireHit = new Directional(skill, 200, 10, null, SkillEntityType.MFIRE, 1);
        skill = new Skill(1, 200, 3, ClassType.MAGE, 10, "LightningHit", 50, 1, 1, 0, 5);
        lightningHit = new Directional(skill, 100, 10, null, SkillEntityType.MLIGHTNING, 1);
        skill = new Skill(1, 150, 1, ClassType.MAGE, 11, "Hit", 0, 2, 2, 0, 0);
        hit = new Melee(skill, 200, null, SkillEntityType.PNORMAL, 1);
    }

    public Abillity getSkillWithID(int id) {
        switch (id) {
            case 0:
                return fireBall;
            case 1:
                return frostBolt;
            case 2:
                return fireWall;
            case 3:
                return fireShield;
            case 4:
                return frostShield;
            case 5:
                return lightningShield;
            case 6:
                return strengthBuff;
            case 7:
                return intellegenceBuff;
            case 8:
                return frostHit;
            case 9:
                return fireHit;
            case 10:
                return lightningHit;
            case 11:
                return hit;
            default:
                return null;
        }
    }
}
