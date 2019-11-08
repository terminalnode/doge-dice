package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainWindow {
  public void startButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.openWindow("fxml/playerSelectionWindow.fxml", "Player Selection");
    Main.hideParentWindow(mouseEvent);
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.openWindow("fxml/highscoreWindow.fxml", "Highscore");
    Main.hideParentWindow(mouseEvent);
  }

  public void helpButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.openWindow("fxml/helpWindow.fxml", "How to play");
    // Do not hide parent window on close.
  }

  public void dogecoinButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.openWindow("fxml/dogeCoinWindow.fxml", "Donate!");
    // Do not hide parent window on close.
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    ImageView spinningDoge = (ImageView) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }
}
