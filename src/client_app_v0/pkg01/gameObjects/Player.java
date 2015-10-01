/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects;

import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.physicBody.Body;
import client_app_v0.pkg01.gameObjects.skills.Skill;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class Player {
    
    private Body _body;    
    private Inventory _inventory;
    private Hero _classHero;
    private List<Skill> _skills = new LinkedList<Skill>();
    
    public Player(Body body, Inventory inventory, Hero classHero, List<Skill> skills) {
        _body = body;
        _inventory = inventory;
        _classHero = classHero;
        _skills = skills;
        
    }
}
