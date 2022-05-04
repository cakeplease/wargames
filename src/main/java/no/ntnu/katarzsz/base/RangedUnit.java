package no.ntnu.katarzsz.base;

import static no.ntnu.katarzsz.base.Terrain.*;

/**
 * RangedUnit class which extends Unit
 */
public class RangedUnit extends Unit {

    Terrain terrain = null;

    /**
     * RangedUnit constructor with all params
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * RangedUnit's second constructor with only name and health params
     * @param name
     * @param health
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15,8);
    }

    /**
     * Gets attack bonus
     * @return attack bonus value
     */
    public int getAttackBonus() {
        if (terrain == HILL) {
            return 9;
        } else if (terrain == FOREST) {
            return 1;
        }

        return 3;
    }

    /**
     * Gets resist bonus based on how many times it was attacked
     * @return resist bonus value
     */
    public int getResistBonus() {
        if (this.gotAttackedCount == 0) {
            return 6;
        } else if (this.gotAttackedCount == 1) {
            return 4;
        }

        return 2;
    }

    /**
     * Set terrain type
     * @param terrainType
     */
    public void setTerrain(Terrain terrainType) {
        terrain = terrainType;
    }
}
