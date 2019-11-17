package com.example.dogedice.controllers;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainWindow extends GenericController {
  public void startButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.playerSelectionWindowFXML,
        HelperMethods.playerSelectionWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.highscoreWindowFXML,
        HelperMethods.highscoreWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void helpButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.helpWindowFXML,
        HelperMethods.helpWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void dogecoinButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.dogeCoinWindowFXML,
        HelperMethods.dogeCoinWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    HelperMethods.spinningDogeClicked(mouseEvent);
  }
}
