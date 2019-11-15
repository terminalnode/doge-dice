package com.example.dogedice.controllers;

import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayWindow {
  private int index = 0;
  private List<Player> players;
  private final Map<Player, Label> playerNames;
  private final Map<Player, Label> playerScores;
  private final Map<Player, FlowPane> playerItems;

  public PlayWindow() {
    playerNames = new HashMap<>();  // the labels where we display player names
    playerScores = new HashMap<>(); // the labels where we display player scores
    playerItems = new HashMap<>();   // the flowpane where we display player dice/modifiers
  }

  @FXML
  VBox playerPaneBox;

  @FXML
  Label roll;

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);
  }

  public void rollButtonClicked(MouseEvent mouseEvent) {
    Player player = players.get(index);
    roll.setText("" + player.rollAllDice());
    playerScores.get(player).setText(""+player.getScore());
    changePlayer();

    Player nextPlayer = players.get(index);
    if (nextPlayer.isBot()) {
      rollButtonClicked(null);
    }
    setInactiveStylePlayer(player);
    setActiveStylePlayer(nextPlayer);
  }

  public void setActiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("-fx-font: bold italic 20pt 'Arial'; -fx-border-color:BLUE ");
  }

  public void setInactiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("-fx-border-color: transparent");
  }


  public void addPlayers(List<Player> players) {
    this.players = players;

    for (Player player : players){
      playerNames.put(player, new Label(player.getName()));
      playerScores.put(player, new Label(""  + player.getScore()));
      playerItems.put(player, new FlowPane());
      GridPane playerInfo = new GridPane();
      playerInfo.setHgap(30);
      playerInfo.addColumn(0 , playerNames.get(player));
      playerInfo.addColumn(1, playerScores.get(player));
      playerScores.get(player).setText("" +player.getScore());
      playerInfo.getColumnConstraints().addAll(new ColumnConstraints(300), new ColumnConstraints(50));
      playerPaneBox
        .getChildren()
          .addAll(
              playerInfo,
              playerItems.get(player)
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


