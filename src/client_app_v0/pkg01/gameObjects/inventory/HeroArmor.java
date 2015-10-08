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
    
    public Stats getArmorStats(){
        Stats s = new Stats(0,0,0,0,0,0);
        s = s.addStats(legs!=null?legs.getStats():null);
        s = s.addStats(hands!=null?hands.getStats():null);
        s = s.addStats(boots!=null?boots.getStats():null);
        s = s.addStats(chest!=null?chest.getStats():null);
        s = s.addStats(helm!=null?helm.getStats():null);
        s = s.addStats(belt!=null?belt.getStats():null);
        s = s.addStats(neck!=null?neck.getStats():null);
        s = s.addStats(ring!=null?ring.getStats():null);
        s = s.addStats(rightHand!=null?rightHand.getStats():null);
        s = s.addStats(leftHand!=null?leftHand.getStats():null);
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
                if(isEmpty(this.legs, armor)){
                    this.legs = armor;
                    return true;
                } else {
                    return false;
                }
            case HANDS:
                if(isEmpty(this.hands, armor)){
                    this.hands = armor;
                    return true;
                } else {
                    return false;
                }
            case BOOTS:
                if(isEmpty(this.boots, armor)){
                    this.boots = armor;
                    return true;
                } else {
                    return false;
                }
            case CHEST:
                if(isEmpty(this.chest, armor)){
                    this.chest = armor;
                    return true;
                } else {
                    return false;
                }
            case HELM:
                if(isEmpty(this.helm, armor)){
                    this.helm = armor;
                    return true;
                } else {
                    return false;
                }
            case BELT:
                if(isEmpty(this.belt, armor)){
                    this.belt = armor;
                    return true;
                } else {
                    return false;
                }
            case NECK:
                if(isEmpty(this.neck, armor)){
                    this.neck = armor;
                    return true;
                } else {
                    return false;
                }
            case RING:
                if(isEmpty(this.ring, armor)){
                    this.ring = armor;
                    return true;
                } else {
                    return false;
                }           
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
