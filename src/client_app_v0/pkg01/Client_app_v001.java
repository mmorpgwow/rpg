/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01;

import client_app_v0.pkg01.battleGround.BattleGround;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.Mage;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.inventory.items.Item;
import client_app_v0.pkg01.gameObjects.inventory.items.ItemList;
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
        Player p1 = SetPlayer();
        Player p2 = SetPlayer();
        BattleGround bg = new BattleGround(100, 12, 5);
        RenderBattleGround r = new RenderBattleGround(bg);
        r.show();
        while (true) {
            r.update();
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client_app_v001.class.getName()).log(Level.SEVERE, null, ex);
            }
            r.show();
        }
    }

    public static Player SetPlayer() { // Probably you should add position of 
        //player at the battle ground as input values
        Body body = new Body(10, 10); //Correct it if it's necessary
        
        List<Abillity> skills = new ArrayList<Abillity>();
        SkillList skillList = new SkillList();
        for (int i = 0; i < 7; i++) {
            skills.add(skillList.getSkillWithID(i));
        }
        
        List<Item> bag = new ArrayList<Item>();
        ItemList itemList = new ItemList();
        bag.add(itemList.GetItemWithID(9));
        bag.add(itemList.GetItemWithID(10));
        HeroArmor heroArmor = HeroArmor();
        for (int i = 0; i < 8; i++) {
            if (i!=2) {
                heroArmor.putOnArmor(skillList.getSkillWithID(i));
            }
            else{
                heroArmor.putOnWeapon(skillList.getSkillWithID(i));
            }
        }
        Inventory inventory = new Inventory(bag,heroArmor);
        
        ChangeableStats stats = new ChangeableStats(10,1,25,2,50,1,70,2,20,1,40,2,
        1000,20,2000,40,10,1,20,2,0);
        Mage mage = new Mage(0,0,stats);
        
        Player player = new Player(0,0,0,0,10,body,inventory,mage,skills);
        return player;
    }
}
