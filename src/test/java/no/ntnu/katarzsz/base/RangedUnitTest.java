package no.ntnu.katarzsz.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangedUnitTest {

    @Test
    public void ifNeverAttackedReturn6() {
        RangedUnit rangedUnit = new RangedUnit("Test", 10);
        assertTrue(rangedUnit.getResistBonus() == 6);
    }

    @Test
    public void ifAttackedSecondTimeReturn4() {
        RangedUnit rangedUnit = new RangedUnit("Test", 10);

        //getAttacked() is running after getting resistBonus() so we only need to use this once to get the value of being attacked again.
        rangedUnit.getAttacked();
        assertTrue(rangedUnit.getResistBonus() == 4);
    }

    @Test
    public void ifAttackedMoreThanTwoTimesReturn2() {
        RangedUnit rangedUnit = new RangedUnit("Test", 10);

        //getAttacked() is running after getting resistBonus() so we only need to use this twice to get the value of being attacked again.
        rangedUnit.getAttacked();
        rangedUnit.getAttacked();

        assertTrue(rangedUnit.getResistBonus() == 2);
    }
}
