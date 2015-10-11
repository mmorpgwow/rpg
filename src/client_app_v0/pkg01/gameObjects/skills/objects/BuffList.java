/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills.objects;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.ClassType;
import client_app_v0.pkg01.gameObjects.skills.Buff;
import client_app_v0.pkg01.gameObjects.skills.Shield;
import client_app_v0.pkg01.gameObjects.skills.Skill;
import client_app_v0.pkg01.gameObjects.skills.SkillEntityType;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class BuffList {
    public static List<Buff> getBuffs(){
        List<Buff> buffList = new LinkedList<Buff>();
        
        Skill skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        ChangeableStats stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Buff newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        skill = new Skill(1, 10, 3, ClassType.MAGE, 6, "IntellegenceBuff", 0, 5, 5, 0, 0);
        stats = new ChangeableStats(0, 0, 10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        newBuff = new Buff(skill, stats, 8, 5);
        buffList.add(newBuff);
        
        return buffList;
    }
}
