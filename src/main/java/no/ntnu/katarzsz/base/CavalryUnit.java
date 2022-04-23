package no.ntnu.katarzsz.base;

import no.ntnu.katarzsz.base.Unit;

/**
 * CavalryUnit class which extends Unit
 */
public class CavalryUnit extends Unit {
    /**
     * CavalryUnit constructor with all params
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Cavalry constructor with only name and health param
     * @param name
     * @param health
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    /**
     * Gets attack bonus if it's first time it's attacking
     * @return attack bonus if attack count is 0
     */
    public int getAttackBonus() {
        if (this.attackCount == 0) {
            return 6;
        }
        return 2;
    }

    /**
     * Gets resist bonus
     * @return resist bonus value
     */
    public int getResistBonus() {
        return 1;
    }
}
