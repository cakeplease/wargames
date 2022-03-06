package no.ntnu.katarzsz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleTest {

    @Test
    public void testSimulation() {
        CommanderUnit unit1 = new CommanderUnit("Unit1", 20);
        RangedUnit unit2 = new RangedUnit("Unit2", 10);

        CommanderUnit unit3 = new CommanderUnit("Unit3", 20);
        RangedUnit unit4 = new RangedUnit("Unit4", 10);

        Army armyOne = new Army("ArmyOne");
        Army armyTwo = new Army("ArmyTwo");

        armyOne.add(unit1);
        armyOne.add(unit2);

        armyTwo.add(unit3);
        armyTwo.add(unit4);

        Battle battle = new Battle(armyOne, armyTwo);
        Army winner = battle.simulate();
        assertTrue(winner instanceof Army);
    }
}
