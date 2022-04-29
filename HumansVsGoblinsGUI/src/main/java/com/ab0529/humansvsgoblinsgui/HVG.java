package com.ab0529.humansvsgoblinsgui;

import com.ab0529.humansvsgoblinsgui.controllers.TitleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HVG extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HVG.class.getResource("title_screen.fxml"));
        fxmlLoader.setController(new TitleController());

        Scene scene = new Scene(fxmlLoader.load(), 512, 512);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}