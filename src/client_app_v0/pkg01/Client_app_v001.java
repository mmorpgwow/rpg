/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01;

import client_app_v0.pkg01.battleGround.BattleGround;
import client_app_v0.pkg01.renderFactory.RenderBattleGround;
import client_app_v0.pkg01.renderFactory.RenderHeroInfo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qw
 */
public class Client_app_v001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        BattleGround bg = new BattleGround(100, 12, 5);
        RenderBattleGround r = new RenderBattleGround(bg);
        r.show();   
        
        while(true){
            r.update();
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client_app_v001.class.getName()).log(Level.SEVERE, null, ex);
            }
            r.show();
        }
    }
    
}
