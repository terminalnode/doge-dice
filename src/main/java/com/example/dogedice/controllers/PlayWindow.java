package com.example.dogedice.controllers;

import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayWindow {
  private int index = 0;
  private List<Player> players;
  private final Map<Player, Label> playerNames;
  private final Map<Player, Label> playerScores;
  private final Map<Player, FlowPane> playerDice;

  public PlayWindow() {
    playerNames = new HashMap<>();  // the labels where we display player names
    playerScores = new HashMap<>(); // the labels where we display player scores
    playerDice = new HashMap<>();   // the flowpane where we display player dice/modifiers
  }

  @FXML
  VBox playerPaneBox;

  @FXML
  Label roll;

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);
  }

  public void rollButtonClicked(MouseEvent mouseEvent) throws IOException{
    Player player = players.get(index);
      roll.setText("" + player.rollAllDice());
      changePlayer();
      addScore();
  }

  @FXML
  Label score;
  public void addScore(){
    Player player = players.get(index);
    score.setText("" + player.getScore());
  }


  public void addPlayers(List<Player> players) {
    this.players = players;

    for (Player player : players){
      playerNames.put(player, new Label(player.getName()));
      playerScores.put(player, new Label("" + player.getScore()));
      playerDice.put(player, new FlowPane());
      HBox playerInfo = new HBox();
      playerInfo.getChildren().addAll(playerNames.get(player), playerScores.get(player));

      playerPaneBox
        .getChildren()
          .addAll(
              playerInfo,
              playerDice.get(player)
          );
    }
  }


  public void changePlayer() {
    index++;
    if (players.size() == index){
     index = 0;
    }
  }
}


