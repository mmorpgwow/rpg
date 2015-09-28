/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory;

import client_app_v0.pkg01.gameObjects.inventory.items.Armor;
import client_app_v0.pkg01.gameObjects.inventory.items.ArmorType;

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
    private Armor _rightHand;
    private Armor _leftHand;

    public HeroArmor() {

    }

    public boolean IsEmpty(Armor slot,Armor newslot){ 
            if (slot==null) {
                    slot = newslot;
                    return true;
                }
                else{
                    return false;
                }
    }
    public boolean IsEmpty(Armor slot1,Armor slot2,Armor newslot){ 
            if (slot1==null & slot2 == null) {
                    slot1 = newslot;
                    return true;
                }
                else{
                    return false;
                }
    }
    
    public boolean PutOn(Armor armor) {
        switch (armor.GetArmorType()) {
            case LEGS:
                return IsEmpty(this._legs,armor);
            case HANDS:
                return IsEmpty(this._hands,armor);
            case BOOTS:
                return IsEmpty(this._boots,armor);
            case CHEST:
                return IsEmpty(this._chest,armor);
            case HELM:
                return IsEmpty(this._helm,armor);
            case BELT:
                return IsEmpty(this._belt,armor);
            case NECK:
                return IsEmpty(this._neck,armor);
            case RING:
                return IsEmpty(this._ring,armor);
            case ONE_HAND_SWORD:
                return IsEmpty(this._rightHand,armor);
            case SHIELD:
                return IsEmpty(this._leftHand,armor);
            case TWO_HAND_SWORD:
                return IsEmpty(this._rightHand, this._leftHand,armor);
            case STUFF:
                return IsEmpty(this._rightHand, this._leftHand,armor);
            case BOW:
                return IsEmpty(this._rightHand, this._leftHand,armor);
            default:
                return false;
        }
    }
    
    public Armor GetArmor(Armor slot){
        Armor arm = slot;
        slot = null;
        return arm;
    }
    public Armor GetArmor(Armor slot1,Armor slot2){
        Armor arm = slot1;
        slot1 = null;
        slot2 = null;
        return arm;
    }
    
    public Armor TakeOff(ArmorType type){
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
            case ONE_HAND_SWORD:
                return GetArmor(this._rightHand);
            case SHIELD:
                return GetArmor(this._leftHand);
            case TWO_HAND_SWORD:
                return GetArmor(this._rightHand, this._leftHand);
            case STUFF:
                return GetArmor(this._rightHand, this._leftHand);
            case BOW:
                return GetArmor(this._rightHand, this._leftHand);
            default:
                return null;
        }
    }
}
