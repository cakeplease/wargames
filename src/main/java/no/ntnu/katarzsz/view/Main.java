package no.ntnu.katarzsz.view;

import javafx.application.Application;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("My Application");
        stage.show();
    }


    @Override
    public void stop() {
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}