/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.battleGround;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.inventory.items.Potion;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.Buff;
import client_app_v0.pkg01.gameObjects.skills.Directional;
import client_app_v0.pkg01.gameObjects.skills.Melee;
import client_app_v0.pkg01.gameObjects.skills.Shield;
import client_app_v0.pkg01.gameObjects.skills.Spell;
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
    private final int fullRoundTime;
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
        this.fullRoundTime = roundTime;
    }

    public void start() {
        if (this.events != null && this.players.size() == 2) {
            players.get(0).setActualHealth(1400);
            players.get(1).setActualHealth(-400);
            players.get(0).setActualEnergy(-1000);
            players.get(1).setActualEnergy(-1300);
            battleState = true;
            render = new RenderBattleGround(players, battleLog, xSize, ySize);
            render.update(players.get(activeP).getNickName(), this.roundTime);
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
                inStr = events.startLine();
                if (inStr.equals("exit")) {
                    stop();
                    break;
                } else {
                    switch (inStr) {
                        case "s":                                 //Skill
                            int spellNum;
                            render.showSkills(players.get(activeP).getAbilityList());
                            try {
                                spellNum = events.startInt();
                                Abillity skill = players.get(activeP).getAbility(spellNum);
                                if (skill != null) {
                                    if (checkRemoveTime(skill.getCastTime())) {
                                        useSkill(skill);
                                        break;
                                    } else {
                                        addEventLog(players.get(activeP).getNickName() + ": Not enough time");
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                            }
                        case "m":                                 //Move
                            int direction;
                            int range;
                            try {
                                direction = events.startInt();
                                range = events.startInt();
                                if (checkRemoveTime(1)) {
                                    removeTime(1);
                                    players.get(activeP).moveBattle(direction, range,
                                            render.getXMin(), render.getXMax(), render.getYMin(), render.getYMax());
                                    addEventLog(players.get(activeP).getNickName() + ": Made a motion.");
                                    break;
                                } else {
                                    addEventLog(players.get(activeP).getNickName() + ": Not enough time");
                                    break;
                                }
                            } catch (Exception e) {
                            }
                        case "i":                                 //Item
                            int itemNum;
                            render.showPotions(players.get(activeP).getPotions());
                            try {
                                itemNum = events.startInt();
                                Potion potion = players.get(activeP).getPotion(itemNum);
                                if (potion != null) {
                                    if (checkRemoveTime(1)) {

                                        break;
                                    } else {
                                        addEventLog(players.get(activeP).getNickName() + ": Not enough time");
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                            }
                            break;
                        case "c":                                 //Check
                            addEventLog(players.get(activeP).getNickName() + ": End step.");
                            removeTime(roundTime);
                            listenEv = false;
                            break;
                        default:
                            break;
                    }
                    render.update(players.get(activeP).getNickName(), this.roundTime);
                    render.show();
                }
            }
            this.roundTime = this.fullRoundTime;
            if (!players.get(activeP).getLifeState()) {
                addEventLog(players.get(activeP).getNickName() + ": is died.");
                battleState = false;
            }
            players.get(activeP).tick();
            setActivePlayer();
            players.get(activeP).tick();
            if (!players.get(activeP).getLifeState()) {
                addEventLog(players.get(activeP).getNickName() + ": is died.");
                battleState = false;
            }
            render.update(players.get(activeP).getNickName(), this.roundTime);
            render.show();
            listenEv = true;
        }
    }

    private void useSkill(Spell skill) {
        if (players.get(activeP).getLifeState()) {
            switch (((Abillity) skill).getSkillType()) {
                case DIRECTIONAL:
                    Directional skillD = (Directional) skill;
                    if (skillD.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        removeTime(skillD.getCastTime());
                        players.get(activeP).setActualEnergy(-skillD.getEnergyCost());
                        int dmg = skillD.use(players.get(nonActiveP));
                        addEventLog(players.get(activeP).getNickName() + ": Use skill(" + skillD.getName() + "). Accept damage -" + dmg + ". " + skillD.getEnergyCost() + " energy is lost.");
                    }
                    break;
                case SHIELD:
                    Shield skillS = (Shield) skill;
                    if (skillS.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        removeTime(skillS.getCastTime());
                        players.get(activeP).setActualEnergy(-skillS.getEnergyCost());
                        skillS.use(players.get(activeP));
                        addEventLog(players.get(activeP).getNickName() + ": Use shield(" + skillS.getName() + "). " + skillS.getEnergyCost() + " energy is lost.");
                    }
                    break;
                case MOVE:
                    break;
                case AOE:
                    break;
                case DEBUFF:
                    break;
                case BUFF:
                    Buff skillB = (Buff) skill;
                    if (skillB.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        removeTime(skillB.getCastTime());
                        players.get(activeP).setActualEnergy(-skillB.getEnergyCost());
                        skillB.use(players.get(activeP));
                        addEventLog(players.get(activeP).getNickName() + ": Use buff(" + skillB.getName() + "). " + skillB.getEnergyCost() + " energy is lost.");
                    }
                    break;
                case RANGED:
                    break;
                case MELEE:
                    Melee skillM = (Melee) skill;
                    if (skillM.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        removeTime(skillM.getCastTime());
                        players.get(activeP).setActualEnergy(-skillM.getEnergyCost());
                        if (checkCollision()) {
                            int dmg = skillM.use(players.get(nonActiveP));
                            addEventLog(players.get(activeP).getNickName() + ": Use skill(" + skillM.getName() + "). Accept damage -" + dmg + ". " + skillM.getEnergyCost() + " energy is lost.");
                        } else {
                            addEventLog(players.get(activeP).getNickName() + ": Use skill(" + skillM.getName() + ") and missed.");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private boolean checkCollision() {
        if (Math.abs(players.get(activeP).getX() - players.get(nonActiveP).getX()) <= 3
                && Math.abs(players.get(activeP).getY() - players.get(nonActiveP).getY()) <= 4) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRemoveTime(int value) {
        if (this.roundTime - value >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean removeTime(int value) {
        if (this.roundTime - value >= 0) {
            this.roundTime -= value;
            return true;
        } else {
            roundTime = fullRoundTime;
            return false;
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
