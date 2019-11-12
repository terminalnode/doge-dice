package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PlayWindow {
  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    FXMLLoader loader = Main.getLoader("fxml/mainWindow.fxml");
    Parent root = loader.load();

    Scene scene = new Scene(root);

    Main.replaceStage(mouseEvent, scene, "Doge dice");


  }
}
