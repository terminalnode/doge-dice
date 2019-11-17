package com.example.dogedice;

import com.example.dogedice.controllers.GenericController;
import com.example.dogedice.controllers.HelperMethods;
import com.example.dogedice.model.GameEngine;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainWindow) throws IOException, URISyntaxException {
    GameEngine gameEngine = new GameEngine(30, 5, 10, 15, new int[]{6,6}, new int[]{});

    // First window must be loaded manually, other windows will use replaceWindow from HelperMethods.
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.mainWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    GenericController controller = loader.getController();
    controller.setGameEngine(gameEngine);

    mainWindow.setTitle(HelperMethods.mainWindowTitle);
    mainWindow.setScene(scene);
    mainWindow.show();
    mainWindow.toFront();

    if (!getClass().getResource("").getProtocol().equals("jar")) {
      File soundFile = new File(HelperMethods.getRes("sounds/biggestSmile.wav").toURI());
      MediaPlayer player = new MediaPlayer(new Media(soundFile.toURI().toString()));
      player.setCycleCount(MediaPlayer.INDEFINITE);
      player.play();
    }
  }
}

