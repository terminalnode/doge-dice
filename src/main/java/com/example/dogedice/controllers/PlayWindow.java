package com.example.dogedice.controllers;

import com.example.dogedice.Main;
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
  @FXML
  VBox playerPaneBox;

  public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.mainWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);  }



  public void addPlayers(List<Player> players) {
    for(Player player : players){
      Label label = new Label(player.getName());
      playerPaneBox
        .getChildren()
          .add(label);
    }
  }
}


