package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HighscoreWindow {

  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    Main.replaceWindow("fxml/mainWindow.fxml", "Main Window", mouseEvent);
  }
}

