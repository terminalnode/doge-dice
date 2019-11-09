package com.example.dogedice.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelpWindow {
  @FXML
  Label text;

  @FXML
  public void initialize() {
    text.setText(
        "1. Happy fun for whole family! :D\n" +
            "2. Enjoy! >:("
    );
  }
}
