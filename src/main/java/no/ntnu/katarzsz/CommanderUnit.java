package no.ntnu.katarzsz;

public class CommanderUnit extends CavalryUnit{
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }

    //Enheten har samme bonusberegninger som CavalryUnit
}
