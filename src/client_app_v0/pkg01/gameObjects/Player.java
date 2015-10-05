/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.inventory.items.Stats;
import client_app_v0.pkg01.gameObjects.physicBody.Body;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class Player extends Entity{
    public final static EntityType type = EntityType.PLAYER;
    
    private Body body;    
    private Inventory inventory;
    private Hero classHero;
    private List<Abillity> skills = new ArrayList<Abillity>();   
    private int abilityPoints;
    
    public Player(int xPos, int yPos,int xBattle,int yBattle,int speed, Body body, Inventory inventory, 
            Hero classHero, List<Abillity> skills) {
        super(xPos, yPos, xBattle, yBattle,speed, body);
        this.inventory = inventory;
        this.classHero = classHero;
        this.skills = skills;
        this.battleState = false;
    }

    public int getLevel(){
        return this.classHero.getLevel();
    }
    
    public void startBattle(){
        this.battleState = true;
    }
    
    public void finishtBattle(){
        this.battleState = false;
    }
    
    public void abilityLvlUp(int abilityId){
        
    }
    
    public List<Abillity> getAbilityList(){
        return skills;
    }
    
    public Abillity getAbility(int id){
        if(skills.size() > id && id >=0){
            return skills.get(id);
        } else {
            return null;
        }
    }
    
    public ChangeableStats getHeroStats(){
        return this.classHero.getStat();
    }
    
    public Stats getArmorStats(){
        return this.inventory.getArmor().getArmorStats();
    }
    
    public int getGold(){
        return this.inventory.getGold();
    }
    
    public void addGold(int gold){
        this.inventory.addGold(gold);
    }
    
    public void addGem(int gem){
        this.inventory.addGem(gem);
    }
    
    public int getGem(){
        return this.inventory.getGem();
    }
    
    public int getStrenght() {
        return getHeroStats().getStrength() + getArmorStats().getStrenght();
    }

    public int getIntellegence() {
        return getHeroStats().getIntellegence() + getArmorStats().getIntellegence();
    }

    public int getPhysicArmor() {
        return getHeroStats().getPhysicArmor() + getArmorStats().getPhysicArmor();
    }

    public int getMagicResist() {
        return getHeroStats().getMagicResist() + getArmorStats().getMagicResist();
    }

    public int getAttackPower() {
        return getHeroStats().getAttackPower() + getArmorStats().getAttackPower();
    }

    public int getSpellPower() {
        return getHeroStats().getSpellPower() + getArmorStats().getSpellPower();
    }
    
    public int getHealth() {
        return this.classHero.getStat().getHealth();
    }

    public int getEnergy() {
        return this.classHero.getStat().getEnergy();
    }

    public int getHealthRegen() {
        return this.classHero.getStat().getHealthRegen();
    }

    public int getEnergyRegen() {
        return this.classHero.getStat().getEnergyRegen();
    }
}
