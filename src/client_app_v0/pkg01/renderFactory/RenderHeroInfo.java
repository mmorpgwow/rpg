/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.renderFactory;

import client_app_v0.pkg01.gameObjects.classes.Hero;

/**
 *
 * @author Broff
 */
public class RenderHeroInfo {

    static final int GRID_SIZE_X = 100;
    static final int GRID_SIZE_Y = 20;
    //==========================================
    float healthBarCount = 15;
    float energyBarCount = 15;
    float line = 60;

    char[][] grid = new char[GRID_SIZE_Y][GRID_SIZE_X];

    //==========================================

    public RenderHeroInfo(Hero hero) {
        initGrid(' ');
    }

    public RenderHeroInfo() {        
        initGrid(' ');
        initWord(0,38,"CLASS HERO - " + "MAG(" + 5 + ")");
        initWord(1,40,"(-_-(-_-)-_-)");
        grawLine(2,0,line);
        initHealth(3,0,50, 100);        
        initEnergy(3,40,200, 300);
        grawLine(4,0,line);
        initWord(5, 0,"strength:        |" + 7);
        initWord(6, 0,"intellegence:    |" + 10);
        initWord(7, 0,"physicArmor:     |" + 34);
        initWord(8, 0,"magicResist:     |" + 23);
        initWord(9, 0,"attackPower:     |" + 23);
        initWord(10,0,"spellPower:      |" + 234);
        initWord(11,0,"healthRegen:     |" + 2);
        initWord(12,0,"energyRegen:     |" + 50);
        
        
    }

    public void initGrid(char c) {
        for (int i = 0; i < GRID_SIZE_Y; i++) {
            for (int j = 0; j < GRID_SIZE_X; j++) {
                grid[i][j] = c;
            }
        }
    }

    public void show() {
        for (int i = 0; i < GRID_SIZE_Y; i++) {
            for (int j = 0; j < GRID_SIZE_X; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public void grawLine(int y, int x,float lineCount) {
        for (int i = 0; i < lineCount; i++) {
            grid[y][x+i] = '─';
        }
    }

    public void initHealth(int y, int x,int actualHp, int maxHp) {
        int startX = x;
        float Hp = healthBarCount * actualHp / maxHp;
        int actHP = (int) Hp;
        grid[y][x] = '►';
        x++;
        for (int i = 0; i < healthBarCount; i++) {            
            if (i < actHP) {
                grid[y][x] = '█';
            } else {
                grid[y][x] = '▒';
            }
            x++;
        }
        grid[y][x] = '◄';
        x+=2;
        String str = " HEALTH (" + actualHp + "/" + maxHp + ")";
        initWord(y,x,str);
    }    

    public void initEnergy(int y, int x,int actualEnergy, int maxEnergy) {
        int startX = x;
        float Hp = energyBarCount * actualEnergy / maxEnergy;
        int actHP = (int) Hp;
        grid[y][x] = '►';
        x++;
        for (int i = 0; i < energyBarCount; i++) {            
            if (i < actHP) {
                grid[y][x] = '█';
            } else {
                grid[y][x] = '▒';
            }
            x++;
        }
        grid[y][x] = '◄';
        x+=2;
        String str = " ENERGY (" + actualEnergy + "/" + maxEnergy + ")";
        initWord(y,x,str);
    }

    public void initWord(int y, int x,String str){
        for (int i = 0; i < str.length(); i++) {
            grid[y][x+i] = str.charAt(i);
        }
    }    
    
    public void initStats() {

    }
}
