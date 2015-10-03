/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.classes;

/**
 *
 * @author Broff
 */
public abstract class Hero {
    private int lvl;
    private int startExp;
    private int exp;
    private ChangeableStats stat;
    
    public Hero(int startExp, int exp, ChangeableStats stats){        
        this.startExp = startExp;
        this.stat = stats;
        lvl = 1;
        exp = 0;
        addExp(exp);    
        stat.initLevel(lvl);
    }
    
    public final int getLevel(){
        return lvl;
    }
    
    public final int getExp(){
        return exp;
    }
    
    public final ChangeableStats getStat(){
        return stat;
    }
    
    public final void addExp(int exp){
        int lvlExp = getLvlExp(lvl);
        int summExp = exp + exp;
        if(summExp < lvlExp){
            exp += exp;
        } else {
            lvlUp();            
            exp = 0;
            addExp(summExp  - lvlExp);
        }
    }
    
    private final void lvlUp(){
        lvl++;
        stat.initLevel(lvl);
    }
    
    public int getLvlExp(int lvl){
        int exp = startExp;
        for(int i = 1; i < lvl;i++ ){
            exp =  exp + exp * 1/3;
        }
        return exp;
    }
}
