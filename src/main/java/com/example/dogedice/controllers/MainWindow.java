package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainWindow {
  public void startButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/playerSelectionWindow.fxml", "Player Selection", mouseEvent);
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/highscoreWindow.fxml", "Highscore", mouseEvent);
  }

  public void helpButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/helpWindow.fxml", "How to play", mouseEvent);
  }

  public void dogecoinButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/dogeCoinWindow.fxml", "Donate!", mouseEvent);
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    ImageView spinningDoge = (ImageView) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }
}
