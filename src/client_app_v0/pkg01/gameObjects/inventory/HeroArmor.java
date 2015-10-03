/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory;

import client_app_v0.pkg01.gameObjects.inventory.items.Armor;
import client_app_v0.pkg01.gameObjects.inventory.items.ArmorType;
import client_app_v0.pkg01.gameObjects.inventory.items.Stats;
import client_app_v0.pkg01.gameObjects.inventory.items.Weapon;

/**
 *
 * @author Pablo
 */
public class HeroArmor {

    private Armor legs;
    private Armor hands;
    private Armor boots;
    private Armor chest;
    private Armor helm;
    private Armor belt;
    private Armor neck;
    private Armor ring;
    private Weapon rightHand;
    private Weapon leftHand;

    public HeroArmor() {

    }
    
    public Stats getHeroStats(){
        Stats s = new Stats(0,0,0,0,0,0);
        s = s.addStats(legs.getStats());
        s = s.addStats(hands.getStats());
        s = s.addStats(boots.getStats());
        s = s.addStats(chest.getStats());
        s = s.addStats(helm.getStats());
        s = s.addStats(belt.getStats());
        s = s.addStats(neck.getStats());
        s = s.addStats(ring.getStats());
        s = s.addStats(rightHand.getStats());
        s = s.addStats(leftHand.getStats());
        return s;
    }
    
    public Weapon takeOffLeftWeapon(){
        if(this.leftHand != null){
            Weapon w = this.leftHand;
            this.leftHand = null;
            return w;
        }
        return null;
    }
    
    public Weapon TakeOffWeapon(){
        if(this.leftHand != null){
            Weapon w = this.leftHand;
            this.leftHand = null;
            return w;
        }
        return null;
    }
    
    public Armor takeOffArmor(ArmorType type) {
        switch (type) {
            case LEGS:
                return getArmor(this.legs);
            case HANDS:
                return getArmor(this.hands);
            case BOOTS:
                return getArmor(this.boots);
            case CHEST:
                return getArmor(this.chest);
            case HELM:
                return getArmor(this.helm);
            case BELT:
                return getArmor(this.belt);
            case NECK:
                return getArmor(this.neck);
            case RING:
                return getArmor(this.ring);
            default:
                return null;
        }
    }
    
     public boolean putOnWeapon(Weapon weapon) {
        switch (weapon.getWeaponType()) {
            case SWORD:
                return takeRightHand(weapon);
            case SHIELD:
                return takeLeftHand(weapon);
            case STUFF:
                return takeRightHand(weapon);
            case BOW:
                return takeRightHand(weapon);         
            default:
                return false;
        }
    }
    
    public boolean putOnArmor(Armor armor) {
        switch (armor.getArmorType()) {
            case LEGS:
                return isEmpty(this.legs, armor);
            case HANDS:
                return isEmpty(this.hands, armor);
            case BOOTS:
                return isEmpty(this.boots, armor);
            case CHEST:
                return isEmpty(this.chest, armor);
            case HELM:
                return isEmpty(this.helm, armor);
            case BELT:
                return isEmpty(this.belt, armor);
            case NECK:
                return isEmpty(this.neck, armor);
            case RING:
                return isEmpty(this.ring, armor);           
            default:
                return false;
        }
    }

    private boolean isEmpty(Armor slot, Armor newslot) {
        if (slot == null) {
            slot = newslot;
            return true;
        } else {
            return false;
        }
    }

    private boolean takeRightHand(Weapon newslot) {
        if(this.rightHand == null){
            if(this.leftHand == null){            
                this.rightHand  = newslot;
                return true;
            } else {
                if(this.rightHand.twoHands()){
                    return false;
                } else {
                    this.rightHand  = newslot;
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean takeLeftHand(Weapon newslot) {
        if(this.leftHand == null){
            if(this.rightHand == null){            
                this.leftHand = newslot;
                return true;
            } else {
                if(this.rightHand.twoHands()){
                    return false;
                } else {
                    this.leftHand = newslot;
                    return true;
                }
            }
        }
        return false;
    }
    
    private Armor getArmor(Armor slot) {
        Armor arm = slot;
        slot = null;
        return arm;
    }    
}
