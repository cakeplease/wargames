package no.ntnu.katarzsz.base;

import java.util.Objects;

/**
 * BattleSimulationResult record used in battle simulation
 * @param winnerArmy
 * @param simulationText
 */
public record BattleSimulationResult(Army winnerArmy, String simulationText) {
    public BattleSimulationResult {
        Objects.requireNonNull(winnerArmy);
        Objects.requireNonNull(simulationText);
    }
}
