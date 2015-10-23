/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.classes;

/**
 *
 * @author Broff
 */
public abstract class Hero {

    protected ClassType heroClass = ClassType.DEFAULT;
    protected int lvl;
    protected int startExp;
    protected int exp;
    protected ChangeableStats stat = new ChangeableStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 1);

    public Hero(int innerExp) {
        this.startExp = 100;
        lvl = 1;
        exp = 0;
        stat.initLevel(lvl);
        addExp(innerExp);
    }

    protected void setStats() {
        switch (heroClass) {
            case MAGE:
                stat = new ChangeableStats(10, 1, 25, 2, 50, 1, 70, 2, 20, 1, 40, 2,
                        1000, 20, 2000, 40, 10, 1, 20, 2, 0);
                break;
            case WARRIOR:
                stat = new ChangeableStats(10, 1, 25, 2, 50, 1, 70, 2, 20, 1, 40, 2,
                        1000, 20, 2000, 40, 10, 1, 20, 2, 0);
            default:
                throw new AssertionError();
        }
    }

    protected void setHeroClass(ClassType heroClass) {
        this.heroClass = heroClass;
    }

    public ClassType getHeroClass() {
        return heroClass;
    }

    public int getLevel() {
        return lvl;
    }

    public int getExp() {
        return this.exp;
    }

    public ChangeableStats getStat() {
        return this.stat;
    }

    public void addExp(int Exp) {
        int lvlExp = getLvlExp();
        if (Exp < lvlExp) {
            this.exp += Exp;
        } else {
            lvlUp();
            this.exp = 0;
            addExp(Exp - lvlExp);
        }
    }

    private void lvlUp() {
        lvl++;
        stat.initLevel(lvl);
    }

    public int getLvlExp() {
        if (startExp <= 0) {
            startExp = 10;
        }
        int Exp = startExp;
        for (int i = 1; i < lvl; i++) {
            Exp = Exp * 4 / 3;
        }
        return Exp;
    }
}
