package com.example.dogedice.controllers;

import com.example.dogedice.model.CpuPlayer;
import com.example.dogedice.model.Die;
import com.example.dogedice.model.HumanPlayer;
import com.example.dogedice.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class NamePlayersWindow {
  private int numCpu = 0;
  private int numHum = 0;
  private List<TextField> humans = new ArrayList<>();
  private List<TextField> cpus = new ArrayList<>();

  @FXML
  VBox namePlayersBox;

  void addHumPlayer(int num) {
    addPlayer("Human", num, true, humans);
    numHum += 1;
  }

  void addCpuPlayer(int num) {
    addPlayer("Robo Doge", num, false, cpus);
    numCpu += 1;
  }

  private void addPlayer(String playerType, int num, boolean editable, List<TextField> list) {
    Label label = new Label(playerType + ": ");
    label.setLayoutY(5);
    TextField textField = new TextField(String.format("%s #%s", playerType, num));
    textField.prefWidth(50);
    textField.setLayoutX(90);
    textField.setEditable(editable);
    list.add(textField);

    namePlayersBox
        .getChildren()
        .add(new Group(label, textField));
  }

  public void confirmButtonClicked(MouseEvent mouseEvent) throws IOException, URISyntaxException {
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.playWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    PlayWindow controller = loader.getController();
    List<Player> players = new ArrayList<>();
    int[] diceSelection = {6,6};
    humans.stream().map(x -> createHuman(x.getText(), diceSelection)).forEach(players::add);
    cpus.stream().map(x -> createBot(x.getText(), diceSelection)).forEach(players::add);
    controller.addPlayers(players);
    HelperMethods.replaceStage(mouseEvent, scene, HelperMethods.playWindowTitle);
  }

  private Player createHuman(String name, int[] dice) {
    Player newPlayer = new HumanPlayer(name);
    for (int i : dice) { newPlayer.addDie(new Die(i)); }
    return newPlayer;
  }

  private Player createBot(String name, int[] dice) {
    Player newPlayer = new CpuPlayer(name);
    for (int i : dice) { newPlayer.addDie(new Die(i)); }
    return newPlayer;
  }

  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.playerSelectionWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    PlayerSelectionWindow controller = loader.getController();
    controller.setCpuPlayersSpinner(numCpu);
    controller.setHumPlayersSpinner(numHum);
    HelperMethods.replaceStage(mouseEvent, scene, HelperMethods.playerSelectionWindowTitle);
  }
}
