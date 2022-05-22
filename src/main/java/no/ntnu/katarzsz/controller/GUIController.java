package no.ntnu.katarzsz.controller;

import javafx.stage.FileChooser;
import no.ntnu.katarzsz.view.StartView;
import java.io.File;
import java.nio.file.Path;

/**
 * GUIController class for user actions
 */
public class GUIController {
    /**
     * Upload army to the project
     * @return Path to the file in current project
     */
    public static Path uploadArmy() {
        Path newFilePath = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        //allow only .csv formatted files
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(StartView.stage);

        if (selectedFile != null) {
            newFilePath = ArmyController.uploadArmy(selectedFile);
        }
        return newFilePath;
    }
}
