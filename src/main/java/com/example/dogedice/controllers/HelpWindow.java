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
        "1. Pick 2leg-Doge or robo Doge if less Friend.\n" +
            "2. so amaze Play! \n" +
            "3. Play til much rich dice. \n" +
            "4. Wow so rich, dice or mod buy now. doge impressed! \n" +
            "5. Lose or win, u never be Top-Doge with no donation \n " +
            "Play much impress donation == Top-Doge" );
  }
}
