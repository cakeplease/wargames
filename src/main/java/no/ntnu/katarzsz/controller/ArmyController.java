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

    public static Army readArmyFromFile(File file) {
        Army army = null;
        Path filePath =  Paths.get(file.getPath());
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
    * Upload army
    */
    public static Path uploadArmy(Path path) {
        Path temporaryFilePath = Paths.get(file.getPath());
        Path filePath = Paths.get("src/main/resources/"+file.getName());
        if (!Files.exists(temporaryFilePath)) {
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
