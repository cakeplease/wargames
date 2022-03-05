package no.ntnu.katarzsz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {

    @Test
    public void isChargeAttack() {
        CavalryUnit cavalryUnit = new CavalryUnit("Test", 10);
        assertTrue(cavalryUnit.getAttackBonus() == 6);
    }

    @Test
    public void isNormalAttack() {
        CavalryUnit cavalryUnit = new CavalryUnit("Test", 10);
        cavalryUnit.registerAttack();
        assertTrue(cavalryUnit.getAttackBonus() == 2);
    }
}