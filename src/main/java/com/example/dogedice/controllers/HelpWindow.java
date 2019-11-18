package com.example.dogedice.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelpWindow extends GenericController {
  @FXML
  Label text;
  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.mainWindowFXML,
        HelperMethods.mainWindowTitle,
        mouseEvent,
        this
    );
  }

  @FXML
  public void initialize() {
    text.setText(
        "1. Pick 2leg-Doge or robo Doge if less Friend.\n" +
            "2. pick so sexi name" +
            "3. so amaze Play! \n" +
            "4. Play til much rich dice. \n" +
            "5. Wow so rich, dice or mod buy now. doge impressed! \n" +
            "6. Lose or win, u never be Top-Doge with no donation \n " +
            "much impress Play with donation == Top-Doge" +
            "\n No like wonder music ? M press.");
  }
  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    HelperMethods.spinningDogeClicked(mouseEvent);
  }
}
