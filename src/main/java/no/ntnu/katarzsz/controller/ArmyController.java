package no.ntnu.katarzsz.controller;

import no.ntnu.katarzsz.base.*;
import no.ntnu.katarzsz.model.DataHandler;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * ArmyController class
 */
public class ArmyController {
    /**
     * Saves army to a file under resources folder
     */
    public static void saveArmyToFile(Army army) {
        String data = "";
        String escapedName = army.getName().replace(" ", "-").toLowerCase();
        Path filePath = Paths.get("src/main/resources/"+escapedName+".csv");
        data += army.getName()+"\n";
        for (Unit unit : army.getAllUnits()) {
            data += unit.getClass().getSimpleName()+","+unit.getName()+","+unit.getHealth()+"\n";
        }

        DataHandler.saveToFile(data, filePath);
    }

    /**
     * Reads Army from a file
     * @param filePath
     * @return Army object
     */
    public static Army readArmyFromFile(Path filePath) {
        Army army = null;
        if (Files.exists(filePath)) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
                String line;
                String splitBy = ",";
                String armyName = null;
                ArrayList<Unit> units = new ArrayList<>();

                while ((line = bufferedReader.readLine()) != null) {
                    if (armyName == null) {
                        armyName = line;
                    } else {
                        String[] unit = line.split(splitBy);
                        String unitType = unit[0].toString();

                        switch (unitType) {
                            case "InfantryUnit":
                                InfantryUnit infantryUnit = new InfantryUnit(unit[1].toString(), Integer.parseInt(unit[2].toString()));
                                units.add(infantryUnit);
                                break;
                            case "CommanderUnit":
                                CommanderUnit commanderUnit = new CommanderUnit(unit[1].toString(), Integer.parseInt(unit[2].toString()));
                                units.add(commanderUnit);
                                break;
                            case "CavalryUnit":
                                CavalryUnit cavalryUnit = new CavalryUnit(unit[1].toString(), Integer.parseInt(unit[2].toString()));
                                units.add(cavalryUnit);
                                break;
                            case "RangedUnit":
                                RangedUnit rangedUnit = new RangedUnit(unit[1].toString(), Integer.parseInt(unit[2].toString()));
                                units.add(rangedUnit);
                                break;
                            default:
                                System.out.println("Invalid unit type");
                        }
                    }
                }
                army = new Army(armyName, units);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return army;
    }

    /**
    * Upload army to project files (resources)
    */
    public static Path uploadArmy(File file) {
        Path temporaryFilePath = Paths.get(file.getPath());
        Path filePath = Paths.get("src/main/resources/"+file.getName());
        if (!Files.exists(filePath)) {
            String data = "";
            try (BufferedReader bufferedReader = Files.newBufferedReader(temporaryFilePath)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    data += line+"\n";
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

            try {
                Files.writeString(filePath, data, StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }
}
