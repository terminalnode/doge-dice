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
    Label label = new Label("Human: ");
    label.setLayoutY(5);
    TextField textField = new TextField(String.format("Player #%s", num));
    textField.prefWidth(50);
    textField.setLayoutX(70);

    Group parent = new Group();
    parent.getChildren().addAll(label, textField);
    namePlayersBox.getChildren().add(parent);
  }

  void addCpuPlayer(int num) {
    Label label = new Label("CPU: ");
    label.setLayoutY(5);
    TextField textField = new TextField(String.format("CPU #%s", num));
    textField.prefWidth(50);
    textField.setLayoutX(70);
    textField.setEditable(false);

    Group parent = new Group();
    parent.getChildren().addAll(label, textField);
    namePlayersBox.getChildren().add(parent);
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
