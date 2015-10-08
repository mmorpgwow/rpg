/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01;

import client_app_v0.pkg01.battleGround.BattleGround;
import client_app_v0.pkg01.battleGround.EventListener;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
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
import client_app_v0.pkg01.renderFactory.RenderBattleGround;
import client_app_v0.pkg01.renderFactory.RenderHeroInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Player p2 = getPlayer(90, 5, "Player2");
        
        EventListener el = new EventListener();        
        BattleGround bg = new BattleGround(100, 12, 5);
        bg.addPlayer(p1);
        bg.addPlayer(p2);
        bg.addEventListener(el);
        bg.start();
    }

    public static Player getPlayer(int x, int y, String name) {
        
        Body body = new Body(3, 3); 

        List<Abillity> skills = new ArrayList<Abillity>();
        SkillList skillList = new SkillList();
        for (int i = 0; i < 8; i++) {
            skills.add(skillList.getSkillWithID(i));
        }

        List<Item> bag = new ArrayList<Item>();
        ItemList itemList = new ItemList();
        bag.add(itemList.getItemWithID(9));
        bag.add(itemList.getItemWithID(10));
        HeroArmor heroArmor = new HeroArmor();
        for (int i = 0; i < 9; i++) {
            if (i != 2) {
                heroArmor.putOnArmor((Armor) itemList.getItemWithID(i));
            } else {
                heroArmor.putOnWeapon((Weapon) itemList.getItemWithID(i));
            }
        }
        Inventory inventory = new Inventory(bag, heroArmor);

        ChangeableStats stats = new ChangeableStats(10, 1, 25, 2, 50, 1, 70, 2, 20, 1, 40, 2,
                1000, 20, 2000, 40, 10, 1, 20, 2, 0);
        Mage mage = new Mage(100, 760, stats.getStats());

        return new Player(0, 0, x, y, 10, body, inventory, mage, skills, name);
    }
}
