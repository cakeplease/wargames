package no.ntnu.katarzsz;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /**
     * Method used below to spare space and get better readability
     * @return army with test units of type InfantryUnit, CommanderUnit, CavalryUnit and RangedUnit
     */
    public Army getTestArmyWithUnitsOfAllType() {
        InfantryUnit infantryUnit = new InfantryUnit("infantryUnit", 10);
        InfantryUnit infantryUnit2 = new InfantryUnit("infantryUnit2", 10);
        CommanderUnit commanderUnit = new CommanderUnit("commanderUnit", 10);
        CommanderUnit commanderUnit2 = new CommanderUnit("commanderUnit2", 10);
        CavalryUnit cavalryUnit = new CavalryUnit("cavalryUnit", 10);
        CavalryUnit cavalryUnit2 = new CavalryUnit("cavalryUnit2", 10);
        RangedUnit rangedUnit = new RangedUnit("rangedUnit", 10);
        RangedUnit rangedUnit2 = new RangedUnit("rangedUnit2", 10);

        Army army = new Army("army");
        army.add(infantryUnit);
        army.add(infantryUnit2);
        army.add(commanderUnit);
        army.add(cavalryUnit);

        return army;
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

}
