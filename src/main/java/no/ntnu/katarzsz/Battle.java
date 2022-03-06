package no.ntnu.katarzsz;

/**
 * Battle class
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;

    private boolean hasWinner = false;

    /**
     * Battle constructor
     * @param armyOne
     * @param armyTwo
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
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
                System.out.println("------New round!------");
                System.out.println("Both armies have units left.");
                System.out.println("Units from ArmyOne: "+armyOne.getAllUnits().toString());
                System.out.println("Units from ArmyTwo: "+armyTwo.getAllUnits().toString());

                randomUnit1 = armyOne.getRandom();
                randomUnit2 = armyTwo.getRandom();

                System.out.println(randomUnit1 +" attacks "+ randomUnit2);
                randomUnit1.attack(randomUnit2);
                System.out.println("Unit\'s health after attack: "+randomUnit2.getHealth());

                if (randomUnit2.getHealth() == 0) {
                    System.out.println(randomUnit2+ " is getting removed from army.");
                    armyTwo.remove(randomUnit2);
                }
                if (armyTwo.hasUnits()) {
                    randomUnit1 = armyOne.getRandom();
                    randomUnit2 = armyTwo.getRandom();

                    System.out.println(randomUnit2 +" attacks "+ randomUnit1);

                    randomUnit2.attack(randomUnit1);
                    System.out.println("Unit\'s health after attack: "+randomUnit1.getHealth());

                    if (randomUnit1.getHealth() == 0) {
                        System.out.println(randomUnit1+ " is getting removed from army.");
                        armyOne.remove(randomUnit1);
                    }
                }
            } else if (!armyOne.hasUnits()) {
                System.out.println("ArmyTwo won!");
                hasWinner = true;
                return armyTwo;
            } else if (!armyTwo.hasUnits()) {
                System.out.println("ArmyOne won!");
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
