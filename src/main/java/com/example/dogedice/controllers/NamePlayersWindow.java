package com.example.dogedice.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class NamePlayersWindow {
  @FXML
  VBox namePlayersBox;

  void addHumPlayer(int num) {
    Label label = new Label("Human: ");
    TextField textField = new TextField(String.format("Player #%s", num));
    textField.prefWidth(50);

    FlowPane parent = new FlowPane();
    parent.setOrientation(Orientation.HORIZONTAL);
    parent.getChildren().addAll(label, textField);
    namePlayersBox.getChildren().add(parent);
  }

  void addCpuPlayer(int num) {
    Label label = new Label("CPU: ");
    TextField textField = new TextField(String.format("CPU #%s", num));
    textField.prefWidth(50);
    textField.setEditable(false);

    FlowPane parent = new FlowPane();
    parent.setOrientation(Orientation.HORIZONTAL);
    parent.getChildren().addAll(label, textField);
    namePlayersBox.getChildren().add(parent);
  }

  public void confirmButtonClicked(MouseEvent mouseEvent) {
  }
}
