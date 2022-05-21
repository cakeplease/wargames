package no.ntnu.katarzsz.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.controller.ArmyController;
import no.ntnu.katarzsz.controller.GUIController;
import no.ntnu.katarzsz.controller.ScreenController;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainScreen extends View {
    protected GridPane pane;
    private ScreenController screenController;

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

        /**
         * Army panes
         */
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(100);
        pane.getColumnConstraints().addAll(column1, column2); // each get 50% of width

        for (int i=0; i<2; i++) {
            ScrollPane armyPane;
            VBox armyInfo;
            VBox unitsInfo;
            Text armyName;
            Button loadArmyButton;
            Text unitNumber;
            Text infantryUnitNumber;
            Text commanderUnitNumber;
            Text rangedUnitNumber;
            Text cavalryUnitNumber;
            Text armyFilePath;

            armyPane = new ScrollPane();
            armyInfo = new VBox();
            unitsInfo = new VBox();

            armyName = new Text("Army "+(i+1));
            loadArmyButton = new Button("Load");
            armyFilePath = new Text("Path to army file: -");
            unitNumber = new Text("Number of units: -");
            infantryUnitNumber = new Text("Infantry units: -");
            commanderUnitNumber = new Text("Commander units: -");
            rangedUnitNumber = new Text("Ranged units: -");
            cavalryUnitNumber = new Text("Cavalry units: -");

            Text unitsText = new Text("Units");
            Text unitInfo = new Text("");

            loadArmyButton.setOnAction(e -> {
                Army army;
                Path path = GUIController.uploadArmy();
                armyFilePath.setText(path.toString());
                /*armyName.setText(army.getName());
                unitNumber.setText("Number of units: " + army.getAllUnits().size());
                infantryUnitNumber.setText("Infantry units: " + army.getInfantryUnits().size());
                commanderUnitNumber.setText("Commander units: " + army.getCommanderUnits().size());
                rangedUnitNumber.setText("Ranged units: " + army.getRangedUnits().size());
                cavalryUnitNumber.setText("Cavalry units: " + army.getCavalryUnits().size());

                unitInfo.setText(army.getAllUnitsInCsvFormat());*/
            });

            ArmyController.readArmyFromFile(Path.of(armyFilePath.getText().toString()));



            unitsInfo.getChildren().addAll(unitsText,unitInfo);
            armyInfo.getChildren().addAll(armyName,loadArmyButton, armyFilePath, unitNumber,infantryUnitNumber,commanderUnitNumber,rangedUnitNumber,cavalryUnitNumber,unitsInfo);
            armyPane.setContent(armyInfo);

            GridPane.setConstraints(armyPane, i, 0);
            pane.getChildren().add(armyPane);
        }

        /**
         * Menu pane
         */
        VBox menuPane = new VBox();
        Button resetButton = new Button("Reset armies");
        Button terrainButton = new Button("Choose terrain");
        Button startBattleButton = new Button("Start battle");

        menuPane.getChildren().addAll(resetButton, terrainButton, startBattleButton);
        GridPane.setConstraints(menuPane, 3, 0);
        pane.getChildren().add(menuPane);

        /**
         * Simulation pane
         */
        ScrollPane simulationPane = new ScrollPane();
        VBox simulationInfo = new VBox();

        simulationInfo.getChildren().addAll();

        simulationPane.setContent(simulationInfo);
        GridPane.setConstraints(simulationPane, 1, 1);
        pane.getChildren().add(simulationPane);
    }

    public void resetPane() {
        this.pane.getChildren().clear();
    }
}
