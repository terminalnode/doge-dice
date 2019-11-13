package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class PlayerSelectionWindowTest extends ApplicationTest {
  private Scene scene;
  private Stage stage;

  @Override
  public void start(Stage stage) throws IOException {
    this.stage = stage;
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.mainWindowFXML);
    Parent root = loader.load();
    this.scene = new Scene(root);
    stage.setScene(this.scene);
    stage.show();
    clickOn("#startButton");
  }

  @Test
  void addHumPlayer() {

  }

  @Test
  void addCpuPlayer() {
  }

  @Test
  void setHumPlayersSpinner() {
    clickOn("#humPlayersSpinner .decrement-arrow-button");
    scene.lookup("#humPlayersSpinner");
    PlayerSelectionWindow playerSelectionWindow = new PlayerSelectionWindow();
    playerSelectionWindow.humPlayersSpinner.getValue();
  }

  @Test
  void setCpuPlayersSpinner() {
    clickOn("#cpuPlayersSpinner .decrement-arrow-button");
    scene.lookup("#cpuPlayersSpinner");
    assertEquals(, stage.equals(2));
  }

  @Test
  void confirmButtonClicked() {
    clickOn("#confirmButton");
    assertEquals(HelperMethods.namePlayersWindowTitle, stage.getTitle());
    clickOn("#backButton");
    assertEquals(HelperMethods.playerSelectionWindowTitle, stage.getTitle());
  }

  @Test
  void backIconClicked() {
    clickOn("#backButton");
    assertEquals(HelperMethods.mainWindowTitle, stage.getTitle());
  }
}