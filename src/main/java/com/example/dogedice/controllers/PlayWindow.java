package com.example.dogedice.controllers;

import com.example.dogedice.model.BotAction;
import com.example.dogedice.model.Die;
import com.example.dogedice.model.Modifier;
import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayWindow extends GenericController {
  private List<Player> players;
  private final Map<Player, Label> playerNames;
  private final Map<Player, Label> playerScores;
  private final Map<Player, FlowPane> playerItems;

  @FXML
  VBox playerPaneBox, diceBox;

  @FXML
  Label roll, gameTurns;

  @FXML
  Button rollButton;

  public PlayWindow() {
    playerNames = new HashMap<>();  // the labels where we display player names
    playerScores = new HashMap<>(); // the labels where we display player scores
    playerItems = new HashMap<>();  // the flowpane where we display player dice/modifiers
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    HelperMethods.spinningDogeClicked(mouseEvent);
  }

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    gameEngine.resetPlayers();
    gameEngine.resetRounds();
    HelperMethods.replaceScene(
        HelperMethods.namePlayersWindowFXML,
        HelperMethods.namePlayersWindowTitle,
        mouseEvent,
        gameEngine
    );
  }

  public void rollButtonClicked(MouseEvent mouseEvent) {
    Player player = gameEngine.getPlayer();
    BotAction botAction = gameEngine.getBotAction();
    while (botAction != BotAction.PASS) {
      switch (botAction) {
        case BUYD6: buyD6(mouseEvent); break;
        case BUYD20: buyD20(mouseEvent); break;
        case BUYMODIFIER: buyModifier(mouseEvent); break;
      }
      botAction = gameEngine.getBotAction();
    }

    roll.setText("" + gameEngine.rollDice());
    playerScores.get(player).setText(gameEngine.getScoreAsString());

    gameEngine.incrementPlayer();
    Player nextPlayer = gameEngine.getPlayer();

    setInactiveStylePlayer(player);
    setActiveStylePlayer(nextPlayer);
    if (nextPlayer.isBot()) {
      rollButtonClicked(mouseEvent);
    }

    gameTurns.setText("Rounds Left: " + gameEngine.getRoundsLeftAsString());
    if (gameEngine.getRoundsLeft() == 0) {
       rollButton.setOnMousePressed(event -> {
         try {
           getWinner(mouseEvent);
         } catch (IOException e) {
           e.printStackTrace();
         }
       });
      rollButton.setText("Show Winner!");
    }
  }

  private void getWinner(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceScene(
        HelperMethods.winnerWindowFXML,
        HelperMethods.winnerWindowTitle,
        mouseEvent,
        gameEngine);
  }

  @Override
  public void postInitialization(){
    Label dieSixPrice = new Label(gameEngine.getD6PriceAsString());
    Label dieTwentyPrice = new Label(gameEngine.getD20PriceAsString());
    Label modifierPrice = new Label(gameEngine.getModifierPriceAsString());

    dieSixPrice.setId("d6p");
    dieTwentyPrice.getStyleClass().add("modifierLabels");
    modifierPrice.getStyleClass().add("modifierLabels");

    Group priceGroup = new Group(dieSixPrice, dieTwentyPrice, modifierPrice);
    priceGroup.getStylesheets().add("css/playWindow.css");
    priceGroup.setId("prices");
    diceBox.getChildren().add(priceGroup);

    VBox dieSix = new VBox();
    VBox dieTwenty = new VBox();
    VBox mods = new VBox();
    Label plusOne = new Label("+1");

    gameTurns.setText("Rounds Left: " + gameEngine.getRoundsLeftAsString());
    try {
      SVGPath die6 = getSVGIcon("svgpaths/d6");
      resizeSVG(die6, 60, 60 );
      Group d6G = new Group(die6);
      dieSix.getChildren().addAll(d6G, dieSixPrice);
      dieSix.setId("dieSix");
      dieSix.getStyleClass().add("itemVBox");

      SVGPath die20 = getSVGIcon("svgpaths/d20");
      resizeSVG(die20, 60, 65);
      Group d20G = new Group(die20);
      dieTwenty.getChildren().addAll(d20G, dieTwentyPrice);
      dieTwenty.getStyleClass().add("itemVBox");

      SVGPath modifier = getSVGIcon("svgpaths/modifier");
      resizeSVG(modifier, 60, 60);
      plusOne.setId("plusOneLabel");
      Group modG = new Group(modifier, plusOne);
      mods.getChildren().addAll(modG, modifierPrice, plusOne);
      mods.getStyleClass().add("itemVBox");

      diceBox.getChildren().addAll(dieSix, dieTwenty, mods);
    } catch (Exception e) {
      e.printStackTrace();
    }

    dieSix.setOnMousePressed(this::buyD6);
    dieTwenty.setOnMousePressed(this::buyD20);
    mods.setOnMousePressed(this::buyModifier);

    this.players = gameEngine.getPlayers();
    for (Player player : players) {
      Label playerNameLabel = new Label(player.getName());
      playerNameLabel.getStyleClass().add("playerInfo");
      playerNames.put(player, playerNameLabel);

      Label playerScore = new Label("" + player.getScore());
      playerScore.getStyleClass().add("playerInfo");
      playerScores.put(player, playerScore);

      FlowPane playerItemPane = new FlowPane();
      playerItemPane.setHgap(5);
      playerItemPane.setPadding(new Insets(5,0,15,0));
      List<Node> playerItemsList = playerItemPane.getChildren();
      player.getDice().forEach(x -> {
        try { playerItemsList.add(getIcon(x)); } catch (Exception e) { e.printStackTrace(); }
      });
      playerItems.put(player, playerItemPane);

      GridPane playerInfo = new GridPane();
      playerInfo.setVgap(100);
      playerInfo.addColumn(0, playerNames.get(player));
      playerInfo.addColumn(1, playerScores.get(player));
      playerScores.get(player).setText("" +player.getScore());
      playerInfo.getColumnConstraints().addAll(new ColumnConstraints(330), new ColumnConstraints(90));
      playerPaneBox
          .getChildren()
          .addAll(
              playerInfo,
              playerItems.get(player)
          );
    }
    setActiveStylePlayer(this.players.get(0));
  }

  private void buyD6(MouseEvent mouseEvent) {
    Die newDie = gameEngine.buyD6();
    if(newDie != null){
      try {
        playerItems.get(gameEngine.getPlayer()).getChildren().add(getIcon(newDie));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    playerScores.get(gameEngine.getPlayer()).setText(gameEngine.getScoreAsString());
  }

  private void buyD20(MouseEvent mouseEvent) {
    Die newDie = gameEngine.buyD20();
    if(newDie != null){
      try {
        playerItems.get(gameEngine.getPlayer()).getChildren().add(getIcon(newDie));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    playerScores.get(gameEngine.getPlayer()).setText(gameEngine.getScoreAsString());
  }

  private void buyModifier(MouseEvent mouseEvent) {
    Modifier newMod = gameEngine.buyModifier();
    if(newMod != null){
      try {
        playerItems.get(gameEngine.getPlayer()).getChildren().add(getIcon(newMod));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    playerScores.get(gameEngine.getPlayer()).setText(gameEngine.getScoreAsString());
  }

  private void setActiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("-fx-text-fill: #2196F3;");
  }

  private void setInactiveStylePlayer(Player player) {
    playerNames.get(player).setStyle("");
  }

  private Group getIcon(Die die) throws IOException {
    SVGPath icon = null;
    if (die.getNumOfSides() == 6) {
      icon = getSVGIcon("svgpaths/d6");
      resizeSVG(icon, 35, 35);
    } else if (die.getNumOfSides() == 20) {
      icon = getSVGIcon("svgpaths/d20");
      resizeSVG(icon, 35, 35);
    }
    Group group = new Group();
    group.getStylesheets().add("css/playWindow.css");
    group.getChildren().addAll(icon); // will return null pointer exception for weird dice
    return group;
  }

  // TODO modifier icon is currently all black. Should display value as well.
  private Group getIcon(Modifier mod) throws IOException {
    SVGPath icon = getSVGIcon("svgpaths/modifier");
    resizeSVG(icon, 35, 35);
    Group group = new Group();
    group.getChildren().add(icon);
    return group;
  }

  private SVGPath getSVGIcon(String filePath) throws IOException {
    SVGPath icon = new SVGPath();
    String path = IOUtils.toString(
        HelperMethods.getResAsStream(filePath),
        StandardCharsets.UTF_8
    );
    icon.setContent(path);
    return icon;
  }

  private void resizeSVG(SVGPath svg, double width, double height) {
    double originalHeight = svg.prefHeight(-1);
    double originalWidth = svg.prefWidth(originalHeight);
    svg.setScaleX(width / originalWidth);
    svg.setScaleY(height / originalHeight);
  }
}

