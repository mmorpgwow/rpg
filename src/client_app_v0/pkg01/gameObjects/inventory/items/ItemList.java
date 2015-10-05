/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_app_v0.pkg01.gameObjects.inventory.items;

/**
 *
 * @author Pablo
 */
public class ItemList {

    private Item helm; // I have no idea how to name items :/
    private Item chest;
    private Item weapon;

    public ItemList() {
        init();
    }

    private void init() {
        Stats stats = new Stats(0, 5, 10, 5, 0, 5);
        helm = new Armor(0, "Helm", 500, 10, stats); // Still no :c
        stats = new Stats(0, 5, 40, 10, 0, 15);
        chest = new Armor(1, "Chest", 1000, 20, stats);
        stats = new Stats(0, 10, 0, 0, 10, 15);
        weapon = new Weapon(2, "STUFF OF THE JAVA GOD", 800, 16, stats, 
                WeaponType.STUFF, true, 50, 20); // Hell yeah
    }

    public Item GetItemWithID(int id) {
        switch (id) {
            case 0:
                return helm;
            case 1:
                return chest;
            case 2:
                return weapon;
            default:
                return null;
        }
    }
}
