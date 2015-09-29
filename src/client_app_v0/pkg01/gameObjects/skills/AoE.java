/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ClassType;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class AoE extends Skill{

    private int _damage;
    private int _xPos;
    private int _yPos;
    private int _area;
    private int _delay; 
    private List<Buff> _buffs;
    
    public AoE(int lvlcost, int cost, int cooldown, ClassType classType, 
            int id, String name, int range, int castTime, int damage, 
            int xPos, int yPos, int area, int delay, List<Buff> buffs) {
        super(lvlcost, cost, cooldown, classType, id, name, range, castTime);
        _damage = damage;
        _area = area;
        _delay = delay;
        _buffs = buffs;
    }
    
    public void SetPos(int xPos, int yPos){
        _xPos = xPos;
        _yPos = yPos;
    }
    
    public int GetDamage(){
        return _damage;
    }
    public int GetXPos(){
        return _xPos;
    }
    public int GetYPos(){
        return _yPos;
    }
    public int GetArea(){
        return _area;
    }
    public int GetDelay(){
        return _delay;
    }
    public List<Buff> GetBuffs(){
        return _buffs;
    }
}
