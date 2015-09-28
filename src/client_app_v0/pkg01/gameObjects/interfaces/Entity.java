/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.interfaces;

import client_app_v0.pkg01.gameObjects.Body;

/**
 *
 * @author qw
 */
public interface Entity {
    int getX();
    int getY();
    
    Body getBody();
    void setBody(Body body);    
    
    void setXpos(int x);
    void setYpos(int y);
}
