/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.physicBody;

import client_app_v0.pkg01.gameObjects.inventory.Inventory;

/**
 *
 * @author qw
 */
public abstract class Entity {

    private int xPos;
    private int yPos;
    private int xPosBattle;
    private int yPosBattle;
    protected boolean battleState;

    private int moveSpeed;
    private Body body;

    public Entity(int x, int y, int xBattle, int yBattle, int speed, Body body) {
        this.xPos = x;
        this.yPos = y;
        this.xPosBattle = xBattle;
        this.yPosBattle = yBattle;
        this.body = body;
        this.moveSpeed = speed;
        //this.inventory = new Inventory();
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getX() {
        if (battleState) {
            return xPosBattle;
        } else {
            return xPos;
        }
    }

    public int getY() {
        if (battleState) {
            return yPosBattle;
        } else {
            return yPos;
        }
    }

    public void setXpos(int x) {
        if (battleState) {
            xPosBattle = x;
        } else {
            xPos = x;
        }
    }

    public void setYpos(int y) {
        if (battleState) {
            yPosBattle = y;
        } else {
            yPos = y;
        }
    }

    public void moveBattle(int direction, int range) {
        if (range > 0 && range < this.moveSpeed && direction <= 8 && direction > 0) {
            switch (direction) {
                case 1:
                    setYpos(yPos-range);
                    break;
                case 2:
                    setXpos(xPos+range);
                    setYpos(yPos-range);
                    break;
                case 3:
                    setXpos(xPos+range);
                    break;
                case 4:
                    setXpos(xPos+range);
                    setYpos(yPos+range);
                    break;
                case 5:
                    setYpos(yPos+range);
                    break;
                case 6:
                    setXpos(xPos-range);
                    setYpos(yPos+range);
                    break;
                case 7:
                    setXpos(xPos-range);
                    break;
                case 8:
                    setXpos(xPos-range);
                    setYpos(yPos-range);
                    break;
                default:
                    break;
            }
        }
    }
}
