package no.ntnu.katarzsz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataHandler {

    public static void saveToFile(String data, Path path) {

        if (!Files.exists(path)) {
            File file = new File(String.valueOf(path));
        }

        try {
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(Path path) {
        if (Files.exists(path)) {
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
}
