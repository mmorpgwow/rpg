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
public class Buff implements Abillity{

    private int time;
    private int timeGain;
    private ChangeableStats stats;
    private Skill skill;
    
    public Buff(Skill skill, ChangeableStats stats, int time, int timeGain) {
        this.time = time;
        this.timeGain = timeGain;
        this.skill = skill;
        this.stats = stats;
    }
    
    public int getTime(){
        return time;
    }
    public ChangeableStats getStats(){
        return stats;
    }

    @Override
    public void lvlUp() {
        time+=timeGain;
        stats.lvlUp();
        skill.lvlUp();
    }
}
