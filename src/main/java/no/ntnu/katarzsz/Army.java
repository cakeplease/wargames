package no.ntnu.katarzsz;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Army class
 */
public class Army {
    private String name;
    private List<Unit> units = new ArrayList<Unit>();

    /**
     * Army constructor with only name
     * @param name
     */
    public Army(String name) {
        this.name = name;
    }

    /**
     * Army constructor with name and units
     * @param name
     * @param units list of units
     */
    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }
    public String getName() {
        return this.name;
    }

    /**
     * Adds unit to army
     * @param unit
     * @return true on success, false on failure
     */
    public boolean add(Unit unit) {
        return this.units.add(unit);
    }

    /**
     * Adds a list of units to army
     * @param units
     * @return true on success, false on failure
     */
    public boolean addAll(List<Unit> units) {
        return this.units.addAll(units);
    }

    /**
     * Removes a unit from army
     * @param unit
     * @return true on success, false on failure
     */
    public boolean remove(Unit unit) {
        return this.units.remove(unit);
    }

    /**
     * Checks if army has units
     * @return true on success, false on failure
     */
    public boolean hasUnits() {
        if (this.units.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets all units in army
     * @return a list of units
     */
    public List<Unit> getAllUnits() {
        return this.units;
    }
    /**
     * Get all infantry units
     * @return a list of infantry units
     */
    public List<Unit> getInfantryUnits() {
        return this.units.stream().filter(u -> u instanceof InfantryUnit).collect(Collectors.toList());
    }
    /**
     * Get all cavalry units
     * @return a list of cavalry units
     */
    public List<Unit> getCavalryUnits() {
        return this.units.stream().filter(u -> u instanceof CavalryUnit).collect(Collectors.toList());
    }
    /**
     * Get all ranged units
     * @return a list of ranged units
     */
    public List<Unit> getRangedUnits() {
        return this.units.stream().filter(u -> u instanceof RangedUnit).collect(Collectors.toList());
    }
    /**
     * Get all commander units
     * @return a list of commander units
     */
    public List<Unit> getCommanderUnits() {
        return this.units.stream().filter(u -> u instanceof CommanderUnit).collect(Collectors.toList());
    }

    /**
     * Gets random unit from army
     * @return random unit
     */
    public Unit getRandom() {
        Random randomNumber = new Random();
        int min = 0;
        int max = this.units.size();
        int random = randomNumber.nextInt(max - min) + min;

        return this.units.get(random);
    }

    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }
}
