package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class MainWindowTest extends ApplicationTest {
  private Scene scene;
  private Stage stage;

  @Override
  public void start(Stage stage) throws IOException {
    this.stage = stage;
    FXMLLoader loader = Main.getLoader("fxml/mainWindow.fxml");
    Parent root = loader.load();
    this.scene = new Scene(root);
    stage.setScene(this.scene);
    stage.show();
  }

  @Test
  void checkButtonTexts() {
    FxAssert.verifyThat("#startButton", LabeledMatchers.hasText("START"));
    FxAssert.verifyThat("#highscoreButton", LabeledMatchers.hasText("HIGHSCORE"));
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
    assertEquals(1.0,scene.lookup("#spinningDoge1").getScaleX());
    assertEquals(1.0,scene.lookup("#spinningDoge2").getScaleX());
    clickOn("#spinningDoge1");
    clickOn("#spinningDoge2");
    assertEquals(-1.0,scene.lookup("#spinningDoge1").getScaleX());
    assertEquals(-1.0,scene.lookup("#spinningDoge2").getScaleX());
    clickOn("#spinningDoge1");
    clickOn("#spinningDoge2");
    assertEquals(1.0,scene.lookup("#spinningDoge1").getScaleX());
    assertEquals(1.0,scene.lookup("#spinningDoge2").getScaleX());
    rightClickOn("#spinningDoge1");
    rightClickOn("#spinningDoge2");
    assertTrue(((ImageView) scene.lookup("#spinningDoge1")).getImage().getUrl().contains("rainbowDoge.gif"));
    assertTrue(((ImageView) scene.lookup("#spinningDoge2")).getImage().getUrl().contains("rainbowDoge.gif"));
    rightClickOn("#spinningDoge1");
    rightClickOn("#spinningDoge2");
    assertTrue(((ImageView) scene.lookup("#spinningDoge1")).getImage().getUrl().contains("dogespin.gif"));
    assertTrue(((ImageView) scene.lookup("#spinningDoge2")).getImage().getUrl().contains("dogespin.gif"));
  }
}