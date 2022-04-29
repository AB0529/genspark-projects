package com.ab0529.humansvsgoblinsgui.controllers;

import com.ab0529.humansvsgoblinsgui.HVG;
import com.ab0529.humansvsgoblinsgui.game.Human;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleController {
    @FXML
    TextField humanNamePrompt;
    @FXML
    Button enterButton;
    @FXML
    Text errorText;

    @FXML
    protected void onEnterButtonSubmit() {
        if (!isValidName(humanNamePrompt.getText())) {
            errorText.setText("Invalid name");
            return;
        }

        errorText.setText("");
        Human player = new Human(humanNamePrompt.getText());

        switchScenes("game.fxml", new GameController(player), (Stage) enterButton.getScene().getWindow());
    }

    public void switchScenes(String viewName, Object controller, Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader( HVG.class.getResource(viewName) );
            loader.setController(controller);

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isValidName(String name) {
        // TODO: add more checks
        return !name.isEmpty();
    }
}
