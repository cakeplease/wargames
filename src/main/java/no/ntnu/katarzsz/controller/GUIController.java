package no.ntnu.katarzsz.controller;

import javafx.stage.FileChooser;
import no.ntnu.katarzsz.base.Army;
import no.ntnu.katarzsz.view.StartScreenView;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GUIController class for user actions
 */
public class GUIController {
    public static Path uploadArmy() {
        Path newFilePath = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(StartScreenView.stage);

        if (selectedFile != null) {
            newFilePath = ArmyController.uploadArmy(Paths.get(selectedFile.getPath()));
        }
        return newFilePath;
    }
}
