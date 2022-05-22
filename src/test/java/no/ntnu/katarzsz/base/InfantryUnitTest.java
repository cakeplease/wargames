package no.ntnu.katarzsz.base;

import org.junit.jupiter.api.Test;
import static no.ntnu.katarzsz.base.Terrain.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InfantryUnitTest {
    @Test
    public void checkIfForestTerrainEffectsAttackBonus() {
        Terrain terrain = FOREST;
        InfantryUnit infantryUnit = new InfantryUnit("test", 10);
        infantryUnit.setTerrain(terrain);
        assertEquals(infantryUnit.getAttackBonus(), 6);
    }
    @Test
    public void checkThatOtherTerrainDoesNotEffectAttackBonus() {
        Terrain terrain = PLAINS;
        InfantryUnit infantryUnit = new InfantryUnit("test", 10);
        infantryUnit.setTerrain(terrain);
        assertNotEquals(infantryUnit.getAttackBonus(), 6);
    }
    @Test
    public void checkIfForestTerrainEffectsResistBonus() {
        Terrain terrain = FOREST;
        InfantryUnit infantryUnit = new InfantryUnit("test", 10);
        infantryUnit.setTerrain(terrain);
        assertEquals(infantryUnit.getResistBonus(), 3);
    }

    @Test
    public void checkThatOtherTerrainDoesNotEffectResistBonus() {
        Terrain terrain = PLAINS;
        InfantryUnit infantryUnit = new InfantryUnit("test", 10);
        infantryUnit.setTerrain(terrain);
        assertNotEquals(infantryUnit.getAttackBonus(), 3);
    }

}
