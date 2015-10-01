/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ChangeableStats;

/**
 *
 * @author qw
 */
public class Buff{

    private int _time;
    private int _timeGain;
    private ChangeableStats _stats;
    private Skill _skill;
    
    public Buff(Skill skill, int time, int timeGain) {
        _time = time;
        _timeGain = timeGain;
        _skill = skill;
    }
    
    public int GetTime(){
        return _time;
    }
    public ChangeableStats GetStats(){
        return _stats;
    }

    public void LvlUp() {
        _time+=_timeGain;
        _stats.LvlUp();
        _skill.LvlUp();
    }
}
