package no.ntnu.katarzsz.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.katarzsz.controller.ScreenController;

public class StartScreenView extends Application {
    private BorderPane frontPage = new BorderPane();
    private Scene frontPageScene = new Scene(frontPage);
    protected ScreenController screenController = new ScreenController(frontPageScene);

    private MainScreen mainScreen = new MainScreen(screenController);
    /*
    private AddTeamView addTeamView = new AddTeamView(screenController);
    private GroupsView groupsView = new GroupsView(screenController);
    private NoGroupsView noGroupsView = new NoGroupsView(screenController);
    private TeamsView teamsView = new TeamsView(screenController);
    private MatchesView matchesView = new MatchesView(screenController);
    private TournamentBracketView tournamentBracketView = new TournamentBracketView(screenController);*/

    @Override
    public void start(Stage stage) {
        stage.setTitle("Wargames");
        stage.show();
        this.setup();
    }

    public void setup() {
        Text welcome = new Text("WARGAMES");
        welcome.setId("title-text");

        Button start = new Button();
        start.setText("Start");
        start.setStyle("-fx-font-size:20");
        start.setOnAction(e -> screenController.activate("FrontPage"));

        Button exit = new Button();
        exit.setText("Quit");
        exit.setStyle("-fx-font-size:20");
        exit.setOnAction(e -> System.exit(0));
        frontPage.getChildren().addAll(welcome, start,exit);
    }

    @Override
    public void stop() {
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}