/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.renderFactory;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.physicBody.Entity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Broff
 */
public class RenderBattleGround {

    static final int GRID_SIZE_X = 151;
    static final int GRID_SIZE_Y = 47;
    //=================================================
    private Player hero1;
    private Player hero2;

    private int xBG = 151;
    private int yBG = 15;

    private char[][] grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
    private char[][] hero1Grid;
    private char[][] hero2Grid;
    private char initChar = ' ';

    //=================================================
    public RenderBattleGround() {//Entity hero1, Entity hero2){
        update();
    }

    public void update() {        
        initGrid(initChar);
        
        initBattleGround();
        drawLine(yBG, 0, GRID_SIZE_X);
        initPlayers(yBG+1);
        drawLine(yBG+16, 0, GRID_SIZE_X);
        drawVerticalLine(16, 75, 16);
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

    private void initBattleGround() {
        for (int i = 0; i < yBG; i++) {
            for (int j = 0; j < xBG; j++) {
                if (i == 0 || i == yBG - 1) {
                    grid[i][j] = '-';
                } else if (j == 0 || j == xBG - 1) {
                    grid[i][j] = '|';
                }
            }
        }
    }

    private void initPlayers(int y) {
        RenderHeroInfo r1 = new RenderHeroInfo();
        hero1Grid = r1.getGrid();
        attachGrid(y, 0, hero1Grid);
        RenderHeroInfo r2 = new RenderHeroInfo();
        hero2Grid = r2.getGrid();
        attachGrid(y, 76, hero1Grid);
    }

    private void attachGrid(int y, int x, char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.grid[y + i][x + j] = grid[i][j];
            }
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
}
