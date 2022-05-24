package no.ntnu.katarzsz.controller;

import no.ntnu.katarzsz.base.Army;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class ArmyControllerTest {
    @Test
    public void isArmyGettingReturned() {
        Path filePath = Paths.get("src/main/resources/test_data/the-army.csv");
        assertTrue(ArmyController.readArmyFromFile(filePath) instanceof Army);
    }

    @Test
    public void isRightArmyNameReturned() {
        Path filePath = Paths.get("src/main/resources/test_data/the-army.csv");
        assertTrue(ArmyController.readArmyFromFile(filePath).getName().equals("The army"));
    }

    @Test
    public void returnCorrectNumberOfCavalryFromFile() {
        Path filePath = Paths.get("src/main/resources/test_data/the-army.csv");
        assertEquals(ArmyController.readArmyFromFile(filePath).getCavalryUnits().size(), 2);
    }

    @Test
    public void returnCorrectNumberOfCommanderUnitsFromFile() {
        Path filePath = Paths.get("src/main/resources/test_data/the-army.csv");
        assertEquals(ArmyController.readArmyFromFile(filePath).getCommanderUnits().size(), 2);
    }

    @Test
    public void returnCorrectNumberOfInfantryUnitsFromFile() {
        Path filePath = Paths.get("src/main/resources/test_data/the-army.csv");
        assertEquals(ArmyController.readArmyFromFile(filePath).getInfantryUnits().size(), 2);
    }

    @Test
    public void detectIncorrectlyFormattedFile() {
        Path filePath = Paths.get("src/main/resources/test_data/fake-army.csv");
        assertThrows(RuntimeException.class, () -> {
            ArmyController.readArmyFromFile(filePath);
        });
    }
}
