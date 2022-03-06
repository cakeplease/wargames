package no.ntnu.katarzsz;

/**
 * CommanderUnit class which extends CavalryUnit
 */
public class CommanderUnit extends CavalryUnit{
    /**
     * CommanderUnit constructor with all params
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * CommanderUnit constructor with only name and health params
     * @param name
     * @param health
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }
}
