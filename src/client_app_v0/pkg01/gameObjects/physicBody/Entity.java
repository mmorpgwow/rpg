/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.physicBody;

import client_app_v0.pkg01.gameObjects.EntityType;
import client_app_v0.pkg01.gameObjects.inventory.Inventory;

/**
 *
 * @author qw
 */
public abstract class Entity {

    public static EntityType type;
    private int xPos;
    private int yPos;
    private int xPosBattle;
    private int yPosBattle;
    protected boolean battleState;

    private int moveSpeed;
    protected Body body;

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

    public int getSpeed() {
        return moveSpeed;
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

    public void moveBattle(int direction, int range, int xMin, int xMax, int yMin, int yMax) {
        if (range > 0 && range <= this.moveSpeed && direction <= 8 && direction > 0) {
            switch (direction) {
                case 1:
                    if (yPosBattle - range >= yMin) {
                        setYpos(yPosBattle - range);
                    } else {
                        setYpos(yMin);
                    }
                    break;
                case 2:
                    if (xPosBattle + range < xMax) {
                        setXpos(xPosBattle + range);
                    } else {
                        setXpos(xMax - 1);
                    }
                    if (yPosBattle - range >= yMax) {
                        setYpos(yPosBattle - range);
                    } else {
                        setYpos(yMin);
                    }
                    break;
                case 3:
                    if (xPosBattle + range < xMax) {
                        setXpos(xPosBattle + range);
                    } else {
                        setXpos(xMax - 1);
                    }
                    break;
                case 4:
                    if (xPosBattle + range < xMax) {
                        setXpos(xPosBattle + range);
                    } else {
                        setXpos(xMax - 1);
                    }
                    if (yPosBattle + range < yMax) {
                        setYpos(yPosBattle + range);
                    } else {
                        setYpos(yMax - 1);
                    }
                    break;
                case 5:
                    if (yPosBattle + range < yMax) {
                        setYpos(yPosBattle + range);
                    } else {
                        setYpos(yMax - 1);
                    }
                    break;
                case 6:
                     if (xPosBattle - range > xMin) {
                        setXpos(xPosBattle - range);
                    } else {
                        setXpos(xMin + 1);
                    }
                    if (yPosBattle + range < yMax) {
                        setYpos(yPosBattle + range);
                    } else {
                        setYpos(yMax - 1);
                    }
                    break;
                case 7:
                    if (xPosBattle - range > xMin) {
                        setXpos(xPosBattle - range);
                    } else {
                        setXpos(xMin + 1);
                    }
                    break;
                case 8:
                    if (xPosBattle - range > xMin) {
                        setXpos(xPosBattle - range);
                    } else {
                        setXpos(xMin + 1);
                    }
                    if (yPosBattle - range > yMin) {
                        setYpos(yPosBattle - range);
                    } else {
                        setYpos(yMin + 1);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
