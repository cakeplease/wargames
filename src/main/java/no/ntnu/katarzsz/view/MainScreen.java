package no.ntnu.katarzsz.view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.base.Battle;
import no.ntnu.katarzsz.base.BattleSimulationResult;
import no.ntnu.katarzsz.base.Terrain;
import no.ntnu.katarzsz.controller.ArmyController;
import no.ntnu.katarzsz.controller.BattleController;
import no.ntnu.katarzsz.controller.GUIController;
import no.ntnu.katarzsz.controller.ScreenController;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainScreen extends View {
    protected GridPane pane;
    private ScreenController screenController;

    Path path;

    ScrollPane army1Pane;
    VBox army1Info;
    VBox units1Info;
    Text army1Name;
    Button loadArmy1Button;
    Army army1;
    Text army1FilePath;
    Text army1UnitNumber;
    Text army1InfantryUnitNumber;
    Text army1CommanderUnitNumber;
    Text army1RangedUnitNumber;
    Text army1CavalryUnitNumber;

    ScrollPane army2Pane;
    VBox army2Info;
    VBox units2Info;
    Text army2Name;
    Army army2;
    Button loadArmy2Button;
    Text army2FilePath;
    Text army2UnitNumber;
    Text army2InfantryUnitNumber;
    Text army2CommanderUnitNumber;
    Text army2RangedUnitNumber;
    Text army2CavalryUnitNumber;

    Army army1Battle;
    Army army2Battle;
    Terrain terrain;
    Battle battle;
    Army winnerArmy;
    Text simulationText = new Text("Battle simulation");

    public MainScreen(ScreenController screenController) {
        this.pane = new GridPane();
        this.screenController = screenController;
        this.setup();
    }

    public Pane getPane() {
        return this.pane;
    }

    public void setup() {
        this.resetPane();

        BattleController battleController = BattleController.getInstance();

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(100);
        pane.getColumnConstraints().addAll(column1, column2); // each get 50% of width


        army1Pane = new ScrollPane();
        army1Pane.setMinHeight(250);
        army1Info = new VBox();
        units1Info = new VBox();

        army1Name = new Text("Army 1");
        loadArmy1Button = new Button("Load");
        army1FilePath = new Text("");
        army1UnitNumber = new Text("Number of units: -");
        army1InfantryUnitNumber = new Text("Infantry units: -");
        army1CommanderUnitNumber = new Text("Commander units: -");
        army1RangedUnitNumber = new Text("Ranged units: -");
        army1CavalryUnitNumber = new Text("Cavalry units: -");

        Text army1UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        Text army1UnitInfo = new Text("");


        loadArmy1Button.setOnAction(e -> {
            path = GUIController.uploadArmy();
            army1FilePath.setText(path.toString());
            army1 = ArmyController.readArmyFromFile(path);
            //battleController.addArmy1(army1);
            army1Name.setText(army1.getName());
            army1UnitNumber.setText("Number of units: " + army1.getAllUnits().size());
            army1InfantryUnitNumber.setText("Infantry units: " + army1.getInfantryUnits().size());
            army1CommanderUnitNumber.setText("Commander units: " + army1.getCommanderUnits().size());
            army1RangedUnitNumber.setText("Ranged units: " + army1.getRangedUnits().size());
            army1CavalryUnitNumber.setText("Cavalry units: " + army1.getCavalryUnits().size());
            army1UnitInfo.setText(army1.getAllUnitsInCsvFormat());

        });

        units1Info.getChildren().addAll(army1UnitsText, army1UnitInfo);
        army1Info.getChildren().addAll(army1Name, loadArmy1Button,army1FilePath,army1UnitNumber,army1InfantryUnitNumber, army1CommanderUnitNumber,army1RangedUnitNumber, army1CavalryUnitNumber,units1Info);
        army1Pane.setContent(army1Info);

        GridPane.setConstraints(army1Pane, 0, 0);

        //army2
        army2Pane = new ScrollPane();
        army2Pane.setMinHeight(250);

        army2Info = new VBox();
        units2Info = new VBox();

        army2Name = new Text("Army 2");
        loadArmy2Button = new Button("Load");
        army2FilePath = new Text("");
        army2UnitNumber = new Text("Number of units: -");
        army2InfantryUnitNumber = new Text("Infantry units: -");
        army2CommanderUnitNumber = new Text("Commander units: -");
        army2RangedUnitNumber = new Text("Ranged units: -");
        army2CavalryUnitNumber = new Text("Cavalry units: -");

        Text army2UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        Text army2UnitInfo = new Text("");


        loadArmy2Button.setOnAction(e -> {
            path = GUIController.uploadArmy();
            army2FilePath.setText(path.toString());
            army2 = ArmyController.readArmyFromFile(path);
            army2Name.setText(army2.getName());
            army2UnitNumber.setText("Number of units: " + army2.getAllUnits().size());
            army2InfantryUnitNumber.setText("Infantry units: " + army2.getInfantryUnits().size());
            army2CommanderUnitNumber.setText("Commander units: " + army2.getCommanderUnits().size());
            army2RangedUnitNumber.setText("Ranged units: " + army2.getRangedUnits().size());
            army2CavalryUnitNumber.setText("Cavalry units: " + army2.getCavalryUnits().size());
            army2UnitInfo.setText(army2.getAllUnitsInCsvFormat());
        });

        units2Info.getChildren().addAll(army2UnitsText, army2UnitInfo);
        army2Info.getChildren().addAll(army2Name, loadArmy2Button,army2FilePath,army2UnitNumber,army2InfantryUnitNumber, army2CommanderUnitNumber,army2RangedUnitNumber, army2CavalryUnitNumber,units2Info);
        army2Pane.setContent(army2Info);

        GridPane.setConstraints(army2Pane, 1, 0);

        pane.getChildren().addAll(army1Pane,army2Pane);

        //MENU
        VBox menuPane = new VBox();
        Button resetButton = new Button("Reset armies");

        resetButton.setOnAction(e -> {
            army1 = ArmyController.readArmyFromFile(Paths.get(army1FilePath.getText()));
            army2 = ArmyController.readArmyFromFile(Paths.get(army2FilePath.getText()));

            army1UnitNumber.setText("Number of units: " + army1.getAllUnits().size());
            army1InfantryUnitNumber.setText("Infantry units: " + army1.getInfantryUnits().size());
            army1CommanderUnitNumber.setText("Commander units: " + army1.getCommanderUnits().size());
            army1RangedUnitNumber.setText("Ranged units: " + army1.getRangedUnits().size());
            army1CavalryUnitNumber.setText("Cavalry units: " + army1.getCavalryUnits().size());
            army1UnitInfo.setText(army1.getAllUnitsInCsvFormat());

            army2UnitNumber.setText("Number of units: " + army2.getAllUnits().size());
            army2InfantryUnitNumber.setText("Infantry units: " + army2.getInfantryUnits().size());
            army2CommanderUnitNumber.setText("Commander units: " + army2.getCommanderUnits().size());
            army2RangedUnitNumber.setText("Ranged units: " + army2.getRangedUnits().size());
            army2CavalryUnitNumber.setText("Cavalry units: " + army2.getCavalryUnits().size());
            army2UnitInfo.setText(army2.getAllUnitsInCsvFormat());

            simulationText.setText("Battle simulation");

        });

        ComboBox terrainSelect = new ComboBox();
        terrainSelect.getItems().add("Select terrain");
        terrainSelect.getSelectionModel().selectFirst();

        for (Terrain terrain : Terrain.values()) {
            terrainSelect.getItems().add(terrain);
        }

        //BATTLE START

        Button startBattleButton = new Button("Start battle");

        startBattleButton.setOnAction(e -> {
            /*army1 = battleController.getArmy1();
            army2 = battleController.getArmy2();*/
            terrain = (Terrain) terrainSelect.getValue();
            battle = new Battle(army1,army2, terrain);
            BattleSimulationResult battleRes = battle.simulate();
            winnerArmy = battleRes.winnerArmy();
            simulationText.setText(battleRes.simulationText());

            /*battleController.addArmy1(battle.getArmyOne());
            battleController.addArmy2(battle.getArmyTwo());
            battleController.setWinnerArmy(winnerArmy);*/

            army1UnitNumber.setText("Number of units: " + army1.getAllUnits().size());
            army1InfantryUnitNumber.setText("Infantry units: " + army1.getInfantryUnits().size());
            army1CommanderUnitNumber.setText("Commander units: " + army1.getCommanderUnits().size());
            army1RangedUnitNumber.setText("Ranged units: " + army1.getRangedUnits().size());
            army1CavalryUnitNumber.setText("Cavalry units: " + army1.getCavalryUnits().size());
            army1UnitInfo.setText(army1.getAllUnitsInCsvFormat());

            army2UnitNumber.setText("Number of units: " + army2.getAllUnits().size());
            army2InfantryUnitNumber.setText("Infantry units: " + army2.getInfantryUnits().size());
            army2CommanderUnitNumber.setText("Commander units: " + army2.getCommanderUnits().size());
            army2RangedUnitNumber.setText("Ranged units: " + army2.getRangedUnits().size());
            army2CavalryUnitNumber.setText("Cavalry units: " + army2.getCavalryUnits().size());
            army2UnitInfo.setText(army2.getAllUnitsInCsvFormat());
        });
       /* ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(100);
        pane.getColumnConstraints().add(column3);*/

        Button exitButton = new Button();
        exitButton.setText("Quit game");
        exitButton.setOnAction(e -> System.exit(0));
        menuPane.getChildren().addAll(resetButton, terrainSelect, startBattleButton,exitButton);
        GridPane.setConstraints(menuPane, 3, 0);
        pane.getChildren().add(menuPane);

        ScrollPane simulationPane = new ScrollPane();
        VBox simulationInfo = new VBox();

        simulationInfo.getChildren().addAll(simulationText);

        simulationPane.setContent(simulationInfo);
        GridPane.setConstraints(simulationPane, 0, 1);
        GridPane.setColumnSpan(simulationPane, 2);
        pane.getChildren().add(simulationPane);
    }

    public void resetPane() {
        this.pane.getChildren().clear();
    }
}
