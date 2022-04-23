package no.ntnu.katarzsz;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests Army class
 */
class ArmyTest {
    @Test
    public void addUnitToArmy() {
        CavalryUnit unit = new CavalryUnit("Test", 10); //unit for testing
        Army army = new Army("Units"); //empty army
        assertTrue(army.add(unit));
    }

    @Test
    public void removeUnitFromArmy() {
        CavalryUnit unit = new CavalryUnit("Test", 10); //unit for testing
        Army army = new Army("Units"); //empty army
        army.add(unit);
        assertTrue(army.remove(unit));
    }

    @Test
    public void addAllUnits() {
        CavalryUnit unit1 = new CavalryUnit("Test1", 10);
        CavalryUnit unit2 = new CavalryUnit("Test2", 10);
        List<Unit> units = new ArrayList<Unit>();
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("Test army");

        assertTrue(army.addAll(units));
    }

    @Test
    public void returnTrueWhenArmyHasUnits() {
        CavalryUnit unit1 = new CavalryUnit("Test1", 10);
        Army army = new Army("Test army");
        army.add(unit1);

        assertTrue(army.hasUnits());
    }

    @Test
    public void returnFalseWhenArmyIsEmpty() {
        Army army = new Army("Test army");

        assertFalse(army.hasUnits());
    }

    @Test
    public void returnOnlyInfantryUnits() {
        Army army = getTestArmyWithUnitsOfAllType();

        assertTrue(army.getInfantryUnits().stream().allMatch(u -> u instanceof InfantryUnit));
    }

    @Test
    public void returnOnlyCavalryUnits() {
        Army army = getTestArmyWithUnitsOfAllType();

        assertTrue(army.getCavalryUnits().stream().allMatch(u -> u instanceof CavalryUnit));
    }
    @Test
    public void returnOnlyRangedUnits() {
        Army army = getTestArmyWithUnitsOfAllType();

        assertTrue(army.getRangedUnits().stream().allMatch(u -> u instanceof RangedUnit));
    }
    @Test
    public void returnOnlyCommanderUnits() {
        Army army = getTestArmyWithUnitsOfAllType();

        assertTrue(army.getCommanderUnits().stream().allMatch(u -> u instanceof CommanderUnit));
    }

    @Test
    public void writeArmyToFile() {
        Army army = getTestArmyWithUnitsOfAllType();
        army.saveArmyToFile();
    }

    @Test
    public void readFromArmyFile() {
        Army army = getTestArmyWithUnitsOfAllType();
        army.readArmyFromFile();
    }

    /**
     * Method used below to avoid duplicate code and get better readability
     * @return army with test units of type InfantryUnit, CommanderUnit, CavalryUnit and RangedUnit
     */
    public Army getTestArmyWithUnitsOfAllType() {
        Army army = new Army("The army");
        army.add(new InfantryUnit("Brr-zerker", 10));
        army.add(new InfantryUnit("Brr-zerrker2", 10));
        army.add(new CommanderUnit("Clawbringer", 10));
        army.add(new CommanderUnit("Clawbringer2", 10));
        army.add(new CavalryUnit("Spellshooter", 10));
        army.add(new CavalryUnit("Spellshooter2", 10));
        army.add(new RangedUnit("Graveborn", 10));
        army.add(new RangedUnit("Graveborn2", 10));
        return army;
    }
}
