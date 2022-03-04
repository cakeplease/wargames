package no.ntnu.katarzsz;

abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    private void attack(Unit opponent) {
        int attackValue = 0;

        attackValue = opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.setHealth(attackValue);
    }

    private String getName() {
        return this.name;
    }
    private int getHealth() {
        return this.health;
    }
    private int getAttack() {
        return this.attack;
    }
    private int getArmor() {
        return this.armor;
    }
    private void setHealth(int health) {
        if (this.health != 0) {
            if (this.health - health < 0) {
                this.health = 0;
            } else {
                this.health -= health;
            }
        }
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }

    abstract int getAttackBonus();
    abstract int getResistBonus();

}
