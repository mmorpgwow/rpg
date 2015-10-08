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
    public ClassType heroClass;
    protected int lvl;
    protected int startExp;
    protected int exp;
    protected ChangeableStats stat;  
    
    public Hero(int startExp, ChangeableStats stats){        
        this.startExp = startExp;
        this.stat = stats;
        lvl = 1;
        exp = 0;    
        stat.initLevel(lvl);   
    }
    
    public ClassType getHeroClass(){
        return heroClass;
    }
    
    public int getLevel(){
        return lvl;
    }
    
    public int getExp(){
        return this.exp;
    }
    
    public ChangeableStats getStat(){
        return stat;
    }
    
    public void addExp(int Exp){
        int lvlExp = getLvlExp();
        if(Exp < lvlExp){
            this.exp += Exp;
        } else {
            lvlUp();            
            this.exp = 0;
            addExp(Exp  - lvlExp);
        }
    }
    
    private void lvlUp(){
        lvl++;
        stat.initLevel(lvl);
    }
    
    public int getLvlExp(){
        if(startExp <= 0){
            startExp = 10;
        }
        int Exp = startExp;
        for(int i = 1; i < lvl;i++ ){
            Exp =Exp* 4/3;
        }
        return Exp;
    }
}
