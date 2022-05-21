package no.ntnu.katarzsz.base;

import java.util.Objects;

public record BattleSimulationResult(Army winnerArmy, String simulationText) {
    public BattleSimulationResult {
        Objects.requireNonNull(winnerArmy);
        Objects.requireNonNull(simulationText);
    }
}
