package pw.espana.kahootgourmet.server.controllers;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pw.espana.kahootgourmet.commons.game.Answer;
import pw.espana.kahootgourmet.commons.game.Question;
import pw.espana.kahootgourmet.commons.game.Questionnaire;
import pw.espana.kahootgourmet.server.ScreenSwitcher;
import pw.espana.kahootgourmet.server.ServerApplication;

public class MainScreenController {
    private Stage stage;
    @FXML
    private TextField txtPIN;
    @FXML
    private TextField txtPuerto;

    @FXML
    protected void initialize()  {
        txtPIN.setText(String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999 + 1)));
        txtPuerto.setText("60420");
    }

    public void onLoad()  {
        txtPIN.setText(String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999 + 1)));
    }

    @FXML
    protected void onLoadButtonClick(ActionEvent actionEvent) throws Exception {
        /*Answer[] answers = { new Answer("Rojo", true), new Answer("Azul", true), new Answer("Amarillo", true), new Answer("Verde", true) };
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.addQuestion(new Question("De qué color es cada cuadro?", 100, answers));

        questionnaire.saveToFile("prueba.bin");*/

        if (!ServerApplication.startServer(Integer.parseInt(txtPuerto.getText()), Integer.parseInt(txtPIN.getText()), "prueba.bin")) return;

        ScreenSwitcher.showStartGameScene();
    }

    @FXML
    protected void onEditorButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenSwitcher.showQuizEditorScene();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}