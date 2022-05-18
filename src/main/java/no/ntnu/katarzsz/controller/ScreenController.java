package no.ntnu.katarzsz.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import no.ntnu.katarzsz.view.View;

import java.util.HashMap;

/**
 * Class imported from our System Development project 2022
 * Controls panes
 */
public class ScreenController {

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private HashMap<String, View> viewMap = new HashMap<>();
    private Scene main;
    private View view;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void addScreen(String name, View view){
        screenMap.put(name, view.getPane());
        viewMap.put(name, view);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        viewMap.get(name).setup();
        main.setRoot( screenMap.get(name));
    }
}