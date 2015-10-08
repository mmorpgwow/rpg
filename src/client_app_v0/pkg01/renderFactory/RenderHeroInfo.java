/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.renderFactory;

import client_app_v0.pkg01.gameObjects.EntityType;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.classes.Hero;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;

/**
 *
 * @author Broff
 */
public class RenderHeroInfo {

    static final int GRID_SIZE_X = 80;
    static final int GRID_SIZE_Y = 15;
    //==========================================
    float healthBarCount = 15;
    float energyBarCount = 15;
    float experienceBarCount = GRID_SIZE_X-3;
    float line = GRID_SIZE_X;
    private char initChar = ' ';

    private char[][] grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
    
    //==========================================

    {
        initGrid(initChar);
    }
    
    public RenderHeroInfo(Player p) {
        if(p.type == EntityType.PLAYER){            
            initWord(0,38,"CLASS HERO - " + p.getClassName() +"(" + p.getLevel() + ") "+p.getNickName());
            drawLine(1,0,line);
            initHealth(2,0,p.getActualHealth(), p.getHealth());        
            initEnergy(2,40,p.getActualEnergy(), p.getEnergy());
            drawLine(3,0,line);
            initExperience(4,0,p.getExp(), p.getLevelExp());
            initWord(6, 0,"STRENGTH:        |" + p.getStrenght());
            initWord(7, 0,"intellegence:    |" + p.getIntellegence());
            initWord(8, 0,"physicArmor:     |" + p.getPhysicArmor());
            initWord(9,0,"magicResist:     |" + p.getMagicResist());
            initWord(6,30,"attackPower:     |" + p.getAttackPower());
            initWord(7,30,"spellPower:      |" + p.getSpellPower());
            initWord(8,30,"healthRegen:     |" + p.getHealthRegen());
            initWord(9,30,"energyRegen:     |" + p.getEnergyRegen());  
        }        
    }
    
    public char[][] getGrid(){
        return grid;
    }
    
    public RenderHeroInfo() {  
        initWord(0,38,"CLASS HERO - " + "MAG(" + 5 + ")");
        drawLine(1,0,line);
        initHealth(2,0,50, 100);        
        initEnergy(2,35,200, 300);
        drawLine(3,0,line);
        initExperience(4,0,700, 1570);
        initWord(6, 0,"STRENGTH:        |" + 7);
        initWord(7, 0,"intellegence:    |" + 10);
        initWord(8, 0,"physicArmor:     |" + 34);
        initWord(9,0,"magicResist:     |" + 23);
        initWord(6,30,"attackPower:     |" + 23);
        initWord(7,30,"spellPower:      |" + 234);
        initWord(8,30,"healthRegen:     |" + 2);
        initWord(9,30,"energyRegen:     |" + 50);
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

    public void drawLine(int y, int x,float lineCount) {
        for (int i = 0; i < lineCount; i++) {
            grid[y][x+i] = '_';
        }
    }

    public void initHealth(int y, int x,int actualHp, int maxHp) {
        int startX = x;
        float Hp = healthBarCount * actualHp / maxHp;
        int actHP = (int) Hp;
        grid[y][x] = '|';
        x++;
        for (int i = 0; i < healthBarCount; i++) {            
            if (i < actHP) {
                grid[y][x] = 'X';
            } else {
                grid[y][x] = '.';
            }
            x++;
        }
        grid[y][x] = '|';
        x+=2;
        String str = " HEALTH (" + actualHp + "/" + maxHp + ")";
        initWord(y,x,str);
    }    

    public void initEnergy(int y, int x,int actualEnergy, int maxEnergy) {
        int startX = x;
        float Hp = energyBarCount * actualEnergy / maxEnergy;
        int actHP = (int) Hp;
        grid[y][x] = '|';
        x++;
        for (int i = 0; i < energyBarCount; i++) {            
            if (i < actHP) {
                grid[y][x] = 'X';
            } else {
                grid[y][x] = '.';
            }
            x++;
        }
        grid[y][x] = '|';
        x+=2;
        String str = " ENERGY (" + actualEnergy + "/" + maxEnergy + ")";
        initWord(y,x,str);
    }
    
    public void initExperience(int y, int x,int actualExperience, int maxExperience) {
        int startX = x;
        float Hp = experienceBarCount * actualExperience / maxExperience;
        int actHP = (int) Hp;
        grid[y][x] = '|';
        x++;
        for (int i = 0; i < experienceBarCount; i++) {            
            if (i < actHP) {
                grid[y][x] = 'X';
            } else {
                grid[y][x] = '.';
            }
            x++;
        }
        grid[y][x] = '|';        
        y++;
        String str = " EXPIRIENCE (" + actualExperience + "/" + maxExperience + ")";
        x =startX + (int)(experienceBarCount-str.length()) / 2;
        initWord(y,x,str);
    }

    public void initWord(int y, int x,String str){
        for (int i = 0; i < str.length(); i++) {
            grid[y][x+i] = str.charAt(i);
        }
    }    
}
