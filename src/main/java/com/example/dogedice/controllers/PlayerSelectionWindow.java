package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerSelectionWindow {
  @FXML
  Spinner<Integer> humPlayersSpinner, cpuPlayersSpinner;

  public void confirmButtonClicked(MouseEvent mouseEvent) throws IOException {
    Stage newWindow = new Stage();
    newWindow.setTitle("Name Players");
    FXMLLoader loader = Main.getLoader("fxml/namePlayersWindow.fxml");
    Parent root = loader.load();
    NamePlayersWindow controller = loader.getController();
    Scene scene = new Scene(root);
    newWindow.setScene(scene);
    controller.setHumPlayers(humPlayersSpinner.getValue());
    controller.setCpuPlayers(cpuPlayersSpinner.getValue());

    Main.hideParentWindow(mouseEvent);
    newWindow.show();
  }
}
