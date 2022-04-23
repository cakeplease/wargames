package no.ntnu.katarzsz.base;

import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.base.Battle;
import no.ntnu.katarzsz.base.CommanderUnit;
import no.ntnu.katarzsz.base.RangedUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests Battle class
 */
class BattleTest {

    /**
     * Simulates the battle
     */
    @Test
    public void testSimulation() {
        //Setup two armies
        Army armyOne = new Army("ArmyOne");
        Army armyTwo = new Army("ArmyTwo");

        //Add some units to both armies
        armyOne.add(new CommanderUnit("Unit1", 20));
        armyOne.add(new RangedUnit("Unit2", 10));

        armyTwo.add(new CommanderUnit("Unit3", 20));
        armyTwo.add(new RangedUnit("Unit4", 10));

        Battle battle = new Battle(armyOne, armyTwo);
        //Run battle
        Army winner = battle.simulate();
        assertTrue(winner instanceof Army);
    }
}
