package no.ntnu.katarzsz.base;

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

        Battle battle = new Battle(armyOne, armyTwo, Terrain.FOREST);

        //Run battle
        BattleSimulationResult res = battle.simulate();
        assertTrue(res.winnerArmy() instanceof Army);
        assertTrue(res.simulationText() instanceof String);

    }
}
