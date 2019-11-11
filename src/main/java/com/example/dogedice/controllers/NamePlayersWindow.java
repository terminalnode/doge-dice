package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NamePlayersWindow {
  @FXML
  VBox namePlayersBox;

  void addHumPlayer(int num) {
    addPlayer("Human", num, true);
  }

  void addCpuPlayer(int num) {
    addPlayer("Robo Doge", num, false);
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
    Main.replaceWindow("fxml/playerSelectionWindow.fxml", "Main Window", mouseEvent);
  }
}
