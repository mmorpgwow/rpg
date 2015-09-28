/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.physicBody;

/**
 *
 * @author qw
 */
public class Body {
    
    private int _width;
    private int _height;
    
    public Body(int width, int height){
        _width = width;
        _height = height;
    }
    
    public int GetWidth(){
        return _width;
    }
    public int GetHeight(){
        return _height;
    }
    
    public void SetWidth(int width){
        _width=width;
    }
    public void SetHeight(int height){
        _height=height;
    }
}
