package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelpWindow {
  @FXML
  Label text;
  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/mainWindow.fxml", "Main Window", mouseEvent);
  }

  @FXML
  public void initialize() {
    text.setText(
        "1. Happy fun for whole family! :D\n" +
            "2. Enjoy! >:("
    );
  }
}
