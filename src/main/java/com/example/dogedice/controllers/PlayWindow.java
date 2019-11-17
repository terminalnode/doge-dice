package com.example.dogedice.controllers;

import com.example.dogedice.model.Die;
import com.example.dogedice.model.Modifier;
import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayWindow extends GenericController {
  private int index = 0;
  private List<Player> players;
  private final Map<Player, Label> playerNames;
  private final Map<Player, Label> playerScores;
  private final Map<Player, FlowPane> playerItems;

  @FXML
  VBox playerPaneBox;

  @FXML
  Label roll;

  public PlayWindow() {
    playerNames = new HashMap<>();  // the labels where we display player names
    playerScores = new HashMap<>(); // the labels where we display player scores
    playerItems = new HashMap<>();  // the flowpane where we display player dice/modifiers
  }

  public void dieTwentyClicked(MouseEvent mouseEvent) {
  }

  public void dieSixClicked(MouseEvent mouseEvent) {
  }

  public void modifierClicked(MouseEvent mouseEvent) {
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    HelperMethods.spinningDogeClicked(mouseEvent);
  }

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.mainWindowFXML,
        HelperMethods.mainWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void rollButtonClicked(MouseEvent mouseEvent) {
    Player player = players.get(index);
    roll.setText("" + player.rollAllDice());
    playerScores.get(player).setText(""+player.getScore());
    changePlayer();

    Player nextPlayer = players.get(index);
    setInactiveStylePlayer(player);
    setActiveStylePlayer(nextPlayer);
    if (nextPlayer.isBot()) {
      rollButtonClicked(null);
    }
  }

  @Override
  public void postInitialization() {
    this.players = gameEngine.getPlayers();
    for (Player player : players){
      Label playerNameLabel = new Label(player.getName());
      playerNameLabel.getStyleClass().add("playerInfo");
      playerNames.put(player, playerNameLabel);

      Label playerScore = new Label("" + player.getScore());
      playerScore.getStyleClass().add("playerInfo");
      playerScores.put(player, playerScore);

      FlowPane playerItemPane = new FlowPane();
      playerItemPane.setHgap(5);
      List<Node> playerItemsList = playerItemPane.getChildren();
      player.getDice().forEach(x -> {
        try { playerItemsList.add(getDieIcon(x)); } catch (Exception e) { e.printStackTrace(); }
      });
      playerItems.put(player, playerItemPane);

      GridPane playerInfo = new GridPane();
      playerInfo.setHgap(30);
      playerInfo.addColumn(0, playerNames.get(player));
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
    setActiveStylePlayer(this.players.get(0));
  }

  private void setActiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("-fx-text-fill: #2196F3;");
  }

  private void setInactiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("");
  }

  private void changePlayer() {
    index++;
    if (players.size() == index){
      index = 0;
    }
  }

  private Group getDieIcon(Die die) throws IOException, URISyntaxException {
    SVGPath icon = null;
    if (die.getNumOfSides() == 6) {
      icon = getSVGIcon("svgpaths/d6");
      resizeSVG(icon, 35, 35);
    } else if (die.getNumOfSides() == 20) {
      icon = getSVGIcon("svgpaths/d20");
      resizeSVG(icon, 35, 35);
    }
    Group group = new Group();
    group.getChildren().add(icon); // will return null pointer exception for weird dice
    return group;
  }

  // TODO modifier icon is currently all black. Should display value as well.
  private Group modifierIcon(Modifier mod) throws IOException, URISyntaxException {
    SVGPath icon = getSVGIcon("svgpaths/modifier");
    resizeSVG(icon, 35, 35);
    Group group = new Group();
    group.getChildren().add(icon);
    return group;
  }

  private SVGPath getSVGIcon(String filePath) throws URISyntaxException, IOException {
    SVGPath icon = new SVGPath();
    List<String> path = Files.readAllLines(Paths.get(HelperMethods.getRes(filePath).toURI()));
    icon.setContent(String.join("", path));
    return icon;
  }

  private void resizeSVG(SVGPath svg, double width, double height) {
    double originalHeight = svg.prefHeight(-1);
    double originalWidth = svg.prefWidth(originalHeight);
    svg.setScaleX(width / originalWidth);
    svg.setScaleY(height / originalHeight);
  }
}


