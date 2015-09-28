/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory.items;

/**
 *
 * @author Pablo
 */
public class Potion extends Item {

    public final ItemType _itemType = ItemType.POTION;
    public final int maxCount = 10;
    //================================================
    private int _resHealth;
    private int _resEnergy;
    private int _count;
    private PotionType _type;
    //================================================
    public Potion(int id, String name,int buyCost, int sellCost, int resHealth, int resEnergy, PotionType type, int count) {
        super(id, name, buyCost, sellCost);
        _resHealth = resHealth;
        _resEnergy = resEnergy;
        _count = count;
        _type = type;
    }
    
    public PotionType GetType(){
        return _type;
    }
    
    public int GetCount(){
        return _count;
    }
    
    public int Add(int i){
        if(i + _count <= maxCount){
            return 0;
        } else {
            return i + _count - maxCount;
        }
    }
    ////WARNING NEED FINISH METHOD/////
    public Potion GetPotions(int i){
        return null;        
    }
    
    public int DrinkPotion(){
        _count--;
        if(_type == PotionType.ENERGY){
            return _resEnergy;
        } else {
            return _resHealth;
        } 
    }
    
    public int[] GetRestoratedValue(){
        _count--;
        int[] Arr = {_resHealth,_resEnergy};
        return Arr;
    }
}
