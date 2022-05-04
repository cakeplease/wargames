package no.ntnu.katarzsz.base;

import static no.ntnu.katarzsz.base.Terrain.*;

/**
 * CavalryUnit class which extends Unit
 */
public class CavalryUnit extends Unit {

    Terrain terrain = null;

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
     * Gets attack bonus, extra bonus if it's the first time attack or/and the terrain type is plains
     * @return attack bonus
     */
    public int getAttackBonus() {
        if (terrain == PLAINS) {
            if (this.attackCount == 0) {
                return 12;
            }
            return 6;
        } else {
            if (this.attackCount == 0) {
                return 6;
            }
        }
        return 2;
    }

    /**
     * Gets resist bonus, no bonus if terrain type is forest
     * @return resist bonus value
     */
    public int getResistBonus() {
        if (terrain == FOREST) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Set terrain type
     * @param terrainType
     */
    public void setTerrain(Terrain terrainType) {
        terrain = terrainType;
    }
}
