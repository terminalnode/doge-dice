package com.example.dogedice;

import com.example.dogedice.controllers.HelperMethods;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainWindow) throws IOException, URISyntaxException {
    mainWindow.setTitle("Doge Dice");  // Give the stage a title.
    Parent root = FXMLLoader.load(getRes("fxml/mainWindow.fxml"));
    Scene scene = new Scene(root);
    mainWindow.setScene(scene);
    mainWindow.show();

    File soundFile = new File(getRes("sounds/biggestSmile.wav").toURI());
    MediaPlayer player = new MediaPlayer(new Media(soundFile.toURI().toString()));
    player.setCycleCount(MediaPlayer.INDEFINITE);
    player.play();
  }

  // Static helper methods used throughout the program
  public static URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  public static void replaceWindow(String fxmlPath, String windowTitle, MouseEvent mouseEvent) throws IOException {
    Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
    stage.setTitle(windowTitle);
    Parent root = FXMLLoader.load(Main.getRes(fxmlPath));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }

  public static FXMLLoader getLoader(String fxmlPath) {
    return new FXMLLoader(getRes(fxmlPath));
  }

  public static void replaceStage(MouseEvent mouseEvent, Scene scene, String title) {
    Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
    stage.setTitle(title);
    stage.setScene(scene);
  }
}

