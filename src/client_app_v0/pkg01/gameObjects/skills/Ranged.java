/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.skills;

import client_app_v0.pkg01.gameObjects.classes.ClassType;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class Ranged extends Skill {

    private int _width;
    private int _height;
    private int _xSpeed;
    private int _ySpeed;
    private int _damage;
    private List<Buff> _buffs;
    private SkillEntityType _type;

    public Ranged(int lvlcost, int cost, int cooldown, ClassType classType,
            int id, String name, int range, int width, int height, int xSpeed,
            int ySpeed, int damage, List<Buff> buffs, SkillEntityType type,
            int castTime) {
        super(lvlcost, cost, cooldown, classType, id, name, range, castTime);
        _width = width;
        _height = height;
        _xSpeed = xSpeed;
        _ySpeed = ySpeed;
        _damage = damage;
        _buffs = buffs;
        _type = type;
    }

    public int GetDamage() {
        return _damage;
    }
    public int GetWidth() {
        return _width;
    }
    public int GetHeight() {
        return _height;
    }
    public int GetXSpeed(){
        return _xSpeed;
    }
    public int GetYSpeed(){
        return _ySpeed;
    }
    public List<Buff> GetBuffs() {
        return _buffs;
    }
    public SkillEntityType GetSkillType(){
        return _type;
    }
}
