package no.ntnu.katarzsz.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import no.ntnu.katarzsz.controller.ScreenController;


public class MainScreen extends View {
    protected VBox pane;
    private ScreenController screenController;

    public MainScreen(ScreenController screenController) {
        this.pane = new VBox();
        this.screenController = screenController;
        this.setup();
    }

    public Pane getPane() {
        return this.pane;
    }

    public void setup() {

    }

    public void resetPane() {
        this.pane.getChildren().clear();
    }
}
