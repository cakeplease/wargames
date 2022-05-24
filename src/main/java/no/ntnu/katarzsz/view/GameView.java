package no.ntnu.katarzsz.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
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
    private Text welcomeText;

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
    private Text errorText = new Text("Feedback box: ");

    /**
     * Constructor which takes in screenController used to change between panes
     * Can be used to expand the project with more panes/views
     * @param screenController
     */
    public GameView(ScreenController screenController) {
        //main pane
        this.pane = new GridPane();
        this.pane.setId("background");

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
        VBox welcomeTextBox = new VBox();
        welcomeText = new Text("Welcome to Wargames!\nTo simulate battle load armies in .csv format and choose the terrain.\nThe simulation output will show in Battle simulation box.\nScroll to the bottom to see the winner army.");
        welcomeText.setId("welcome-text");
        welcomeTextBox.getChildren().add(welcomeText);
        welcomeTextBox.setAlignment(Pos.TOP_LEFT);
        welcomeTextBox.setPadding(new Insets(10, 20, 10, 0));

        //Army 1 setup
        army1Pane = new ScrollPane();
        army1Pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        army1Pane.setPadding(new Insets(10, 10, 10, 10));
        army1Info = new VBox();
        army1Info.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        units1Info = new VBox();
        units1Info.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        army1Name = new Text("Army 1");
        loadArmy1Button = new Button("Load");
        loadArmy1Button.setId("load-button");
        army1FilePath = new Text("");
        army1UnitNumber = new Text("Number of units: -");
        army1InfantryUnitNumber = new Text("Infantry units: -");
        army1CommanderUnitNumber = new Text("Commander units: -");
        army1RangedUnitNumber = new Text("Ranged units: -");
        army1CavalryUnitNumber = new Text("Cavalry units: -");

        army1UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        army1UnitInfo = new Text("");

        loadArmy1Button.setOnAction(e -> {
            errorText.setText("Feedback box: ");

            path = GUIController.uploadArmy();
            if (path != null) {
                army1FilePath.setText(path.toString());
                army1 = ArmyController.readArmyFromFile(path);
                army1Name.setText(army1.getName());
                updateArmy1Info();
            } else {
                errorText.setText("Something went wrong while uploading the file.");
            }

        });

        units1Info.getChildren().addAll(army1UnitsText, army1UnitInfo);
        army1Info.getChildren().addAll(army1Name, loadArmy1Button,army1FilePath,army1UnitNumber,army1InfantryUnitNumber, army1CommanderUnitNumber,army1RangedUnitNumber, army1CavalryUnitNumber,units1Info);
        army1Pane.setContent(army1Info);


        //Army 2
        army2Pane = new ScrollPane();
        army2Pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        army2Pane.setPadding(new Insets(10, 10, 10, 10));
        army2Info = new VBox();
        army2Info.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        units2Info = new VBox();
        units2Info.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        army2Name = new Text("Army 2");
        loadArmy2Button = new Button("Load");
        loadArmy2Button.setId("load-button");
        army2FilePath = new Text("");
        army2UnitNumber = new Text("Number of units: -");
        army2InfantryUnitNumber = new Text("Infantry units: -");
        army2CommanderUnitNumber = new Text("Commander units: -");
        army2RangedUnitNumber = new Text("Ranged units: -");
        army2CavalryUnitNumber = new Text("Cavalry units: -");

        army2UnitsText = new Text("Units (unit type, name, health, armour, attack):");
        army2UnitInfo = new Text("");

        loadArmy2Button.setOnAction(e -> {
            errorText.setText("Feedback box: ");
            path = GUIController.uploadArmy();
            if (path != null) {
                army2FilePath.setText(path.toString());
                army2 = ArmyController.readArmyFromFile(path);
                army2Name.setText(army2.getName());
                updateArmy2Info();
            } else {
                errorText.setText("Something went wrong while uploading file");
            }

        });

        units2Info.getChildren().addAll(army2UnitsText, army2UnitInfo);
        army2Info.getChildren().addAll(army2Name, loadArmy2Button,army2FilePath,army2UnitNumber,army2InfantryUnitNumber, army2CommanderUnitNumber,army2RangedUnitNumber, army2CavalryUnitNumber,units2Info);
        army2Pane.setContent(army2Info);

        //MENU with buttons
        VBox menuPane = new VBox();
        Button resetButton = new Button("Reset armies");

        //resets armies to the original condition from the files
        resetButton.setOnAction(e -> {
            errorText.setText("Feedback box: ");
            army1 = ArmyController.readArmyFromFile(Paths.get(army1FilePath.getText()));
            army2 = ArmyController.readArmyFromFile(Paths.get(army2FilePath.getText()));
            updateArmiesInfo();
            simulationText.setText("Battle simulation");
        });

        //terrain select box
        ComboBox terrainSelect = new ComboBox();
        terrainSelect.setOnAction(e-> {
            if (terrainSelect.getValue() == Terrain.HILL) {
                this.pane.setStyle("-fx-background-color: linear-gradient(from 100% 25% to 100% 50%, #000, #3d3d3d);");
            } else if (terrainSelect.getValue() == Terrain.PLAINS) {
                this.pane.setStyle("-fx-background-color: linear-gradient(from 100% 25% to 100% 50%, #000, #a7af34);");
            } else if (terrainSelect.getValue() == Terrain.FOREST) {
                this.pane.setStyle("-fx-background-color: linear-gradient(from 100% 25% to 100% 50%, #000, #155000);");
            }
        });
        terrainSelect.getItems().add("Select terrain");
        terrainSelect.getSelectionModel().selectFirst();

        for (Terrain terrain : Terrain.values()) {
            terrainSelect.getItems().add(terrain);
        }

        //BATTLE START
        Button startBattleButton = new Button("Start battle");
        startBattleButton.setOnAction(e -> {
            errorText.setText("Feedback box: ");

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
            errorText.setText("Feedback box: ");
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
        menuPane.setPadding(new Insets(100, 10, 10, 0));

        VBox errorTextBox = new VBox();
        errorTextBox.getChildren().add(errorText);
        errorTextBox.setPadding(new Insets(10, 10, 10, 10));
        errorTextBox.setStyle("-fx-border-color: black");
        errorTextBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        menuPane.getChildren().addAll(resetButton, terrainSelect, startBattleButton,exitButton, errorTextBox);


        //Battle simulation output pane
        ScrollPane simulationPane = new ScrollPane();
        VBox simulationInfo = new VBox();
        simulationInfo.setPrefWidth(485);
        simulationInfo.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        simulationPane.setMinHeight(250);
        simulationPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        simulationPane.setPadding(new Insets(10, 10, 10, 10));

        simulationInfo.getChildren().addAll(simulationText);
        simulationPane.setContent(simulationInfo);

        //instruction box
        GridPane.setConstraints(welcomeTextBox, 0, 0);
        pane.getChildren().add(welcomeTextBox);

        //armies
        GridPane.setConstraints(army1Pane, 1, 0);
        GridPane.setConstraints(army2Pane, 2, 0);
        pane.getChildren().addAll(army1Pane,army2Pane);

        //menu with buttons
        GridPane.setConstraints(menuPane, 0, 0);
        pane.getChildren().add(menuPane);

        //simulation pane
        GridPane.setConstraints(simulationPane, 1, 1);
        GridPane.setColumnSpan(simulationPane, 2);
        pane.getChildren().add(simulationPane);

        pane.setPadding(new Insets(50, 50, 50, 40));
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
