package no.ntnu.katarzsz;

abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;
    protected int gotAttackedCount = 0;

    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public void attack(Unit opponent) {
        int attackValue = 0;

        attackValue = opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.getAttacked();
        opponent.setHealth(attackValue);
    }

    protected void getAttacked() {
        this.gotAttackedCount++;
    }

    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getArmor() {
        return this.armor;
    }
    private void setHealth(int health) {
        if (this.health != 0) {
            if ((this.health - health) < 0) {
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
