package no.ntnu.katarzsz;

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    private boolean hasWinner = false;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    private Army simulate() {
        while (this.hasWinner == false) {
            if (this.armyOne.hasUnits() && this.armyTwo.hasUnits()) {
                this.armyOne.getRandom().attack(this.armyTwo.getRandom());
                if (this.armyTwo.hasUnits()) {
                    this.armyTwo.getRandom().attack(this.armyOne.getRandom());
                }
            } else if (!this.armyOne.hasUnits()) {
                this.hasWinner = true;
                return this.armyOne;
            } else if (!this.armyTwo.hasUnits()) {
                this.hasWinner = true;
                return this.armyTwo;
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
