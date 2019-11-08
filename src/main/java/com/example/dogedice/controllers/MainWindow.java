package com.example.dogedice.controllers;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainWindow {
  public void startButtonClicked(MouseEvent mouseEvent) {
    System.out.println("startButton clicked!");
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) {
    System.out.println("highscoreButton clicked!");
  }

  public void helpButtonClicked(MouseEvent mouseEvent) {
    System.out.println("helpButton clicked!");
  }

  public void dogecoinButtonClicked(MouseEvent mouseEvent) {
    System.out.println("dogeCoinButton clicked!");
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    ImageView spinningDoge = (ImageView) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }
}
