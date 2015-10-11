/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.battleGround;

import client_app_v0.pkg01.gameObjects.Player;
import client_app_v0.pkg01.gameObjects.skills.Abillity;
import client_app_v0.pkg01.gameObjects.skills.Buff;
import client_app_v0.pkg01.gameObjects.skills.Directional;
import client_app_v0.pkg01.gameObjects.skills.Melee;
import client_app_v0.pkg01.gameObjects.skills.Shield;
import client_app_v0.pkg01.gameObjects.skills.Spell;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Broff
 */
public class AIBattleGround {

    private List<Player> players = new LinkedList<Player>();
    private List<String> battleLog = new LinkedList<String>();

    private int activeP = 0;
    private int nonActiveP = 1;
    private int alive = 0;
    private boolean battleState;

    public AIBattleGround(Player p1, Player p2) {
        players.add(p1);
        players.add(p2);
    }

    public void start() {
        if (this.players.size() == 2) {
            battleState = true;
            steps();
        }
    }

    boolean listenEv = true;
    Random rnd = new Random();

    private void steps() {
        String inStr;
        while (battleState) {

            while (listenEv) {
                int spellNum = rnd.nextInt(players.get(activeP).getAbilityList().size());
                try {
                    Abillity skill = players.get(activeP).getAbility(spellNum);
                    if (skill != null) {
                        useSkill(skill);
                    }
                } catch (Exception e) { }
            }

            if (!players.get(activeP).getLifeState()) {
                System.out.println(players.get(activeP).getNickName() + ": is died.");
                alive = this.nonActiveP;
                battleState = false;
            }
            players.get(activeP).tick();
            setActivePlayer();
            players.get(activeP).tick();
            if (!players.get(activeP).getLifeState()) {
                System.out.println(players.get(activeP).getNickName() + ": is died.");
                alive = this.nonActiveP;
                battleState = false;
            }
            listenEv = true;
        }
    }

    private void useSkill(Spell skill) {
        if (players.get(activeP).getLifeState()) {
            switch (((Abillity) skill).getSkillType()) {
                case DIRECTIONAL:
                    Directional skillD = (Directional) skill;
                    if (skillD.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {                        
                        players.get(activeP).setActualEnergy(-skillD.getEnergyCost());
                        int dmg = skillD.use(players.get(nonActiveP));
                        System.out.println(players.get(activeP).getNickName() + ": Use skill(" + skillD.getName() + "). Accept damage -" + dmg + ". " + skillD.getEnergyCost() + " energy is lost.");
                        listenEv = false;
                    }
                    break;
                case SHIELD:
                    Shield skillS = (Shield) skill;
                    if (skillS.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        players.get(activeP).setActualEnergy(-skillS.getEnergyCost());
                        skillS.use(players.get(activeP));
                        System.out.println(players.get(activeP).getNickName() + ": Use shield(" + skillS.getName() + "). " + skillS.getEnergyCost() + " energy is lost.");
                        listenEv = false;
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
                        players.get(activeP).setActualEnergy(-skillB.getEnergyCost());
                        skillB.use(players.get(activeP));
                        System.out.println(players.get(activeP).getNickName() + ": Use buff(" + skillB.getName() + "). " + skillB.getEnergyCost() + " energy is lost.");
                        listenEv = false;
                    }
                    break;
                case RANGED:
                    break;
                case MELEE:
                    Melee skillM = (Melee) skill;
                    if (skillM.checkAvailability(players.get(activeP).getLevel(), players.get(activeP).getActualEnergy())) {
                        players.get(activeP).setActualEnergy(-skillM.getEnergyCost());
                        if (checkCollision()) {
                            int dmg = skillM.use(players.get(nonActiveP));
                            System.out.println(players.get(activeP).getNickName() + ": Use skill(" + skillM.getName() + "). Accept damage -" + dmg + ". " + skillM.getEnergyCost() + " energy is lost.");
                        } else {
                            System.out.println(players.get(activeP).getNickName() + ": Use skill(" + skillM.getName() + ") and missed.");
                        }
                    }
                    listenEv = false;
                    break;
                default:
                    break;
            }            
        }
    }
    
    public int getAliveBot(){
        return alive;
    }

    private boolean checkCollision() {
        if (Math.abs(players.get(activeP).getX() - players.get(nonActiveP).getX()) <= 3
                && Math.abs(players.get(activeP).getY() - players.get(nonActiveP).getY()) <= 4) {
            return true;
        } else {
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
}
