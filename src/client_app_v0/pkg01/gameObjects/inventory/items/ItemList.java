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
    private Item legs;
    private Item hands;
    private Item boots;
    private Item belt;
    private Item neck;
    private Item ring;
    private Potion healingPotion;
    private Potion energyPotion;

    public ItemList() {
        init();
    }

    private void init() {
        Stats stats = new Stats(0, 5, 10, 5, 0, 5);
        helm = new Armor(0, "Helm", 500, 10, stats, ArmorType.HELM); // Still no :c
        stats = new Stats(0, 5, 40, 10, 0, 15);
        chest = new Armor(1, "Chest", 1000, 20, stats, ArmorType.CHEST);
        stats = new Stats(0, 10, 0, 0, 10, 15);
        weapon = new Weapon(2, "STUFF OF THE JAVA GOD", 800, 16, stats,
                WeaponType.STUFF, true, 50, 20); // Hell yeah
        stats = new Stats(0, 5, 5, 0, 0, 5);
        legs = new Armor(3, "Legs", 200, 4, stats, ArmorType.LEGS);
         stats = new Stats(0, 5, 5, 0, 0, 5);
        hands = new Armor(4, "Hands", 200, 4, stats, ArmorType.HANDS);
         stats = new Stats(0, 5, 2, 0, 0, 0);
        boots = new Armor(5, "Boots", 100, 2, stats, ArmorType.BOOTS);
         stats = new Stats(0, 5, 2, 0, 0, 8);
        belt = new Armor(6, "Belt", 200, 4, stats, ArmorType.BELT);
         stats = new Stats(0, 10, 0, 0, 0, 10);
        neck = new Armor(7, "Neck", 500, 10, stats, ArmorType.NECK);
         stats = new Stats(0, 10, 0, 0, 0, 10);
        ring = new Armor(8, "Ring", 500, 10, stats, ArmorType.RING);
        healingPotion = new Potion(9,"Heal",50,1,200,0,1);
        energyPotion = new Potion(10,"Energy",50,1,0,200,1);
    }

    public Item getItemWithID(int id) {
        switch (id) {
            case 0:
                return helm;
            case 1:
                return chest;
            case 2:
                return weapon;
            case 3:
                return legs;
            case 4:
                return hands;
            case 5:
                return boots;
            case 6:
                return belt;
            case 7:
                return neck;
            case 8:
                return ring;
            case 9:
                return healingPotion;
            case 10:
                return energyPotion;
            default:
                return null;
        }
    }
}
