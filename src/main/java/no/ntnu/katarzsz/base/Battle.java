package no.ntnu.katarzsz.base;

/**
 * Battle class
 */
public class Battle {
    final Army armyOne;
    final Army armyTwo;
    private Terrain terrain;

    private boolean hasWinner = false;

    /**
     * Battle constructor
     * @param armyOne army 1
     * @param armyTwo army 2
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) throws IllegalArgumentException {
        if (!(armyOne instanceof Army) || !(armyTwo instanceof Army)) {
            throw new IllegalArgumentException("Passed object must be an instance of Army class.");
        } else {
            this.armyOne = armyOne;
            this.armyTwo = armyTwo;
            this.terrain = terrain;
        }
    }

    /**
     * Simulates a battle until hasWinner is true.
     * Battle is won when one of the armies is empty of units.
     * @return winner army
     */
    public BattleSimulationResult simulate() {
        Unit randomUnit1;
        Unit randomUnit2;

        String simulationText = "";
        simulationText += "Welcome to WARGAMES! \n Let\'s get started!\n";
        simulationText += "Chosen terrain: "+terrain+"\n";
        while (!hasWinner) {
            if (armyOne.hasUnits() && armyTwo.hasUnits()) {
                randomUnit1 = armyOne.getRandom();
                randomUnit2 = armyTwo.getRandom();

                randomUnit1.setTerrain(terrain);
                randomUnit2.setTerrain(terrain);
                simulationText += "------New round!------ \n";

                simulationText += randomUnit1 +" attacks "+ randomUnit2+"\n";
                randomUnit1.attack(randomUnit2);
                simulationText += "Unit\'s health after attack: "+randomUnit2.getHealth()+"\n";

                if (randomUnit2.getHealth() == 0) {
                    simulationText += randomUnit2+ " is getting removed from army.\n";
                    armyTwo.remove(randomUnit2);
                }

                if (armyTwo.hasUnits()) {

                    randomUnit1 = armyOne.getRandom();
                    randomUnit2 = armyTwo.getRandom();

                    randomUnit1.setTerrain(terrain);
                    randomUnit2.setTerrain(terrain);

                    simulationText += randomUnit2 +" attacks "+ randomUnit1+"\n";
                    randomUnit2.attack(randomUnit1);
                    simulationText += "Unit\'s health after attack: "+randomUnit1.getHealth()+"\n";


                    if (randomUnit1.getHealth() == 0) {
                        simulationText += randomUnit1+ " is getting removed from army. \n";
                        armyOne.remove(randomUnit1);
                    }
                }
            } else if (!armyOne.hasUnits()) {
                hasWinner = true;
                simulationText += armyTwo.getName() + " won! \n";
                return new BattleSimulationResult(armyTwo, simulationText);

            } else if (!armyTwo.hasUnits()) {
                hasWinner = true;
                simulationText += armyOne.getName() + " won! \n";
                return new BattleSimulationResult(armyOne, simulationText);
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
