package no.ntnu.katarzsz.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.base.Battle;
import no.ntnu.katarzsz.base.BattleSimulationResult;
import no.ntnu.katarzsz.base.Terrain;
import no.ntnu.katarzsz.controller.ArmyController;
import no.ntnu.katarzsz.controller.GUIController;
import no.ntnu.katarzsz.controller.ScreenController;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GameView class extending View
 * Used to show main game screen with armies, menu panel and battle simulation output
 */
public class GameView extends View {
    protected GridPane pane;
    private ScreenController screenController;
    private Path path;

    //Army 1
    private ScrollPane army1Pane;
    private VBox army1Info;
    private VBox units1Info;
    private Text army1Name;
    private Button loadArmy1Button;
    private Army army1;
    private Text army1FilePath;
    private Text army1UnitNumber;
    private Text army1InfantryUnitNumber;
    private Text army1CommanderUnitNumber;
    private Text army1RangedUnitNumber;
    private Text army1CavalryUnitNumber;
    private Text army1UnitsText;
    private Text army1UnitInfo;

    //Army 2
    private ScrollPane army2Pane;
    private VBox army2Info;
    private VBox units2Info;
    private Text army2Name;
    private Army army2;
    private Button loadArmy2Button;
    private Text army2FilePath;
    private Text army2UnitNumber;
    private Text army2InfantryUnitNumber;
    private Text army2CommanderUnitNumber;
    private Text army2RangedUnitNumber;
    private Text army2CavalryUnitNumber;
    Text army2UnitsText;
    Text army2UnitInfo;

    private Terrain terrain;
    private Battle battle;
    private Text simulationText = new Text("Battle simulation");
    private Text errorText = new Text();

    /**
     * Constructor which takes in screenController used to change between panes
     * Can be used to expand the project with more panes/views
     * @param screenController
     */
    public GameView(ScreenController screenController) {
        //main pane
        this.pane = new GridPane();
        this.screenController = screenController;
        //sets up everything that we can see in this screen
        this.setup();
    }

    public Pane getPane() {
        return this.pane;
    }

    /**
     * Setup method sets up army-boxes, menu with buttons as well as the battle simulation box
     */
    public void setup() {
        errorText.setFill(Color.RED);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(100);
        pane.getColumnConstraints().addAll(column1, column2);

        //Army 1 setup
        army1Pane = new ScrollPane();
        army1Pane.setPadding(new Insets(10, 10, 10, 10));
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

        army1UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        army1UnitInfo = new Text("");

        loadArmy1Button.setOnAction(e -> {
            path = GUIController.uploadArmy();
            army1FilePath.setText(path.toString());
            army1 = ArmyController.readArmyFromFile(path);
            army1Name.setText(army1.getName());
            updateArmy1Info();
        });

        units1Info.getChildren().addAll(army1UnitsText, army1UnitInfo);
        army1Info.getChildren().addAll(army1Name, loadArmy1Button,army1FilePath,army1UnitNumber,army1InfantryUnitNumber, army1CommanderUnitNumber,army1RangedUnitNumber, army1CavalryUnitNumber,units1Info);
        army1Pane.setContent(army1Info);

        GridPane.setConstraints(army1Pane, 0, 0);

        //Army 2
        army2Pane = new ScrollPane();
        army2Pane.setPadding(new Insets(10, 10, 10, 10));
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

        army2UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        army2UnitInfo = new Text("");

        loadArmy2Button.setOnAction(e -> {
            path = GUIController.uploadArmy();
            army2FilePath.setText(path.toString());
            army2 = ArmyController.readArmyFromFile(path);
            army2Name.setText(army2.getName());

            updateArmy2Info();
        });

        units2Info.getChildren().addAll(army2UnitsText, army2UnitInfo);
        army2Info.getChildren().addAll(army2Name, loadArmy2Button,army2FilePath,army2UnitNumber,army2InfantryUnitNumber, army2CommanderUnitNumber,army2RangedUnitNumber, army2CavalryUnitNumber,units2Info);
        army2Pane.setContent(army2Info);

        GridPane.setConstraints(army2Pane, 1, 0);

        pane.setPadding(new Insets(50, 50, 50, 50));
        pane.getChildren().addAll(army1Pane,army2Pane);

        //MENU with buttons
        VBox menuPane = new VBox();
        Button resetButton = new Button("Reset armies");

        //resets armies to the original condition from the files
        resetButton.setOnAction(e -> {
            errorText.setText("");
            army1 = ArmyController.readArmyFromFile(Paths.get(army1FilePath.getText()));
            army2 = ArmyController.readArmyFromFile(Paths.get(army2FilePath.getText()));

            updateArmiesInfo();

            simulationText.setText("Battle simulation");

        });

        //terrain select box
        ComboBox terrainSelect = new ComboBox();
        terrainSelect.getItems().add("Select terrain");
        terrainSelect.getSelectionModel().selectFirst();

        for (Terrain terrain : Terrain.values()) {
            terrainSelect.getItems().add(terrain);
        }

        //BATTLE START
        Button startBattleButton = new Button("Start battle");
        startBattleButton.setOnAction(e -> {
            errorText.setText("");

            //some requirements to run battle
            if (terrainSelect.getValue().toString().equals("Select terrain")) {
                errorText.setText("Please choose terrain before starting battle.");
                return;
            } else {
                terrain = (Terrain) terrainSelect.getValue();
            }

            if (army1 == null || army2 == null) {
                errorText.setText("Please load armies before starting battle.");
                return;
            }

            if (!army1.hasUnits() || !army2.hasUnits()) {
                errorText.setText("Please reset armies first in order to start a new battle.");
                return;
            }

            //Everything went fine, we can reset error text and proceed to simulation
            errorText.setText("");
            battle = new Battle(army1,army2, terrain);
            BattleSimulationResult battleRes = battle.simulate();
            simulationText.setText(battleRes.simulationText());
            updateArmiesInfo();
        });

        //quit button
        Button exitButton = new Button();
        exitButton.setText("Quit game");
        exitButton.setOnAction(e -> System.exit(0));
        menuPane.setAlignment(Pos.TOP_CENTER);
        menuPane.setSpacing(20);
        menuPane.setPadding(new Insets(10, 10, 10, 10));

        //button styling
        resetButton.setStyle("-fx-min-width: 120; -fx-min-height: 40");
        terrainSelect.setStyle("-fx-min-width: 120; -fx-min-height: 40");
        startBattleButton.setStyle("-fx-min-width: 120; -fx-min-height: 40");
        exitButton.setStyle("-fx-min-width: 120; -fx-min-height: 40");

        menuPane.getChildren().addAll(resetButton, terrainSelect, startBattleButton,exitButton, errorText);
        GridPane.setConstraints(menuPane, 3, 0);
        pane.getChildren().add(menuPane);

        //Battle simulation output pane
        ScrollPane simulationPane = new ScrollPane();
        VBox simulationInfo = new VBox();
        simulationInfo.getChildren().addAll(simulationText);
        simulationPane.setContent(simulationInfo);
        GridPane.setConstraints(simulationPane, 0, 1);
        GridPane.setColumnSpan(simulationPane, 2);
        pane.getChildren().add(simulationPane);
    }

    public void resetPane() {
        pane.getChildren().clear();
    }

    public void updateArmiesInfo() {
        updateArmy1Info();
        updateArmy2Info();
    }
    public void updateArmy1Info() {
        army1UnitNumber.setText("Number of units: " + army1.getAllUnits().size());
        army1InfantryUnitNumber.setText("Infantry units: " + army1.getInfantryUnits().size());
        army1CommanderUnitNumber.setText("Commander units: " + army1.getCommanderUnits().size());
        army1RangedUnitNumber.setText("Ranged units: " + army1.getRangedUnits().size());
        army1CavalryUnitNumber.setText("Cavalry units: " + army1.getCavalryUnits().size());
        army1UnitInfo.setText(army1.getAllUnitsInCsvFormat());
    }
    public void updateArmy2Info() {
        army2UnitNumber.setText("Number of units: " + army2.getAllUnits().size());
        army2InfantryUnitNumber.setText("Infantry units: " + army2.getInfantryUnits().size());
        army2CommanderUnitNumber.setText("Commander units: " + army2.getCommanderUnits().size());
        army2RangedUnitNumber.setText("Ranged units: " + army2.getRangedUnits().size());
        army2CavalryUnitNumber.setText("Cavalry units: " + army2.getCavalryUnits().size());
        army2UnitInfo.setText(army2.getAllUnitsInCsvFormat());
    }
}