/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills.objects;

import client_app_v0.pkg01.gameObjects.classes.ClassType;
import client_app_v0.pkg01.gameObjects.skills.Shield;
import client_app_v0.pkg01.gameObjects.skills.Skill;
import client_app_v0.pkg01.gameObjects.skills.SkillEntityType;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class ShieldList {
    
    public static List<Shield> getShields(){
        List<Shield> shieldList = new LinkedList<Shield>();
        
        Skill skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        Shield shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        
        skill = new Skill(1, 4, 55, ClassType.MAGE, 4, "FrostShield", 0, 4, 2, 1, 0);
        shield = new Shield(skill, SkillEntityType.MFROST, 4, 100, 80);
        shieldList.add(shield);
        return shieldList;
    }
}
