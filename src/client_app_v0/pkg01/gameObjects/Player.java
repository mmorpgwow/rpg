/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.ClassType;
import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;
import client_app_v0.pkg01.gameObjects.inventory.items.Stats;
import client_app_v0.pkg01.gameObjects.physicBody.Body;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.Buff;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Broff
 */
public class Player extends Entity {

    public final static EntityType type = EntityType.PLAYER;

    private Inventory inventory;
    private Hero classHero;
    private List<Abillity> skills = new ArrayList<Abillity>();
    private List<Buff> buffs = new ArrayList<Buff>();
    private int abilityPoints;
    private String nick;
    private int health;
    private int energy;
    private boolean lifeState = true;
    
    public Player(int xPos, int yPos, int xBattle, int yBattle, int speed, Body body, Inventory inventory,
            Hero classHero, List<Abillity> skills, String nick) {
        super(xPos, yPos, xBattle, yBattle, speed, body);
        this.inventory = inventory;
        this.classHero = classHero;
        this.skills = skills;
        this.battleState = false;
        this.nick = nick;
        this.health = getHealth();
        this.energy = getEnergy();
        abilityPoints = getLevel();
    }

    public ClassType getClassHero() {
        return classHero.getHeroClass();
    }

    public String getNickName(){
        return this.nick;
    }
    
    public List<Buff> getBuffs(){
        return this.buffs;
    }
    
    public String getClassName() {
        switch (getClassHero()) {
            case MAGE:
                return "MAGE";
            case WARRIOR:
                return "WARRIOR";
            default:
                return "NO CLASS";
        }
    }
    
    public void tick(){
        if(lifeState){
            buffsTick();
            regenTick();
        }
    }
    
    private void buffsTick(){
        for(int i = 0 ;i < buffs.size();i++){
            if(buffs.get(i).getTime() <= 1){
                buffs.get(i).tick();
                buffs.remove(i);
            } else {
                buffs.get(i).tick();
            }
        }
    }
    
    private void regenTick(){
        if(health + getHealthRegen() > getHealth()){
            health = getHealth();
        } else {
            health += getHealthRegen();
        }
        if(energy + getEnergyRegen() > getEnergy())
        {
            energy = getEnergy();
        } else {
            energy += getEnergyRegen();
        }   
    }

    public int getLevel() {
        return this.classHero.getLevel();
    }

    public void startBattle() {
        this.health = getHealth();
        this.energy = getEnergy();
        this.battleState = true;
    }

    public void finishtBattle() {
        this.battleState = false;
        
    }

    public void abilityLvlUp(int abilityId) {

    }

    public List<Abillity> getAbilityList() {
        return skills;
    }

    public Abillity getAbility(int id) {
        if (skills.size() > id && id >= 0) {
            return skills.get(id);
        } else {
            return null;
        }
    }

    public ChangeableStats getHeroStats() {
        return this.classHero.getStat();
    }

    public Stats getArmorStats() {
        return this.inventory.getArmor().getArmorStats();
    }

    public int getLevelExp() {
        return this.classHero.getLvlExp();
    }

    public int getExp() {
        return this.classHero.getExp();
    }

    public int getGold() {
        return this.inventory.getGold();
    }

    public void addGold(int gold) {
        this.inventory.addGold(gold);
    }

    public void addGem(int gem) {
        this.inventory.addGem(gem);
    }

    public int getGem() {
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
        return getHeroStats().getHealth() + getStrenght();
    }

    public int getEnergy() {
        return getHeroStats().getEnergy() + getIntellegence();
    }

    public int getActualHealth() {
        return this.health;
    }

    public int getActualEnergy() {
        return this.energy;
    }
    
    public void setActualHealth(int dlt) {
        if(this.health + dlt > getHealth()){
            this.health = getHealth();
        } else if(this.health + dlt <= 0){
            this.health = 0;
            setLifeState();
        } else {
            this.health += dlt;
        }
        
    }
    
    public void setLifeState(){
        this.lifeState = !this.lifeState;
    }
    
    public boolean getLifeState(){
        return this.lifeState;
    }

    public boolean setActualEnergy(int dlt) {
        if(this.energy + dlt > getHealth()){
            this.energy = getHealth();
            return true;
        } else if(this.energy + dlt < 0){
            this.energy = 0;
            return false;
        } else {
            this.energy += dlt;
            return true;
        }
    }

    public int getHealthRegen() {
        return getHeroStats().getHealthRegen();
    }

    public int getEnergyRegen() {
        return getHeroStats().getEnergyRegen();
    }
    
    public int getWidth() {
        return this.body.getWidth();
    }

    public int getHeight() {         
        return this.body.getHeight();
    }
}
