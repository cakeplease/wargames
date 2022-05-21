package no.ntnu.katarzsz.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.katarzsz.controller.ScreenController;

public class StartScreenView extends Application {
    private BorderPane frontPage = new BorderPane();
    private Scene frontPageScene = new Scene(frontPage);
    protected ScreenController screenController = new ScreenController(frontPageScene);
    public static Stage stage;
    private MainScreen mainScreen = new MainScreen(screenController);

    @Override
    public void start(Stage stage) {
        StartScreenView.stage = stage;
        screenController.addScreen("MainScreen", mainScreen);
        frontPage.getStyleClass().add("#front-page");
        stage.setScene(frontPageScene);
        stage.setTitle("Wargames");
        stage.show();
        this.setup();
    }

    public void setup() {
        VBox vBox = new VBox();
        Text gameTitle = new Text("WARGAMES");
        gameTitle.setStyle("-fx-font-family: 'Book Antiqua'; -fx-font-size: 33px");
        gameTitle.setId("title-text");

        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setStyle("-fx-font-size:20");
        startButton.setOnAction(e -> screenController.activate("MainScreen"));

        Button exitButton = new Button();
        exitButton.setText("Quit");
        exitButton.setStyle("-fx-font-size:20");
        exitButton.setOnAction(e -> System.exit(0));

        vBox.getChildren().addAll(gameTitle, startButton, exitButton);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(50, 50, 50, 50));

        frontPage.setPadding(new Insets(10, 10, 10, 10));
        frontPage.setCenter(vBox);
    }

    @Override
    public void stop() {
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}