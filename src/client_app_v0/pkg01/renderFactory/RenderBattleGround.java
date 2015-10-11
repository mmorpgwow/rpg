/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.renderFactory;
import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.inventory.items.Potion;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.Buff;
import client_app_v0.pkg01.gameObjects.skills.Shield;
import client_app_v0.pkg01.gameObjects.skills.Skill;
import client_app_v0.pkg01.gameObjects.skills.SkillType;
import java.io.PrintStream;
import java.util.List;
import sun.awt.image.ImageWatched.Link;

/**
 *
 * @author Broff
 */
public class RenderBattleGround {

    private Player hero1;
    private Player hero2;

    private List<String> battleLog;
            
    private int xBG;
    private int yBG;

    int GRID_SIZE_X;
    int GRID_SIZE_Y;
    
    private char[][] grid;
    private char[][] hero1Grid;
    private char[][] hero2Grid;
    private final char initChar = ' ';
    PrintStream stream;

    //=================================================
    public RenderBattleGround(List<Player> players, List<String> battleLog,int width,int height){
               
        this.battleLog = battleLog;
        hero1 = players.get(0);
        hero2 = players.get(1);
        
        xBG = width;
        yBG = height;        
        GRID_SIZE_X = RenderHeroInfo.GRID_SIZE_X * 2+50;
        GRID_SIZE_Y = yBG + 23;
        if(xBG > 151){
            GRID_SIZE_X = xBG+3;
        }
        grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
    }

    public void update(String activePlayer, int roundTime) {            
        initGrid(initChar);
                
        initBattleGround((int)(RenderHeroInfo.GRID_SIZE_X * 2-xBG)/2);
        drawLine(yBG+2, 0, RenderHeroInfo.GRID_SIZE_X * 2);
        initPlayers(yBG+3);
        drawLine(yBG+12, 0, RenderHeroInfo.GRID_SIZE_X * 2);
        initBattleLog(yBG+13, 0);
        initEffectsLog(yBG+18, 0);
        drawVerticalLine(yBG+19, (int)RenderHeroInfo.GRID_SIZE_X * 2/2-1, 4);
        drawVerticalLine(yBG+3, (int)RenderHeroInfo.GRID_SIZE_X * 2/2-1, 10);
        initRules(yBG+2, RenderHeroInfo.GRID_SIZE_X * 2+1,activePlayer, roundTime);
    }

    private void initRules(int y, int x, String actP, int roundTime){        
        initWord(y-2,x,"Time remaining "+roundTime);
        initWord(y-1,x,"Now active player - "+actP);
        initWord(y,x,"s - Use skill");
        initWord(y+1,x,"m - Move");
        initWord(y+2,x,"i - Use item");
        initWord(y+3,x,"c - End step");        
        initWord(y+4,x,"Move settings");
        initWord(y+5,x,"812");        
        initWord(y+6,x,"7 3");        
        initWord(y+7,x,"654");        
    }
    
    public void initGrid(char c) {
        for (int i = 0; i < GRID_SIZE_Y; i++) {
            for (int j = 0; j < GRID_SIZE_X; j++) {
                grid[i][j] = c;
            }
        }
    }

    private void initBattleGround(int x) {
        char player1Symbol = 'X';
        char player2Symbol = 'O';
        drawLine(0, x, xBG+1);
        drawLine(yBG+1, x, xBG+1);
        drawVerticalLine(1, x+xBG+1, yBG);
        drawVerticalLine(1, x, yBG);
        for (int i = 1; i <= yBG; i++) {
            for (int j = 1+x; j < xBG+x; j++) {
                grid[i][j] = '.';
            }
        }
        
        char[][] p1 = new char[hero1.getHeight()][hero1.getWidth()];
        char[][] p2 = new char[hero2.getHeight()][hero2.getWidth()];
        
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                p1[i][j] = player1Symbol;
            }
        }
        for (int i = 0; i < p2.length; i++) {
            for (int j = 0; j < p2[0].length; j++) {
                p2[i][j] = player2Symbol;
            }
        }
        attachGrid(hero1.getY(), hero1.getX() + x, p1);
        attachGrid(hero2.getY(), hero2.getX() + x, p2);        
    }

    private void initPlayers(int y) {
        RenderHeroInfo r1 = new RenderHeroInfo(hero1);
        hero1Grid = r1.getGrid();
        attachGrid(y, 0, hero1Grid);
        RenderHeroInfo r2 = new RenderHeroInfo(hero2);
        hero2Grid = r2.getGrid();
        attachGrid(y, RenderHeroInfo.GRID_SIZE_X, hero2Grid);
    }
    
    private void initBattleLog(int y, int x){
        initWord(y,RenderHeroInfo.GRID_SIZE_X-8,"--=BATTLE LOG=--");
        for(int i = 0; i < this.battleLog.size(); i++){
            initWord(y+1+i,x, this.battleLog.get(i));  
        }           
    }
    
    private void initEffectsLog(int y, int x){
        int dlt = (int)GRID_SIZE_X/2;
        initWord(y,RenderHeroInfo.GRID_SIZE_X-8,"--=EFFECTS LOG=--");
        int i = 0;
        for(Abillity b :hero1.getEffects() ){
            if (b.getSkillType() == SkillType.BUFF) {
                initWord(y+1+i,x,hero1.getNickName()+": "+((Buff)b).getName()+" time late " + ((Buff)b).getTimeValue());
            } else if(b.getSkillType() == SkillType.SHIELD){
                initWord(y+1+i,x,hero1.getNickName()+": "+((Shield)b).getName()+" damage late " + ((Shield)b).getDamage()+" time late " + ((Shield)b).getTimeValue());
            }
            i++;
        }
        i = 0;
        for(Abillity b :hero2.getEffects() ){
            if (b.getSkillType() == SkillType.BUFF) {
                initWord(y+1+i,x+dlt,hero2.getNickName()+": "+((Buff)b).getName()+" time late " + ((Buff)b).getTimeValue());
            } else if(b.getSkillType() == SkillType.SHIELD){
                initWord(y+1+i,x+dlt,hero2.getNickName()+": "+((Shield)b).getName()+" damage late " + ((Shield)b).getDamage()+" time late " + ((Shield)b).getTimeValue());
            }
            i++;
        }
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
    
    public void showSkills(List<Abillity> skillList){
        System.out.println("Chose skill");
        for(int i =0;i< skillList.size();i++){
            System.out.println(i+") "+skillList.get(i).getName()+" CastTime = "+skillList.get(i).getCastTime());
        }
    }
     public void showPotions(List<Potion> skillList){
        System.out.println("Chose potion");
        for(int i =0;i< skillList.size();i++){
            System.out.println(i+") "+skillList.get(i).getName()+": Res Health = "+skillList.get(i).getResHealth()+" Res Energy = "+skillList.get(i).getResEnergy());
        }
    }
    
    public int getXMin(){
        return 0;
    }
    
    public int getYMin(){
        return 1;
    }
    
    public int getXMax(){
        return xBG-1;
    }
    
    public int getYMax(){
        return yBG-1;
    }
}
