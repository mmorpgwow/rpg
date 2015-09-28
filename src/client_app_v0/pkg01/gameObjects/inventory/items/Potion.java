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

    private int _resHealth;
    private int _resEnergy;
    private PotionType _type;

    public Potion(int id, String name, int resHealth, int resEnergy, PotionType type) {
        super(id, name);
        _resHealth = resHealth;
        _resEnergy = resEnergy;
        _type = type;
    }
    
    public PotionType GetType(){
        return _type;
    }
    
    public int DrinkPotion(){
        return _resHealth;
    }
    public int[] GetRestoratedValue(){
        int[] Arr = {_resHealth,_resEnergy};
        return Arr;
    }
}
