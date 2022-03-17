package no.ntnu.katarzsz;

/**
 * Unit class - template for other unit classes
 */
abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;
    protected int gotAttackedCount = 0;
    protected int attackCount = 0;

    /**
     * Unit constructor with all arguments
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        this.name = name;

        if (health <= 0) {
            throw new IllegalArgumentException("Health value must be over 0.");
        } else {
            this.health = health;
        }
        if (attack <= 0) {
            throw new IllegalArgumentException("Attack value must be over 0.");
        } else {
            this.attack = attack;
        }
        
        this.armor = armor;
    }

    /**
     * Attack method
     * @param opponent
     */
    public void attack(Unit opponent) {
        /*int attackValue = 0;
        attackValue = (this.getAttack() + this.getAttackBonus());*/

        int health = opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.getAttacked();
        this.registerAttack();
        opponent.setHealth(health);
    }

    /**
     * Registers attack, used for calculating attackBonus
     */
    protected void registerAttack() {
        this.attackCount++;
    }

    /**
     * Registers being attacked, used for calculating resist bonus
     */
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

    /**
     * Sets health
     * @param health
     */
    private void setHealth(int health) {
            if (health <= 0) {
                this.health = 0;
            } else {
                this.health = health;
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
