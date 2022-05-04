package no.ntnu.katarzsz.base;

/**
 * UnitFactory
 * Used to dynamically create unit classes based on type, name and health value
 */
public class UnitFactory {

    public static Unit getUnit(String typeOfUnit, String name, int health) {

        if (typeOfUnit == null) {
            return null;
        }

        if (typeOfUnit.equalsIgnoreCase("commander")) {
            return new CommanderUnit(name, health);
        } else if (typeOfUnit.equalsIgnoreCase("infantry")) {
            return new InfantryUnit(name, health);
        } else if (typeOfUnit.equalsIgnoreCase("ranged")) {
            return new RangedUnit(name, health);
        } else if (typeOfUnit.equalsIgnoreCase("cavalry")) {
            return new CavalryUnit(name, health);
        }

        return null;
    }
}
