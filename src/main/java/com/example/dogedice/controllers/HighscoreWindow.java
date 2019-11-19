package com.example.dogedice.controllers;

import com.example.dogedice.model.HumanPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class HighscoreWindow extends GenericController {

  @FXML
  Label firstPlace, secondPlace, thirdPlace;

  @Override
  public void postInitialization () {
    List<HumanPlayer> highScore = gameEngine.getHighScore();
    firstPlace.setText(highScore.get(0).getName());
    secondPlace.setText(highScore.get(1).getName());
    thirdPlace.setText(highScore.get(2).getName());
  }

  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.mainWindowFXML,
        HelperMethods.mainWindowTitle,
        mouseEvent,
        this
    );
  }
}
