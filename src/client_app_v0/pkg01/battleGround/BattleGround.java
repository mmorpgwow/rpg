/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.battleGround;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.Directional;
import client_app_v0.pkg01.renderFactory.RenderBattleGround;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class BattleGround {

    private int xSize;
    private int ySize;
    private int roundTime;
    private boolean battleState = false;

    private List<Player> players = new LinkedList<Player>();
    private List<String> battleLog = new LinkedList<String>();
    private EventListener events;
    private RenderBattleGround render;
    private int activeP = 0;
    private int nonActiveP = 1;

    public BattleGround(int xSize, int ySize, int roundTime) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.roundTime = roundTime;
    }

    public void start() {
        if (this.events != null && this.players.size() == 2) {
            players.get(0).setActualHealth(-400);
            players.get(1).setActualHealth(-700);
            players.get(0).setActualEnergy(-1700);
            players.get(1).setActualEnergy(-1400);
            battleState = true;
            render = new RenderBattleGround(players, battleLog, xSize, ySize);
            render.update();
            render.show();
            steps();
        }
    }

    boolean listenEv = true;
    private void steps() {
        String inStr;        
        while (battleState) {
            exit:
            while (listenEv) {
                inStr = events.start();
                if (inStr.equals("exit")) {
                    stop();
                    break;
                } else {
                    switch (inStr) {
                        case "s":                                 //Skill
                            useSkill(players.get(activeP).getAbility(7));
                            break exit;
                        case "m":                                 //Move
                            listenEv = false;
                            break exit;
                        case "i":                                 //Item
                            listenEv = false;
                            break exit;
                        case "c":                                 //Check
                            addEventLog(players.get(activeP).getNickName()+": Miss step.");
                            listenEv = false;
                            break exit;
                        default:
                            render.update();
                            render.show();
                            break;
                    }
                }
            }
            if(!players.get(activeP).getLifeState()){
                addEventLog(players.get(activeP).getNickName()+": is died.");
                battleState = false;
            }
            players.get(activeP).tick();
            setActivePlayer();
            players.get(activeP).tick();
            if(!players.get(activeP).getLifeState()){
                addEventLog(players.get(activeP).getNickName()+": is died.");
                battleState = false;
            }
            render.update();
            render.show();
            listenEv = true;
        }
    }
    
    private void useSkill(Abillity skill){
        switch(skill.getSkillType()){
            case DIRECTIONAL:
                Directional skillD = (Directional)skill;
                if(skillD.checkAvailability(players.get(activeP).getLevel(),players.get(activeP).getActualEnergy())){
                    players.get(activeP).setActualEnergy(-skillD.getEnergyCost());
                    int dmg = skillD.use(players.get(nonActiveP));
                    addEventLog(players.get(activeP).getNickName()+": Use skill("+skillD.getName()+"). Accept damage -"+dmg+". "+skillD.getEnergyCost()+"energy is lost.");
                    listenEv = false;
                }
                break;
            default :
                break;
        }
    }

    private void setActivePlayer() {
        if (activeP == 0) {
            activeP = 1;
            nonActiveP = 0;
        } else {
            activeP = 0;
            nonActiveP = 1;
        }
    }

    public void stop() {
        battleState = false;
    }

    public void addEventListener(EventListener event) {
        if (this.events == null) {
            this.events = event;
        }
    }

    public void addPlayer(Player e) {
        if (!battleState && players.size() < 2) {
            e.startBattle();
            players.add(e);
        }
    }

    public Player getPlayer(int id) {
        if (id >= 0 && id < players.size()) {
            return players.get(id);
        }
        return null;
    }

    public List<Player> getEntityList() {
        return this.players;
    }

    public List<String> getBattleLog() {
        return this.battleLog;
    }

    public void addEventLog(String str) {
        if (this.battleLog.size() >= 4) {
            this.battleLog.remove(0);
        }
        this.battleLog.add(str);
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }
}
