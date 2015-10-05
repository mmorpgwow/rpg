/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.renderFactory;

import client_app_v0.pkg01.battleGround.BattleGround;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Broff
 */
public class RenderBattleGround {

    private Player hero1;
    private Player hero2;

    private int xBG;
    private int yBG;

    int GRID_SIZE_X;
    int GRID_SIZE_Y;
    
    private char[][] grid;
    private char[][] hero1Grid;
    private char[][] hero2Grid;
    private char initChar = ' ';

    //=================================================
    public RenderBattleGround(BattleGround bg) {//Entity hero1, Entity hero2){
        xBG = bg.getXSize();
        yBG = bg.getYSize();        
        GRID_SIZE_X = 151;
        GRID_SIZE_Y = yBG + 33;
        if(xBG > 151){
            GRID_SIZE_X = xBG+3;
        }
        grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
        update();
    }

    public void update() {        
        initGrid(initChar);
                
        initBattleGround((int)(GRID_SIZE_X-xBG)/2);
        drawLine(yBG+2, 0, GRID_SIZE_X);
        initPlayers(yBG+3);
        drawLine(yBG+18, 0, GRID_SIZE_X);
        initBattleLog(yBG+19, 0);
        drawLine(yBG+25, 0, GRID_SIZE_X);
        initEffectsLog(yBG+26, 0);
        drawLine(yBG+32, 0, GRID_SIZE_X);
        drawVerticalLine(yBG+28, 75, 4);
        drawVerticalLine(yBG+2, 75, 16);
    }

    public void initGrid(char c) {
        for (int i = 0; i < GRID_SIZE_Y; i++) {
            for (int j = 0; j < GRID_SIZE_X; j++) {
                grid[i][j] = c;
            }
        }
    }

    private void initBattleGround(int x) {
        drawLine(0, x, xBG+1);
        drawLine(yBG+1, x, xBG+1);
        drawVerticalLine(1, x+xBG+1, yBG);
        drawVerticalLine(1, x, yBG);
        for (int i = 1; i <= yBG; i++) {
            for (int j = 1+x; j < xBG+x; j++) {
                grid[i][j] = '.';
            }
        }
    }

    private void initPlayers(int y) {
        RenderHeroInfo r1 = new RenderHeroInfo();
        hero1Grid = r1.getGrid();
        attachGrid(y, 0, hero1Grid);
        RenderHeroInfo r2 = new RenderHeroInfo();
        hero2Grid = r2.getGrid();
        attachGrid(y, 76, hero2Grid);
    }
    
    private void initBattleLog(int y, int x){
        initWord(y,(int)GRID_SIZE_X/2-8,"--=BATTLE LOG=--");
        drawLine(y+1, 0, GRID_SIZE_X);
        initWord(y+2,x,"Player1: Use skill awdaw Damage 100");
        initWord(y+3,x,"Player2: Use skill awdaw Damage 100");
        initWord(y+4,x,"Player1: Use skill awdaw Damage 100");
        initWord(y+5,x,"Player2: Use skill awdaw Damage 100");        
    }
    
    private void initEffectsLog(int y, int x){
        initWord(y,(int)GRID_SIZE_X/2-9,"--=EFFECTS LOG=--");
        drawLine(y+1, 0, GRID_SIZE_X);
        initWord(y+2,x,"Player1: Use skill awdaw Damage 100");
        initWord(y+3,x,"Player1: Use skill awdaw Damage 100");
        initWord(y+4,x,"Player1: Use skill awdaw Damage 100");
        initWord(y+5,x,"Player1: Use skill awdaw Damage 100");    
        initWord(y+2,x+76,"Player2: Use skill awdaw Damage 100");
        initWord(y+3,x+76,"Player2: Use skill awdaw Damage 100");
        initWord(y+4,x+76,"Player2: Use skill awdaw Damage 100");
        initWord(y+5,x+76,"Player2: Use skill awdaw Damage 100");
    }

    public void initWord(int y, int x,String str){
        for (int i = 0; i < str.length(); i++) {
            grid[y][x+i] = str.charAt(i);
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
    public void drawLine(int y, int x, float lineCount) {
        for (int i = 0; i < lineCount; i++) {
            grid[y][x + i] = '_';
        }
    }

    public void drawVerticalLine(int y, int x, float lineCount) {
        for (int i = 0; i < lineCount; i++) {
            grid[y + i][x] = '|';
        }
    }  
    
    private void attachGrid(int y, int x, char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.grid[y + i][x + j] = grid[i][j];
            }
        }
    }
}
