package com.example.dogedice;

import com.example.dogedice.controllers.HelperMethods;
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
    mainWindow.setTitle(HelperMethods.mainWindowTitle);  // Give the stage a title.
    Parent root = FXMLLoader.load(HelperMethods.getRes(HelperMethods.mainWindowFXML));
    Scene scene = new Scene(root);
    mainWindow.setScene(scene);
    mainWindow.show();
    mainWindow.toFront();

    File soundFile = new File(HelperMethods.getRes("sounds/biggestSmile.wav").toURI());
    MediaPlayer player = new MediaPlayer(new Media(soundFile.toURI().toString()));
    player.setCycleCount(MediaPlayer.INDEFINITE);
    player.play();
  }
}

