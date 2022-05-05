package no.ntnu.katarzsz.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private StackPane frontPage = new StackPane();
    private Scene frontPageScene = new Scene(frontPage);
    public static Stage primaryStage;

    /**
     * Overrides the start() method which takes a single parameter stage.
     * Uses the show() method to display the stage.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        HelloApplication.primaryStage = primaryStage;
        primaryStage.setScene(frontPageScene);
        primaryStage.show();

        //this.setup();
    }

    private void setup() {

    }

    /**
     * Uses the static launch() method to launch the stage.
     * @param args
     */
    public static void main(String[] args) {
        HelloApplication.launch(args);
    }

}

