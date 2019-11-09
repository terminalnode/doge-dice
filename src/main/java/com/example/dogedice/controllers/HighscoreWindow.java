package com.example.dogedice.controllers;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HighscoreWindow {
/*
  public void highscoreRanking () {
  }*/

  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);

  }
/*
  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    //ImageView backIcon = (ImageView) mouseEvent.getSource();
    //HighscoreWindow.openWindow("fxml/mainWindow.fxml", "Main Window", mouseEvent);
  }
*/
}

