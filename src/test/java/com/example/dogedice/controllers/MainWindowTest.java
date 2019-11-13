package com.example.dogedice.controllers;

import com.example.dogedice.TestHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class MainWindowTest extends ApplicationTest {
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
  }

  @Test
  void checkButtons() {
    Button startButton = (Button) scene.lookup("#startButton");
    Button highscoreButton = (Button) scene.lookup("#highscoreButton");
    assertEquals("START", startButton.getText());
    assertEquals("HIGHSCORE", highscoreButton.getText());
    TestHelper.assertButtonStyle(this, startButton);
    TestHelper.assertButtonStyle(this, highscoreButton);
  }

  @Test
  void startButtonClicked() {
    clickOn("#startButton");
    assertEquals(HelperMethods.playerSelectionWindowTitle, stage.getTitle());
    clickOn("#backButton");
    assertEquals(HelperMethods.mainWindowTitle, stage.getTitle());
  }

  @Test
  void highscoreButtonClicked() {
    clickOn("#highscoreButton");
    assertEquals(HelperMethods.highscoreWindowTitle, stage.getTitle());
    clickOn("#backButton");
    assertEquals(HelperMethods.mainWindowTitle, stage.getTitle());
  }

  @Test
  void helpButtonClicked() {
    clickOn("#helpButton");
    assertEquals(HelperMethods.helpWindowTitle, stage.getTitle());
    clickOn("#backButton");
    assertEquals(HelperMethods.mainWindowTitle, stage.getTitle());
  }

  @Test
  void dogecoinButtonClicked() {
    clickOn("#dogecoinButton");
    assertEquals(HelperMethods.dogeCoinWindowTitle, stage.getTitle());
    clickOn("#backButton");
    assertEquals(HelperMethods.mainWindowTitle, stage.getTitle());

  }

  @Test
  void spinningDogeClicked() {
    TestHelper.assertDogeSpin(this, scene, "#spinningDoge1");
    TestHelper.assertDogeSpin(this, scene, "#spinningDoge2");
  }
}