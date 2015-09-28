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
public abstract class Item {
    
    private int _id;
    private String _name;
    
    public Item(int id, String name){
        _id = id;
        _name = name;
    }
    
    public int GetId(){
        return _id;
    }
    public String GetName(){
        return _name;
    }
}
