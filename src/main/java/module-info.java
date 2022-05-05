module wargames {
    requires javafx.controls;
    requires javafx.fxml;

    //opens wargames to javafx.fxml;
    exports no.ntnu.katarzsz.model;
    opens no.ntnu.katarzsz.model to javafx.fxml;
    exports no.ntnu.katarzsz.view;
    opens no.ntnu.katarzsz.view to javafx.fxml;
    exports no.ntnu.katarzsz.controller;
    opens no.ntnu.katarzsz.controller to javafx.fxml;
    exports no.ntnu.katarzsz.base;
    opens no.ntnu.katarzsz.base to javafx.fxml;
}