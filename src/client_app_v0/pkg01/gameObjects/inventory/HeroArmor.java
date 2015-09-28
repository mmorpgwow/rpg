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

    private Armor _legs;
    private Armor _hands;
    private Armor _boots;
    private Armor _chest;
    private Armor _helm;
    private Armor _belt;
    private Armor _neck;
    private Armor _ring;
    private Weapon _rightHand;
    private Weapon _leftHand;

    public HeroArmor() {

    }
    
    public Stats GetHeroStats(){
        Stats s = new Stats(0,0,0,0,0,0);
        s = s.addStats(_legs.GetStats());
        s = s.addStats(_hands.GetStats());
        s = s.addStats(_boots.GetStats());
        s = s.addStats(_chest.GetStats());
        s = s.addStats(_helm.GetStats());
        s = s.addStats(_belt.GetStats());
        s = s.addStats(_neck.GetStats());
        s = s.addStats(_ring.GetStats());
        s = s.addStats(_rightHand.GetStats());
        s = s.addStats(_leftHand.GetStats());
        return s;
    }
    
    public Weapon TakeOffLeftWeapon(){
        if(this._leftHand != null){
            Weapon w = this._leftHand;
            this._leftHand = null;
            return w;
        }
        return null;
    }
    
    public Weapon TakeOffWeapon(){
        if(this._leftHand != null){
            Weapon w = this._leftHand;
            this._leftHand = null;
            return w;
        }
        return null;
    }
    
    public Armor TakeOffArmor(ArmorType type) {
        switch (type) {
            case LEGS:
                return GetArmor(this._legs);
            case HANDS:
                return GetArmor(this._hands);
            case BOOTS:
                return GetArmor(this._boots);
            case CHEST:
                return GetArmor(this._chest);
            case HELM:
                return GetArmor(this._helm);
            case BELT:
                return GetArmor(this._belt);
            case NECK:
                return GetArmor(this._neck);
            case RING:
                return GetArmor(this._ring);
            default:
                return null;
        }
    }
    
     public boolean PutOnWeapon(Weapon weapon) {
        switch (weapon.GetWeaponType()) {
            case SWORD:
                return TakeRightHand(weapon);
            case SHIELD:
                return TakeLeftHand(weapon);
            case STUFF:
                return TakeRightHand(weapon);
            case BOW:
                return TakeRightHand(weapon);         
            default:
                return false;
        }
    }
    
    public boolean PutOnArmor(Armor armor) {
        switch (armor.GetArmorType()) {
            case LEGS:
                return IsEmpty(this._legs, armor);
            case HANDS:
                return IsEmpty(this._hands, armor);
            case BOOTS:
                return IsEmpty(this._boots, armor);
            case CHEST:
                return IsEmpty(this._chest, armor);
            case HELM:
                return IsEmpty(this._helm, armor);
            case BELT:
                return IsEmpty(this._belt, armor);
            case NECK:
                return IsEmpty(this._neck, armor);
            case RING:
                return IsEmpty(this._ring, armor);           
            default:
                return false;
        }
    }

    private boolean IsEmpty(Armor slot, Armor newslot) {
        if (slot == null) {
            slot = newslot;
            return true;
        } else {
            return false;
        }
    }

    private boolean TakeRightHand(Weapon newslot) {
        if(this._rightHand == null){
            if(this._leftHand == null){            
                this._rightHand  = newslot;
                return true;
            } else {
                if(this._rightHand.TwoHands()){
                    return false;
                } else {
                    this._rightHand  = newslot;
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean TakeLeftHand(Weapon newslot) {
        if(this._leftHand == null){
            if(this._rightHand == null){            
                this._leftHand = newslot;
                return true;
            } else {
                if(this._rightHand.TwoHands()){
                    return false;
                } else {
                    this._leftHand = newslot;
                    return true;
                }
            }
        }
        return false;
    }
    
    private Armor GetArmor(Armor slot) {
        Armor arm = slot;
        slot = null;
        return arm;
    }    
}
