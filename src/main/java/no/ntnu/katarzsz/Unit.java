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
        int attackValue = 0;
        attackValue = (this.getAttack() + this.getAttackBonus());
        opponent.getAttacked();
        this.registerAttack();
        opponent.setHealth(attackValue);
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
     * Sets health based on unit's total health - (health + armor + resist bonus) minus attack value passed in
     * @param attackValue
     */
    private void setHealth(int attackValue) {
        if (this.health != 0) {
            int totalHealth = this.health + this.getArmor() + this.getResistBonus();
            if ((totalHealth - attackValue) <= 0) {
                this.health = 0;
            } else {
                this.health = totalHealth - attackValue;
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
