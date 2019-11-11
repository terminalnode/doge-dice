package com.example.dogedice.controllers;

import com.example.dogedice.Main;
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
import javafx.stage.Stage;

import java.io.IOException;

public class NamePlayersWindow {
  private int numCpu = 0;
  private int numHum = 0;

  @FXML
  VBox namePlayersBox;

  void addHumPlayer(int num) {
    addPlayer("Human", num, true);
    numHum += 1;
  }

  void addCpuPlayer(int num) {
    addPlayer("Robo Doge", num, false);
    numCpu += 1;
  }

  private void addPlayer(String playerType, int num, boolean editable) {
    Label label = new Label(playerType + ": ");
    label.setLayoutY(5);
    TextField textField = new TextField(String.format("%s #%s", playerType, num));
    textField.prefWidth(50);
    textField.setLayoutX(90);
    textField.setEditable(editable);

    namePlayersBox
        .getChildren()
        .add(new Group(label, textField));
  }

  public void confirmButtonClicked(MouseEvent mouseEvent) {
  }

  public void spinningDogeClicked(MouseEvent mouseEvent)  {
    ImageView spinningDoge = (ImageView ) mouseEvent.getSource();
    spinningDoge.setScaleX(spinningDoge.getScaleX() * -1);
  }

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    Stage newWindow = new Stage();
    newWindow.setTitle("Player Selection");
    FXMLLoader loader = Main.getLoader("fxml/playerSelectionWindow.fxml");
    Parent root = loader.load();
    PlayerSelectionWindow controller = loader.getController();
    Scene scene = new Scene(root);
    newWindow.setScene(scene);

    controller.setCpuPlayersSpinner(numCpu);
    controller.setHumPlayersSpinner(numHum);

    Main.hideParentWindow(mouseEvent);
    newWindow.show();
  }
}
