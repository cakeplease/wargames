package no.ntnu.katarzsz;

/**
 * Battle class
 */
public class Battle {
    final Army armyOne;
    final Army armyTwo;

    private boolean hasWinner = false;

    /**
     * Battle constructor
     * @param armyOne army 1
     * @param armyTwo army 2
     */
    public Battle(Army armyOne, Army armyTwo) throws IllegalArgumentException {
        if (!(armyOne instanceof Army) || !(armyTwo instanceof Army)) {
            throw new IllegalArgumentException("Passed object must be an instance of Army class.");
        } else {
            this.armyOne = armyOne;
            this.armyTwo = armyTwo;
        }
    }

    /**
     * Simulates a battle until hasWinner is true.
     * Battle is won when one of the armies is empty of units.
     * @return winner army
     */
    public Army simulate() {
        Unit randomUnit1;
        Unit randomUnit2;

        while (!hasWinner) {
            if (armyOne.hasUnits() && armyTwo.hasUnits()) {

                randomUnit1 = armyOne.getRandom();
                randomUnit2 = armyTwo.getRandom();

                randomUnit1.attack(randomUnit2);

                if (randomUnit2.getHealth() == 0) {
                    armyTwo.remove(randomUnit2);
                }

                if (armyTwo.hasUnits()) {
                    randomUnit1 = armyOne.getRandom();
                    randomUnit2 = armyTwo.getRandom();

                    randomUnit2.attack(randomUnit1);

                    if (randomUnit1.getHealth() == 0) {
                        armyOne.remove(randomUnit1);
                    }
                }
            } else if (!armyOne.hasUnits()) {
                hasWinner = true;
                return armyTwo;
            } else if (!armyTwo.hasUnits()) {
                hasWinner = true;
                return armyOne;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
