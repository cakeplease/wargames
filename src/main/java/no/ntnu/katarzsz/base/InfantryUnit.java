package no.ntnu.katarzsz.base;

import static no.ntnu.katarzsz.base.Terrain.*;

/**
 * InfantryUnit class which extends Unit
 */
public class InfantryUnit extends Unit {

    Terrain terrain = null;
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
        if (terrain == FOREST) {
            return 6;
        }
        return 2;
    }

    /**
     * Gets resist bonus
     * @return resist bonus
     */
    public int getResistBonus() {
        if (terrain == FOREST) {
            return 3;
        }
        return 1;
    }

    /**
     * Set terrain type
     * @param terrainType
     */
    public void setTerrain(Terrain terrainType) {
        terrain = terrainType;
    }
}
