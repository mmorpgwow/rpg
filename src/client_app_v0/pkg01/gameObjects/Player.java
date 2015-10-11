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
import client_app_v0.pkg01.gameObjects.skills.SkillEntityType;
import client_app_v0.pkg01.gameObjects.skills.SkillType;
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
    private List<Abillity> effects = new LinkedList<Abillity>();
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

    public void addBuff(Buff b) {
        for (Abillity buf : effects) {
            if (buf.getSkillType() == SkillType.BUFF) {
                if (((Buff) buf).getId() == b.getId()) {
                    effects.remove(b);
                }
            }
        }
        effects.add(b);
    }

    public void addShield(Shield sh) {
        for (Abillity buf : effects) {
            if (buf.getSkillType() == SkillType.SHIELD) {
                if (((Buff) buf).getId() == sh.getId()) {
                    effects.remove(sh);
                }
            }
        }
        effects.add(sh);
    }

    public ClassType getClassHero() {
        return classHero.getHeroClass();
    }

    public String getNickName() {
        return this.nick;
    }

    public List<Abillity> getEffects() {
        return this.effects;
    }

    public List<Buff> getBuffs() {
        List<Buff> buffs = new LinkedList<Buff>();
        for (int i = 0; i < effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffs.add((Buff) effects.get(i));
            }
        }
        return buffs;
    }

    public List<Shield> getShields() {
        List<Shield> shields = new LinkedList<Shield>();
        for (int i = 0; i < effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.SHIELD) {
                shields.add((Shield) effects.get(i));
            }
        }
        return shields;
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

    public void tick() {
        if (lifeState) {
            skillsTick();
            effectsTick();
            regenTick();
        }
    }

    private void skillsTick() {
        for (Abillity a : skills) {
            a.tick();
        }
    }

    private void effectsTick() {
        for (int i = 0; i < effects.size(); i++) {
            switch (effects.get(i).getSkillType()) {
                case BUFF:
                    if (((Buff) effects.get(i)).getTimeValue() < 1) {
                        effects.remove(i);
                    } else {
                        ((Buff) effects.get(i)).tickCuldown();
                    }
                    break;
                case SHIELD:
                    if (((Shield) effects.get(i)).getTimeValue() < 1 || ((Shield) effects.get(i)).getDamage() == 0) {
                        effects.remove(i);
                    } else {
                        ((Shield) effects.get(i)).tickCuldown();
                    }
                    break;
            }
        }
    }

    private void regenTick() {
        if (health + getHealthRegen() > getHealth()) {
            health = getHealth();
        } else {
            health += getHealthRegen();
        }
        if (energy + getEnergyRegen() > getEnergy()) {
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
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getStrength();
            }
        }
        return getHeroStats().getStrength() + getArmorStats().getStrenght() + buffsVal;
    }

    public int getIntellegence() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getIntellegence();
            }
        }
        return getHeroStats().getIntellegence() + getArmorStats().getIntellegence() + buffsVal;
    }

    public int getPhysicArmor() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getPhysicArmor();
            }
        }
        return getHeroStats().getPhysicArmor() + getArmorStats().getPhysicArmor() + buffsVal;
    }

    public int getMagicResist() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getMagicResist();
            }
        }
        return getHeroStats().getMagicResist() + getArmorStats().getMagicResist() + buffsVal;
    }

    public int getAttackPower() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getAttackPower();
            }
        }
        return getHeroStats().getAttackPower() + getArmorStats().getAttackPower() + buffsVal;
    }

    public int getSpellPower() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getSpellPower();
            }
        }
        return getHeroStats().getSpellPower() + getArmorStats().getSpellPower() + buffsVal;
    }

    public int getHealth() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getHealth();
            }
        }
        return getHeroStats().getHealth() + getStrenght() + buffsVal;
    }

    public int getEnergy() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getEnergy();
            }
        }
        return getHeroStats().getEnergy() + getIntellegence() + buffsVal;
    }

    public int getActualHealth() {
        return this.health;
    }

    public int getActualEnergy() {
        return this.energy;
    }

    public void takeDamage(int dlt, SkillEntityType st) {
        List<Shield> shields = getShields();
        int damage = dlt;
        for (Shield s : shields) {
            if (s.getSkillEntityType() == st) {
                int d = damage;
                damage -= s.getDamage();
                s.takeDamage(d);
                if (damage <= 0) {
                    damage = 0;
                    break;
                }
            }
        }
        setActualHealth(-damage);
    }

    public void setActualHealth(int dlt) {
        if (this.health + dlt > getHealth()) {
            this.health = getHealth();
        } else if (this.health + dlt <= 0) {
            this.health = 0;
            setLifeState();
        } else {
            this.health += dlt;
        }

    }

    public void setLifeState() {
        this.lifeState = !this.lifeState;
    }

    public boolean getLifeState() {
        return this.lifeState;
    }

    public boolean setActualEnergy(int dlt) {
        if (this.energy + dlt > getHealth()) {
            this.energy = getHealth();
            return true;
        } else if (this.energy + dlt < 0) {
            this.energy = 0;
            return false;
        } else {
            this.energy += dlt;
            return true;
        }
    }

    public int getHealthRegen() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getHealthRegen();
            }
        }
        return getHeroStats().getHealthRegen() + buffsVal;
    }

    public int getEnergyRegen() {
        int buffsVal = 0;
        for (int i = 0; i < this.effects.size(); i++) {
            if (effects.get(i).getSkillType() == SkillType.BUFF) {
                buffsVal += ((Buff) effects.get(i)).getStats().getEnergyRegen();
            }
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
