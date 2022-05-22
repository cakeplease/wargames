package no.ntnu.katarzsz.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Simple class for data handling
 */
public class DataHandler {
    /**
     * Save data to file
     * @param data
     * @param path
     */
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

    /**
     * Read data from file
     * @param path
     */
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
