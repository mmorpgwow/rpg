/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.battleGround;

import java.util.Scanner;

/**
 *
 * @author Broff
 */
public class EventListener {
    
    private Scanner scan;
    private boolean status = false;
    
    public EventListener(){
        scan = new Scanner(System.in);
    }
    
    public String startLine(){
        return scan.nextLine();
    }
    
    public int startInt(){
        return scan.nextInt();
    }
}
