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
    private int _lvl;
    private int _startExp;
    private int _exp;
    private ChangeableStats _stat;
    
    public Hero(int startExp, int exp, ChangeableStats stats){        
        _startExp = startExp;
        _stat = stats;
        _lvl = 1;
        _exp = 0;
        AddExp(exp);    
        _stat.initLevel(_lvl);
    }
    
    public final int GetLevel(){
        return _lvl;
    }
    
    public final int GetExp(){
        return _exp;
    }
    
    public final ChangeableStats GetStat(){
        return _stat;
    }
    
    public final void AddExp(int exp){
        int lvlExp = GetLvlExp(_lvl);
        int summExp = _exp + exp;
        if(summExp < lvlExp){
            _exp += exp;
        } else {
            LvlUp();            
            _exp = 0;
            AddExp(summExp  - lvlExp);
        }
    }
    
    private final void LvlUp(){
        _lvl++;
        _stat.initLevel(_lvl);
    }
    
    public int GetLvlExp(int lvl){
        int exp = _startExp;
        for(int i = 1; i < _lvl;i++ ){
            exp =  exp + exp * 1/3;
        }
        return exp;
    }
}
