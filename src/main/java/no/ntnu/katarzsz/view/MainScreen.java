package no.ntnu.katarzsz.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.controller.GUIController;
import no.ntnu.katarzsz.controller.ScreenController;


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

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(100);
        pane.getColumnConstraints().addAll(column1, column2); // each get 50% of width

        ScrollPane army1Pane = new ScrollPane();
        army1Pane.setPannable(true);
        VBox army1Info = new VBox();
        Text army1Name = new Text("Army 1");
        Button loadArmy1Button = new Button("Load");
        Text unitNumber = new Text("Number of units: -");
        Text infantryUnitNumber = new Text("Infantry units: -");
        Text commanderUnitNumber = new Text("Commander units: -");
        Text rangedUnitNumber = new Text("Ranged units: -");
        Text cavalryUnitNumber = new Text("Cavalry units: -");

        loadArmy1Button.setOnAction(e -> {
            Army army1 = GUIController.uploadArmy();
            army1Name.setText(army1.getName());
            unitNumber.setText("Number of units: "+army1.getAllUnits().size());
            infantryUnitNumber.setText("Infantry units: "+army1.getInfantryUnits().size());
            commanderUnitNumber.setText("Commander units: "+army1.getCommanderUnits().size());
            rangedUnitNumber.setText("Ranged units: "+army1.getRangedUnits().size());
            cavalryUnitNumber.setText("Cavalry units: "+army1.getCavalryUnits().size());
        });

        army1Info.getChildren().addAll(army1Name,loadArmy1Button, unitNumber,infantryUnitNumber,commanderUnitNumber,rangedUnitNumber,cavalryUnitNumber);
        army1Pane.setContent(army1Info);

        GridPane.setConstraints(army1Pane, 0, 0); // column=0 row=0

        ScrollPane army2Pane = new ScrollPane();
        army2Pane.setPannable(true);
        Text test2 = new Text("Army 2");
        Button loadArmy2 = new Button("Load");
        loadArmy2.setOnAction(e -> GUIController.uploadArmy());
        VBox army2Container = new VBox();

        army2Container.getChildren().addAll(test2,loadArmy2);
        army2Pane.setContent(army2Container);
        GridPane.setConstraints(army2Pane, 1, 0); // column=1 row=0


        pane.getChildren().addAll(army1Pane,army2Pane);
    }

    public void resetPane() {
        this.pane.getChildren().clear();
    }
}
