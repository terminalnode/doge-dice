package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PlayerSelectionWindow {
  public void confirmButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.openWindow("fxml/namePlayersWindow.fxml", "Name Players");
    Main.hideParentWindow(mouseEvent);
  }
}
