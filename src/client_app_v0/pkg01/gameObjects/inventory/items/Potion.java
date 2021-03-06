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

    public final ItemType itemType = ItemType.POTION;
    public final int maxCount = 10;
    //================================================
    private int resHealth;
    private int resEnergy;
    private int count;
    private PotionType type;
    //================================================
    public Potion(int id, String name,int buyCost, int sellCost, int resHealth, int resEnergy, int count) {
        super(id, name, buyCost, sellCost);
        this.resHealth = resHealth;
        this.resEnergy = resEnergy;
        this.count = count;
        this.type = type;
    }
    
    public PotionType getType(){
        return type;
    }
    
    public int getCount(){
        return count;
    }
    
    public int add(int i){
        if(i + count <= maxCount){
            return 0;
        } else {
            return i + count - maxCount;
        }
    }
    
    public Potion getPotion(){
        if(count == 0){
            return null;   
        } else {
            count--;
            return new Potion(id,name, buyCost, sellCost, resHealth, resEnergy, 1);
        }
    }
    
    public int getResHealth(){        
        return this.resHealth;
    }
    
    public int getResEnergy(){        
        return this.resEnergy;
    }
    
    @Override
    public ItemType getItemType(){
        return itemType;
    }
}
