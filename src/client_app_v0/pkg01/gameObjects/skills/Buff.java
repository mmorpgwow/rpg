/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;
import client_app_v0.pkg01.gameObjects.classes.ClassType;

/**
 *
 * @author qw
 */
public class Buff extends Skill{

    private int _time;
    private ChangeableStats _stats;
    
    public Buff(int lvlcost, int cost, int cooldown, 
            ClassType classType, int id, String name, int range, int time,
            int castTime) {
        super(lvlcost, cost, cooldown, classType, id, name, range, castTime);
        _time = time;
    }
    
    public int GetTime(){
        return _time;
    }
    public ChangeableStats GetStats(){
        return _stats;
    }
}
