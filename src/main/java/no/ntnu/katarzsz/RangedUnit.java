package no.ntnu.katarzsz;

public class RangedUnit extends Unit{

    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public RangedUnit(String name, int health) {
        super(name, health, 15,8);
    }

    public int getAttackBonus() {
        return 3;
    }

    public int getResistBonus() {

        if (this.gotAttackedCount == 0) {
            return 6;
        } else if (this.gotAttackedCount == 1) {
            return 4;
        }

        return 2;
    }
}
