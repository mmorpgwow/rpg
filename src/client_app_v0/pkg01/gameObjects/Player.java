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
import client_app_v0.pkg01.gameObjects.skills.Shield;
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
    private List<Abillity> skills = new LinkedList<Abillity>();
    private List<Buff> buffs = new LinkedList<Buff>();
    private List<Shield> shields = new LinkedList<Shield>();
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
    
    public void addBuff(Buff b){
        
        for(Buff buf : buffs){
            if(buf.equals(b)){
                buffs.remove(b);
            }            
        }        
        buffs.add(b);        
    }
    
    public void addShield(Shield sh){
        
        for(Shield s : shields){
            if(s.equals(sh)){
                shields.remove(sh);
            }            
        }        
        shields.add(sh);        
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
            skillsTick();
            buffsTick();
            shieldsTick();
            regenTick();
        }
    }
    
    private void skillsTick(){
        for(Abillity a: skills){
            a.tick();
        }
    }
    
    private void buffsTick(){
        for(int i = 0 ;i < buffs.size();i++){
            if(buffs.get(i).getTimeValue() < 1){
                buffs.remove(i);
                continue;
            } else { 
                buffs.get(i).tickCuldown();
            }
        }
    }
    
    private void shieldsTick(){
        for(int i = 0 ;i < shields.size();i++){
            if(shields.get(i).getTimeValue() < 1){
                shields.remove(i);
                continue;
            } else { 
                shields.get(i).tickCuldown();
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
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getStrength();
        }
        return getHeroStats().getStrength() + getArmorStats().getStrenght() + buffsVal;
    }

    public int getIntellegence() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getIntellegence();
        }
        return getHeroStats().getIntellegence() + getArmorStats().getIntellegence() + buffsVal;
    }

    public int getPhysicArmor() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getPhysicArmor();
        }
        return getHeroStats().getPhysicArmor() + getArmorStats().getPhysicArmor() + buffsVal;
    }

    public int getMagicResist() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getMagicResist();
        }
        return getHeroStats().getMagicResist() + getArmorStats().getMagicResist() + buffsVal;
    }

    public int getAttackPower() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getAttackPower();
        }
        return getHeroStats().getAttackPower() + getArmorStats().getAttackPower() + buffsVal;
    }

    public int getSpellPower() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getSpellPower();
        }
        return getHeroStats().getSpellPower() + getArmorStats().getSpellPower() + buffsVal;
    }

    public int getHealth() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getHealth();
        }
        return getHeroStats().getHealth() + getStrenght() + buffsVal;
    }

    public int getEnergy() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getEnergy();
        }
        return getHeroStats().getEnergy() + getIntellegence() + buffsVal;
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
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getHealthRegen();
        }
        return getHeroStats().getHealthRegen() + buffsVal;
    }

    public int getEnergyRegen() {
        int buffsVal = 0;
        for(int i = 0 ;i < this.buffs.size();i++){
            buffsVal += this.buffs.get(i).getStats().getEnergyRegen();
        }
        return getHeroStats().getEnergyRegen() + buffsVal;
    }
    
    public int getWidth() {
        return this.body.getWidth();
    }

    public int getHeight() {         
        return this.body.getHeight();
    }
}
