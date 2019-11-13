package com.example.dogedice.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelpWindow {
  @FXML
  Label text;
  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);
  }

  @FXML
  public void initialize() {
    text.setText(
        "1. Happy fun for whole family! :D\n" +
            "2. Enjoy! >:("
    );
  }
}
