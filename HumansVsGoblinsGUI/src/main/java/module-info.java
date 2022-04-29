module com.ab0529.humansvsgoblinsgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ab0529.humansvsgoblinsgui to javafx.fxml;
    exports com.ab0529.humansvsgoblinsgui;
    exports com.ab0529.humansvsgoblinsgui.controllers;
    opens com.ab0529.humansvsgoblinsgui.controllers to javafx.fxml;
}