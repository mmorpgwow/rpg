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
public class AoE {

    private int _damage;
    private int _damageGain;
    private int _xPos;
    private int _yPos;
    private int _area;
    private int _areaGain;
    private int _delay;
    private int _delayGain;
    private List<Buff> _buffs;
    private Skill _skill;
    private SkillEntityType _type;

    public AoE(int damage, int xPos, int yPos, int area, int delay,
            List<Buff> buffs, int damageGain, int areaGain, int delayGain,
            Skill skill, SkillEntityType type) {
        _damage = damage;
        _area = area;
        _delay = delay;
        _buffs = buffs;
        _damageGain = damageGain;
        _areaGain = areaGain;
        _delayGain = delayGain;
        _skill = skill;
        _type = type;
    }

    private void UpStats() {
        _damage += _damageGain;
        _area += _areaGain;
        _delay += _delayGain;
    }

    public void SetPos(int xPos, int yPos) {
        _xPos = xPos;
        _yPos = yPos;
    }

    public int GetDamage() {
        return _damage;
    }

    public int GetXPos() {
        return _xPos;
    }

    public int GetYPos() {
        return _yPos;
    }

    public int GetArea() {
        return _area;
    }

    public int GetDelay() {
        return _delay;
    }

    public List<Buff> GetBuffs() {
        return _buffs;
    }

    public void LvlUp() {
        _skill.LvlUp();
        UpStats();
    }
}
