package no.ntnu.katarzsz.base;

import no.ntnu.katarzsz.base.Unit;

/**
 * InfantryUnit class which extends Unit
 */
public class InfantryUnit extends Unit {
    /**
     * Infantry constructor that takes in attack and armor in addition to name and health
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }
    /**
     * Other infantry constructor that takes in only name and health
     * @param name
     * @param health
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }

    /**
     * Gets attack bonus
     * @return attack bonus
     */
    public int getAttackBonus() {
        return 2;
    }

    /**
     * Gets resist bonus
     * @return resist bonus
     */
    public int getResistBonus() {
        return 1;
    }
}
