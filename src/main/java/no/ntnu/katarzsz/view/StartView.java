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

/**
 * StartView is the first view that user sees.
 * It also sets up all the necessary elements for JavaFX like scene, screen, stage etc.
 */
public class StartView extends Application {
    private BorderPane frontPage = new BorderPane();
    private Scene frontPageScene = new Scene(frontPage, 1000,700);
    protected ScreenController screenController = new ScreenController(frontPageScene);
    public static Stage stage;
    private GameView gameView = new GameView(screenController);

    /**
     * StartView constructor
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        StartView.stage = stage;
        screenController.addScreen("GameView", gameView);
        stage.setScene(frontPageScene);
        frontPageScene.getStylesheets().add("/styles/styles.css");
        frontPage.setId("background");

        Image icon = new Image("/styles/sword.png");
        stage.getIcons().add(icon);

        stage.setTitle("Wargames");
        stage.show();
        this.setup();
    }

    /**
     * Sets up game title and start and quit buttons.
     */
    public void setup() {
        VBox vBox = new VBox();
        Text gameTitle = new Text("WARGAMES");
        gameTitle.setId("game-title");

        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setStyle("-fx-font-size:20");
        startButton.setId("start-button");

        startButton.setOnAction(e -> screenController.activate("GameView"));

        Button exitButton = new Button();
        exitButton.setText("Quit");
        exitButton.setId("quit-button");
        exitButton.setOnAction(e -> System.exit(0));

        vBox.getChildren().addAll(gameTitle, startButton, exitButton);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(200, 50, 50, 50));
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