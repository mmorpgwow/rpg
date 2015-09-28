/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.physicBody.interfaces;

import client_app_v0.pkg01.gameObjects.physicBody.Body;

/**
 *
 * @author qw
 */
public interface DynamicEntity extends Entity{
    
    float getHealth();
    float setHealth(float health);
        
    float getEnergy();
    float setEnergy(float energy);
    
    void update();
}
