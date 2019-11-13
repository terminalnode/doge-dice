package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WinnerWindow {

   @FXML
   VBox winnerBox;


  private void printWinner(String listWinner) {
     Label label = new Label(listWinner + " \n Jocke");
    label.setLayoutY(50);
    label.setPrefHeight(50);
    label.setPrefWidth(50);

     winnerBox
         .getChildren()
         .add(label);
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
