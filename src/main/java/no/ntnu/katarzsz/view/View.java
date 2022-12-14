package no.ntnu.katarzsz.view;

import javafx.scene.layout.Pane;

/**
 * Class from our System Development project 2022
 * Concept created by me and my project partners.
 * Different View classes are extending this abstract View class and get added and activated by ScreenController in MainScreen-class.
 * This way we can easily switch between different panes/views.
 * Even though I have only two views, this gives an opportunity to expand the project easy.
 */
public abstract class View {
    public abstract Pane getPane();
    public abstract void setup();
    abstract void resetPane();
}
