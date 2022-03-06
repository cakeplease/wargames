package no.ntnu.katarzsz;

/**
 * InfantryUnit class which extends Unit
 */
public class InfantryUnit extends Unit {
    /**
     * Infantry constructor
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }
    public int getAttackBonus() {
        return 2;
    }
    public int getResistBonus() {
        return 1;
    }
}
