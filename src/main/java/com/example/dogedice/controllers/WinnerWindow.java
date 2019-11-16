package com.example.dogedice.controllers;

import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WinnerWindow {

   @FXML
   VBox winnerBox;


  private void printWinner(List<Player> players) {
    for (Player player: players) {
      Collections.sort(players);
      Label label = new Label(player.getName() + "with a score of: " +  player.getScore());
      label.setLayoutY(50);
      label.setPrefHeight(50);
      label.setPrefWidth(50);

      winnerBox
          .getChildren()
          .add(label);
    }

  }

  public void menuButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML,HelperMethods.mainWindowTitle, mouseEvent);
  }

  public void replayButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.playWindowFXML, HelperMethods.playWindowTitle, mouseEvent);
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.highscoreWindowFXML, HelperMethods.highscoreWindowTitle, mouseEvent);
  }
  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }
}
