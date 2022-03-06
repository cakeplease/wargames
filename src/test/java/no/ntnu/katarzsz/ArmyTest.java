package no.ntnu.katarzsz;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        //create some test units
        CavalryUnit unit1 = new CavalryUnit("Test1", 10);
        CavalryUnit unit2 = new CavalryUnit("Test2", 10);

        //create an empty list
        List<Unit> units = new ArrayList<Unit>();

        //add units to the list
        units.add(unit1);
        units.add(unit2);

        //create an empty army
        Army army = new Army("Test army");

        //check if .addAll() returns true when ran
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

}
