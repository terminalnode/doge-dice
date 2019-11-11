package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.scene.control.Label;

public class WinnerWindow {

   @FXML
   Label text;

   @FXML
  public void printWinner() {
   text.setText("FIttJOCKEE");
  }

  public void menuButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/mainWindow.fxml", "Main Window", mouseEvent);
  }

  public void replayButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/playWindow.fxml", "Play Window", mouseEvent);
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/highscoreWindow.fxml", "Highscore Window", mouseEvent);
  }
  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }
}
