package com.example.dogedice.controllers;

import com.example.dogedice.model.Die;
import com.example.dogedice.model.HumanPlayer;
import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class PlayWindow {
  private int index = 0;
  private List<Player> players;

  @FXML
  VBox playerPaneBox;

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.mainWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);  }

  @FXML
  Label roll;

  public void rollButtonClicked(MouseEvent mouseEvent) throws IOException{
    Player player = players.get(index);
      roll.setText("" + player.rollAllDice());
      changePlayer();
  }

  public void addPlayers(List<Player> players) {
    for (Player player : players){
      Label label = new Label(player.getName());
      playerPaneBox
        .getChildren()
          .add(label);
    }
    this.players = players;
  }


  public void changePlayer() {
    index++;
    if (players.size() == index){
     index = 0;
    }
  }
}


