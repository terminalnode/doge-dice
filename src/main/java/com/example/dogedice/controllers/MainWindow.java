package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
    ImageView imageView = (ImageView) mouseEvent.getSource();
    Image image = imageView.getImage();

    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
      imageView.setScaleX(imageView.getScaleX() * -1);
    } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
      if (image.getUrl().contains("dogespin")) {
        Image newImage = new Image(Main.getRes("images/rainbowDoge.gif").toExternalForm());
        imageView.setImage(newImage);
      } else {
        Image newImage = new Image(Main.getRes("images/dogespin.gif").toExternalForm());
        imageView.setImage(newImage);
      }
    }
  }
}
