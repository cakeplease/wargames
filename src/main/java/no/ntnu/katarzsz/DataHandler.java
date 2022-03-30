package no.ntnu.katarzsz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataHandler {

    public static void saveToFile(String data, Path path, String fileName) {
        try {
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            File file = new File("src/main/resources/"+fileName+".csv");
            Path filePath = Paths.get("src/main/resources/"+fileName+".csv");
        }
    }

    public static void readFromFile(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
