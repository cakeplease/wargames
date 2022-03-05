package no.ntnu.katarzsz;

public class CavalryUnit extends Unit {

    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    public int getAttackBonus() {
        if (this.attackCount == 0) {
            return 6;
        }
        return 2;
    }

    public int getResistBonus() {
        return 1;
    }
}
