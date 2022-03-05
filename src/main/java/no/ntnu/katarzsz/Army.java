package no.ntnu.katarzsz;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;

public class Army {
    private String name;
    private List<Unit> units;

    public Army(String name) {
        this.name = name;
    }
    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }
    private String getName() {
        return this.name;
    }
    private void add(Unit unit) {
        this.units.add(unit);
    }
    private void addAll(List<Unit> units) {
        //check if this actually works
        this.units = Stream.concat(this.units.stream(), units.stream()).collect(Collectors.toList());
    }
    private void remove(List<Unit> unit) {
        this.units.remove(unit);
    }
    private boolean hasUnits() {
        if (this.units.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    /*private List<Unit> getAllUnits() {
        //Clone this.units and return cloned list
    }*/

    private Unit getRandom() {
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
