package no.ntnu.katarzsz.controller;

import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.base.Terrain;

public class BattleController {
    Army army1;
    Army army2;
    Terrain terrain;
    Army winnerArmy;

    private static BattleController battleController = new BattleController();

    public static BattleController getInstance() {
        return battleController;
    }

    public void addArmy1(Army army) {
        this.army1 = army;
    }

    public void addArmy2(Army army) {
        this.army2 = army;
    }

    public void setWinnerArmy(Army winnerArmy) {
        this.winnerArmy = winnerArmy;
    }

    public void changeTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Army getArmy1() {
        return this.army1;
    }

    public Army getArmy2() {
        return this.army2;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

}
