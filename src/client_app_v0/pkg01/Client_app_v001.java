/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01;

import client_app_v0.pkg01.battleGround.AIBattleGround;
import client_app_v0.pkg01.battleGround.BattleGround;
import client_app_v0.pkg01.battleGround.EventListener;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.classes.Mage;
import client_app_v0.pkg01.gameObjects.inventory.HeroArmor;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.inventory.items.Armor;
import client_app_v0.pkg01.gameObjects.inventory.items.Item;
import client_app_v0.pkg01.gameObjects.inventory.items.ItemList;
import client_app_v0.pkg01.gameObjects.inventory.items.Weapon;
import client_app_v0.pkg01.gameObjects.physicBody.Body;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.SkillList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author qw
 */
public class Client_app_v001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1 = getPlayer(10, 6, "Player1");
        Player p2 = getPlayer(80, 5, "Player2");

        EventListener el = new EventListener();
        BattleGround bg = new BattleGround(100, 12, 5);
        bg.addPlayer(p1);
        bg.addPlayer(p2);
        bg.addEventListener(el);
        bg.start();
        int b1 = 0;
        int b2 = 0;
        /*AIBattleGround ai;        
         for(int i = 0; i < 3000;i++){
         ai = new AIBattleGround(p1,p2);
         ai.start();
         if(ai.getAliveBot() == 0){
         p2.setLifeState();
         b1++;
         } else {
         p1.setLifeState();
         b2++;
         }
         p1.setActualEnergy(p1.getEnergy());
         p2.setActualEnergy(p2.getEnergy());
         p2.setActualHealth(p2.getHealth());
         p1.setActualHealth(p1.getHealth());
         }
         System.out.println("First bot win - "+b1);
         System.out.println("Second bot win - "+b2); */
    }

    public static Player getPlayer(int x, int y, String name) {

        Player p = new Player(0, 0, x, y, 5, name);

        Body body = new Body(3, 3);
        p.setBody(body);

        Hero mage = new Mage(23760);
        p.addHeroClass(mage);       
        
        List<Abillity> skills = new ArrayList<Abillity>();
        SkillList skillList = new SkillList();
        for (int i = 0; i < 9; i++) {
            skills.add(skillList.getSkillWithID(i));
        }
        p.addSkills(skills);

        List<Item> bag = new LinkedList<Item>();
        ItemList itemList = new ItemList();
        bag.add(itemList.getItemWithID(9));
        bag.add(itemList.getItemWithID(10));
        p.addBag(bag);
        HeroArmor heroArmor = new HeroArmor();
        for (int i = 0; i < 9; i++) {
            if (i != 2) {
                heroArmor.putOnArmor((Armor) itemList.getItemWithID(i));
            } else {
                heroArmor.putOnWeapon((Weapon) itemList.getItemWithID(i));
            }
        }
        p.addHeroArmor(heroArmor); 

        return p;
    }
}
