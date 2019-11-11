package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DogeCoinWindow {

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/mainWindow.fxml", "Main Window", mouseEvent);
  }
}

